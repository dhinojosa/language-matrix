package com.evolutionnext.concurrency.racecondition;

public class LazyInitRace {
    private ExpensiveObject expensiveObject;

    public ExpensiveObject getInstance() {
        if (expensiveObject == null) return new ExpensiveObject();
        else return expensiveObject;
    }
}
