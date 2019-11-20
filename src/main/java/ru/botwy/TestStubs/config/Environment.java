package ru.botwy.TestStubs.config;

import ru.botwy.TestStubs.DAO.DaoFabric;
import ru.botwy.TestStubs.util.JsonConverter;

public interface Environment {
    JsonConverter getJsonConverter();
    DaoFabric getDaoFabric();
}
