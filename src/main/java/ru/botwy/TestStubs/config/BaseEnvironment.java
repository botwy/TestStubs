package ru.botwy.TestStubs.config;

import ru.botwy.TestStubs.DAO.DaoFabric;
import ru.botwy.TestStubs.DAO.DaoFabricImpl;
import ru.botwy.TestStubs.util.JsonConverter;
import ru.botwy.TestStubs.util.JsonConverterImpl;

public final class BaseEnvironment implements Environment {
    private final JsonConverter jsonConverter = new JsonConverterImpl();
    private final DaoFabric daoFabric = new DaoFabricImpl();

    public JsonConverter getJsonConverter() {
        return jsonConverter;
    }

    public DaoFabric getDaoFabric() {
        return daoFabric;
    }
}
