package com.shashank.ps.patterns.factory;

public class CertificateService {

    public static void main(String[] args) {
        CertificateFactory certificateFactory = new CertificateFactory();

        //Create
        Certificate create = certificateFactory.getCertificateOperation("Create");
        create.crud();
        create.fetch();

        //Create
        Certificate renew = certificateFactory.getCertificateOperation("Renew");
        renew.crud();
        renew.fetch();

        //Create
        Certificate delete = certificateFactory.getCertificateOperation("Delete");
        delete.crud();
        delete.fetch();

        //Create
        Certificate unknownOps = certificateFactory.getCertificateOperation("UnknownOps");
        unknownOps.crud();
        unknownOps.fetch();
    }
}
