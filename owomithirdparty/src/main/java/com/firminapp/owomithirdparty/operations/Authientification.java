package com.firminapp.owomithirdparty.operations;

import android.os.Bundle;

import com.firminapp.owomithirdparty.operations.types.OperationType;

/**
 * Created by firmin on 23/07/18.
 */

public class Authientification extends Operation {
    /**
     * superclass of operations
     *
     * @param data  data need to procced th operation
     * @param sdkId to identifie the sdk which init this operation
     */
    public Authientification(Bundle data, String sdkId) {
        super(data, sdkId);
        this.setOperationType(OperationType.AUTHENTIFICATION);
    }
}
