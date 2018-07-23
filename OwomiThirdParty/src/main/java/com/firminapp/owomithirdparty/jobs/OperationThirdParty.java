package com.firminapp.owomithirdparty.jobs;

/**
 * Created by firmin on 18/07/18.
 */

public class OperationThirdParty {
    private int typeOperation;//1=athentification, 2=payement

    public OperationThirdParty() {
    }

    public OperationThirdParty(int typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(int typeOperation) {
        this.typeOperation = typeOperation;
    }
}
