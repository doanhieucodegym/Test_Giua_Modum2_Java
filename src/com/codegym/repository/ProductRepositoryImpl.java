package com.codegym.repository;

import com.codegym.model.Product;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {

    public static Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Duong", 150, "ngon", "Bo"));
        productList.put(2, new Product(2, "Sua", 15, "Thom", "TH"));
        productList.put(3, new Product(3, "gao", 100, "Deo", "Re"));
    }

    @Override
    public void add(Product product) {
        productList.put(product.getId(), product);
    }


    @Override
    public void edit(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);


    }

    @Override
    public Product search(String name) {
        Collection<Product> p = productList.values();
        for (Product item : p) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void sortDescending() {
        List<Map.Entry<Integer,Product>> list = new LinkedList<Map.Entry<Integer, Product>>(productList.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Product>>() {
            @Override
            public int compare(Map.Entry<Integer, Product> o1, Map.Entry<Integer, Product> o2) {
                if (o1.getValue().getPrice()>o2.getValue().getPrice()){
                    return 1;
                }else if (o1.getValue().getPrice()<o2.getValue().getPrice()){
                    return -1;
                }
                return 0;
            }
        });
        for (Map.Entry<Integer,Product> item: list){
            System.out.println(item);
        }


    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }



}
