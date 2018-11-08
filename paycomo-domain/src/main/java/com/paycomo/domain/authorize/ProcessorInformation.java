package com.paycomo.domain.authorize;

public class ProcessorInformation {
    private String approvalCode;
    private String transactionId;
    private String responseCode;
    private String responseDetails;
    private String responseCategoryCode;
    private String forwardedAcquirerCode;
    private String systemTraceAuditNumber;
    private String paymentAccountReferenceNumber;
    private String transactionIntegrityCode;
    private String amexVerbalAuthReferenceNumber;
    private int salesSlipNumber;
    private String masterCardServiceCode;
    private String masterCardServiceReplyCode;
    private String masterCardAuthenticationType;
    private CodeResponse avs;
    private CardVerification cardVerification;
    private CodeResponse merchantAdvice;
    private ElectronicVerificationResults electronicVerificationResults;
    private Customer customer;
    private CodeResponse consumerAuthenticationResponse;
    private Issuer issuer;

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(String responseDetails) {
        this.responseDetails = responseDetails;
    }

    public String getResponseCategoryCode() {
        return responseCategoryCode;
    }

    public void setResponseCategoryCode(String responseCategoryCode) {
        this.responseCategoryCode = responseCategoryCode;
    }

    public String getForwardedAcquirerCode() {
        return forwardedAcquirerCode;
    }

    public void setForwardedAcquirerCode(String forwardedAcquirerCode) {
        this.forwardedAcquirerCode = forwardedAcquirerCode;
    }

    public String getSystemTraceAuditNumber() {
        return systemTraceAuditNumber;
    }

    public void setSystemTraceAuditNumber(String systemTraceAuditNumber) {
        this.systemTraceAuditNumber = systemTraceAuditNumber;
    }

    public String getPaymentAccountReferenceNumber() {
        return paymentAccountReferenceNumber;
    }

    public void setPaymentAccountReferenceNumber(String paymentAccountReferenceNumber) {
        this.paymentAccountReferenceNumber = paymentAccountReferenceNumber;
    }

    public String getTransactionIntegrityCode() {
        return transactionIntegrityCode;
    }

    public void setTransactionIntegrityCode(String transactionIntegrityCode) {
        this.transactionIntegrityCode = transactionIntegrityCode;
    }

    public String getAmexVerbalAuthReferenceNumber() {
        return amexVerbalAuthReferenceNumber;
    }

    public void setAmexVerbalAuthReferenceNumber(String amexVerbalAuthReferenceNumber) {
        this.amexVerbalAuthReferenceNumber = amexVerbalAuthReferenceNumber;
    }

    public int getSalesSlipNumber() {
        return salesSlipNumber;
    }

    public void setSalesSlipNumber(int salesSlipNumber) {
        this.salesSlipNumber = salesSlipNumber;
    }

    public String getMasterCardServiceCode() {
        return masterCardServiceCode;
    }

    public void setMasterCardServiceCode(String masterCardServiceCode) {
        this.masterCardServiceCode = masterCardServiceCode;
    }

    public String getMasterCardServiceReplyCode() {
        return masterCardServiceReplyCode;
    }

    public void setMasterCardServiceReplyCode(String masterCardServiceReplyCode) {
        this.masterCardServiceReplyCode = masterCardServiceReplyCode;
    }

    public String getMasterCardAuthenticationType() {
        return masterCardAuthenticationType;
    }

    public void setMasterCardAuthenticationType(String masterCardAuthenticationType) {
        this.masterCardAuthenticationType = masterCardAuthenticationType;
    }

    public CodeResponse getAvs() {
        return avs;
    }

    public void setAvs(CodeResponse avs) {
        this.avs = avs;
    }

    public CardVerification getCardVerification() {
        return cardVerification;
    }

    public void setCardVerification(CardVerification cardVerification) {
        this.cardVerification = cardVerification;
    }

    public CodeResponse getMerchantAdvice() {
        return merchantAdvice;
    }

    public void setMerchantAdvice(CodeResponse merchantAdvice) {
        this.merchantAdvice = merchantAdvice;
    }

    public ElectronicVerificationResults getElectronicVerificationResults() {
        return electronicVerificationResults;
    }

    public void setElectronicVerificationResults(ElectronicVerificationResults electronicVerificationResults) {
        this.electronicVerificationResults = electronicVerificationResults;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CodeResponse getConsumerAuthenticationResponse() {
        return consumerAuthenticationResponse;
    }

    public void setConsumerAuthenticationResponse(CodeResponse consumerAuthenticationResponse) {
        this.consumerAuthenticationResponse = consumerAuthenticationResponse;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }
}
