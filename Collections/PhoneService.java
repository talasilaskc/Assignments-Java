package Collections;

import java.util.*;

public class PhoneService {

    public void addPhone(List<Phone> list, Phone phone) {
        list.add(phone);
    }

    public void removePhone(List<Phone> list, int id) {
        Iterator<Phone> iterator = list.iterator();
        while (iterator.hasNext()) {
            Phone p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
            }
        }
    //for(Phone p : list) { if (p.getId() == id) { list.remove(p); } }
    }

    public void printPhones(List<Phone> list) {
        for (Phone p : list) {
            System.out.println(p.getBrand() + " " +
                    p.getModel() + " - $" +
                    p.getPrice() + " (Released: " + p.getReleaseDate() + ")");
        }
    }

    public void sortByPrice(List<Phone> list) {

        class SortByPrice implements Comparator<Phone>{
            public int compare(Phone a, Phone b){
                return Double.compare(a.getPrice(),b.getPrice());
            }
        }
        Collections.sort(list,(a, b)->{
                return Double.compare(a.getPrice(),b.getPrice());
            }
        );

        //1st way using local class
//        class SortByPrice implements Comparator<Phone> {
//            public int compare(Phone a, Phone b) {
//                return Double.compare(a.getPrice(), b.getPrice());
//            }
//        }
        //Collections.sort(list, new SortByPrice());

        //2nd way using anonymous class
        /*
        Collections.sort(list, new Comarator<Phone>(){
                public int compare(Phone a, Phone b) {
                return Double.compare(a.getPrice(), b.getPrice());
            }
         */

        //3rd way using lambda expression
        //Colllections.sort(list,(a,b)-> Double.compare(a.getPrice(), b.getPrice()));
    }

    public void sortByPriceDescending(List<Phone> list){
        class SortByPriceDesc implements Comparator<Phone>{
            public int compare(Phone a, Phone b){
                return Double.compare(b.getPrice(),a.getPrice());
            }
        }
        Collections.sort(list,( a,  b)->{
                return Double.compare(b.getPrice(),a.getPrice());
            }
        );
    }

    public void sortByBrand(List<Phone> list){
        class SortByBrand implements Comparator<Phone>{
            public int compare(Phone a, Phone b) {
                return a.getBrand().compareTo(b.getBrand());
            }
        }

        Collections.sort(list,( a,  b)-> {
                return a.getBrand().compareTo(b.getBrand());
            }
        );
    }

    public void sortByBrandDescending(List<Phone> list){
        Collections.sort(list,(Phone a, Phone b)->{
                return b.getBrand().compareTo(a.getBrand());
        }
        );
    }

    public void sortByModel(List<Phone> list){
        class sortByModel implements Comparator<Phone>{
            public int compare(Phone a, Phone b) {
                return a.getModel().compareTo(b.getModel());
            }
        }
        Collections.sort(list, new sortByModel());

        Collections.sort(list,new Comparator<Phone>(){
            public int compare(Phone a, Phone b){
                return a.getModel().compareTo(b.getModel());
            }
        });

        Collections.sort(list,(a, b)-> a.getModel().compareTo(b.getModel()));
    }

    public void sortByModelDescending(List<Phone> list){
        class sortByModel implements Comparator<Phone>{
            public int compare(Phone a, Phone b) {
                return b.getModel().compareTo(a.getModel());
            }
        }
        Collections.sort(list, new sortByModel());

        Collections.sort(list,new Comparator<Phone>(){
            public int compare(Phone a, Phone b){
                return b.getModel().compareTo(a.getModel());
            }
        });
        Collections.sort(list,(a, b)-> b.getModel().compareTo(a.getModel()));
    }

    public void sortByReleaseDate(List<Phone> list){
        class sortByReleaseDate implements Comparator<Phone>{
            public int compare(Phone a, Phone b) {
                String[] A=a.getReleaseDate().split("-");
                String[] B=b.getReleaseDate().split("-");
                int yearA=Integer.parseInt(A[2]);
                int yearB=Integer.parseInt(B[2]);
                if(yearA!=yearB)
                    return Integer.compare(yearA,yearB);
                int monthA=Integer.parseInt(A[1]);
                int monthB=Integer.parseInt(B[1]);
                if(monthA!=monthB)
                    return Integer.compare(monthA,monthB);
                int dayA=Integer.parseInt(A[0]);
                int dayB=Integer.parseInt(B[0]);
                return Integer.compare(dayA,dayB);
            }
        }

        Collections.sort(list, new sortByReleaseDate());

    }



    public List<Phone> filterByBrand(List<Phone> list, String brand) {
        List<Phone> result = new ArrayList<>();
        for (Phone p : list) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                result.add(p);
            }
        }
        return result;
    }
}
