package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Project {
    public void start() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please choose name of your project");
            String title = sc.next();
            System.out.println("Duration of your project(in month)");
            int duration = sc.nextInt();
            ArrayList<Employee> employees = new ArrayList<>();
            System.out.println("Please write amount of workers");
            int amount = sc.nextInt();
            System.out.println("please write down employee type\n" +
                    "1 - Manager\n" +
                    "2 - FrontEndDeveloper\n" +
                    "3 - BackendDeveloper\n");

            for (int i = 0; i < amount; i++) {
                int name = sc.nextInt();
                if (name == 1) {
                    System.out.println("your manager ID");
                    int id = sc.nextInt();
                    System.out.println("your manager salary");
                    int salary = sc.nextInt();
                    System.out.println("your manager name");
                    String worker_name = sc.next();
                    System.out.println("your manager position\n" +
                            "If it is Junior write j\n" +
                            "If it is Middle write m");
                    String position = sc.next();
                    if (position.equalsIgnoreCase("j")) {
                        Position worker_position = new Junior();
                        employees.add(new Manager(id, salary, worker_name, worker_position));
                    } else if (position.equalsIgnoreCase("m")) {
                        Position worker_position = new Middle();
                        employees.add(new Manager(id, salary, worker_name, worker_position));
                    }
                } else if (name == 2) {
                    System.out.println("your Front-end Developer ID");
                    int id = sc.nextInt();
                    System.out.println("your Front-end Developer salary");
                    int salary = sc.nextInt();
                    System.out.println("your Front-end Developer name");
                    String worker_name = sc.next();
                    System.out.println("your Front-end Developer position\n" +
                            "If it is Junior write j\n" +
                            "If it is Middle write m");
                    String position = sc.next();
                    if (position.equalsIgnoreCase("j")) {
                        Position worker_position = new Junior();
                        employees.add(new FrontEndDeveloper(id, salary, worker_name, worker_position));
                    } else if (position.equalsIgnoreCase("m")) {
                        Position worker_position = new Middle();
                        employees.add(new FrontEndDeveloper(id, salary, worker_name, worker_position));
                    }
                } else if (name == 3) {
                    System.out.println("your Back-end Developer ID");
                    int id = sc.nextInt();
                    System.out.println("your Back-end Developer salary");
                    int salary = sc.nextInt();
                    System.out.println("your Back-end Developer name");
                    String worker_name = sc.next();
                    System.out.println("your Back-end Developer position\n" +
                            "If it is Junior write j\n" +
                            "If it is Middle write m");
                    String position = sc.next();
                    if (position.equalsIgnoreCase("j")) {
                        Position worker_position = new Junior();
                        employees.add(new BackEndDeveloper(id, salary, worker_name, worker_position));
                    } else if (position.equalsIgnoreCase("m")) {
                        Position worker_position = new Middle();
                        employees.add(new BackEndDeveloper(id, salary, worker_name, worker_position));
                    }
                }
            }
            // Getting salary of of workers
            int totalCost = 0;
            for (Employee Aa : employees) {
                totalCost += Aa.getSalary();
            }
            //Complete info about project
            System.out.println("The total cost of project is" + " " + duration * totalCost);
            System.out.println("The project name is" + " " + title);
            System.out.println("The project workers are: ");
            System.out.println("                            ");
            for (Employee Aa : employees) {
                System.out.println("Worker ID: " + Aa.getId() + "\n" +
                        "Worker salary: " + Aa.getSalary() + "\n" +
                        "Worker name: " + Aa.getName() + "\n" +
                        "Worker position: " + Aa.getPosition() + "\n" +
                        "__________________________________________");
            }
            //Inserting data into Database
            System.out.println("Would you like to add these info into database?");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("yes")) {
                Connection databaseConnection = DatabaseConnection.getInstance().getConnection();
                Statement statement = databaseConnection.createStatement();//uses fpr  executing sql staatement
                for (Employee Aa : employees) {
                    int id = Aa.getId();
                    int salary = Aa.getSalary();
                    String name = Aa.getName();
                    String position = Aa.getPosition();
                    String sql = "INSERT INTO employee VALUES ('" + id + "','" + salary + "','" + name + "','" + position + "')";
                    statement.executeUpdate(sql); //for executing sql statements
                }
                databaseConnection.close();
            }
        } catch (SQLException e) { //SQL exception handling
            System.out.println("something is wrong" + e.getMessage());
        }
    }
    public void showRecordings(){
        try {
            Connection databaseConnection = DatabaseConnection.getInstance().getConnection();
            Statement statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM employee";
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()){
                int id =resultSet.getInt(1);
                int salary = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String position = resultSet.getString(4);
                System.out.println("Worker ID:" + " " + id);
                System.out.println("Worker Salary:" + " " + salary);
                System.out.println("Worker Name:" + " " + name);
                System.out.println("Worker Position:" + " " + position);
                System.out.println("____________________________________");
            }
        }catch (SQLException a){
            System.out.println("problem with Database" + " " + a.getMessage());
        }
    }
    public void showRecordingWithId(){
        try {
            System.out.println("Please write exact id for your employee");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            Connection databaseConnection = DatabaseConnection.getInstance().getConnection();
            Statement statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM employee WHERE id = \'"+ a + "\'";
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int salary = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String position = resultSet.getString(4);
                System.out.println("Worker ID:" + " " + id);
                System.out.println("Worker Salary:" + " " + salary);
                System.out.println("Worker Name:" + " " + name);
                System.out.println("Worker Position:" + " " + position);
                System.out.println("____________________________________");
            }
        }catch (SQLException a){
            System.out.println("Problem with database" + a.getMessage());
        }
    }

}


