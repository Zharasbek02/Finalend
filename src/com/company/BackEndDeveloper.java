package com.company;

public class BackEndDeveloper extends Developer {


    public BackEndDeveloper(int id, int salary, String name, Position position) {
        super(id, salary, name, position);
    }

    @Override
    public void whoAmI() {
        System.out.println("I'm Back-end developer");
    }
}
