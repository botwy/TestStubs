package ru.botwy.TestStubs.Services;

import ru.botwy.TestStubs.DAO.api.ProductDAO;
import ru.botwy.TestStubs.DaoFabric;
import ru.botwy.TestStubs.Models.entity.Product;

public class ProductService {

    public Product getLastProduct() {
        ProductDAO productDAO = DaoFabric.makeProductDAO();

        return productDAO.getLastProduct();
    }
}
