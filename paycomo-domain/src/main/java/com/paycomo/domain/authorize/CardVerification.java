package com.paycomo.domain.authorize;

public class CardVerification {
    private String resultCode;
    private String resultCodeRaw;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultCodeRaw() {
        return resultCodeRaw;
    }

    public void setResultCodeRaw(String resultCodeRaw) {
        this.resultCodeRaw = resultCodeRaw;
    }
}
