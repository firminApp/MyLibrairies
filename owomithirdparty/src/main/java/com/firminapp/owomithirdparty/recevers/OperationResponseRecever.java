package com.firminapp.owomithirdparty.recevers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firminapp.owomithirdparty.listeners.AuthListener;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * response from owomi after proccede an operation
 */
public class OperationResponseRecever extends BroadcastReceiver implements AuthListener {
private String TAG=OperationResponseRecever.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        String data=bundle.getString("OWOMIRESPONSE");
        Log.e(TAG,"onReceive: data="+data);
        JSONObject response=null;
        try {
            //response must content statut= success|error data="data need by operarion"
             response=new JSONObject(data);
             String statut=response.getString("statut");
             String responsdata=response.getString("data");
             switch (statut)
             {
                 case "ERROR":
                     onError(responsdata);
                     break;
                 case "SUCCESS":
                     onFinish(response);
                     break;
                     default:
                         onFinish(response);


                         return;
             }

        } catch (JSONException e) {
            onError(e.getMessage());
            e.printStackTrace();
        }
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onProcced() {
        Log.e(TAG, "processing...");
    }

    @Override
    public JSONObject onFinish(JSONObject data) {
        Log.e(TAG,"onFinish: data="+data);
        return data;
    }

    @Override
    public String onError(String data) {
        Log.e(TAG,"onError: data="+data);
        return data;
    }
}
