package ru.botwy.TestStubs.DAO.api;

import ru.botwy.TestStubs.Models.entity.Product;

public interface ProductDAO {
    void appendProduct(Product product);
    Product getLastProduct();
}
