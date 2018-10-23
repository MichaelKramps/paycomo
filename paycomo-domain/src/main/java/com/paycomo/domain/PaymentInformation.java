package com.paycomo.domain;

public class PaymentInformation {
    private Card card;
    private TokenizedCard tokenizedCard;
    private FluidData fluidData;
    private Customer customer;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public TokenizedCard getTokenizedCard() {
        return tokenizedCard;
    }

    public void setTokenizedCard(TokenizedCard tokenizedCard) {
        this.tokenizedCard = tokenizedCard;
    }

    public FluidData getFluidData() {
        return fluidData;
    }

    public void setFluidData(FluidData fluidData) {
        this.fluidData = fluidData;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
