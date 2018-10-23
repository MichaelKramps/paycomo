package com.paycomo.domain;

public class AmountDetails {
    private String totalAmount;
    private String currency;
    private String discountAmount;
    private String dutyAmount;
    private String taxAmount;
    private String nationalTaxIncluded;
    private String taxAppliedAfterDiscount;
    private String taxAppliedLevel;
    private String taxTypeCode;
    private String freightAmount;
    private String foreignAmount;
    private String foreignCurrency;
    private String exchangeRate;
    private String exchangeRateTimeStamp;
    private String surchargeAmount;

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDutyAmount() {
        return dutyAmount;
    }

    public void setDutyAmount(String dutyAmount) {
        this.dutyAmount = dutyAmount;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getNationalTaxIncluded() {
        return nationalTaxIncluded;
    }

    public void setNationalTaxIncluded(String nationalTaxIncluded) {
        this.nationalTaxIncluded = nationalTaxIncluded;
    }

    public String getTaxAppliedAfterDiscount() {
        return taxAppliedAfterDiscount;
    }

    public void setTaxAppliedAfterDiscount(String taxAppliedAfterDiscount) {
        this.taxAppliedAfterDiscount = taxAppliedAfterDiscount;
    }

    public String getTaxAppliedLevel() {
        return taxAppliedLevel;
    }

    public void setTaxAppliedLevel(String taxAppliedLevel) {
        this.taxAppliedLevel = taxAppliedLevel;
    }

    public String getTaxTypeCode() {
        return taxTypeCode;
    }

    public void setTaxTypeCode(String taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }

    public String getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(String freightAmount) {
        this.freightAmount = freightAmount;
    }

    public String getForeignAmount() {
        return foreignAmount;
    }

    public void setForeignAmount(String foreignAmount) {
        this.foreignAmount = foreignAmount;
    }

    public String getForeignCurrency() {
        return foreignCurrency;
    }

    public void setForeignCurrency(String foreignCurrency) {
        this.foreignCurrency = foreignCurrency;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getExchangeRateTimeStamp() {
        return exchangeRateTimeStamp;
    }

    public void setExchangeRateTimeStamp(String exchangeRateTimeStamp) {
        this.exchangeRateTimeStamp = exchangeRateTimeStamp;
    }

    public String getSurchargeAmount() {
        return surchargeAmount;
    }

    public void setSurchargeAmount(String surchargeAmount) {
        this.surchargeAmount = surchargeAmount;
    }
}
