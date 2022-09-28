package com.shashank.ps.patterns.decorator;

public class ChickenSalamiTopping extends ToppingsDecorator {

    private BasePizza basePizza;

    public ChickenSalamiTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 80;
    }
}
