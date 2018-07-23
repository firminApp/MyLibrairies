package com.firminapp.owomithirdparty.operations;

import com.firminapp.owomithirdparty.jobs.OperationThirdParty;

/**
 * Created by firmin on 18/07/18.
 */

public class AuthentificationThirdParty  extends OperationThirdParty{

    private String sdkId;
    public AuthentificationThirdParty(String sdkId) {
        super();
        this.sdkId=sdkId;
        this.setTypeOperation(1);
    }

    public String getSdkId() {
        return sdkId;
    }

    public void setSdkId(String sdkId) {
        this.sdkId = sdkId;
    }
}
