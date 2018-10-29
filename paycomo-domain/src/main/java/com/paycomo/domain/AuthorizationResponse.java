package com.paycomo.domain;

public class AuthorizationResponse {
    private String id;
    private String submitTimeUtc;
    private String status;
    private String reconciliationId;
    private Links _links;
    private Embedded _embedded;
    private ErrorInformation errorInformation;
    private ClientReferenceInformation clientReferenceInformation;
    private ProcessorInformation processorInformation;
    private PaymentInformation paymentInformation;
    private OrderInformation orderInformation;
    private PointOfSaleInformation pointOfSaleInformation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubmitTimeUtc() {
        return submitTimeUtc;
    }

    public void setSubmitTimeUtc(String submitTimeUtc) {
        this.submitTimeUtc = submitTimeUtc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReconciliationId() {
        return reconciliationId;
    }

    public void setReconciliationId(String reconciliationId) {
        this.reconciliationId = reconciliationId;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public Embedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(Embedded _embedded) {
        this._embedded = _embedded;
    }

    public ErrorInformation getErrorInformation() {
        return errorInformation;
    }

    public void setErrorInformation(ErrorInformation errorInformation) {
        this.errorInformation = errorInformation;
    }

    public ClientReferenceInformation getClientReferenceInformation() {
        return clientReferenceInformation;
    }

    public void setClientReferenceInformation(ClientReferenceInformation clientReferenceInformation) {
        this.clientReferenceInformation = clientReferenceInformation;
    }

    public ProcessorInformation getProcessorInformation() {
        return processorInformation;
    }

    public void setProcessorInformation(ProcessorInformation processorInformation) {
        this.processorInformation = processorInformation;
    }

    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public OrderInformation getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }

    public PointOfSaleInformation getPointOfSaleInformation() {
        return pointOfSaleInformation;
    }

    public void setPointOfSaleInformation(PointOfSaleInformation pointOfSaleInformation) {
        this.pointOfSaleInformation = pointOfSaleInformation;
    }
}
