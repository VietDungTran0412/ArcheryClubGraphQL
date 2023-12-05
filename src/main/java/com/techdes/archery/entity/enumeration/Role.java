package com.techdes.archery.entity.enumeration;

public enum Role {
    ARCHER("ARCHER"),
    ADMIN("ADMIN"),
    RECORDER("RECORDER");

    private final String code;
    Role(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
