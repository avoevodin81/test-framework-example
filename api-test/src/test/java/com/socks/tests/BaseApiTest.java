package com.socks.tests;

import java.util.Locale;
import org.testng.annotations.BeforeClass;
import com.github.javafaker.Faker;
import com.socks.api.config.ConfigManager;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;

public class BaseApiTest {
    protected final Faker faker = new Faker(Locale.of(ConfigManager.getConfig().locale()));

    protected final UserApiService userApiService = new UserApiService();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigManager.getConfig().baseUrl();
    }
}
