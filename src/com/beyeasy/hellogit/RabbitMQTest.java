package com.beyeasy.hellogit;

import com.beyeasy.hellogit.rabbitmq.ControlQueueReceive;
import com.beyeasy.hellogit.rabbitmq.TestQueueReceiveA;
import com.beyeasy.hellogit.rabbitmq.TestQueueReceiveB;

public class RabbitMQTest {

    public static void main(String[] args) {

        TestQueueReceiveA ta = new TestQueueReceiveA();
        ta.start();
        
        TestQueueReceiveB tb = new TestQueueReceiveB();
        tb.start();
        
        ControlQueueReceive cq = new ControlQueueReceive();
        cq.start();
    }

}
