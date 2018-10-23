package com.paycomo.domain;

public class PointOfSaleInformation {
    private String terminalId;
    private String laneNumber;
    private boolean cardPresent;
    private int catLevel;
    private String entryMode;
    private int terminalCapability;
    private String operatingEnvironment;
    private String amexCapnData;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getLaneNumber() {
        return laneNumber;
    }

    public void setLaneNumber(String laneNumber) {
        this.laneNumber = laneNumber;
    }

    public boolean isCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(boolean cardPresent) {
        this.cardPresent = cardPresent;
    }

    public int getCatLevel() {
        return catLevel;
    }

    public void setCatLevel(int catLevel) {
        this.catLevel = catLevel;
    }

    public String getEntryMode() {
        return entryMode;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
    }

    public int getTerminalCapability() {
        return terminalCapability;
    }

    public void setTerminalCapability(int terminalCapability) {
        this.terminalCapability = terminalCapability;
    }

    public String getOperatingEnvironment() {
        return operatingEnvironment;
    }

    public void setOperatingEnvironment(String operatingEnvironment) {
        this.operatingEnvironment = operatingEnvironment;
    }

    public String getAmexCapnData() {
        return amexCapnData;
    }

    public void setAmexCapnData(String amexCapnData) {
        this.amexCapnData = amexCapnData;
    }
}
