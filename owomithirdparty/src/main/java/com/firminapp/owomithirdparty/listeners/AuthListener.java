package com.firminapp.owomithirdparty.listeners;

import org.json.JSONObject;

/**
 * Created by firmin on 19/07/18.
 */

public interface AuthListener {
    //JSONObject onInitAuth(String sdkId);
    void onProcced();
    JSONObject onFinish(JSONObject data);
    String onError(String error);
}
