package com.shashank.ps.patterns.factory;

public class CreateCertificate implements Certificate {

    @Override
    public void crud() {
        System.out.println("Certificate create requested.");
    }

    @Override
    public void fetch() {
        System.out.println("Certificate create successful.");
    }
}
