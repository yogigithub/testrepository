package com.amazonaws;

import com.amazonaws.services.sqs.AmazonSQSClient;

/**
 * Created by kapil_shrivastava on 11/25/15.
 */
public class KapilTestSQS {
    public static void main(String[] args) {
        AmazonSQSClient client = new AmazonSQSClient();
        System.out.println(client.getQueueUrl("connect-insight-qastg"));

    }
}
