package Product;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService {
    public String getProductDetails(Product product) {
        return "Product ID: " + product.getId() + "\n" +
               "Name: " + product.getName() + "\n" +
               "Price: $" + product.getPrice() + "\n" +
               "Brand: " + product.getBrand() + "\n" +
               "Category: " + product.getCategory() + "\n" +
               "Rating: " + product.getRating() + "\n" +
               "Discount: " + product.getDiscount() + "%";
    }

    public String printTreeMap(Map<Integer, Product> products){
        StringBuilder sb = new StringBuilder();
        for (Integer key : products.keySet()) {
            sb.append("Key: ").append(key).append("\n");
            sb.append(getProductDetails(products.get(key))).append("\n\n");
        }
        return sb.toString();
    }

    public String printArrayList(ArrayList<Product> products) {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append(getProductDetails(product)).append("\n\n");
        }
        return sb.toString();
    }

    public LinkedHashMap<Integer,Product> convertToLinkedHashMap(ArrayList<Product> products, Map<Integer,Product> map){
        LinkedHashMap<Integer,Product> lhs=new LinkedHashMap<>();
        for(Product product:products){
            for(Map.Entry<Integer,Product> entry: map.entrySet()){
                if(entry.getValue().equals(product)){
                    lhs.put(entry.getKey(),entry.getValue());
                }
            }
        }
        return lhs;
    }

    public ArrayList<Product> sortProductsByPrice(ArrayList<Product> products) {
        class SortByPrice implements Comparator<Product> {
            public int compare(Product a, Product b) {
                return Double.compare(a.getPrice(), b.getPrice());
            }
        }

        Collections.sort(products, new SortByPrice());

        Collections.sort(products, new Comparator<Product>() {
                public int compare(Product a, Product b){
                    return Double.compare(a.getPrice(), b.getPrice());
            }
        });

        Collections.sort(products, (a,b)->{return Double.compare(a.getPrice(), b.getPrice());});

        return products;
    }

    public ArrayList<Product> sortProductsByDiscount(ArrayList<Product> products){
        class sortByDiscount implements Comparator<Product>{
            public int compare(Product a,Product b){
                return Double.compare(a.getDiscount(),b.getDiscount());
            }
        }
        Collections.sort(products, new sortByDiscount());

        Collections.sort(products,new Comparator<Product>(){
        public int compare(Product a,Product b){
            return Double.compare(a.getDiscount(),b.getDiscount());
        }
        });

        Collections.sort(products,(a,b)->Double.compare(a.getDiscount(),b.getDiscount()));

        return products;
    }

    public Map.Entry<Integer, Product> filterProductByName(Map<Integer,Product> products, String name){
        for(Map.Entry<Integer,Product> prod:products.entrySet()){
            if(prod.getValue().getName().equalsIgnoreCase(name)){
                return prod;
            }
        }
        return null;
    }

    public Map<Integer, Product> filterProductByBrand(Map<Integer,Product> products, String name){
//        for(Map.Entry<Integer,Product> prod:products.entrySet()){
//            if(prod.getValue().getBrand().equalsIgnoreCase(name)){
//                return prod;
//            }
//        }
//        return null;
        return products.entrySet().stream()
                .filter(p->p.getValue().getBrand().equals(name))
                .collect(Collectors.toMap(
                        p->p.getKey(),
                        p->p.getValue()
                ));
    }

    public Map.Entry<Integer, Product> filterProductByCategory(Map<Integer,Product> products, String name){
        for(Map.Entry<Integer,Product> prod:products.entrySet()){
            if(prod.getValue().getCategory().equalsIgnoreCase(name)){
                return prod;
            }
        }
        return null;
    }

    public Map<Integer, Product> sortByPriceThenDiscount(
            Map<Integer, Product> products) {

        return products.entrySet()
                .stream()
                .sorted(
                        Comparator.comparing(
                                (Map.Entry<Integer, Product> entry)
                                        -> entry.getValue().getPrice()
                        ).thenComparing(
                                entry -> entry.getValue().getDiscount()
                        )
                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }




}
