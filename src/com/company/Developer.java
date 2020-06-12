package com.company;

public abstract class Developer extends Employee{

    public Developer(int id, int salary, String name, Position position) {
        super(id, salary, name, position);
    }

    public abstract void whoAmI();
}
