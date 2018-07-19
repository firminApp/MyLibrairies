package com.firminapp.mylibrairies;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firminapp.owomithirdparty.cofigs.config.Configo2o;
import com.firminapp.owomithirdparty.listeners.AuthListener;

import org.json.JSONException;
import org.json.JSONObject;

public class SdkOperationRecever extends BroadcastReceiver implements AuthListener {
private String TAG=SdkOperationRecever.class.getSimpleName();
private Intent intent;
private Context context;
    @Override
    public void onReceive(Context context, Intent intent) {

        this.intent=intent;
        this.context=context;
        Log.e(TAG, "receving an operation to procced");

        /*try {
            wait(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       onProcced();
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onProcced() {
        Log.e(TAG,"processing");
        JSONObject response=new JSONObject();
        JSONObject data=new JSONObject();
        try {
            if (intent.getExtras().get("sdkId")==null)
            {
                response.put("statut","ERROR");
                data.put("message","sdkId can not be null");
            }
            else
            {
                response.put("statut","SUCCESS");
                data.put("message","message success");
            }

            data.put("token","1234512345");

            response.put("data",data.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Intent intente=new Intent();
        intente.setAction(Configo2o.OPERATION_BROADCAST_RESPONSE);
        Bundle bundle=new Bundle();
        bundle.putString("sdkId",intent.getExtras().getString("sdkId"));
        bundle.putString("OWOMIRESPONSE",response.toString());
        intente.putExtras(bundle);
        context.sendBroadcast(intente);

    }

    @Override
    public JSONObject onFinish(JSONObject data) {

        return null;
    }

    @Override
    public String onError(String error) {
        return null;
    }
}
