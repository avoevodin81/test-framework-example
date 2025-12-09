package com.socks.api.conditions;

import org.hamcrest.Matcher;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Conditions {

    public static Condition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static Condition bodyField(String jsonPath, Matcher<String> matcher) {
        return new BodyFieldCondition(jsonPath, matcher);
    }
}
