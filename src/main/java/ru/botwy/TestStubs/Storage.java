package ru.botwy.TestStubs;

import ru.botwy.TestStubs.Models.dto.ProductDTO;
import ru.botwy.TestStubs.Models.entity.Product;
import ru.botwy.TestStubs.util.JsonConverter;
import ru.botwy.TestStubs.util.JsonConverterImpl;
import ru.botwy.TestStubs.util.RequestReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Storage {
    public static Storage shared = new Storage();

    private ArrayList<Product> products = new ArrayList<Product>();
    private final Lock readLock;
    private final Lock writeLock;

    private Storage() {
        ReentrantReadWriteLock rwLock =  new ReentrantReadWriteLock();
        this.readLock = rwLock.readLock();
        this.writeLock = rwLock.writeLock();
        fillByStubs();
    }

    private void fillByStubs() {
        try {
            JsonConverter converter = new JsonConverterImpl();
            String json = RequestReader.shared.getContent("productStub.json");
            ProductDTO[] dtos = converter.fromJsonArray(json);

            for (ProductDTO dto : dtos) {
                Product product = new Product(dto.getCode(), dto.getName(), dto.getPrice());
                products.add(product);
            }
        } catch (IOException error) {
            System.out.println(error);
        }
    }

    public void appendProduct(Product product) {
        writeLock.lock();
        products.add(product);
        writeLock.unlock();
    }

    public Product getLastProduct() {
        readLock.lock();
        try {
            int size = products.size();
            if (size == 0) {
                return null;
            }
            return products.get(size - 1);
        } finally {
            readLock.unlock();
        }
    }

    public Product[] getAllProducts() {
        readLock.lock();
        try {
            int size = products.size();
            if (size == 0) {
                return null;
            }
            Product[] array = new Product[size];

            return products.toArray(array);
        } finally {
            readLock.unlock();
        }
    }
}
