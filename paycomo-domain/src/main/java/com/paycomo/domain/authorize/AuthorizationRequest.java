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

    public String generateCardType() {
        if (isVisa()){
            return "001";
        } else if (isMasterCard()){
            return "002";
        } else if (isAmericanExpress()){
            return "003";
        } else if (isDiscover()){
            return "004";
        }

        return "";
    }

    private boolean isVisa(){
        return passesDigitCheck(400000, 499999);
    }

    private boolean isMasterCard(){
        return (passesLengthCheck(16) && (passesDigitCheck(510000, 559999) || passesDigitCheck(222100, 272099)));
    }

    private boolean isAmericanExpress(){
        return (passesLengthCheck(15) && (passesDigitCheck(340000, 349999) || passesDigitCheck(370000, 379999)));
    }

    private boolean isDiscover(){
        return (passesLengthCheck(16) &&
                (passesDigitCheck(601100, 601109) ||
                 passesDigitCheck(601120, 601149) ||
                 passesDigitCheck(601174, 601174) ||
                 passesDigitCheck(601177, 601179) ||
                 passesDigitCheck(601186, 601199) ||
                 passesDigitCheck(644000, 659999)));
    }

    private boolean passesLengthCheck(int cardLenth){
        return getCardNumber().length() == cardLenth;
    }

    private boolean passesDigitCheck(int lowerLimit, int upperLimit){
        int firstSixDigits = getFirstSixDigits();
        return (firstSixDigits >= lowerLimit && firstSixDigits <= upperLimit);
    }

    private String getCardNumber(){
        return this.getPaymentInformation().getTokenizedCard() != null ? this.getPaymentInformation().getTokenizedCard().getNumber() : this.getPaymentInformation().getCard().getNumber();
    }

    private int getFirstSixDigits(){
        return Integer.parseInt(getCardNumber().substring(0, 6));
    }
}
