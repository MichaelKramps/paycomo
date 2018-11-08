package com.paycomo.domain.authorize;

public class Card {
    private String number;
    private String expirationMonth;
    private String expirationYear;
    private String type;
    private String useAs;
    private String sourceAccountType;
    private String securityCode;
    private String securityCodeIndicator;
    private String accountEncoderId;
    private String issueNumber;
    private String startMonth;
    private String startYear;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUseAs() {
        return useAs;
    }

    public void setUseAs(String useAs) {
        this.useAs = useAs;
    }

    public String getSourceAccountType() {
        return sourceAccountType;
    }

    public void setSourceAccountType(String sourceAccountType) {
        this.sourceAccountType = sourceAccountType;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getSecurityCodeIndicator() {
        return securityCodeIndicator;
    }

    public void setSecurityCodeIndicator(String securityCodeIndicator) {
        this.securityCodeIndicator = securityCodeIndicator;
    }

    public String getAccountEncoderId() {
        return accountEncoderId;
    }

    public void setAccountEncoderId(String accountEncoderId) {
        this.accountEncoderId = accountEncoderId;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }
}
