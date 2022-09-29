package com.shashank.ps.patterns.factory;

public enum CertOperation {

    CREATE("Create"),
    RENEW("Renew"),
    DELETE("Delete");

    public final String operation;

    private CertOperation(String operation) {
        this.operation = operation;
    }
}
