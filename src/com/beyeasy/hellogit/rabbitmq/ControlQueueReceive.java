package com.beyeasy.hellogit.rabbitmq;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ControlQueueReceive extends BaseReceive {

    @Override
    protected String getListenQueue() {
        return MQConstant.CONTROL_QUEUE;
    }

    @Override
    protected void doBiz(JSONObject json) {
        System.out.println("ControlQueueRecieve.doBiz ¿ªÊ¼Ö´ÐÐ");

        JSONArray ja = json.getJSONArray("queue");
        String status = json.getString("status");
        for (int i = 0; i<ja.size();i++) {
            String queue = ja.getString(i);
            super.setQueueStatus(queue, status);
            if ("all".equals(queue)) {
                break;
            }
        }

        return;
    }
}
