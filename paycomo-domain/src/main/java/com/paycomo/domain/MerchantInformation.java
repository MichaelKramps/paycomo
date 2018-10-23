package com.paycomo.domain;

public class MerchantInformation {
    private String salesOrganizationId;
    private int categoryCode;
    private String vatRegistrationNumber;
    private String cardAcceptorReferenceNumber;
    private String transactionLocalDateTime;
    private MerchantDescriptor merchantDescriptor;

    public String getSalesOrganizationId() {
        return salesOrganizationId;
    }

    public void setSalesOrganizationId(String salesOrganizationId) {
        this.salesOrganizationId = salesOrganizationId;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getVatRegistrationNumber() {
        return vatRegistrationNumber;
    }

    public void setVatRegistrationNumber(String vatRegistrationNumber) {
        this.vatRegistrationNumber = vatRegistrationNumber;
    }

    public String getCardAcceptorReferenceNumber() {
        return cardAcceptorReferenceNumber;
    }

    public void setCardAcceptorReferenceNumber(String cardAcceptorReferenceNumber) {
        this.cardAcceptorReferenceNumber = cardAcceptorReferenceNumber;
    }

    public String getTransactionLocalDateTime() {
        return transactionLocalDateTime;
    }

    public void setTransactionLocalDateTime(String transactionLocalDateTime) {
        this.transactionLocalDateTime = transactionLocalDateTime;
    }

    public MerchantDescriptor getMerchantDescriptor() {
        return merchantDescriptor;
    }

    public void setMerchantDescriptor(MerchantDescriptor merchantDescriptor) {
        this.merchantDescriptor = merchantDescriptor;
    }
}
