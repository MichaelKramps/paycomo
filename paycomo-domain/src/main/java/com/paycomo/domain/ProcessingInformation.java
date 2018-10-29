package com.paycomo.domain;

public class ProcessingInformation {
    private boolean capture;
    private String processorId;
    private String commerceIndicator;
    private String paymentSolution;
    private String reconciliationId;
    private String linkId;
    private String purchaseLevel;
    private String reportGroup;
    private String visaCheckoutId;
    private Issuer issuer;
    private AuthorizationOptions authorizationOptions;
    private CaptureOptions captureOptions;
    private RecurringOptions recurringOptions;

    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }

    public String getProcessorId() {
        return processorId;
    }

    public void setProcessorId(String processorId) {
        this.processorId = processorId;
    }

    public String getCommerceIndicator() {
        return commerceIndicator;
    }

    public void setCommerceIndicator(String commerceIndicator) {
        this.commerceIndicator = commerceIndicator;
    }

    public String getPaymentSolution() {
        return paymentSolution;
    }

    public void setPaymentSolution(String paymentSolution) {
        this.paymentSolution = paymentSolution;
    }

    public String getReconciliationId() {
        return reconciliationId;
    }

    public void setReconciliationId(String reconciliationId) {
        this.reconciliationId = reconciliationId;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getPurchaseLevel() {
        return purchaseLevel;
    }

    public void setPurchaseLevel(String purchaseLevel) {
        this.purchaseLevel = purchaseLevel;
    }

    public String getReportGroup() {
        return reportGroup;
    }

    public void setReportGroup(String reportGroup) {
        this.reportGroup = reportGroup;
    }

    public String getVisaCheckoutId() {
        return visaCheckoutId;
    }

    public void setVisaCheckoutId(String visaCheckoutId) {
        this.visaCheckoutId = visaCheckoutId;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public AuthorizationOptions getAuthorizationOptions() {
        return authorizationOptions;
    }

    public void setAuthorizationOptions(AuthorizationOptions authorizationOptions) {
        this.authorizationOptions = authorizationOptions;
    }

    public CaptureOptions getCaptureOptions() {
        return captureOptions;
    }

    public void setCaptureOptions(CaptureOptions captureOptions) {
        this.captureOptions = captureOptions;
    }

    public RecurringOptions getRecurringOptions() {
        return recurringOptions;
    }

    public void setRecurringOptions(RecurringOptions recurringOptions) {
        this.recurringOptions = recurringOptions;
    }
}
