package Collections;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        Map<Integer, Phone> phoneMap = new HashMap<>();

        PhoneServiceMap serviceMap = new PhoneServiceMap();

        serviceMap.addPhoneToMap(phoneMap, new Phone(101,"Apple", "IphoneX", 70000, "12-01-2023"));
        serviceMap.addPhoneToMap(phoneMap, new Phone(102,"Samsung", "S10", 60000, "05-10-2021"));
        serviceMap.addPhoneToMap(phoneMap, new Phone(103,"OnePlus", "7Pro", 40000, "01-02-2022"));
        serviceMap.addPhoneToMap(phoneMap, new Phone(104,"Nokia", "G20", 20000, "10-01-2016"));

        System.out.println("All Phones:");
        serviceMap.printAllPhonesFromMap(phoneMap);

        System.out.println("\nSorted By Price ASC:");
        serviceMap.getPhonesSortedByPriceAsc(phoneMap)
                .forEach(System.out::println);
    }
}