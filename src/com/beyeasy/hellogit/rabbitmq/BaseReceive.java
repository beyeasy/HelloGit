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
            System.out.println("[" + this.getClass().getName() + "]��ʼ����" + getListenQueue() + "������Ϣ����...");
            long deliveryTag = 0L;
            while (true) {
                try {
                    // �յ�ֹͣ��Ϣ
                    if (isStop()) {
                        System.out.println("[" + this.getClass().getName() + "]ֹͣ����" + getListenQueue() + "������Ϣ����...");
                        break;
                    }

                    // �յ���ͣ��Ϣ
                    if (isPause()) {
                        System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "���м�����Ϣ��ͣ");
                        sleep(30000);
                        continue;
                    }

                    // ���Ӳ������������ӡ�
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
                    System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "RabbitMQ ������������Ϣʧ�ܣ�"
                            + e.getMessage());
                } catch(AlreadyClosedException e) {
                    e.printStackTrace();
                    System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "RabbitMQ ������������Ϣʧ�ܣ�"
                            + e.getMessage());
                } catch(Exception e) {
                    e.printStackTrace();
                    System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "RabbitMQ ������������Ϣʧ�ܣ�"
                            + e.getMessage());
                    try {
                        channel.basicAck(deliveryTag, false);
                    } catch(IOException e1) {
                        e.printStackTrace();
                        System.out.println("[" + this.getClass().getName() + "]" + getListenQueue()
                                + "RabbitMQ ������������Ϣʧ�ܣ�" + e1.getMessage());
                    }
                }
            }
        } finally {
            close();
        }
    }

    // ��ʼ�����м����ĳ�ʼ״̬��stop
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

        // ���е��̶߳�ֹͣ�ˣ�ֹͣ�����߳�
        if (queueStatus.isEmpty()) {
            queueStatus.put(MQConstant.CONTROL_QUEUE, MQConstant.QUEUE_STOP);
        }
    }

    protected boolean isStop() {
        // �����߳��ж��Ƿ�״̬��STOP
        if (MQConstant.CONTROL_QUEUE.equals(getListenQueue())
                && MQConstant.QUEUE_STOP.equals(queueStatus.get(getListenQueue())))
            return true;

        // �ǿ����߳��ж��б����Ƿ���״̬���ڣ�û��˵���Ѿ�ֹͣ��
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
     * ����RabbitMQ������,����ͨ��.
     */
    protected void connect() {

        String host = "127.0.0.1";
        String port = "5672";
        String username = "zlfund";
        String password = "zlfund";
        String virtualHost = "/zlfund";

        // ����rabbitmq������
        ConnectionFactory factory = new ConnectionFactory();
        // 30s���ӳ�ʱ�ͷ���
        factory.setConnectionTimeout(30000);
        // Ĭ��û����������������Ϊ30s��һ������
        factory.setRequestedHeartbeat(30);

        factory.setHost(host);
        factory.setPort(Integer.parseInt(port));
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        try {
            conn = factory.newConnection();
            // ����ͨ��
            channel = conn.createChannel();
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "����RabbitMQ������ʧ�ܣ�"
                    + e.getMessage());
        }
    }

    /**
     * �Ͽ�����.
     */
    protected void close() {
        if (null != channel) {
            try {
                if (channel.isOpen()) {
                    channel.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
                System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "�Ͽ�RabbitMQ������Channelʧ�ܣ�"
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
                        + "�Ͽ�RabbitMQ������Connectionʧ�ܣ�" + e.getMessage());
            } finally {
                conn = null;
            }
        }
    }

    /**
     * �ȴ���������
     * 
     * @throws InterruptedException
     */
    protected void reConnect(long wait) {
        try {
            sleep(wait);
        } catch(InterruptedException e) {
            e.printStackTrace();
            System.out.println("[" + this.getClass().getName() + "]" + getListenQueue() + "��������RabbitMQ��������"
                    + e.getMessage());
        }
        close();
        connect();
    }

    protected boolean needReConnect() {
        return channel == null || conn == null || !channel.isOpen() || !conn.isOpen();
    }
}
