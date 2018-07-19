package com.firminapp.owomithirdparty;

import com.firminapp.owomithirdparty.sdk.SdkOperationListener;

public class InitThirdPartyOperation  {
    private String sdkId;
    private SdkOperationListener listener;

    public InitThirdPartyOperation(String sdkId, SdkOperationListener listerner) {
        this.sdkId = sdkId;
        this.listener=listerner;
    }

    public String getSdkId() {
        return sdkId;
    }

    public void setSdkId(String sdkId) {
        this.sdkId = sdkId;
    }
}
