package ru.botwy.TestStubs;

import ru.botwy.TestStubs.Models.entity.Product;

import java.util.ArrayList;

public class Storage {
    public static Storage shared = new Storage();

    private ArrayList<Product> products = new ArrayList<Product>();

    public void appendProduct(Product product) {
        products.add(product);
    }

    public Product getLastProduct() {
        int size = products.size();
        if (size == 0) {
            return null;
        }
        return products.get(size - 1);
    }

    public Product[] getAllProducts() {
        int size = products.size();
        if (size == 0) {
            return null;
        }
        Product[] array = new Product[size];

        return products.toArray(array);
    }
}
