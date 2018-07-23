package com.firminapp.owomithirdparty;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firminapp.owomithirdparty.cofigs.config.Configo2o;
import com.firminapp.owomithirdparty.listeners.AuthListener;
import com.firminapp.owomithirdparty.listeners.PayementListener;
import com.firminapp.owomithirdparty.operations.Operation;
import com.firminapp.owomithirdparty.operations.Payement;
import com.firminapp.owomithirdparty.recevers.OperationResponseRecever;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by firmin on 23/07/18.
 */

public class OwomiThirdParty {
   private Operation operation=null;
   private Context context;
   private JSONObject testResponseAuth;
   private JSONObject testResponsePayement;
   private String TAG=OwomiThirdParty.class.getSimpleName();

    /**
     * init an operation to procced by the thirdparty librairie
     * @param operation the operation to procced
     *                  you can to things like Operation=new Payement(...)
     */
    public OwomiThirdParty(Context context,Operation operation) {
        this.operation=operation;
        this.context=context;
    }
    public void initAuthThirdParty( AuthListener authListener)
    {
        authListener.onProcced();
        this.testResponseAuth=new JSONObject();
        try{
            this.testResponseAuth.put("statut","succes");
            this.testResponseAuth.put("message","succes");
            this.testResponseAuth.put("token","1234567890");


        } catch (JSONException e) {
            e.printStackTrace();
        }


        //create and send broadcast to owomi app
        proccedAuthentification(authListener);
        //todo to simulate this operation in test enviroment
        //todo to be remove on production
        //todo this must be replace by the process of waiting for the broacast response from owomiApp


/*
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

        thread.run();*/
        Log.e(TAG,"finish waiting for the operation...");

        //todo the real response will come from the broadcast
        BroadcastReceiver receiver=new OperationResponseRecever(){
            @Override
            public void onReceive(Context context, Intent intent) {
                super.onReceive(context, intent);
                //intent.getExtras().
                Bundle bundle=intent.getExtras();
                Log.e(TAG,"OperationRecever "+bundle.getString("data").toString());
            }
        };
        authListener.onFinish(testResponseAuth);

    }
    public void initThirdPartyPayement(PayementListener payementListener)
    {
        //for test
        this.testResponsePayement=new JSONObject();
        try {
            this.testResponsePayement.put("statut","success");
            this.testResponsePayement.put("message","Payement soumis avec succes");
            this.testResponsePayement.put("operationId","88");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //create and send broadcast to owomi app
        proccedPayement(payementListener);
        //for test
        payementListener.onFinish(testResponsePayement);

    }
    private void proccedAuthentification(AuthListener listener)
    {

        Intent intent = new Intent();

        intent.setAction(Configo2o.OPERATION_BROADCAST_STARTER);
        if (null==operation)
        {
            listener.onError("Données non complète pour proceder à l'opération");
            return;
        }
        intent.putExtras(operation.getData());
        context.sendBroadcast(intent);



    }
    private void proccedPayement(PayementListener listener)
    {
        //todo verifier d'abord que les donnée sont au complet
        Intent intent = new Intent();

        intent.setAction(Configo2o.OPERATION_BROADCAST_STARTER);
        if (null==operation)
        {
            listener.onError("Données non complète pour proceder à l'opération");
            return;
        }
        intent.putExtras(operation.getData());
        context.sendBroadcast(intent);


    }

}
