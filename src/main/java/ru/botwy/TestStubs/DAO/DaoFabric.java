package ru.botwy.TestStubs.DAO;

import ru.botwy.TestStubs.DAO.api.ProductDAO;

public interface DaoFabric {
    ProductDAO makeProductDAO();
}
