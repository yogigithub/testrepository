package com.amazonaws;

import com.amazonaws.services.sqs.AmazonSQSClient;

/**
 * Created by kapil_shrivastava on 11/25/15.
 */
public class KapilTestSQS {
    public static void main(String[] args) {
        AmazonSQSClient client = new AmazonSQSClient();
        System.out.println(client.getQueueUrl("connect-insight-qastg"));
        client.sendMessage(client.getQueueUrl("connect-insight-qastg").getQueueUrl(),"This is a first test message");
        System.out.println(client.receiveMessage(client.getQueueUrl("connect-insight-qastg").getQueueUrl()));

        //This commit should only go to local branch.
        //One more commit made to branch, local and remote.


    }
}
