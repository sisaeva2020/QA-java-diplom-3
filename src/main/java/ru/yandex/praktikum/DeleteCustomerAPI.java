package ru.yandex.praktikum;

import com.Base;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static com.Base.BASE_URL;

public class DeleteCustomerAPI {
    public static final String PATH = BASE_URL + "auth/";

    @Step("Delete customer")
    public void deleteCustomerByEmailAndPassword(String email, String password) {

        String body = "{\"email\":\"" + email + "\","
                + "\"password\":\"" + password + "\"}";

        String accessToken = given()
                .spec(Base.getBaseSpec())
                .body(body)
                .when()
                .post(PATH + "login/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");

        given()
                .spec(Base.getBaseSpec())
                .auth().oauth2(accessToken.substring(7))
                .when()
                .delete(PATH + "user/")
                .then()
                .assertThat()
                .statusCode(202);
    }
}
