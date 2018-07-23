package com.firminapp.owomimicrocore.recevers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firminapp.owomimicrocore.config.Config;

import org.json.JSONException;
import org.json.JSONObject;

public class SdkOperationRecever extends BroadcastReceiver /*implements AuthListener*/ {
    private String TAG=SdkOperationRecever.class.getSimpleName();
    private Intent intent;
    private Context context;
    private final String ERROR_MESG="ERROR";
    private final String SUCCESS_MESG="SUCCESS";
    private final String STATUT_KEY="statut";
    private final String MESSAGE_KEY="message";
    private final String OWOMI_RESPPONSE_KEY="owomiResponse";
    private JSONObject internetErrorResponse,erreorResponse;

    /**
     * receve operations from sdk to process
     * have to proccess this operation and send the response by broadcast
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e(TAG,"operation receved...");
        Intent intente=new Intent();
        intente.setAction(Config.OPERATION_BROADCAST_RESPONSE);

        internetErrorResponse=new JSONObject();
        erreorResponse=new JSONObject();
        try {
            internetErrorResponse.put(STATUT_KEY,ERROR_MESG);
            internetErrorResponse.put(MESSAGE_KEY,"Impossible de se connecter au serveur");
            erreorResponse.put(STATUT_KEY,ERROR_MESG);
           // erreorResponse.put(MESSAGE_KEY,"Une error s'est produite lors du processus ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Bundle bundleTosend=new Bundle();



        Bundle bundle=intent.getExtras();
        String sdkId=null;
        String typeOperation=null;
         sdkId=bundle.getString("sdkId");

         typeOperation=bundle.getString("typeOperation");

        if (typeOperation==null)
        {
            try {
                erreorResponse.put(MESSAGE_KEY,"Information incomplete pour déclencher l'opération demandée, le type d'opération n'a pas été renseigné ");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            bundleTosend.putString(OWOMI_RESPPONSE_KEY,erreorResponse.toString());
            intente.putExtras(bundleTosend);
            context.sendBroadcast(intente);
            return;
        }
        if (sdkId==null)
        {
            try {
                erreorResponse.put(MESSAGE_KEY,"Information incomplete pour déclencher l'opération demandée, le sdkId n'a pas été renseigné ");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            bundleTosend.putString(OWOMI_RESPPONSE_KEY,erreorResponse.toString());
            intente.putExtras(bundleTosend);
            context.sendBroadcast(intente);
            return;
        }

        switch (typeOperation)
        {
            //authentification thirdParty
            case "1":
                proccedOperation("1");
                break;
                //payement thirdParty
            case "2":
                proccedOperation("2");
                break;
                default:
            proccedOperation("2");

        }

    }


   public void proccedOperation(String typeOperation)
   {
       Log.e(TAG,"proccessiong...");
       Bundle bundle=new Bundle();
       JSONObject response=new JSONObject();
       try {
           response.put(STATUT_KEY,SUCCESS_MESG);
           response.put(MESSAGE_KEY,response);
           bundle.putString(OWOMI_RESPPONSE_KEY,response.toString());

           Intent intente=new Intent();
           intente.setAction(Config.OPERATION_BROADCAST_RESPONSE);
           intent.putExtras(bundle);
           context.sendBroadcast(intente);


       } catch (JSONException e) {
           e.printStackTrace();
       }


       //todo make request
       //todo get server response
       //todo send receved data by broadcast to sdk

   }
}
