package com.zzycc.yuche.zzycc_subscriber;

import android.os.Bundle;

import org.ros.android.MessageCallable;
import org.ros.android.RosActivity;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;

import sensor_msgs.PointCloud2;


public class ZzyccSubscriber extends RosActivity {
//    private AndroidSubscriber text=new AndroidSubscriber();
    private PointcloudView pclsurface;
    /** Called when the activity is first created. */
    public ZzyccSubscriber(){
        super("subscriber","subscriber");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
/*
        text.setTopicName("/camera/depth_registered/points");
        text.setMessageType(sensor_msgs.PointCloud2._TYPE);
        text.setMessageToStringCallable(new MessageCallable<java.lang.String, PointCloud2>() {
            @Override
            public java.lang.String call(PointCloud2 message) {
                return "received Pointcloud2 Msg";
            }
        });
*/
        pclsurface = new PointcloudView(this);
        pclsurface.setTopicName("/camera/depth_registered/points");
        pclsurface.setMessageType(PointCloud2._TYPE);
        setContentView(pclsurface);
    }
    @Override
    protected void init(NodeMainExecutor nodeMainExecutor){
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(getRosHostname());
        nodeConfiguration.setMasterUri(getMasterUri());
        nodeMainExecutor.execute(pclsurface, nodeConfiguration);
    }
}
