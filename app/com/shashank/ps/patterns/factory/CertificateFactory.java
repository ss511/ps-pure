package com.shashank.ps.patterns.factory;

public class CertificateFactory {

    public Certificate getCertificateOperation (String operationType) {
        if (CertOperation.CREATE.operation.equals(operationType)) {
            return new CreateCertificate();
        } else if (CertOperation.RENEW.operation.equals(operationType)) {
            return new RenewCertificate();
        } else if (CertOperation.DELETE.operation.equals(operationType)) {
            return new DeleteCertificate();
        } else {
            return new UnknownCertificateOperation();
        }
    }
}
