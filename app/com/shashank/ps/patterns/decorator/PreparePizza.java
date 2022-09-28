package com.shashank.ps.patterns.decorator;

public class PreparePizza {
    public static void main(String[] args) {
        BasePizza desiredPizza = new SupremePizza();

        System.out.println("Initial pizza cost without extra toppings: " + desiredPizza.cost());

        //Adding Toppings
        BasePizza finalPizza = new CheeseTopping(new ChickenSalamiTopping(desiredPizza));

        System.out.println("Final pizza cost after adding toppings: " + finalPizza.cost());
    }
}
