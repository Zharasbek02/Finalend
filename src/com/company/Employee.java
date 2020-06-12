package com.company;

public abstract class Employee {
    private int id;
    private int salary;
    private String name;
    private Position position;

    public Employee(int id, int salary, String name, Position position) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position.myPosition();
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
