package com.amazonaws;

import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.buffered.AmazonSQSBufferedAsyncClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

import java.util.List;

/**
 * Created by kapil_shrivastava on 11/25/15.
 */
public class KapilTestSQS {
    public static void main(String[] args) {

        AmazonSQSClient client = new AmazonSQSClient();
        String queueURL = client.getQueueUrl("connect-insight-qastg").getQueueUrl();
        System.out.println(queueURL);
        client.sendMessage(queueURL,"This is a first test message:"+Math.random());
        //System.out.println(client.receiveMessage(queueURL));

        
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueURL);
        receiveMessageRequest.setMaxNumberOfMessages(10);
        List<Message> messages = client.receiveMessage(receiveMessageRequest).getMessages();
        for (Message message : messages) {
            System.out.println(message.getBody());
        }


        AmazonSQSAsyncClient asyncClient = new AmazonSQSAsyncClient();
        ReceiveMessageResult result = new ReceiveMessageResult();
        AsyncHandler handler = new AsyncHandler() {
            @Override
            public void onError(Exception exception) {
                System.err.println("errr:"+exception);
            }

            @Override
            public void onSuccess(AmazonWebServiceRequest request, Object o) {
                System.out.println("I received a async message:"+ o);
            }
        };
        asyncClient.receiveMessageAsync(receiveMessageRequest,handler);
//        try {
//            KapilTestSQS.class.wait(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
