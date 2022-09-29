package com.shashank.ps.patterns.factory;

public class UnknownCertificateOperation implements Certificate{
    @Override
    public void crud() {
        System.out.println("Unknown Operation.");
    }

    @Override
    public void fetch() {
        System.out.println("Unknown Operation.");
    }
}
