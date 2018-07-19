package com.firminapp.owomithirdparty.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firminapp.owomithirdparty.cofigs.config.Configo2o;
import com.firminapp.owomithirdparty.listeners.AuthListener;
import com.firminapp.owomithirdparty.listeners.OperationListener;

import org.json.JSONObject;

/**
 * Created by firmin on 19/07/18.
 */

public class InitThirdParty {
    private String sdkId;
    private JSONObject operationData;
    private Context context;
    private String TAG=InitThirdParty.class.getSimpleName();

    public InitThirdParty(Context context,String sdkId, JSONObject operationData) {
        this.sdkId = sdkId;
        this.context=context;
        //needed data entry to init the operartion (can be null)
        this.operationData=operationData;
    }
    public void  onSubmit(String sdkId,AuthListener listener)
    {
        Intent intent = new Intent();
        intent.setAction(Configo2o.OPERATION_BROADCAST_STARTER);
        Bundle bundle=new Bundle();
        bundle.putString("sdkId",sdkId);
        if (null!=operationData)
            bundle.putString("data",operationData.toString());
        intent.putExtra("OWOMIRESPONSE", bundle);
        context.sendBroadcast(intent);
        Log.e(TAG, "proccessing...");
        //doit probablement prendre un listener en paramettre
        listener.onProcced();
    }
   /* public void onRecevedToken(AuthListener authListener)
    {
        Intent intent = new Intent();
        intent.setAction(Configo2o.OPERATION_BROADCAST);
        Bundle bundle=new Bundle();
        bundle.putString("sdkId",sdkId);
        if (null!=operationData)
        bundle.putString("operationdata",operationData.toString());
        intent.putExtra("data", bundle);
        context.sendBroadcast(intent);

        //creer un broadcast pour l'authentification
        //JSONObject authResponse=null;
       //return authResponse;
    }*/

   /* @Override
    public void onProcced() {
        Intent intent = new Intent();
        intent.setAction(Configo2o.OPERATION_BROADCAST_STARTER);
        Bundle bundle=new Bundle();
        bundle.putString("sdkId",sdkId);
        if (null!=operationData)
            bundle.putString("data",operationData.toString());
        intent.putExtra("OWOMIRESPONSE", bundle);
        context.sendBroadcast(intent);
        Log.e(TAG, "proccessing...");
    }

    @Override
    public JSONObject onFinish(JSONObject data) {
        Log.e(TAG, data.toString());
        //successfuly finish do something with receved data
        return null;
    }

    @Override
    public String onError(String error) {
        Log.e(TAG,error);
        //an error occured ... do something accordingly
        return null;
    }*/
}
