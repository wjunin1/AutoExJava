package stepDefinitions;

import config.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.googlePage;

public class googleSteps {
    WebDriver driver = DriverManager.getDriver();
    googlePage googlePage = new googlePage(driver);

    @Given("acesso o site do google")
    public void acesso_o_site_do_google() {
        driver.get("https://www.google.com.br/");
    }
    @When("o campo de busca fica visivel")
    public void o_campo_de_busca_fica_visivel() {
        googlePage.validarBuscaGoogle();
    }
    @Then("o titulo da página é google")
    public void o_titulo_da_página_é_google() {
        googlePage.validarTituloGoogle();
    }

}
