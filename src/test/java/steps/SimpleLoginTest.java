package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpleLoginTest {
    
    @Given("estoy en la página de inicio de sesión")
    public void navigateToLoginPage() {
        System.out.println("Hola mundo");
        
        // Aquí deberías navegar a la página de inicio de sesión en tu aplicación web
    }

    @When("ingreso mi nombre de usuario {string} y mi contraseña {string}")
    public void enterCredentials(String username, String password) {
        System.out.println(username + password);
        
    }

    @When("hago clic en el botón Iniciar sesión")
    public void submitLogin() {
        // Aquí deberías simular el clic en el botón de iniciar sesión en tu aplicación web
    }

    @Then("debo ser redirigido a la página principal")
    public void redirectToHomePage() {
        // Aquí deberías validar que se haya redirigido a la página principal
    }

    @Then("debo ver un mensaje de bienvenida {string}")
    public void seeWelcomeMessage(String message) {
        // Aquí deberías validar que se muestre el mensaje de bienvenida esperado
    }

    @When("hago clic en el botón {string}")
    public void hago_clic_en_el_bot_n(String s) {
        assertEquals("hola","hola");
        // Write code here that turns the phrase above into concrete actions
    }
}
