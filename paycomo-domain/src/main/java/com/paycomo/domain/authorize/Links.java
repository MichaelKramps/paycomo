package com.paycomo.domain.authorize;

public class Links {
    private Link self;
    private Link reversal;
    private Link capture;

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Link getReversal() {
        return reversal;
    }

    public void setReversal(Link reversal) {
        this.reversal = reversal;
    }

    public Link getCapture() {
        return capture;
    }

    public void setCapture(Link capture) {
        this.capture = capture;
    }
}
