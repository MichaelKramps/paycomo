package com.paycomo.domain.tokenize;

public class FlexibleTokenKeyResponse {
    private String keyId;
    private Der der;
    private Jwk jwk;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public Der getDer() {
        return der;
    }

    public void setDer(Der der) {
        this.der = der;
    }

    public Jwk getJwk() {
        return jwk;
    }

    public void setJwk(Jwk jwk) {
        this.jwk = jwk;
    }
}
