package Collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Phone> list = new ArrayList<>();

        PhoneService service = new PhoneService();

        service.addPhone(list, new Phone(101,"Apple", "IphoneX", 70000, "12-01-2023"));
        service.addPhone(list, new Phone(102,"Samsung", "S10", 60000, "05-10-2021"));
        service.addPhone(list, new Phone(103,"OnePlus", "7Pro", 40000, "01-02-2022"));
        service.addPhone(list, new Phone(104,"Nokia", "G20", 20000, "10-01-2016"));

        System.out.println("All Phones:");
        service.printPhones(list);

        service.removePhone(list, 104);
        System.out.println("\nAfter removing phone with id 104:");
        service.printPhones(list);

        service.sortByPrice(list);
        System.out.println("\nAfter sorting by price:");
        service.printPhones(list);

        service.sortByPriceDescending(list);
        System.out.println("\nAfter sorting by price (descending):");
        service.printPhones(list);

        service.sortByReleaseDate(list);
        System.out.println("\nAfter sorting by release date:");
        service.printPhones(list);

        System.out.println("\nPhones with brand Apple:");
        List<Phone> search = service.filterByBrand(list, "Apple");
        service.printPhones(search);
    }
}
