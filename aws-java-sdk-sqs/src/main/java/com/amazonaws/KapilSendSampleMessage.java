package com.amazonaws;

import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

import java.util.List;

/**
 * Created by kapil_shrivastava on 11/26/15.
 */
public class KapilSendSampleMessage {
    public static void main(String[] args) {
        AmazonSQSClient client = new AmazonSQSClient();
        String queueURL = client.getQueueUrl("connect-insight-qastg").getQueueUrl();
        System.out.println(queueURL);
        client.sendMessage(queueURL,"This is a test message:"+Math.random());
        //System.out.println(client.receiveMessage(queueURL));
    }


}
