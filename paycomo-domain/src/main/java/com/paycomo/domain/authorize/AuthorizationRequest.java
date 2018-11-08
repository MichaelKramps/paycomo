package com.paycomo.domain.authorize;


public class AuthorizationRequest {
    private ClientReferenceInformation clientReferenceInformation;
    private ProcessingInformation processingInformation;
    private PaymentInformation paymentInformation;
    private OrderInformation orderInformation;
    private BuyerInformation buyerInformation;
    private RecipientInformation recipientInformation;
    private DeviceInformation deviceInformation;
    private MerchantInformation merchantInformation;
    private AggregatorInformation aggregatorInformation;
    private ConsumerAuthenticationInformation consumerAuthenticationInformation;
    private PointOfSaleInformation pointOfSaleInformation;
    private MerchantDefinedInformation merchantDefinedInformation;

    public ClientReferenceInformation getClientReferenceInformation() {
        return clientReferenceInformation;
    }

    public void setClientReferenceInformation(ClientReferenceInformation clientReferenceInformation) {
        this.clientReferenceInformation = clientReferenceInformation;
    }

    public ProcessingInformation getProcessingInformation() {
        return processingInformation;
    }

    public void setProcessingInformation(ProcessingInformation processingInformation) {
        this.processingInformation = processingInformation;
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

    public BuyerInformation getBuyerInformation() {
        return buyerInformation;
    }

    public void setBuyerInformation(BuyerInformation buyerInformation) {
        this.buyerInformation = buyerInformation;
    }

    public RecipientInformation getRecipientInformation() {
        return recipientInformation;
    }

    public void setRecipientInformation(RecipientInformation recipientInformation) {
        this.recipientInformation = recipientInformation;
    }

    public DeviceInformation getDeviceInformation() {
        return deviceInformation;
    }

    public void setDeviceInformation(DeviceInformation deviceInformation) {
        this.deviceInformation = deviceInformation;
    }

    public MerchantInformation getMerchantInformation() {
        return merchantInformation;
    }

    public void setMerchantInformation(MerchantInformation merchantInformation) {
        this.merchantInformation = merchantInformation;
    }

    public AggregatorInformation getAggregatorInformation() {
        return aggregatorInformation;
    }

    public void setAggregatorInformation(AggregatorInformation aggregatorInformation) {
        this.aggregatorInformation = aggregatorInformation;
    }

    public ConsumerAuthenticationInformation getConsumerAuthenticationInformation() {
        return consumerAuthenticationInformation;
    }

    public void setConsumerAuthenticationInformation(ConsumerAuthenticationInformation consumerAuthenticationInformation) {
        this.consumerAuthenticationInformation = consumerAuthenticationInformation;
    }

    public PointOfSaleInformation getPointOfSaleInformation() {
        return pointOfSaleInformation;
    }

    public void setPointOfSaleInformation(PointOfSaleInformation pointOfSaleInformation) {
        this.pointOfSaleInformation = pointOfSaleInformation;
    }

    public MerchantDefinedInformation getMerchantDefinedInformation() {
        return merchantDefinedInformation;
    }

    public void setMerchantDefinedInformation(MerchantDefinedInformation merchantDefinedInformation) {
        this.merchantDefinedInformation = merchantDefinedInformation;
    }
}
