package Emp_collections;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "John", "Hyderabad", "9999",
                        List.of("Java", "SQL"), 60000),

                new Employee(2, "Ram", "Bangalore", "8888",
                        List.of("Python", "ML"), 70000),

                new Employee(3, "Sam", "Hyderabad", "7777",
                        List.of("Java", "Spring"), 65000),

                new Employee(4, "David", "Chennai", "6666",
                        List.of("React", "JS"), 55000),

                new Employee(5, "Kiran", "Bangalore", "5555",
                        List.of("Java", "AWS"), 72000)
        );

        // Group + print + count together
        employees.stream()
                .collect(Collectors.groupingBy(e -> e.city))
                .forEach((city, empList) -> {
                    System.out.println("\nCity: " + city +
                            " | Count: " + empList.size());
                    empList.forEach(System.out::println);
                });

        // 3️⃣ Find all skills of employees
        System.out.println("\nAll Skills:");

        employees.stream()
                .flatMap(e -> e.skills.stream())
                .distinct()
                .forEach(System.out::println);

        Map<Boolean, List<Employee>> grouped =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.salary > 50000 && e.salary < 60000
                        ));

        grouped.get(true).forEach(System.out::println);

        DoubleSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingDouble(e -> e.salary));

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());

        List<List<Integer>> numbers = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );

        List<Integer> sums =
                numbers.stream()
                        .map(list ->
                                list.stream()
                                        .mapToInt(Integer::intValue)
                                        .sum()
                        )
                        .collect(Collectors.toList());

        System.out.println(sums);

        employees.stream()
                .sorted(Comparator.comparing(e -> e.name))
                .forEach(System.out::println);


    }
}