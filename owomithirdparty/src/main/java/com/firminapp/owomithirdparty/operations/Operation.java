package com.firminapp.owomithirdparty.operations;

import android.os.Bundle;

import com.firminapp.owomithirdparty.operations.types.OperationType;

/**
 * Created by firmin on 19/07/18.
 */

public abstract class Operation {
    private Bundle data;
    private String sdkId;
    private OperationType operationType;

    /**
     * superclass of operations
     *
     * @param data data need to procced th operation
     * @param sdkId to identifie the sdk which init this operation
     */
    public Operation(Bundle data, String sdkId) {
        this.data = data;
        this.sdkId = sdkId;
    }

    public Bundle getData() {
        return data;
    }

    public void setData(Bundle data) {
        this.data = data;
    }

    public String getSdkId() {
        return sdkId;
    }

    public void setSdkId(String sdkId) {
        this.sdkId = sdkId;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
