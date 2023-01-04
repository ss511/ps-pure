package com.shashank.ps.patterns.chainOfResponsibility;

public class INR200Dispenser implements DispenseChain{

    DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 200) {
            int num = cur.getAmount() / 200;
            int remainder = cur.getAmount() % 200;
            System.out.println("Dispensing " +num + " 200 note: ");
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(cur);
        }
    }
}
