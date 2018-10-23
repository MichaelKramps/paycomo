package com.paycomo.domain;

public class CaptureOptions {
    private int captureSequenceNumber;
    private int totalCaptureCount;
    private String dateToCapture;

    public int getCaptureSequenceNumber() {
        return captureSequenceNumber;
    }

    public void setCaptureSequenceNumber(int captureSequenceNumber) {
        this.captureSequenceNumber = captureSequenceNumber;
    }

    public int getTotalCaptureCount() {
        return totalCaptureCount;
    }

    public void setTotalCaptureCount(int totalCaptureCount) {
        this.totalCaptureCount = totalCaptureCount;
    }

    public String getDateToCapture() {
        return dateToCapture;
    }

    public void setDateToCapture(String dateToCapture) {
        this.dateToCapture = dateToCapture;
    }
}
