package com.shashank.ps.patterns.chainOfResponsibility;

import java.util.Scanner;

public class Atm {
    private DispenseChain c1;
    public Atm() {
        // initialize the chain
        this.c1 = new INR500Dispenser();
        DispenseChain c2 = new INR200Dispenser();
        DispenseChain c3 = new INR100Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atm.c1.dispense(new Currency(amount));
        }
    }
}
