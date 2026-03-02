package Collections;

import java.util.List;

public interface PhoneDAO {
    void addPhone(List<Phone> list, Phone phone);
    void removePhone(List<Phone> list, int id);
    void printPhones(List<Phone> list);
    void sortByPrice(List<Phone> list);
    void sortByPriceDescending(List<Phone> list);
    void sortByBrand(List<Phone> list);
    void sortByBrandDesc(List<Phone> list);
    void sortByModel(List<Phone> list);
    void sortByModelDesc(List<Phone> list);
    public void sortByReleaseDate(List<Phone> list);
    List<Phone> filterByBrand(List<Phone> list, String brand);
    List<Phone> filterByModel(List<Phone> list, String brand);
}
