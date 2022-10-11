package com.shashank.ps.patterns.state;

public class NoCash implements ATMState {
    ATMMachine atmMachine;

    public NoCash(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("No cash.");
    }

    @Override
    public void ejectCard() {
        System.out.println("You didn't entered a card.");
    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("No cash.");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("No cash.");
    }
}
