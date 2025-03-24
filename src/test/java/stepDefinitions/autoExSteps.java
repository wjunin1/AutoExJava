package stepDefinitions;

import config.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.autoExPage;

import static org.junit.Assert.assertEquals;

public class autoExSteps {

    WebDriver driver = DriverManager.getDriver();
    autoExPage autoExPage = new autoExPage(driver);

    @Given("the user navigates to the URL {string}")
    public void the_user_navigates_to_the_url(String string) {
        driver.get(string);
    }
    @Then("the home page should be displayed successfully")
    public void the_home_page_should_be_displayed_successfully() {
        autoExPage.validarHome();
    }
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        autoExPage.btnClick(string);
    }
    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {
        autoExPage.visibleField(string);
    }
    @When("the user enters a name and email address")
    public void the_user_enters_a_name_and_email_address() {
        autoExPage.preencherNomeEmail();
    }

    @And("clicks the Signup button")
    public void clicksTheSignupButton() {
        autoExPage.clickSignupButton();
    }

    @When("the user fills in the details: Title, Name, Email, Password, Date of birth")
    public void the_user_fills_in_the_details_title_name_email_password_date_of_birth() {
        autoExPage.cadastroNovo();
    }
    @When("selects the checkbox {string}")
    public void selects_the_checkbox(String string) {
        autoExPage.selectCheckbox(string);
    }
    @When("fills in the details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fills_in_the_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        autoExPage.cadastroNovoAdress();
    }

    @And("clicks the Create Account button")
    public void clicksTheCreateAccountButton() {
        autoExPage.btnCreate();
    }

    @When("the user enters a correct email address and password")
    public void theUserEntersACorrectEmailAddressAndPassword() {
        autoExPage.loginCredencials();
    }

    @And("And clicks the {string} button")
    public void andClicksTheLoginButton(String string) {
        autoExPage.btnLogin(string);
    }
}
