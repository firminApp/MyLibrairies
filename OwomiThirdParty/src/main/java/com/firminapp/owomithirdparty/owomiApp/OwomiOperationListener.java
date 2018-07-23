package com.firminapp.owomithirdparty.owomiApp;

import com.firminapp.owomithirdparty.jobs.OperationThirdParty;

/**
 * Created by firmin on 18/07/18.
 */

public interface OwomiOperationListener {
    //call by owomi app
    public  void onProcess(OperationThirdParty operation);
    public void onReply(OperationThirdParty operation);
}
