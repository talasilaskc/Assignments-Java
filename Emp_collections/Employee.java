package Emp_collections;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String city;
    String phone;
    List<String> skills;
    double salary;

    Employee(int id, String name, String city,
             String phone, List<String> skills,
             double salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.phone = phone;
        this.skills = skills;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " | " + name +
                " | " + city +
                " | Salary: " + salary +
                " | Skills: " + skills;
    }
}

