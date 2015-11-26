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
package com.amazonaws.services.sqs;

import org.w3c.dom.*;

import java.net.*;
import java.util.*;
import java.util.Map.Entry;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.util.AWSRequestMetrics.Field;

import com.amazonaws.services.sqs.model.*;
import com.amazonaws.services.sqs.model.transform.*;

/**
 * Client for accessing AmazonSQS.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * Amazon Simple Queue Service <p>
 * Welcome to the <i>Amazon Simple Queue Service API Reference</i> . This
 * section describes who should read this guide, how the guide is
 * organized, and other resources related to the Amazon Simple Queue
 * Service (Amazon SQS).
 * </p>
 * <p>
 * Amazon SQS offers reliable and scalable hosted queues for storing
 * messages as they travel between computers. By using Amazon SQS, you
 * can move data between distributed components of your applications that
 * perform different tasks without losing messages or requiring each
 * component to be always available.
 * </p>
 * <p>
 * Helpful Links:
 * <ul>
 * <li>
 * <a href="http://queue.amazonaws.com/doc/2012-11-05/QueueService.wsdl"> Current WSDL (2012-11-05) </a>
 * </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/MakingRequestsArticle.html"> Making API Requests </a>
 * </li>
 * <li>
 * <a href="http://aws.amazon.com/sqs/"> Amazon SQS product page </a>
 * </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/SQSMessageAttributes.html"> Using Amazon SQS Message Attributes </a>
 * </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/SQSDeadLetterQueue.html"> Using Amazon SQS Dead Letter Queues </a>
 * </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/general/latest/gr/rande.html#sqs_region"> Regions and Endpoints </a>
 * </li>
 * 
 * </ul>
 * 
 * </p>
 * <p>
 * We also provide SDKs that enable you to access Amazon SQS from your
 * preferred programming language. The SDKs contain functionality that
 * automatically takes care of tasks such as:
 * </p>
 * <p>
 * 
 * <ul>
 * <li>Cryptographically signing your service requests</li>
 * <li>Retrying requests</li>
 * <li>Handling error responses</li>
 * 
 * </ul>
 * 
 * </p>
 * <p>
 * For a list of available SDKs, go to
 * <a href="http://aws.amazon.com/tools/"> Tools for Amazon Web Services </a>
 * .
 * </p>
 */
public class AmazonSQSClient extends AmazonWebServiceClient implements AmazonSQS {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AmazonSQS exceptions.
     */
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers
            = new ArrayList<Unmarshaller<AmazonServiceException, Node>>();

    /**
     * Constructs a new client to invoke service methods on
     * AmazonSQS.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonSQSClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonSQS.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonSQS
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonSQSClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonSQS using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonSQSClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonSQS using the specified AWS account credentials
     * and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonSQS
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonSQS using the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonSQSClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonSQS using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonSQS
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonSQSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonSQS using the specified AWS account credentials
     * provider, client configuration options, and request metric collector.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonSQS
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    public AmazonSQSClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(clientConfiguration, requestMetricCollector);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    private void init() {
        exceptionUnmarshallers.add(new QueueDeletedRecentlyExceptionUnmarshaller());
        exceptionUnmarshallers.add(new QueueNameExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new EmptyBatchRequestExceptionUnmarshaller());
        exceptionUnmarshallers.add(new UnsupportedOperationExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidMessageContentsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidBatchEntryIdExceptionUnmarshaller());
        exceptionUnmarshallers.add(new OverLimitExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyEntriesInBatchRequestExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidIdFormatExceptionUnmarshaller());
        exceptionUnmarshallers.add(new QueueDoesNotExistExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidAttributeNameExceptionUnmarshaller());
        exceptionUnmarshallers.add(new BatchRequestTooLongExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ReceiptHandleIsInvalidExceptionUnmarshaller());
        exceptionUnmarshallers.add(new MessageNotInflightExceptionUnmarshaller());
        exceptionUnmarshallers.add(new PurgeQueueInProgressExceptionUnmarshaller());
        exceptionUnmarshallers.add(new BatchEntryIdsNotDistinctExceptionUnmarshaller());
        
        exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("sqs.us-east-1.amazonaws.com");
        
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/sqs/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/sqs/request.handler2s"));
    }

    /**
     * <p>
     * Sets the value of one or more queue attributes. When you change a
     * queue's attributes, the change can take up to 60 seconds for most of
     * the attributes to propagate throughout the SQS system. Changes made to
     * the <code>MessageRetentionPeriod</code> attribute can take up to 15
     * minutes.
     * </p>
     * <p>
     * <b>NOTE:</b>Going forward, new attributes might be added. If you are
     * writing code that calls this action, we recommend that you structure
     * your code so that it can handle new attributes gracefully.
     * </p>
     *
     * @param setQueueAttributesRequest Container for the necessary
     *           parameters to execute the SetQueueAttributes service method on
     *           AmazonSQS.
     * 
     * 
     * @throws InvalidAttributeNameException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void setQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest) {
        ExecutionContext executionContext = createExecutionContext(setQueueAttributesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<SetQueueAttributesRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetQueueAttributesRequestMarshaller().marshall(super.beforeMarshalling(setQueueAttributesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Changes the visibility timeout of multiple messages. This is a batch
     * version of ChangeMessageVisibility. The result of the action on each
     * message is reported individually in the response. You can send up to
     * 10 ChangeMessageVisibility requests with each
     * <code>ChangeMessageVisibilityBatch</code> action.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Because the batch request can result in a
     * combination of successful and unsuccessful actions, you should check
     * for batch errors even when the call returns an HTTP status code of
     * 200.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     *
     * @param changeMessageVisibilityBatchRequest Container for the necessary
     *           parameters to execute the ChangeMessageVisibilityBatch service method
     *           on AmazonSQS.
     * 
     * @return The response from the ChangeMessageVisibilityBatch service
     *         method, as returned by AmazonSQS.
     * 
     * @throws BatchEntryIdsNotDistinctException
     * @throws TooManyEntriesInBatchRequestException
     * @throws InvalidBatchEntryIdException
     * @throws EmptyBatchRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {
        ExecutionContext executionContext = createExecutionContext(changeMessageVisibilityBatchRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ChangeMessageVisibilityBatchRequest> request = null;
        Response<ChangeMessageVisibilityBatchResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ChangeMessageVisibilityBatchRequestMarshaller().marshall(super.beforeMarshalling(changeMessageVisibilityBatchRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ChangeMessageVisibilityBatchResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Changes the visibility timeout of a specified message in a queue to a
     * new value. The maximum allowed timeout value you can set the value to
     * is 12 hours. This means you can't extend the timeout of a message in
     * an existing queue to more than a total visibility timeout of 12 hours.
     * (For more information visibility timeout, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/AboutVT.html"> Visibility Timeout </a>
     * in the <i>Amazon SQS Developer Guide</i> .)
     * </p>
     * <p>
     * For example, let's say you have a message and its default message
     * visibility timeout is 30 minutes. You could call
     * <code>ChangeMessageVisiblity</code> with a value of two hours and the
     * effective timeout would be two hours and 30 minutes. When that time
     * comes near you could again extend the time out by calling
     * ChangeMessageVisiblity, but this time the maximum allowed timeout
     * would be 9 hours and 30 minutes.
     * </p>
     * <p>
     * <b>NOTE:</b> There is a 120,000 limit for the number of inflight
     * messages per queue. Messages are inflight after they have been
     * received from the queue by a consuming component, but have not yet
     * been deleted from the queue. If you reach the 120,000 limit, you will
     * receive an OverLimit error message from Amazon SQS. To help avoid
     * reaching the limit, you should delete the messages from the queue
     * after they have been processed. You can also increase the number of
     * queues you use to process the messages.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>If you attempt to set the VisibilityTimeout to an
     * amount more than the maximum time left, Amazon SQS returns an error.
     * It will not automatically recalculate and increase the timeout to the
     * maximum time remaining.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Unlike with a queue, when you change the visibility
     * timeout for a specific message, that timeout value is applied
     * immediately but is not saved in memory for that message. If you don't
     * delete a message after it is received, the visibility timeout for the
     * message the next time it is received reverts to the original timeout
     * value, not the value you set with the ChangeMessageVisibility action.
     * </p>
     *
     * @param changeMessageVisibilityRequest Container for the necessary
     *           parameters to execute the ChangeMessageVisibility service method on
     *           AmazonSQS.
     * 
     * 
     * @throws ReceiptHandleIsInvalidException
     * @throws MessageNotInflightException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
        ExecutionContext executionContext = createExecutionContext(changeMessageVisibilityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ChangeMessageVisibilityRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ChangeMessageVisibilityRequestMarshaller().marshall(super.beforeMarshalling(changeMessageVisibilityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Returns the URL of an existing queue. This action provides a simple
     * way to retrieve the URL of an Amazon SQS queue.
     * </p>
     * <p>
     * To access a queue that belongs to another AWS account, use the
     * <code>QueueOwnerAWSAccountId</code> parameter to specify the account
     * ID of the queue's owner. The queue's owner must grant you permission
     * to access the queue. For more information about shared queue access,
     * see AddPermission or go to
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/acp-overview.html"> Shared Queues </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     *
     * @param getQueueUrlRequest Container for the necessary parameters to
     *           execute the GetQueueUrl service method on AmazonSQS.
     * 
     * @return The response from the GetQueueUrl service method, as returned
     *         by AmazonSQS.
     * 
     * @throws QueueDoesNotExistException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetQueueUrlResult getQueueUrl(GetQueueUrlRequest getQueueUrlRequest) {
        ExecutionContext executionContext = createExecutionContext(getQueueUrlRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetQueueUrlRequest> request = null;
        Response<GetQueueUrlResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetQueueUrlRequestMarshaller().marshall(super.beforeMarshalling(getQueueUrlRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetQueueUrlResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Revokes any permissions in the queue policy that matches the
     * specified <code>Label</code> parameter. Only the owner of the queue
     * can remove permissions.
     * </p>
     *
     * @param removePermissionRequest Container for the necessary parameters
     *           to execute the RemovePermission service method on AmazonSQS.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void removePermission(RemovePermissionRequest removePermissionRequest) {
        ExecutionContext executionContext = createExecutionContext(removePermissionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RemovePermissionRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RemovePermissionRequestMarshaller().marshall(super.beforeMarshalling(removePermissionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Gets attributes for the specified queue. The following attributes are
     * supported:
     * <ul>
     * <li> <code>All</code> - returns all values.</li>
     * <li> <code>ApproximateNumberOfMessages</code> - returns the
     * approximate number of visible messages in a queue. For more
     * information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/ApproximateNumber.html"> Resources Required to Process Messages </a>
     * in the <i>Amazon SQS Developer Guide</i> .</li>
     * <li> <code>ApproximateNumberOfMessagesNotVisible</code> - returns the
     * approximate number of messages that are not timed-out and not deleted.
     * For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/ApproximateNumber.html"> Resources Required to Process Messages </a>
     * in the <i>Amazon SQS Developer Guide</i> .</li>
     * <li> <code>VisibilityTimeout</code> - returns the visibility timeout
     * for the queue. For more information about visibility timeout, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/AboutVT.html"> Visibility Timeout </a>
     * in the <i>Amazon SQS Developer Guide</i> .</li>
     * <li> <code>CreatedTimestamp</code> - returns the time when the queue
     * was created (epoch time in seconds).</li>
     * <li> <code>LastModifiedTimestamp</code> - returns the time when the
     * queue was last changed (epoch time in seconds).</li>
     * <li> <code>Policy</code> - returns the queue's policy.</li>
     * <li> <code>MaximumMessageSize</code> - returns the limit of how many
     * bytes a message can contain before Amazon SQS rejects it.</li>
     * <li> <code>MessageRetentionPeriod</code> - returns the number of
     * seconds Amazon SQS retains a message.</li>
     * <li> <code>QueueArn</code> - returns the queue's Amazon resource name
     * (ARN).</li>
     * <li> <code>ApproximateNumberOfMessagesDelayed</code> - returns the
     * approximate number of messages that are pending to be added to the
     * queue.</li>
     * <li> <code>DelaySeconds</code> - returns the default delay on the
     * queue in seconds.</li>
     * <li> <code>ReceiveMessageWaitTimeSeconds</code> - returns the time
     * for which a ReceiveMessage call will wait for a message to
     * arrive.</li>
     * <li> <code>RedrivePolicy</code> - returns the parameters for dead
     * letter queue functionality of the source queue. For more information
     * about RedrivePolicy and dead letter queues, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/SQSDeadLetterQueue.html"> Using Amazon SQS Dead Letter Queues </a>
     * in the <i>Amazon SQS Developer Guide</i> .</li>
     * 
     * </ul>
     * 
     * </p>
     * <p>
     * <b>NOTE:</b>Going forward, new attributes might be added. If you are
     * writing code that calls this action, we recommend that you structure
     * your code so that it can handle new attributes gracefully.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     *
     * @param getQueueAttributesRequest Container for the necessary
     *           parameters to execute the GetQueueAttributes service method on
     *           AmazonSQS.
     * 
     * @return The response from the GetQueueAttributes service method, as
     *         returned by AmazonSQS.
     * 
     * @throws InvalidAttributeNameException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetQueueAttributesResult getQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest) {
        ExecutionContext executionContext = createExecutionContext(getQueueAttributesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetQueueAttributesRequest> request = null;
        Response<GetQueueAttributesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetQueueAttributesRequestMarshaller().marshall(super.beforeMarshalling(getQueueAttributesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetQueueAttributesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Delivers up to ten messages to the specified queue. This is a batch
     * version of SendMessage. The result of the send action on each message
     * is reported individually in the response. The maximum allowed
     * individual message size is 256 KB (262,144 bytes).
     * </p>
     * <p>
     * The maximum total payload size (i.e., the sum of all a batch's
     * individual message lengths) is also 256 KB (262,144 bytes).
     * </p>
     * <p>
     * If the <code>DelaySeconds</code> parameter is not specified for an
     * entry, the default for the queue is used.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>The following list shows the characters (in Unicode)
     * that are allowed in your message, according to the W3C XML
     * specification. For more information, go to
     * http://www.faqs.org/rfcs/rfc1321.html. If you send any characters that
     * are not included in the list, your request will be rejected. #x9 | #xA
     * | #xD | [#x20 to #xD7FF] | [#xE000 to #xFFFD] | [#x10000 to #x10FFFF]
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Because the batch request can result in a
     * combination of successful and unsuccessful actions, you should check
     * for batch errors even when the call returns an HTTP status code of
     * 200.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     *
     * @param sendMessageBatchRequest Container for the necessary parameters
     *           to execute the SendMessageBatch service method on AmazonSQS.
     * 
     * @return The response from the SendMessageBatch service method, as
     *         returned by AmazonSQS.
     * 
     * @throws BatchEntryIdsNotDistinctException
     * @throws TooManyEntriesInBatchRequestException
     * @throws BatchRequestTooLongException
     * @throws UnsupportedOperationException
     * @throws InvalidBatchEntryIdException
     * @throws EmptyBatchRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest) {
        ExecutionContext executionContext = createExecutionContext(sendMessageBatchRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SendMessageBatchRequest> request = null;
        Response<SendMessageBatchResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SendMessageBatchRequestMarshaller().marshall(super.beforeMarshalling(sendMessageBatchRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new SendMessageBatchResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes the messages in a queue specified by the <b>queue URL</b> .
     * </p>
     * <p>
     * <b>IMPORTANT:</b>When you use the PurgeQueue API, the deleted
     * messages in the queue cannot be retrieved.
     * </p>
     * <p>
     * When you purge a queue, the message deletion process takes up to 60
     * seconds. All messages sent to the queue before calling
     * <code>PurgeQueue</code> will be deleted; messages sent to the queue
     * while it is being purged may be deleted. While the queue is being
     * purged, messages sent to the queue before <code>PurgeQueue</code> was
     * called may be received, but will be deleted within the next minute.
     * </p>
     *
     * @param purgeQueueRequest Container for the necessary parameters to
     *           execute the PurgeQueue service method on AmazonSQS.
     * 
     * 
     * @throws PurgeQueueInProgressException
     * @throws QueueDoesNotExistException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void purgeQueue(PurgeQueueRequest purgeQueueRequest) {
        ExecutionContext executionContext = createExecutionContext(purgeQueueRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<PurgeQueueRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PurgeQueueRequestMarshaller().marshall(super.beforeMarshalling(purgeQueueRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Returns a list of your queues that have the RedrivePolicy queue
     * attribute configured with a dead letter queue.
     * </p>
     * <p>
     * For more information about using dead letter queues, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/SQSDeadLetterQueue.html"> Using Amazon SQS Dead Letter Queues </a>
     * .
     * </p>
     *
     * @param listDeadLetterSourceQueuesRequest Container for the necessary
     *           parameters to execute the ListDeadLetterSourceQueues service method on
     *           AmazonSQS.
     * 
     * @return The response from the ListDeadLetterSourceQueues service
     *         method, as returned by AmazonSQS.
     * 
     * @throws QueueDoesNotExistException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListDeadLetterSourceQueuesResult listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest) {
        ExecutionContext executionContext = createExecutionContext(listDeadLetterSourceQueuesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDeadLetterSourceQueuesRequest> request = null;
        Response<ListDeadLetterSourceQueuesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDeadLetterSourceQueuesRequestMarshaller().marshall(super.beforeMarshalling(listDeadLetterSourceQueuesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListDeadLetterSourceQueuesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes the queue specified by the <b>queue URL</b> , regardless of
     * whether the queue is empty. If the specified queue does not exist,
     * Amazon SQS returns a successful response.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Use DeleteQueue with care; once you delete your
     * queue, any messages in the queue are no longer available.
     * </p>
     * <p>
     * When you delete a queue, the deletion process takes up to 60 seconds.
     * Requests you send involving that queue during the 60 seconds might
     * succeed. For example, a SendMessage request might succeed, but after
     * the 60 seconds, the queue and that message you sent no longer exist.
     * Also, when you delete a queue, you must wait at least 60 seconds
     * before creating a queue with the same name.
     * </p>
     * <p>
     * We reserve the right to delete queues that have had no activity for
     * more than 30 days. For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/SQSConcepts.html"> How Amazon SQS Queues Work </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     *
     * @param deleteQueueRequest Container for the necessary parameters to
     *           execute the DeleteQueue service method on AmazonSQS.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteQueue(DeleteQueueRequest deleteQueueRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteQueueRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteQueueRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteQueueRequestMarshaller().marshall(super.beforeMarshalling(deleteQueueRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Delivers a message to the specified queue. With Amazon SQS, you now
     * have the ability to send large payload messages that are up to 256KB
     * (262,144 bytes) in size. To send large payloads, you must use an AWS
     * SDK that supports SigV4 signing. To verify whether SigV4 is supported
     * for an AWS SDK, check the SDK release notes.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> The following list shows the characters (in
     * Unicode) allowed in your message, according to the W3C XML
     * specification. For more information, go to
     * http://www.w3.org/TR/REC-xml/#charsets If you send any characters not
     * included in the list, your request will be rejected. #x9 | #xA | #xD |
     * [#x20 to #xD7FF] | [#xE000 to #xFFFD] | [#x10000 to #x10FFFF]
     * </p>
     *
     * @param sendMessageRequest Container for the necessary parameters to
     *           execute the SendMessage service method on AmazonSQS.
     * 
     * @return The response from the SendMessage service method, as returned
     *         by AmazonSQS.
     * 
     * @throws InvalidMessageContentsException
     * @throws UnsupportedOperationException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SendMessageResult sendMessage(SendMessageRequest sendMessageRequest) {
        ExecutionContext executionContext = createExecutionContext(sendMessageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SendMessageRequest> request = null;
        Response<SendMessageResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SendMessageRequestMarshaller().marshall(super.beforeMarshalling(sendMessageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new SendMessageResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Retrieves one or more messages, with a maximum limit of 10 messages,
     * from the specified queue. Long poll support is enabled by using the
     * <code>WaitTimeSeconds</code> parameter. For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-long-polling.html"> Amazon SQS Long Poll </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * <p>
     * Short poll is the default behavior where a weighted random set of
     * machines is sampled on a <code>ReceiveMessage</code> call. This means
     * only the messages on the sampled machines are returned. If the number
     * of messages in the queue is small (less than 1000), it is likely you
     * will get fewer messages than you requested per
     * <code>ReceiveMessage</code> call. If the number of messages in the
     * queue is extremely small, you might not receive any messages in a
     * particular <code>ReceiveMessage</code> response; in which case you
     * should repeat the request.
     * </p>
     * <p>
     * For each message returned, the response includes the following:
     * </p>
     * 
     * <ul>
     * <li> <p>
     * Message body
     * </p>
     * </li>
     * <li> <p>
     * MD5 digest of the message body. For information about MD5, go to
     * <a href="http://www.faqs.org/rfcs/rfc1321.html"> http://www.faqs.org/rfcs/rfc1321.html </a>
     * .
     * </p>
     * </li>
     * <li> <p>
     * Message ID you received when you sent the message to the queue.
     * </p>
     * </li>
     * <li> <p>
     * Receipt handle.
     * </p>
     * </li>
     * <li> <p>
     * Message attributes.
     * </p>
     * </li>
     * <li> <p>
     * MD5 digest of the message attributes.
     * </p>
     * </li>
     * 
     * </ul>
     * <p>
     * The receipt handle is the identifier you must provide when deleting
     * the message. For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/ImportantIdentifiers.html"> Queue and Message Identifiers </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * <p>
     * You can provide the <code>VisibilityTimeout</code> parameter in your
     * request, which will be applied to the messages that Amazon SQS returns
     * in the response. If you do not include the parameter, the overall
     * visibility timeout for the queue is used for the returned messages.
     * For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/AboutVT.html"> Visibility Timeout </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b> Going forward, new attributes might be added. If you are
     * writing code that calls this action, we recommend that you structure
     * your code so that it can handle new attributes gracefully.
     * </p>
     *
     * @param receiveMessageRequest Container for the necessary parameters to
     *           execute the ReceiveMessage service method on AmazonSQS.
     * 
     * @return The response from the ReceiveMessage service method, as
     *         returned by AmazonSQS.
     * 
     * @throws OverLimitException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ReceiveMessageResult receiveMessage(ReceiveMessageRequest receiveMessageRequest) {
        ExecutionContext executionContext = createExecutionContext(receiveMessageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReceiveMessageRequest> request = null;
        Response<ReceiveMessageResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReceiveMessageRequestMarshaller().marshall(super.beforeMarshalling(receiveMessageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ReceiveMessageResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns a list of your queues. The maximum number of queues that can
     * be returned is 1000. If you specify a value for the optional
     * <code>QueueNamePrefix</code> parameter, only queues with a name
     * beginning with the specified value are returned.
     * </p>
     *
     * @param listQueuesRequest Container for the necessary parameters to
     *           execute the ListQueues service method on AmazonSQS.
     * 
     * @return The response from the ListQueues service method, as returned
     *         by AmazonSQS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListQueuesResult listQueues(ListQueuesRequest listQueuesRequest) {
        ExecutionContext executionContext = createExecutionContext(listQueuesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListQueuesRequest> request = null;
        Response<ListQueuesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListQueuesRequestMarshaller().marshall(super.beforeMarshalling(listQueuesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListQueuesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes up to ten messages from the specified queue. This is a batch
     * version of DeleteMessage. The result of the delete action on each
     * message is reported individually in the response.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Because the batch request can result in a
     * combination of successful and unsuccessful actions, you should check
     * for batch errors even when the call returns an HTTP status code of
     * 200.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     *
     * @param deleteMessageBatchRequest Container for the necessary
     *           parameters to execute the DeleteMessageBatch service method on
     *           AmazonSQS.
     * 
     * @return The response from the DeleteMessageBatch service method, as
     *         returned by AmazonSQS.
     * 
     * @throws BatchEntryIdsNotDistinctException
     * @throws TooManyEntriesInBatchRequestException
     * @throws InvalidBatchEntryIdException
     * @throws EmptyBatchRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteMessageBatchResult deleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteMessageBatchRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteMessageBatchRequest> request = null;
        Response<DeleteMessageBatchResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteMessageBatchRequestMarshaller().marshall(super.beforeMarshalling(deleteMessageBatchRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new DeleteMessageBatchResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a new queue, or returns the URL of an existing one. When you
     * request <code>CreateQueue</code> , you provide a name for the queue.
     * To successfully create a new queue, you must provide a name that is
     * unique within the scope of your own queues.
     * </p>
     * <p>
     * <b>NOTE:</b> If you delete a queue, you must wait at least 60 seconds
     * before creating a queue with the same name.
     * </p>
     * <p>
     * You may pass one or more attributes in the request. If you do not
     * provide a value for any attribute, the queue will have the default
     * value for that attribute. Permitted attributes are the same that can
     * be set using SetQueueAttributes.
     * </p>
     * <p>
     * <b>NOTE:</b> Use GetQueueUrl to get a queue's URL. GetQueueUrl
     * requires only the QueueName parameter.
     * </p>
     * <p>
     * If you provide the name of an existing queue, along with the exact
     * names and values of all the queue's attributes,
     * <code>CreateQueue</code> returns the queue URL for the existing queue.
     * If the queue name, attribute names, or attribute values do not match
     * an existing queue, <code>CreateQueue</code> returns an error.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     *
     * @param createQueueRequest Container for the necessary parameters to
     *           execute the CreateQueue service method on AmazonSQS.
     * 
     * @return The response from the CreateQueue service method, as returned
     *         by AmazonSQS.
     * 
     * @throws QueueNameExistsException
     * @throws QueueDeletedRecentlyException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateQueueResult createQueue(CreateQueueRequest createQueueRequest) {
        ExecutionContext executionContext = createExecutionContext(createQueueRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateQueueRequest> request = null;
        Response<CreateQueueResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateQueueRequestMarshaller().marshall(super.beforeMarshalling(createQueueRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateQueueResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Adds a permission to a queue for a specific
     * <a href="http://docs.aws.amazon.com/general/latest/gr/glos-chap.html#P"> principal </a>
     * . This allows for sharing access to the queue.
     * </p>
     * <p>
     * When you create a queue, you have full control access rights for the
     * queue. Only you (as owner of the queue) can grant or deny permissions
     * to the queue. For more information about these permissions, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/acp-overview.html"> Shared Queues </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b> AddPermission writes an Amazon SQS-generated policy. If
     * you want to write your own policy, use SetQueueAttributes to upload
     * your policy. For more information about writing your own policy, see
     * Using The Access Policy Language in the Amazon SQS Developer Guide.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     *
     * @param addPermissionRequest Container for the necessary parameters to
     *           execute the AddPermission service method on AmazonSQS.
     * 
     * 
     * @throws OverLimitException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void addPermission(AddPermissionRequest addPermissionRequest) {
        ExecutionContext executionContext = createExecutionContext(addPermissionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<AddPermissionRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AddPermissionRequestMarshaller().marshall(super.beforeMarshalling(addPermissionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
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
     * <b>NOTE:</b> The receipt handle is associated with a specific
     * instance of receiving the message. If you receive a message more than
     * once, the receipt handle you get each time you receive the message is
     * different. When you request DeleteMessage, if you don't provide the
     * most recently received receipt handle for the message, the request
     * will still succeed, but the message might not be deleted.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> It is possible you will receive a message even
     * after you have deleted it. This might happen on rare occasions if one
     * of the servers storing a copy of the message is unavailable when you
     * request to delete the message. The copy remains on the server and
     * might be returned to you again on a subsequent receive request. You
     * should create your system to be idempotent so that receiving a
     * particular message more than once is not a problem.
     * </p>
     *
     * @param deleteMessageRequest Container for the necessary parameters to
     *           execute the DeleteMessage service method on AmazonSQS.
     * 
     * 
     * @throws ReceiptHandleIsInvalidException
     * @throws InvalidIdFormatException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteMessage(DeleteMessageRequest deleteMessageRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteMessageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteMessageRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteMessageRequestMarshaller().marshall(super.beforeMarshalling(deleteMessageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Returns a list of your queues. The maximum number of queues that can
     * be returned is 1000. If you specify a value for the optional
     * <code>QueueNamePrefix</code> parameter, only queues with a name
     * beginning with the specified value are returned.
     * </p>
     * 
     * @return The response from the ListQueues service method, as returned
     *         by AmazonSQS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListQueuesResult listQueues() throws AmazonServiceException, AmazonClientException {
        return listQueues(new ListQueuesRequest());
    }
    
    /**
     * <p>
     * Sets the value of one or more queue attributes. When you change a
     * queue's attributes, the change can take up to 60 seconds for most of
     * the attributes to propagate throughout the SQS system. Changes made to
     * the <code>MessageRetentionPeriod</code> attribute can take up to 15
     * minutes.
     * </p>
     * <p>
     * <b>NOTE:</b>Going forward, new attributes might be added. If you are
     * writing code that calls this action, we recommend that you structure
     * your code so that it can handle new attributes gracefully.
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param attributes A map of attributes to set. <p>The following lists
     * the names, descriptions, and values of the special request parameters
     * the <code>SetQueueAttributes</code> action uses: <p> <ul>
     * <li><code>DelaySeconds</code> - The time in seconds that the delivery
     * of all messages in the queue will be delayed. An integer from 0 to 900
     * (15 minutes). The default for this attribute is 0 (zero).</li>
     * <li><code>MaximumMessageSize</code> - The limit of how many bytes a
     * message can contain before Amazon SQS rejects it. An integer from 1024
     * bytes (1 KiB) up to 262144 bytes (256 KiB). The default for this
     * attribute is 262144 (256 KiB).</li>
     * <li><code>MessageRetentionPeriod</code> - The number of seconds Amazon
     * SQS retains a message. Integer representing seconds, from 60 (1
     * minute) to 1209600 (14 days). The default for this attribute is 345600
     * (4 days).</li> <li><code>Policy</code> - The queue's policy. A valid
     * AWS policy. For more information about policy structure, see <a
     * href="http://docs.aws.amazon.com/IAM/latest/UserGuide/PoliciesOverview.html">Overview
     * of AWS IAM Policies</a> in the <i>Amazon IAM User Guide</i>.</li>
     * <li><code>ReceiveMessageWaitTimeSeconds</code> - The time for which a
     * ReceiveMessage call will wait for a message to arrive. An integer from
     * 0 to 20 (seconds). The default for this attribute is 0. </li>
     * <li><code>VisibilityTimeout</code> - The visibility timeout for the
     * queue. An integer from 0 to 43200 (12 hours). The default for this
     * attribute is 30. For more information about visibility timeout, see
     * Visibility Timeout in the <i>Amazon SQS Developer Guide</i>.</li>
     * <li><code>RedrivePolicy</code> - The parameters for dead letter queue
     * functionality of the source queue. For more information about
     * RedrivePolicy and dead letter queues, see Using Amazon SQS Dead Letter
     * Queues in the <i>Amazon SQS Developer Guide</i>.</li> </ul>
     * 
     * @return The response from the SetQueueAttributes service method, as
     *         returned by AmazonSQS.
     * 
     * @throws InvalidAttributeNameException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void setQueueAttributes(String queueUrl, java.util.Map<String,String> attributes) {
        SetQueueAttributesRequest setQueueAttributesRequest = new SetQueueAttributesRequest();
        setQueueAttributesRequest.setQueueUrl(queueUrl);
        setQueueAttributesRequest.setAttributes(attributes);
        setQueueAttributes(setQueueAttributesRequest);
    }
    
    /**
     * <p>
     * Changes the visibility timeout of multiple messages. This is a batch
     * version of ChangeMessageVisibility. The result of the action on each
     * message is reported individually in the response. You can send up to
     * 10 ChangeMessageVisibility requests with each
     * <code>ChangeMessageVisibilityBatch</code> action.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Because the batch request can result in a
     * combination of successful and unsuccessful actions, you should check
     * for batch errors even when the call returns an HTTP status code of
     * 200.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param entries A list of receipt handles of the messages for which the
     * visibility timeout must be changed.
     * 
     * @return The response from the ChangeMessageVisibilityBatch service
     *         method, as returned by AmazonSQS.
     * 
     * @throws BatchEntryIdsNotDistinctException
     * @throws TooManyEntriesInBatchRequestException
     * @throws InvalidBatchEntryIdException
     * @throws EmptyBatchRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(String queueUrl, java.util.List<ChangeMessageVisibilityBatchRequestEntry> entries) {
        ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest = new ChangeMessageVisibilityBatchRequest();
        changeMessageVisibilityBatchRequest.setQueueUrl(queueUrl);
        changeMessageVisibilityBatchRequest.setEntries(entries);
        return changeMessageVisibilityBatch(changeMessageVisibilityBatchRequest);
    }
    
    /**
     * <p>
     * Changes the visibility timeout of a specified message in a queue to a
     * new value. The maximum allowed timeout value you can set the value to
     * is 12 hours. This means you can't extend the timeout of a message in
     * an existing queue to more than a total visibility timeout of 12 hours.
     * (For more information visibility timeout, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/AboutVT.html"> Visibility Timeout </a>
     * in the <i>Amazon SQS Developer Guide</i> .)
     * </p>
     * <p>
     * For example, let's say you have a message and its default message
     * visibility timeout is 30 minutes. You could call
     * <code>ChangeMessageVisiblity</code> with a value of two hours and the
     * effective timeout would be two hours and 30 minutes. When that time
     * comes near you could again extend the time out by calling
     * ChangeMessageVisiblity, but this time the maximum allowed timeout
     * would be 9 hours and 30 minutes.
     * </p>
     * <p>
     * <b>NOTE:</b> There is a 120,000 limit for the number of inflight
     * messages per queue. Messages are inflight after they have been
     * received from the queue by a consuming component, but have not yet
     * been deleted from the queue. If you reach the 120,000 limit, you will
     * receive an OverLimit error message from Amazon SQS. To help avoid
     * reaching the limit, you should delete the messages from the queue
     * after they have been processed. You can also increase the number of
     * queues you use to process the messages.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>If you attempt to set the VisibilityTimeout to an
     * amount more than the maximum time left, Amazon SQS returns an error.
     * It will not automatically recalculate and increase the timeout to the
     * maximum time remaining.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Unlike with a queue, when you change the visibility
     * timeout for a specific message, that timeout value is applied
     * immediately but is not saved in memory for that message. If you don't
     * delete a message after it is received, the visibility timeout for the
     * message the next time it is received reverts to the original timeout
     * value, not the value you set with the ChangeMessageVisibility action.
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param receiptHandle The receipt handle associated with the message
     * whose visibility timeout should be changed. This parameter is returned
     * by the <a>ReceiveMessage</a> action.
     * @param visibilityTimeout The new value (in seconds - from 0 to 43200 -
     * maximum 12 hours) for the message's visibility timeout.
     * 
     * @return The response from the ChangeMessageVisibility service method,
     *         as returned by AmazonSQS.
     * 
     * @throws ReceiptHandleIsInvalidException
     * @throws MessageNotInflightException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void changeMessageVisibility(String queueUrl, String receiptHandle, Integer visibilityTimeout) {
        ChangeMessageVisibilityRequest changeMessageVisibilityRequest = new ChangeMessageVisibilityRequest();
        changeMessageVisibilityRequest.setQueueUrl(queueUrl);
        changeMessageVisibilityRequest.setReceiptHandle(receiptHandle);
        changeMessageVisibilityRequest.setVisibilityTimeout(visibilityTimeout);
        changeMessageVisibility(changeMessageVisibilityRequest);
    }
    
    /**
     * <p>
     * Returns the URL of an existing queue. This action provides a simple
     * way to retrieve the URL of an Amazon SQS queue.
     * </p>
     * <p>
     * To access a queue that belongs to another AWS account, use the
     * <code>QueueOwnerAWSAccountId</code> parameter to specify the account
     * ID of the queue's owner. The queue's owner must grant you permission
     * to access the queue. For more information about shared queue access,
     * see AddPermission or go to
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/acp-overview.html"> Shared Queues </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * 
     * @param queueName The name of the queue whose URL must be fetched.
     * Maximum 80 characters; alphanumeric characters, hyphens (-), and
     * underscores (_) are allowed.
     * 
     * @return The response from the GetQueueUrl service method, as returned
     *         by AmazonSQS.
     * 
     * @throws QueueDoesNotExistException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetQueueUrlResult getQueueUrl(String queueName) {
        GetQueueUrlRequest getQueueUrlRequest = new GetQueueUrlRequest();
        getQueueUrlRequest.setQueueName(queueName);
        return getQueueUrl(getQueueUrlRequest);
    }
    
    /**
     * <p>
     * Revokes any permissions in the queue policy that matches the
     * specified <code>Label</code> parameter. Only the owner of the queue
     * can remove permissions.
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param label The identification of the permission to remove. This is
     * the label added with the <a>AddPermission</a> action.
     * 
     * @return The response from the RemovePermission service method, as
     *         returned by AmazonSQS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void removePermission(String queueUrl, String label) {
        RemovePermissionRequest removePermissionRequest = new RemovePermissionRequest();
        removePermissionRequest.setQueueUrl(queueUrl);
        removePermissionRequest.setLabel(label);
        removePermission(removePermissionRequest);
    }
    
    /**
     * <p>
     * Gets attributes for the specified queue. The following attributes are
     * supported:
     * <ul>
     * <li> <code>All</code> - returns all values.</li>
     * <li> <code>ApproximateNumberOfMessages</code> - returns the
     * approximate number of visible messages in a queue. For more
     * information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/ApproximateNumber.html"> Resources Required to Process Messages </a>
     * in the <i>Amazon SQS Developer Guide</i> .</li>
     * <li> <code>ApproximateNumberOfMessagesNotVisible</code> - returns the
     * approximate number of messages that are not timed-out and not deleted.
     * For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/ApproximateNumber.html"> Resources Required to Process Messages </a>
     * in the <i>Amazon SQS Developer Guide</i> .</li>
     * <li> <code>VisibilityTimeout</code> - returns the visibility timeout
     * for the queue. For more information about visibility timeout, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/AboutVT.html"> Visibility Timeout </a>
     * in the <i>Amazon SQS Developer Guide</i> .</li>
     * <li> <code>CreatedTimestamp</code> - returns the time when the queue
     * was created (epoch time in seconds).</li>
     * <li> <code>LastModifiedTimestamp</code> - returns the time when the
     * queue was last changed (epoch time in seconds).</li>
     * <li> <code>Policy</code> - returns the queue's policy.</li>
     * <li> <code>MaximumMessageSize</code> - returns the limit of how many
     * bytes a message can contain before Amazon SQS rejects it.</li>
     * <li> <code>MessageRetentionPeriod</code> - returns the number of
     * seconds Amazon SQS retains a message.</li>
     * <li> <code>QueueArn</code> - returns the queue's Amazon resource name
     * (ARN).</li>
     * <li> <code>ApproximateNumberOfMessagesDelayed</code> - returns the
     * approximate number of messages that are pending to be added to the
     * queue.</li>
     * <li> <code>DelaySeconds</code> - returns the default delay on the
     * queue in seconds.</li>
     * <li> <code>ReceiveMessageWaitTimeSeconds</code> - returns the time
     * for which a ReceiveMessage call will wait for a message to
     * arrive.</li>
     * <li> <code>RedrivePolicy</code> - returns the parameters for dead
     * letter queue functionality of the source queue. For more information
     * about RedrivePolicy and dead letter queues, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/SQSDeadLetterQueue.html"> Using Amazon SQS Dead Letter Queues </a>
     * in the <i>Amazon SQS Developer Guide</i> .</li>
     * 
     * </ul>
     * 
     * </p>
     * <p>
     * <b>NOTE:</b>Going forward, new attributes might be added. If you are
     * writing code that calls this action, we recommend that you structure
     * your code so that it can handle new attributes gracefully.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param attributeNames A list of attributes to retrieve information
     * for.
     * 
     * @return The response from the GetQueueAttributes service method, as
     *         returned by AmazonSQS.
     * 
     * @throws InvalidAttributeNameException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetQueueAttributesResult getQueueAttributes(String queueUrl, java.util.List<String> attributeNames) {
        GetQueueAttributesRequest getQueueAttributesRequest = new GetQueueAttributesRequest();
        getQueueAttributesRequest.setQueueUrl(queueUrl);
        getQueueAttributesRequest.setAttributeNames(attributeNames);
        return getQueueAttributes(getQueueAttributesRequest);
    }
    
    /**
     * <p>
     * Delivers up to ten messages to the specified queue. This is a batch
     * version of SendMessage. The result of the send action on each message
     * is reported individually in the response. The maximum allowed
     * individual message size is 256 KB (262,144 bytes).
     * </p>
     * <p>
     * The maximum total payload size (i.e., the sum of all a batch's
     * individual message lengths) is also 256 KB (262,144 bytes).
     * </p>
     * <p>
     * If the <code>DelaySeconds</code> parameter is not specified for an
     * entry, the default for the queue is used.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>The following list shows the characters (in Unicode)
     * that are allowed in your message, according to the W3C XML
     * specification. For more information, go to
     * http://www.faqs.org/rfcs/rfc1321.html. If you send any characters that
     * are not included in the list, your request will be rejected. #x9 | #xA
     * | #xD | [#x20 to #xD7FF] | [#xE000 to #xFFFD] | [#x10000 to #x10FFFF]
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Because the batch request can result in a
     * combination of successful and unsuccessful actions, you should check
     * for batch errors even when the call returns an HTTP status code of
     * 200.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param entries A list of <a>SendMessageBatchRequestEntry</a> items.
     * 
     * @return The response from the SendMessageBatch service method, as
     *         returned by AmazonSQS.
     * 
     * @throws BatchEntryIdsNotDistinctException
     * @throws TooManyEntriesInBatchRequestException
     * @throws BatchRequestTooLongException
     * @throws UnsupportedOperationException
     * @throws InvalidBatchEntryIdException
     * @throws EmptyBatchRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SendMessageBatchResult sendMessageBatch(String queueUrl, java.util.List<SendMessageBatchRequestEntry> entries) {
        SendMessageBatchRequest sendMessageBatchRequest = new SendMessageBatchRequest();
        sendMessageBatchRequest.setQueueUrl(queueUrl);
        sendMessageBatchRequest.setEntries(entries);
        return sendMessageBatch(sendMessageBatchRequest);
    }
    
    /**
     * <p>
     * Deletes the queue specified by the <b>queue URL</b> , regardless of
     * whether the queue is empty. If the specified queue does not exist,
     * Amazon SQS returns a successful response.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Use DeleteQueue with care; once you delete your
     * queue, any messages in the queue are no longer available.
     * </p>
     * <p>
     * When you delete a queue, the deletion process takes up to 60 seconds.
     * Requests you send involving that queue during the 60 seconds might
     * succeed. For example, a SendMessage request might succeed, but after
     * the 60 seconds, the queue and that message you sent no longer exist.
     * Also, when you delete a queue, you must wait at least 60 seconds
     * before creating a queue with the same name.
     * </p>
     * <p>
     * We reserve the right to delete queues that have had no activity for
     * more than 30 days. For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/SQSConcepts.html"> How Amazon SQS Queues Work </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * 
     * @return The response from the DeleteQueue service method, as returned
     *         by AmazonSQS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteQueue(String queueUrl) {
        DeleteQueueRequest deleteQueueRequest = new DeleteQueueRequest();
        deleteQueueRequest.setQueueUrl(queueUrl);
        deleteQueue(deleteQueueRequest);
    }
    
    /**
     * <p>
     * Delivers a message to the specified queue. With Amazon SQS, you now
     * have the ability to send large payload messages that are up to 256KB
     * (262,144 bytes) in size. To send large payloads, you must use an AWS
     * SDK that supports SigV4 signing. To verify whether SigV4 is supported
     * for an AWS SDK, check the SDK release notes.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> The following list shows the characters (in
     * Unicode) allowed in your message, according to the W3C XML
     * specification. For more information, go to
     * http://www.w3.org/TR/REC-xml/#charsets If you send any characters not
     * included in the list, your request will be rejected. #x9 | #xA | #xD |
     * [#x20 to #xD7FF] | [#xE000 to #xFFFD] | [#x10000 to #x10FFFF]
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param messageBody The message to send. String maximum 256 KB in size.
     * For a list of allowed characters, see the preceding important note.
     * 
     * @return The response from the SendMessage service method, as returned
     *         by AmazonSQS.
     * 
     * @throws InvalidMessageContentsException
     * @throws UnsupportedOperationException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SendMessageResult sendMessage(String queueUrl, String messageBody) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setQueueUrl(queueUrl);
        sendMessageRequest.setMessageBody(messageBody);
        return sendMessage(sendMessageRequest);
    }
    
    /**
     * <p>
     * Retrieves one or more messages, with a maximum limit of 10 messages,
     * from the specified queue. Long poll support is enabled by using the
     * <code>WaitTimeSeconds</code> parameter. For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-long-polling.html"> Amazon SQS Long Poll </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * <p>
     * Short poll is the default behavior where a weighted random set of
     * machines is sampled on a <code>ReceiveMessage</code> call. This means
     * only the messages on the sampled machines are returned. If the number
     * of messages in the queue is small (less than 1000), it is likely you
     * will get fewer messages than you requested per
     * <code>ReceiveMessage</code> call. If the number of messages in the
     * queue is extremely small, you might not receive any messages in a
     * particular <code>ReceiveMessage</code> response; in which case you
     * should repeat the request.
     * </p>
     * <p>
     * For each message returned, the response includes the following:
     * </p>
     * 
     * <ul>
     * <li> <p>
     * Message body
     * </p>
     * </li>
     * <li> <p>
     * MD5 digest of the message body. For information about MD5, go to
     * <a href="http://www.faqs.org/rfcs/rfc1321.html"> http://www.faqs.org/rfcs/rfc1321.html </a>
     * .
     * </p>
     * </li>
     * <li> <p>
     * Message ID you received when you sent the message to the queue.
     * </p>
     * </li>
     * <li> <p>
     * Receipt handle.
     * </p>
     * </li>
     * <li> <p>
     * Message attributes.
     * </p>
     * </li>
     * <li> <p>
     * MD5 digest of the message attributes.
     * </p>
     * </li>
     * 
     * </ul>
     * <p>
     * The receipt handle is the identifier you must provide when deleting
     * the message. For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/ImportantIdentifiers.html"> Queue and Message Identifiers </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * <p>
     * You can provide the <code>VisibilityTimeout</code> parameter in your
     * request, which will be applied to the messages that Amazon SQS returns
     * in the response. If you do not include the parameter, the overall
     * visibility timeout for the queue is used for the returned messages.
     * For more information, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/AboutVT.html"> Visibility Timeout </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b> Going forward, new attributes might be added. If you are
     * writing code that calls this action, we recommend that you structure
     * your code so that it can handle new attributes gracefully.
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * 
     * @return The response from the ReceiveMessage service method, as
     *         returned by AmazonSQS.
     * 
     * @throws OverLimitException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ReceiveMessageResult receiveMessage(String queueUrl) {
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest();
        receiveMessageRequest.setQueueUrl(queueUrl);
        return receiveMessage(receiveMessageRequest);
    }
    
    /**
     * <p>
     * Returns a list of your queues. The maximum number of queues that can
     * be returned is 1000. If you specify a value for the optional
     * <code>QueueNamePrefix</code> parameter, only queues with a name
     * beginning with the specified value are returned.
     * </p>
     * 
     * @param queueNamePrefix A string to use for filtering the list results.
     * Only those queues whose name begins with the specified string are
     * returned.
     * 
     * @return The response from the ListQueues service method, as returned
     *         by AmazonSQS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListQueuesResult listQueues(String queueNamePrefix) {
        ListQueuesRequest listQueuesRequest = new ListQueuesRequest();
        listQueuesRequest.setQueueNamePrefix(queueNamePrefix);
        return listQueues(listQueuesRequest);
    }
    
    /**
     * <p>
     * Deletes up to ten messages from the specified queue. This is a batch
     * version of DeleteMessage. The result of the delete action on each
     * message is reported individually in the response.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Because the batch request can result in a
     * combination of successful and unsuccessful actions, you should check
     * for batch errors even when the call returns an HTTP status code of
     * 200.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param entries A list of receipt handles for the messages to be
     * deleted.
     * 
     * @return The response from the DeleteMessageBatch service method, as
     *         returned by AmazonSQS.
     * 
     * @throws BatchEntryIdsNotDistinctException
     * @throws TooManyEntriesInBatchRequestException
     * @throws InvalidBatchEntryIdException
     * @throws EmptyBatchRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteMessageBatchResult deleteMessageBatch(String queueUrl, java.util.List<DeleteMessageBatchRequestEntry> entries) {
        DeleteMessageBatchRequest deleteMessageBatchRequest = new DeleteMessageBatchRequest();
        deleteMessageBatchRequest.setQueueUrl(queueUrl);
        deleteMessageBatchRequest.setEntries(entries);
        return deleteMessageBatch(deleteMessageBatchRequest);
    }
    
    /**
     * <p>
     * Creates a new queue, or returns the URL of an existing one. When you
     * request <code>CreateQueue</code> , you provide a name for the queue.
     * To successfully create a new queue, you must provide a name that is
     * unique within the scope of your own queues.
     * </p>
     * <p>
     * <b>NOTE:</b> If you delete a queue, you must wait at least 60 seconds
     * before creating a queue with the same name.
     * </p>
     * <p>
     * You may pass one or more attributes in the request. If you do not
     * provide a value for any attribute, the queue will have the default
     * value for that attribute. Permitted attributes are the same that can
     * be set using SetQueueAttributes.
     * </p>
     * <p>
     * <b>NOTE:</b> Use GetQueueUrl to get a queue's URL. GetQueueUrl
     * requires only the QueueName parameter.
     * </p>
     * <p>
     * If you provide the name of an existing queue, along with the exact
     * names and values of all the queue's attributes,
     * <code>CreateQueue</code> returns the queue URL for the existing queue.
     * If the queue name, attribute names, or attribute values do not match
     * an existing queue, <code>CreateQueue</code> returns an error.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     * 
     * @param queueName The name for the queue to be created.
     * 
     * @return The response from the CreateQueue service method, as returned
     *         by AmazonSQS.
     * 
     * @throws QueueNameExistsException
     * @throws QueueDeletedRecentlyException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateQueueResult createQueue(String queueName) {
        CreateQueueRequest createQueueRequest = new CreateQueueRequest();
        createQueueRequest.setQueueName(queueName);
        return createQueue(createQueueRequest);
    }
    
    /**
     * <p>
     * Adds a permission to a queue for a specific
     * <a href="http://docs.aws.amazon.com/general/latest/gr/glos-chap.html#P"> principal </a>
     * . This allows for sharing access to the queue.
     * </p>
     * <p>
     * When you create a queue, you have full control access rights for the
     * queue. Only you (as owner of the queue) can grant or deny permissions
     * to the queue. For more information about these permissions, see
     * <a href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/acp-overview.html"> Shared Queues </a>
     * in the <i>Amazon SQS Developer Guide</i> .
     * </p>
     * <p>
     * <b>NOTE:</b> AddPermission writes an Amazon SQS-generated policy. If
     * you want to write your own policy, use SetQueueAttributes to upload
     * your policy. For more information about writing your own policy, see
     * Using The Access Policy Language in the Amazon SQS Developer Guide.
     * </p>
     * <p>
     * <b>NOTE:</b>Some API actions take lists of parameters. These lists
     * are specified using the param.n notation. Values of n are integers
     * starting from 1. For example, a parameter list with two elements looks
     * like this:
     * </p>
     * <p>
     * <code>&Attribute.1=this</code>
     * </p>
     * <p>
     * <code>&Attribute.2=that</code>
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param label The unique identification of the permission you're
     * setting (e.g., <code>AliceSendMessage</code>). Constraints: Maximum 80
     * characters; alphanumeric characters, hyphens (-), and underscores (_)
     * are allowed.
     * @param aWSAccountIds The AWS account number of the <a
     * href="http://docs.aws.amazon.com/general/latest/gr/glos-chap.html#P">principal</a>
     * who will be given permission. The principal must have an AWS account,
     * but does not need to be signed up for Amazon SQS. For information
     * about locating the AWS account identification, see <a
     * href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/AWSCredentials.html">Your
     * AWS Identifiers</a> in the <i>Amazon SQS Developer Guide</i>.
     * @param actions The action the client wants to allow for the specified
     * principal. The following are valid values: <code>* | SendMessage |
     * ReceiveMessage | DeleteMessage | ChangeMessageVisibility |
     * GetQueueAttributes | GetQueueUrl</code>. For more information about
     * these actions, see <a
     * href="http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/acp-overview.html#PermissionTypes">Understanding
     * Permissions</a> in the <i>Amazon SQS Developer Guide</i>.
     * <p>Specifying <code>SendMessage</code>, <code>DeleteMessage</code>, or
     * <code>ChangeMessageVisibility</code> for the <code>ActionName.n</code>
     * also grants permissions for the corresponding batch versions of those
     * actions: <code>SendMessageBatch</code>,
     * <code>DeleteMessageBatch</code>, and
     * <code>ChangeMessageVisibilityBatch</code>.
     * 
     * @return The response from the AddPermission service method, as
     *         returned by AmazonSQS.
     * 
     * @throws OverLimitException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void addPermission(String queueUrl, String label, java.util.List<String> aWSAccountIds, java.util.List<String> actions) {
        AddPermissionRequest addPermissionRequest = new AddPermissionRequest();
        addPermissionRequest.setQueueUrl(queueUrl);
        addPermissionRequest.setLabel(label);
        addPermissionRequest.setAWSAccountIds(aWSAccountIds);
        addPermissionRequest.setActions(actions);
        addPermission(addPermissionRequest);
    }
    
    /**
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
     * <b>NOTE:</b> The receipt handle is associated with a specific
     * instance of receiving the message. If you receive a message more than
     * once, the receipt handle you get each time you receive the message is
     * different. When you request DeleteMessage, if you don't provide the
     * most recently received receipt handle for the message, the request
     * will still succeed, but the message might not be deleted.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> It is possible you will receive a message even
     * after you have deleted it. This might happen on rare occasions if one
     * of the servers storing a copy of the message is unavailable when you
     * request to delete the message. The copy remains on the server and
     * might be returned to you again on a subsequent receive request. You
     * should create your system to be idempotent so that receiving a
     * particular message more than once is not a problem.
     * </p>
     * 
     * @param queueUrl The URL of the Amazon SQS queue to take action on.
     * @param receiptHandle The receipt handle associated with the message to
     * delete.
     * 
     * @return The response from the DeleteMessage service method, as
     *         returned by AmazonSQS.
     * 
     * @throws ReceiptHandleIsInvalidException
     * @throws InvalidIdFormatException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSQS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteMessage(String queueUrl, String receiptHandle) {
        DeleteMessageRequest deleteMessageRequest = new DeleteMessageRequest();
        deleteMessageRequest.setQueueUrl(queueUrl);
        deleteMessageRequest.setReceiptHandle(receiptHandle);
        deleteMessage(deleteMessageRequest);
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            Unmarshaller<X, StaxUnmarshallerContext> unmarshaller,
            ExecutionContext executionContext)
    {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();
        if (originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setCredentials(credentials);
        
        StaxResponseHandler<X> responseHandler = new StaxResponseHandler<X>(unmarshaller);
        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
        return client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }
}
        