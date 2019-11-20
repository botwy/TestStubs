package ru.botwy.TestStubs.Services;

import ru.botwy.TestStubs.DAO.api.ProductDAO;
import ru.botwy.TestStubs.Models.entity.Product;
import ru.botwy.TestStubs.config.AppConfig;
import ru.botwy.TestStubs.config.Environment;

public class ProductService {

    public Product getLastProduct() {
        Environment currentEnvironment = AppConfig.shared.environment;
        ProductDAO productDAO = currentEnvironment.getDaoFabric().makeProductDAO();

        return productDAO.getLastProduct();
    }

    public Product[] getAllProducts() {
        Environment currentEnvironment = AppConfig.shared.environment;
        ProductDAO productDAO = currentEnvironment.getDaoFabric().makeProductDAO();

        return productDAO.getAllProducts();
    }
}
