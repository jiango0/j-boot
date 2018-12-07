package com.jzc.spring.coupon.constant;

public enum PartnerEnum {

    PLAY1("4483259F-3261-41F0-922F-E9EEC4166374", "Play1互动中心"),
    MIYOU("142F0894-66B4-4A4C-AB0D-6A84B5891C08", "蜜柚潮玩"),
    CHAOLECHANG("1ED99993-AF12-4DEB-9A5A-3B545AB4E54C", "大玩家超乐场"),
    GUFEN("5AC8CE38-3020-4061-AE7F-CAF2829C6D62", "大玩家股份公司")
    ;

    private String code;

    private String value;

    PartnerEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
