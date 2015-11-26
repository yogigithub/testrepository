/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.sqs.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * Container for the parameters to the {@link com.amazonaws.services.sqs.AmazonSQS#deleteMessage(DeleteMessageRequest) DeleteMessage operation}.
 * <p>
 * Deletes the specified message from the specified queue. You specify
 * the message by using the message's <code>receipt handle</code> and not
 * the <code>message ID</code> you received when you sent the message.
 * Even if the message is locked by another reader due to the visibility
 * timeout setting, it is still deleted from the queue. If you leave a
 * message in the queue for longer than the queue's configured retention
 * period, Amazon SQS automatically deletes it.
 * </p>
 * <p>
 * <b>NOTE:</b> The receipt handle is associated with a specific instance
 * of receiving the message. If you receive a message more than once, the
 * receipt handle you get each time you receive the message is different.
 * When you request DeleteMessage, if you don't provide the most recently
 * received receipt handle for the message, the request will still
 * succeed, but the message might not be deleted.
 * </p>
 * <p>
 * <b>IMPORTANT:</b> It is possible you will receive a message even after
 * you have deleted it. This might happen on rare occasions if one of the
 * servers storing a copy of the message is unavailable when you request
 * to delete the message. The copy remains on the server and might be
 * returned to you again on a subsequent receive request. You should
 * create your system to be idempotent so that receiving a particular
 * message more than once is not a problem.
 * </p>
 *
 * @see com.amazonaws.services.sqs.AmazonSQS#deleteMessage(DeleteMessageRequest)
 */
public class DeleteMessageRequest extends AmazonWebServiceRequest implements Serializable, Cloneable {

    /**
     * The URL of the Amazon SQS queue to take action on.
     */
    private String queueUrl;

    /**
     * The receipt handle associated with the message to delete.
     */
    private String receiptHandle;

    /**
     * Default constructor for a new DeleteMessageRequest object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public DeleteMessageRequest() {}
    
    /**
     * Constructs a new DeleteMessageRequest object.
     * Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param receiptHandle The receipt handle associated with the message to
     * delete.
     */
    public DeleteMessageRequest(String queueUrl, String receiptHandle) {
        setQueueUrl(queueUrl);
        setReceiptHandle(receiptHandle);
    }

    /**
     * The URL of the Amazon SQS queue to take action on.
     *
     * @return The URL of the Amazon SQS queue to take action on.
     */
    public String getQueueUrl() {
        return queueUrl;
    }
    
    /**
     * The URL of the Amazon SQS queue to take action on.
     *
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     */
    public void setQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
    }
    
    /**
     * The URL of the Amazon SQS queue to take action on.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public DeleteMessageRequest withQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
        return this;
    }

    /**
     * The receipt handle associated with the message to delete.
     *
     * @return The receipt handle associated with the message to delete.
     */
    public String getReceiptHandle() {
        return receiptHandle;
    }
    
    /**
     * The receipt handle associated with the message to delete.
     *
     * @param receiptHandle The receipt handle associated with the message to delete.
     */
    public void setReceiptHandle(String receiptHandle) {
        this.receiptHandle = receiptHandle;
    }
    
    /**
     * The receipt handle associated with the message to delete.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param receiptHandle The receipt handle associated with the message to delete.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public DeleteMessageRequest withReceiptHandle(String receiptHandle) {
        this.receiptHandle = receiptHandle;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getQueueUrl() != null) sb.append("QueueUrl: " + getQueueUrl() + ",");
        if (getReceiptHandle() != null) sb.append("ReceiptHandle: " + getReceiptHandle() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getQueueUrl() == null) ? 0 : getQueueUrl().hashCode()); 
        hashCode = prime * hashCode + ((getReceiptHandle() == null) ? 0 : getReceiptHandle().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof DeleteMessageRequest == false) return false;
        DeleteMessageRequest other = (DeleteMessageRequest)obj;
        
        if (other.getQueueUrl() == null ^ this.getQueueUrl() == null) return false;
        if (other.getQueueUrl() != null && other.getQueueUrl().equals(this.getQueueUrl()) == false) return false; 
        if (other.getReceiptHandle() == null ^ this.getReceiptHandle() == null) return false;
        if (other.getReceiptHandle() != null && other.getReceiptHandle().equals(this.getReceiptHandle()) == false) return false; 
        return true;
    }
    
    @Override
    public DeleteMessageRequest clone() {
        
            return (DeleteMessageRequest) super.clone();
    }

}
    