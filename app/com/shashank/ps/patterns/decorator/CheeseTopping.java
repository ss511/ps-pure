package com.shashank.ps.patterns.decorator;

public class CheeseTopping extends ToppingsDecorator {

    private BasePizza basePizza;

    public CheeseTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 50;
    }
}
