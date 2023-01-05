package org.tasks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.apache.http.HttpStatus;

public class LoginTest {
    @Test
    public void loginTest(){
        String BASE_URL = "https://test-api.k6.io/auth/basic/login/";
        String response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\": \"junior0123\",\n" +
                        "    \"password\": \"test123\"\n" +
                        "}")
                .post(BASE_URL)
                .then()
                .statusCode(HttpStatus.SC_OK).toString();
               //.body("json", notNullValue()).toString();
    }

}
