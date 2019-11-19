package ru.botwy.TestStubs;

import ru.botwy.TestStubs.DAO.api.ProductDAO;
import ru.botwy.TestStubs.DAO.impl.ProductDAOImpl;

public class DaoFabric {
    public static ProductDAO makeProductDAO() {
        return new ProductDAOImpl();
    }
}
