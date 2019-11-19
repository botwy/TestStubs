package ru.botwy.TestStubs.DAO.impl;

import ru.botwy.TestStubs.DAO.api.ProductDAO;
import ru.botwy.TestStubs.Models.entity.Product;
import ru.botwy.TestStubs.Storage;

public class ProductDAOImpl implements ProductDAO {

    public void appendProduct(Product product) {
        Storage.shared.appendProduct(product);
    }

    public Product getLastProduct() {
        return Storage.shared.getLastProduct();
    }
}
