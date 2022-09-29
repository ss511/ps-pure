package com.shashank.ps.patterns.factory;

public class DeleteCertificate implements Certificate {

    @Override
    public void crud() {
        System.out.println("Certificate delete requested.");
    }

    @Override
    public void fetch() {
        System.out.println("Certificate delete successful.");
    }
}
