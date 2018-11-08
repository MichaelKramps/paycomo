package com.paycomo.domain.authorize;

public class OrderInformation {
    private AmountDetails amountDetails;
    private PersonAddress billTo;
    private PersonAddress shipTo;

    public AmountDetails getAmountDetails() {
        return amountDetails;
    }

    public void setAmountDetails(AmountDetails amountDetails) {
        this.amountDetails = amountDetails;
    }

    public PersonAddress getBillTo() {
        return billTo;
    }

    public void setBillTo(PersonAddress billTo) {
        this.billTo = billTo;
    }

    public PersonAddress getShipTo() {
        return shipTo;
    }

    public void setShipTo(PersonAddress shipTo) {
        this.shipTo = shipTo;
    }
}
