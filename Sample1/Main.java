package Sample1;

import java.util.*;

class Employee {
    private String name;
    private String email;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("John", "john@gmail.com"),
                new Employee("Alice", "alice@gmail.com"),
                new Employee("Bob", "bob@gmail.com")
        );

        String emailToFind = "alice@gmil.com";

        employees.stream()
                .filter(e -> e.getEmail().equals(emailToFind))
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
