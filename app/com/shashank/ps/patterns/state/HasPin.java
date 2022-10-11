package com.shashank.ps.patterns.state;

public class HasPin implements ATMState {
    ATMMachine atmMachine;

    public HasPin(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You cant enter more than one card.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected");
        atmMachine.setAtmState(atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("Already entered pin.");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("Request cash.");
        if (cashToWithdraw > atmMachine.cashInMachine) {
            System.out.println("Don't have enough cash");
            atmMachine.setAtmState(atmMachine.getNoCardState());
        } else {
            System.out.println(cashToWithdraw + " is provided by the machine");
            atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);
            System.out.println("Card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCardState());

            if (atmMachine.cashInMachine <= 0) {
                atmMachine.setAtmState(atmMachine.getNoCashState());
            }
        }
    }
}
