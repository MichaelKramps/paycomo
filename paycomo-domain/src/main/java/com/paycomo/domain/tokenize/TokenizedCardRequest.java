package com.paycomo.domain.tokenize;

public class TokenizedCardRequest {
    private String keyId;
    private CardInfo cardInfo;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }
}
