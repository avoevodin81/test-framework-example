package com.socks.api.services;

import java.util.Collections;
import java.util.List;
import com.socks.api.config.ConfigManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiService {

    protected RequestSpecification setup() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .filters(getFilters());
    }

    private List<Filter> getFilters() {
        boolean enableLogging = ConfigManager.getConfig().logging();
        if (enableLogging) {
            return List.of(
                    new RequestLoggingFilter(),
                    new ResponseLoggingFilter(),
                    new AllureRestAssured()
            );
        } else {
            return Collections.singletonList(new AllureRestAssured());
        }
    }
}
