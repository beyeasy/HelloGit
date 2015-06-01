package com.beyeasy.hellogit.rabbitmq;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

public abstract class BaseReceive extends Thread {

    protected Connection conn;

    protected Channel channel;

    protected static boolean AUTO_ACK = false;

    protected static String MSG_ENCODING = "UTF-8";

    private static boolean inited = false;

    private static Map<String, String> queueStatus;

    private static ReentrantLock lock = new ReentrantLock();

    protected abstract String getListenQueue();

    protected abstract void doBiz(JSONObject json);

    protected int icnt = 0;

    @Override
    public void run() {
        try {
            if (!inited) {
                lock.lock();
                if (!inited)
                    initReceiveStatus();
            }
        } finally {
            lock.unlock();
        }
        receive();
    }

    private void receive() {

        try {
            connect();
            System.out.println("[" + this.getClass().getName() + "]开始监听" + getListenQueue() + "公共消息队列...");
            long deliveryTag = 0L;
            while (true) {
                try {
                    // 收到停止消息
                    if (isStop()) {
                        System.out.println("[" + this.getClass().getName() + "]停止监听" + getListenQueue() + "公共消息队列...");
                        break;
                    }

                    // 收到暂停消息
                    if (isPause()) {
                        System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "队列监听消息暂停");
                        sleep(30000);
                        continue;
                    }

                    // 连接不正常就先连接。
                    if (needReConnect()) {
                        reConnect(5000);
                        continue;
                    }

                    GetResponse response = channel.basicGet(getListenQueue(), AUTO_ACK);
                    if (response == null) {
                        sleep(200);
                    } else {
                        deliveryTag = response.getEnvelope().getDeliveryTag();
                        String msg = new String(response.getBody(), MSG_ENCODING);
                        System.out.println(msg);
                        JSONObject json = JSONObject.fromObject(msg);
                        System.out.println("[" + this.getClass().getName() + "]receive msg of " + getListenQueue()
                                + ", msg = " + json);
                        doBiz(json);
                        channel.basicAck(deliveryTag, false);
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                    System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "RabbitMQ 服务器接收消息失败："
                            + e.getMessage());
                } catch(AlreadyClosedException e) {
                    e.printStackTrace();
                    System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "RabbitMQ 服务器接收消息失败："
                            + e.getMessage());
                } catch(Exception e) {
                    e.printStackTrace();
                    System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "RabbitMQ 服务器接收消息失败："
                            + e.getMessage());
                    try {
                        channel.basicAck(deliveryTag, false);
                    } catch(IOException e1) {
                        e.printStackTrace();
                        System.out.println("[" + this.getClass().getName() + "]" + getListenQueue()
                                + "RabbitMQ 服务器接收消息失败：" + e1.getMessage());
                    }
                }
            }
        } finally {
            close();
        }
    }

    // 初始化所有监听的初始状态：stop
    private void initReceiveStatus() {
        System.out.println(this.getClass().getName() + " initReceiveStatus");
        queueStatus = new HashMap<String, String>();
        for (String queue : MQConstant.QUEUES) {
            queueStatus.put(queue, MQConstant.QUEUE_PAUSE);
        }
        inited = true;
    }

    // {"queue":["all"],"status":"run"}
    protected void setQueueStatus(String queueName, String status) {
        System.out.println("set queueName=" + queueName + " status=" + status);
        if ("all".equals(queueName)) {
            if (MQConstant.QUEUE_STOP.equals(status)) {
                queueStatus.clear();
            } else {
                Set<String> queues = new HashSet<String>(queueStatus.keySet());
                for (String queue : queues) {
                    queueStatus.remove(queue);
                    queueStatus.put(queue, status);
                }
            }
        } else {
            if (queueStatus.containsKey(queueName))
                queueStatus.remove(queueName);
            if (!MQConstant.QUEUE_STOP.equals(status)) {
                queueStatus.put(queueName, status);
            }
        }

        // 所有的线程都停止了，停止控制线程
        if (queueStatus.isEmpty()) {
            queueStatus.put(MQConstant.CONTROL_QUEUE, MQConstant.QUEUE_STOP);
        }
    }

    protected boolean isStop() {
        // 控制线程判断是否状态是STOP
        if (MQConstant.CONTROL_QUEUE.equals(getListenQueue())
                && MQConstant.QUEUE_STOP.equals(queueStatus.get(getListenQueue())))
            return true;

        // 非控制线程判断列表中是否有状态存在，没有说明已经停止了
        if (!MQConstant.CONTROL_QUEUE.equals(getListenQueue()) && !queueStatus.containsKey(getListenQueue()))
            return true;

        return false;
    }

    private boolean isPause() {
        String status = queueStatus.get(getListenQueue());
        if (StringUtils.isNotBlank(status) && MQConstant.QUEUE_PAUSE.equals(status))
            return true;
        return false;
    }

    /**
     * 连接RabbitMQ服务器,创建通道.
     */
    protected void connect() {

        String host = "127.0.0.1";
        String port = "5672";
        String username = "zlfund";
        String password = "zlfund";
        String virtualHost = "/zlfund";

        // 连接rabbitmq服务器
        ConnectionFactory factory = new ConnectionFactory();
        // 30s链接超时就放弃
        factory.setConnectionTimeout(30000);
        // 默认没有心跳，这里设置为30s发一次心跳
        factory.setRequestedHeartbeat(30);

        factory.setHost(host);
        factory.setPort(Integer.parseInt(port));
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        try {
            conn = factory.newConnection();
            // 创建通道
            channel = conn.createChannel();
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "连接RabbitMQ服务器失败："
                    + e.getMessage());
        }
    }

    /**
     * 断开连接.
     */
    protected void close() {
        if (null != channel) {
            try {
                if (channel.isOpen()) {
                    channel.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
                System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "断开RabbitMQ服务器Channel失败："
                        + e.getMessage());
            } finally {
                channel = null;
            }
        }

        if (null != conn) {
            try {
                if (conn.isOpen()) {
                    conn.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
                System.out.println("[" + this.getClass().getName() + "]" + getListenQueue()
                        + "断开RabbitMQ服务器Connection失败：" + e.getMessage());
            } finally {
                conn = null;
            }
        }
    }

    /**
     * 等待重新连接
     * 
     * @throws InterruptedException
     */
    protected void reConnect(long wait) {
        try {
            sleep(wait);
        } catch(InterruptedException e) {
            e.printStackTrace();
            System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "重新连接RabbitMQ服务器："
                    + e.getMessage());
        }
        close();
        connect();
    }

    protected boolean needReConnect() {
        return channel == null || conn == null || !channel.isOpen() || !conn.isOpen();
    }
}
