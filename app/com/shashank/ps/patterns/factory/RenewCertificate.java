package com.shashank.ps.patterns.factory;

public class RenewCertificate implements Certificate {

    @Override
    public void crud() {
        System.out.println("Certificate renew requested.");
    }

    @Override
    public void fetch() {
        System.out.println("Certificate renew successful.");
    }
}
