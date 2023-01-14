package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.tasks.User;

public class SimpleLoginTest {
    String BASE_URI = "https://test-api.k6.io";
    String endPoint;
    String requestBody;
    Response response;
    User user;
    @Given("a user with valid credentials")
    public void obtainAddressOfEndPoint() {
        endPoint = "/auth/basic/login/";
    }
    @When("the user enters his name {string} and password {string}")
    public void enterCredentials(String username, String password) {
        System.out.println(password + username);
            user = User.builder()
                .username(username)
                .password(password).build();
    }
                
    @When("send the information to the website")
    public void submitLogin() {
        System.out.println(BASE_URI + endPoint);
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(BASE_URI + endPoint);
    }
    @Then("the user see a status code is ok")
    public void seeTheStatusCodeOK() {
        assertEquals(200,response.getStatusCode());
    }

    @Then("and see correct login information")
    public void and_see_login_information() {
        JsonPath responseData = response.jsonPath();
        int idValue = responseData.get("id");
        String nameValue = responseData.get("first_name");
        String lastNameValue = responseData.get("last_name");
        String emailValue = responseData.get("email");
        assertEquals(664436,idValue);
        assertEquals("Alvaro", nameValue);
        assertEquals("Sivila", lastNameValue);
        assertEquals("alvaro.sivila@jala.university",emailValue);
        
    }
}
