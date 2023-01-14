package steps;

import static org.junit.Assert.assertEquals;

import org.tasks.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BadLogin {
    String BASE_URI = "https://test-api.k6.io";
    String endPoint;
    String requestBody;
    Response response;
    User user;
    @Given("a user with invalid credentials")
    public void obtainAddressOfEndPoint() {
        endPoint = "/auth/basic/login/";
    }
    @When("the user enters his invalid username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        System.out.println(password + username);
            user = User.builder()
                .username(username)
                .password(password).build();
    }
                
    @When("send the invalid information to the website")
    public void submitLogin() {
        System.out.println(BASE_URI + endPoint);
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(BASE_URI + endPoint);
    }
    @Then("the user see a bad request")
    public void seeTheStatusCodeOK() {
        assertEquals(400,response.getStatusCode());
    }
}
    