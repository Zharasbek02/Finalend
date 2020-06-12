package com.company;

public class FrontEndDeveloper extends Developer {


    public FrontEndDeveloper(int id, int salary, String name, Position position) {
        super(id, salary, name, position);
    }

    @Override
    public void whoAmI() {
        System.out.println("I'm Front-end Developer");
    }
}
