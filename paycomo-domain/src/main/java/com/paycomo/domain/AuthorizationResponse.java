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
}
