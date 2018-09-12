package com.zzycc.yuche.zzycc_subscriber;

import android.util.Log;

import org.ros.android.MessageCallable;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeMain;
import org.ros.node.topic.Subscriber;

import sensor_msgs.PointCloud2;

public class AndroidSubscriber implements NodeMain{
    private String topicName;
    private String messageType;
    private MessageCallable<String,PointCloud2> callable;
    private int count;
    public void setTopicName(String topicName){
        this.topicName=topicName;
    }

    public void setMessageType(String messageType){
        this.messageType=messageType;
    }

    public void setMessageToStringCallable(MessageCallable<String, PointCloud2> callable) {
        this.callable=callable;
    }
    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("android_subscriber_yuche");
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {
        count=0;
        Subscriber<PointCloud2> subscriber = connectedNode.newSubscriber(topicName,messageType);
        subscriber.addMessageListener(new MessageListener<PointCloud2>() {
            @Override
            public void onNewMessage(PointCloud2 message) {
                if(callable!=null) {
                    Log.d("message_From_phone", callable.call(message)+"count: "+String.valueOf(++count));
                    Log.d("message_From_phone", "Height: "+String.valueOf(message.getHeight()));
                    Log.d("message_From_phone", "Width: "+String.valueOf(message.getWidth()));
                    Log.d("message_From_phone", "PointField size: "+String.valueOf(message.getFields().size()));
                    Log.d("message_From_phone", "PointField0 name: "+String.valueOf(message.getFields().get(0).getName()));
                    Log.d("message_From_phone", "PointField0 Datatype: "+String.valueOf(message.getFields().get(0).getDatatype()));
                    Log.d("message_From_phone", "PointField0 Offset : "+String.valueOf(message.getFields().get(0).getOffset()));
                    Log.d("message_From_phone", "PointField0 Count : "+String.valueOf(message.getFields().get(0).getCount()));
                    Log.d("message_From_phone", "PointField1 name: "+String.valueOf(message.getFields().get(1).getName()));
                    Log.d("message_From_phone", "PointField1 Datatype: "+String.valueOf(message.getFields().get(1).getDatatype()));
                    Log.d("message_From_phone", "PointField1 Offset : "+String.valueOf(message.getFields().get(1).getOffset()));
                    Log.d("message_From_phone", "PointField1 Count : "+String.valueOf(message.getFields().get(1).getCount()));
                    Log.d("message_From_phone", "PointField2 name: "+String.valueOf(message.getFields().get(2).getName()));
                    Log.d("message_From_phone", "PointField2 Datatype: "+String.valueOf(message.getFields().get(2).getDatatype()));
                    Log.d("message_From_phone", "PointField2 Offset : "+String.valueOf(message.getFields().get(2).getOffset()));
                    Log.d("message_From_phone", "PointField2 Count : "+String.valueOf(message.getFields().get(2).getCount()));
                    Log.d("message_From_phone", "PointField3 name: "+String.valueOf(message.getFields().get(3).getName()));
                    Log.d("message_From_phone", "PointField3 Datatype: "+String.valueOf(message.getFields().get(3).getDatatype()));
                    Log.d("message_From_phone", "PointField3 Offset : "+String.valueOf(message.getFields().get(3).getOffset()));
                    Log.d("message_From_phone", "PointField3 Count : "+String.valueOf(message.getFields().get(3).getCount()));
                    Log.d("message_From_phone", "Point_step : "+String.valueOf(message.getPointStep()));
                    Log.d("message_From_phone", "Row_step : "+String.valueOf(message.getRowStep()));
                    Log.d("message_From_phone", "data size : "+String.valueOf(message.getData().capacity()));

                }
                else{
                    Log.d("message_From_phone", message.toString()+"count: "+String.valueOf(++count));
                }
            }
        });
    }

    @Override
    public void onShutdown(Node node) {

    }

    @Override
    public void onShutdownComplete(Node node) {

    }

    @Override
    public void onError(Node node, Throwable throwable) {

    }
}
