package ru.botwy.TestStubs.DAO;

import ru.botwy.TestStubs.DAO.api.ProductDAO;
import ru.botwy.TestStubs.DAO.impl.ProductDAOImpl;

public class DaoFabricImpl implements DaoFabric {
    public ProductDAO makeProductDAO() {
        return new ProductDAOImpl();
    }
}
