package Collections;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneServiceMap {

    // ADD PHONE
    public void addPhoneToMap(Map<Integer, Phone> phoneMap, Phone phone) {
        phoneMap.put(phone.getId(), phone);
    }

    // REMOVE PHONE
    public void removePhoneFromMap(Map<Integer, Phone> phoneMap, int id) {
        phoneMap.remove(id);
    }

    // PRINT ALL
    public void printAllPhonesFromMap(Map<Integer, Phone> phoneMap) {
        for (Phone p : phoneMap.values()) {
            System.out.println(p.getBrand() + " " +
                    p.getModel() + " - $" +
                    p.getPrice() + " (Released: " + p.getReleaseDate() + ")");
        }
    }

    // SORT BY PRICE ASC
    public List<Phone> getPhonesSortedByPriceAsc(Map<Integer, Phone> phoneMap) {
        return phoneMap.values()
                .stream()
                .sorted(Comparator.comparing(Phone::getPrice))
                .toList();
    }

    // SORT BY PRICE DESC
    public List<Phone> getPhonesSortedByPriceDesc(Map<Integer, Phone> phoneMap) {
        return phoneMap.values()
                .stream()
                .sorted(Comparator.comparing(Phone::getPrice).reversed())
                .toList();
    }

    // SORT BY BRAND ASC
    public List<Phone> getPhonesSortedByBrandAsc(Map<Integer, Phone> phoneMap) {
        return phoneMap.values()
                .stream()
                .sorted(Comparator.comparing(Phone::getBrand))
                .toList();
    }

    // SORT BY RELEASE DATE ASC
    public List<Phone> getPhonesSortedByReleaseDate(Map<Integer, Phone> phoneMap) {
        return phoneMap.values()
                .stream()
                .sorted((a, b) -> {
                    String[] A = a.getReleaseDate().split("-");
                    String[] B = b.getReleaseDate().split("-");

                    int year = Integer.compare(
                            Integer.parseInt(A[2]),
                            Integer.parseInt(B[2])
                    );
                    if (year != 0) return year;

                    int month = Integer.compare(
                            Integer.parseInt(A[1]),
                            Integer.parseInt(B[1])
                    );
                    if (month != 0) return month;

                    return Integer.compare(
                            Integer.parseInt(A[0]),
                            Integer.parseInt(B[0])
                    );
                })
                .toList();
    }

    // FILTER BY BRAND
    public List<Phone> findPhonesByBrandFromMap(Map<Integer, Phone> phoneMap, String brand) {
        return phoneMap.values()
                .stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }
}