package com.paycomo.domain.authorize;

public class CodeResponse {
    private String code;
    private String codeRaw;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeRaw() {
        return codeRaw;
    }

    public void setCodeRaw(String codeRaw) {
        this.codeRaw = codeRaw;
    }
}
