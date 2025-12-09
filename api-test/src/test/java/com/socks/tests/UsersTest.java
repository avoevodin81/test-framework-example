package com.socks.tests;

import static com.socks.api.conditions.Conditions.bodyField;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import org.testng.annotations.Test;
import com.socks.api.payloads.UserPayload;

public class UsersTest extends BaseApiTest {

    @Test
    public void testCanRegisterNewUser() {
        // given
        UserPayload user = new UserPayload()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        // expected
        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(is(emptyString()))));
    }

    @Test
    public void testCanNotRegisterSameUserTwice() {
        // given
        UserPayload user = new UserPayload()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        // then
        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(is(emptyString()))));

        // expected
        userApiService.registerUser(user)
                .shouldHave(statusCode(500));
    }
}
