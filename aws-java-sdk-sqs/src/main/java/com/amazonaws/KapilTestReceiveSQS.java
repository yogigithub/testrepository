package com.amazonaws;

import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.buffered.AmazonSQSBufferedAsyncClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

import java.util.List;

/**
 * Created by kapil_shrivastava on 11/25/15.
 */
public class KapilTestReceiveSQS {
    public static void main(String[] args) {

        AmazonSQSClient client = new AmazonSQSClient();
        final String queueURL = client.getQueueUrl("connect-insight-qastg").getQueueUrl();
        System.out.println(queueURL);
//        client.sendMessage(queueURL,"This is a first test message:"+Math.random());
//        //System.out.println(client.receiveMessage(queueURL));

        //This is how you receive messages synchronusly
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueURL);
        receiveMessageRequest.setMaxNumberOfMessages(10);
        List<Message> messages = client.receiveMessage(receiveMessageRequest).getMessages();
        for (Message message : messages) {
            System.out.println(message.getBody());
            //received message so deleting from queue
            client.deleteMessage(new DeleteMessageRequest(queueURL,message.getReceiptHandle()));
        }

        //This is how I am trying to receive messages A-synchronusly, but still not getting new messages
        final AmazonSQSAsyncClient asyncClient = new AmazonSQSAsyncClient();
        ReceiveMessageResult result = new ReceiveMessageResult();
        AsyncHandler handler = new AsyncHandler() {
            @Override
            public void onError(Exception exception) {
                System.err.println("errr:"+exception);
            }

            @Override
            public void onSuccess(AmazonWebServiceRequest request, Object o) {
                System.out.println("I received a async message:"+ o);
                List<Message> asyncMessages =  (List<Message>) o;
                for (Message message : asyncMessages) {
                    System.out.println(message.getBody());
                    //received message so deleting from queue
                    asyncClient.deleteMessage(new DeleteMessageRequest(queueURL,message.getReceiptHandle()));
                }
            }
        };
        asyncClient.receiveMessageAsync(receiveMessageRequest,handler);
        System.out.println("I am done !! b bye!!");

    }
}
