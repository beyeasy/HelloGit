package com.beyeasy.hellogit.rabbitmq;

import net.sf.json.JSONObject;

public class TestQueueReceiveB extends BaseReceive {

    @Override
    protected String getListenQueue() {
        return MQConstant.TEST_QUEUE_B;
    }

    @Override
    protected void doBiz(JSONObject json) {
        System.out.println("[" + this.getClass().getName() + "]收到消息：" + json.toString());
    }

}
