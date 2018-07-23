package com.firminapp.owomithirdparty.recevers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firminapp.owomithirdparty.listeners.AuthListener;
import com.firminapp.owomithirdparty.listeners.PayementListener;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * response from owomi after proccede an operation
 */
public class OperationResponseRecever extends BroadcastReceiver implements AuthListener, PayementListener {
private String TAG=OperationResponseRecever.class.getSimpleName();
private JSONObject owomiAppResponse;
    @Override
    public void onReceive(Context context, Intent intent) {
        onProcced();
        Bundle bundle=intent.getExtras();
        String data=bundle.getString("owomiResponse");
        Log.e(TAG,"onReceive: data="+data);
        try {
            this.owomiAppResponse=new JSONObject(data);
            if (owomiAppResponse.has("statut")&&owomiAppResponse.getString("statut").equals("SUCCESS"))

            {
                onFinish(owomiAppResponse);
            }
            else
            {
                onError("Erreur..");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onProcced() {
        //todo simulation
        Thread thread=new  Thread(new Runnable() {
            @Override
            public void run() {

                Log.e(TAG,"waiting for the operation to finish...");

            }
        });
        synchronized (thread) {
            try {
                thread.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread.run();

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
