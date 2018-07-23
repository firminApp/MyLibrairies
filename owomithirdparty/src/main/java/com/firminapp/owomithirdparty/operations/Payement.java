package com.firminapp.owomithirdparty.operations;

import android.media.VolumeShaper;
import android.os.Bundle;

import com.firminapp.owomithirdparty.operations.types.OperationType;

/**
 * Created by firmin on 23/07/18.
 */

public class Payement extends Operation{

    private String CODE_PRODUIT_KEY="codeProduit";
    private String MONTANT_KEY="montant";
    private String DESTINATAIRE_KEY="destinataire";
    private String FORMSTRING_KEY="formString";
    private String REFERENCE_EXTERNE_KEY="referenceExterne";

    /**
     * superclass of operations
     *
     * @param data          data need to procced th operation
     * @param sdkId         to identifie the sdk which init this operation

     */
    private String codeProduit;
    private String montant;
    private String destinataire;
    private String formString;
    private String referenceExterne;
    public Payement(Bundle data,
                    String sdkId,
                    String codeProduit,
                    String montant,
                    String destinataire,
                    String formString,
                    String referenceExterne) {
        super(data, sdkId);
        this.setOperationType(OperationType.PAYEMENT);
        this.codeProduit=codeProduit;
        this.destinataire=destinataire;
        this.montant=montant;
        this.formString=formString;
        this.referenceExterne=referenceExterne;

        data.putString(CODE_PRODUIT_KEY,codeProduit);
        data.putString(MONTANT_KEY,montant);
        data.putString(DESTINATAIRE_KEY,destinataire);
        data.putString(FORMSTRING_KEY,formString);
        data.putString(REFERENCE_EXTERNE_KEY,referenceExterne);
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getFormString() {
        return formString;
    }

    public void setFormString(String formString) {
        this.formString = formString;
    }
}
