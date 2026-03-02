package ProductStreams;

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

    public LinkedHashMap<Integer, Product> convertToLinkedHashMap(ArrayList<Product> products, Map<Integer, Product> map){
        LinkedHashMap<Integer, Product> lhs=new LinkedHashMap<>();
        for(Product product:products){
            for(Map.Entry<Integer, Product> entry: map.entrySet()){
                if(entry.getValue().equals(product)){
                    lhs.put(entry.getKey(),entry.getValue());
                }
            }
        }
        return lhs;
    }

    public LinkedHashMap<Integer,Product> sortByDiscount(Map<Integer,Product> map){
        return map.entrySet().stream()
                .sorted(Comparator.comparing(e->e.getValue().getDiscount()))
                .collect(Collectors.toMap(
                        e->e.getKey(),
                        e->e.getValue(),
                        (old,n)->old,
                        LinkedHashMap::new
                ));
    }

    public LinkedHashMap<Integer,Product> sortByDiscountDesc(Map<Integer,Product> map){
        return map.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Integer, Product> e) -> e.getValue().getDiscount()).reversed())
                .collect(Collectors.toMap(
                        e->e.getKey(),
                        e->e.getValue(),
                        (o,n)->o,
                        LinkedHashMap::new
                ));
    }

    public LinkedHashMap<Integer,Product> sortByPrice(Map<Integer,Product> map){
        return map.entrySet().stream()
                .sorted(Comparator.comparing(e->e.getValue().getPrice()))
                .collect(Collectors.toMap(
                        e->e.getKey(),
                        e->e.getValue(),
                        (old,n)->old,
                        LinkedHashMap::new
                ));
    }

    public LinkedHashMap<Integer,Product> sortByPriceDesc(Map<Integer,Product> map){
        return map.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Integer, Product> e)->e.getValue().getPrice()).reversed())
                .collect(Collectors.toMap(
                        e->e.getKey(),
                        e->e.getValue(),
                        (old,n)->old,
                        LinkedHashMap::new
                ));

    }

    public LinkedHashMap<Integer,Product> sortByRating(Map<Integer,Product> map){
        return map.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Integer,Product> e)->e.getValue().getRating()).reversed())
                .collect(Collectors.toMap(
                        e->e.getKey(),
                        e->e.getValue(),
                        (o,n)->o,
                        LinkedHashMap::new

                ));
    }

    public LinkedHashMap<Integer,Product> sortByPricethenDiscount(Map<Integer,Product> map){
        return map.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Integer,Product> e)->e.getValue().getPrice())
                        .thenComparing(e->e.getValue().getDiscount())
                )
                        .collect(Collectors.toMap(
                                e->e.getKey(),
                                e->e.getValue(),
                                (o,n)->o,
                                LinkedHashMap::new
                        ));
    }

    public LinkedHashMap<Integer,Product> sortByPricethenRating(Map<Integer,Product> map){
        return map.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Integer,Product> e)->e.getValue().getPrice())
                        .thenComparing(e->e.getValue().getRating()))
                .collect(
                        Collectors.toMap(
                                e->e.getKey(),
                                e->e.getValue(),
                                (o,n)->o,
                                LinkedHashMap::new
                        )
                );
    }

    public LinkedHashMap<Integer,Product> filterByName(Map<Integer,Product> map,String name){
        return map.entrySet().stream()
                .filter(e->e.getValue().getName().equalsIgnoreCase(name))
                .collect(
                        Collectors.toMap(
                                e->e.getKey(),
                                e->e.getValue(),
                                (o,n)->o,
                                LinkedHashMap::new
                        )
                );
    }

    public LinkedHashMap<Integer,Product> filterByBrand(Map<Integer,Product> map,String name){
        return map.entrySet().stream()
                .filter(e->e.getValue().getBrand().equalsIgnoreCase(name))
                .collect(
                        Collectors.toMap(
                                e->e.getKey(),
                                e->e.getValue(),
                                (o,n)->o,
                                LinkedHashMap::new
                        )
                );
    }

    public LinkedHashMap<Integer,Product> filterByCategory(Map<Integer,Product> map,String name){
        return map.entrySet().stream()
                .filter(e->e.getValue().getCategory().equalsIgnoreCase(name))
                .collect(
                        Collectors.toMap(
                                e->e.getKey(),
                                e->e.getValue(),
                                (o,n)->o,
                                LinkedHashMap::new
                        )
                );
    }

    public LinkedHashMap<Integer,Product> filterByMinMaxAmt(Map<Integer,Product> map,double mini,double maxi){
        return map.entrySet().stream()
                .filter(e->mini<=e.getValue().getPrice() && e.getValue().getPrice()<=maxi)
                .collect(
                        Collectors.toMap(
                                e->e.getKey(),
                                e->e.getValue(),
                                (o,n)->o,
                                LinkedHashMap::new
                        )
                );
    }
}
