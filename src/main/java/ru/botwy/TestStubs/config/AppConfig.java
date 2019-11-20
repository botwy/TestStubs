package ru.botwy.TestStubs.config;

public final class AppConfig {
    public final static AppConfig shared = new AppConfig();

    private AppConfig() {}

    public final Environment environment = new BaseEnvironment();
}
