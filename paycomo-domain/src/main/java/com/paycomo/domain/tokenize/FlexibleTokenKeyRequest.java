package com.paycomo.domain.tokenize;

public class FlexibleTokenKeyRequest {
    private String encryptionType;

    public FlexibleTokenKeyRequest(){
        this.encryptionType = "RsaOaep256";
    }

    public String getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(String encryptionType) {
        this.encryptionType = encryptionType;
    }
}
