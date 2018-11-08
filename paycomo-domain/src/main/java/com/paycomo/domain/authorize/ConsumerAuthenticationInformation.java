package com.paycomo.domain.authorize;

public class ConsumerAuthenticationInformation {
    private String cavv;
    private String cavvAlgorithm;
    private String eciRaw;
    private String paresStatus;
    private String veresEnrolled;
    private String xid;
    private String ucafAuthenticationData;
    private String ucafCollectionIndicator;

    public String getCavv() {
        return cavv;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public String getCavvAlgorithm() {
        return cavvAlgorithm;
    }

    public void setCavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
    }

    public String getEciRaw() {
        return eciRaw;
    }

    public void setEciRaw(String eciRaw) {
        this.eciRaw = eciRaw;
    }

    public String getParesStatus() {
        return paresStatus;
    }

    public void setParesStatus(String paresStatus) {
        this.paresStatus = paresStatus;
    }

    public String getVeresEnrolled() {
        return veresEnrolled;
    }

    public void setVeresEnrolled(String veresEnrolled) {
        this.veresEnrolled = veresEnrolled;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getUcafAuthenticationData() {
        return ucafAuthenticationData;
    }

    public void setUcafAuthenticationData(String ucafAuthenticationData) {
        this.ucafAuthenticationData = ucafAuthenticationData;
    }

    public String getUcafCollectionIndicator() {
        return ucafCollectionIndicator;
    }

    public void setUcafCollectionIndicator(String ucafCollectionIndicator) {
        this.ucafCollectionIndicator = ucafCollectionIndicator;
    }
}
