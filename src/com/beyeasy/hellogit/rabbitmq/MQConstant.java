package com.beyeasy.hellogit.rabbitmq;

import java.util.ArrayList;
import java.util.List;

public class MQConstant {

    public static final String TEST_QUEUE_A = "test_queue_a"; 
    public static final String TEST_QUEUE_B = "test_queue_b";
    public static final String CONTROL_QUEUE = "control_queue";
    
    public static final List<String> QUEUES = new ArrayList<String>();
    static {
        QUEUES.add(TEST_QUEUE_A);
        QUEUES.add(TEST_QUEUE_B);
    }

    public static final String QUEUE_STOP = "stop";

    public static final String QUEUE_RUN = "run";

    public static final String QUEUE_PAUSE = "pause";

}
