package org.tasks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.apache.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    @Test
    public void loginTest(){
        String BASE_URL = "https://test-api.k6.io/auth/basic/login/";
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\": \"junior0123\",\n" +
                        "    \"password\": \"test123\"\n" +
                        "}")
                .post(BASE_URL)
                .then()
                .assertThat().statusCode(200).extract().response();

    }
    @Test
    public void invalidLogin(){
        String BASE_URL = "https://test-api.k6.io/auth/basic/login/";
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\": \"junior0123\",\n" +
                        "    \"password\": \"test123222\"\n" +
                        "}")
                .post(BASE_URL)
                .then()
                .assertThat().statusCode(400).extract().response();

    }
    @Test
    public void shouldCorrectData(){
        String BASE_URL = "https://test-api.k6.io/auth/basic/login/";
        int expectedUserID = 664436;
        String expectedFirstName =  "Alvaro";
        String expectedLastName = "Sivila";
        String expectedEmail = "alvaro.sivila@jala.university";
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\": \"junior0123\",\n" +
                        "    \"password\": \"test123\"\n" +
                        "}")
                .post(BASE_URL)
                .then()
                .assertThat().statusCode(200).extract().response();

        JsonPath responseData = response.jsonPath();
        int idValue = responseData.get("id");
        String nameValue = responseData.get("first_name");
        String lastNameValue = responseData.get("last_name");
        String emailValue = responseData.get("email");
        assertEquals(expectedFirstName,nameValue);
        assertEquals(expectedLastName,lastNameValue);
        assertEquals(expectedEmail,emailValue);


    }

}
