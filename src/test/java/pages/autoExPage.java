package pages;

import config.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class autoExPage{
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//a[contains(text(), 'Signup / Login')]")
    private WebElement botaoSignupLogin;

    //tela de signin signup

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    //tela de cadastro de conta

    @FindBy(id = "id_gender1")
    private WebElement cadastroGenero;

    @FindBy(id="name")
    private WebElement cadastroNome;

    @FindBy(id="email")
    private WebElement cadastroEmail;

    @FindBy(id="password")
    private WebElement cadastropassword;

    @FindBy(id="days")
    private WebElement cadastroDay;

    @FindBy(id="months")
    private WebElement cadastroMonth;

    @FindBy(id="years")
    private WebElement cadastroYears;

    @FindBy(xpath = ("//input[@type='checkbox']"))
    private WebElement cadastroCheckBox;

//    @FindBy(id="name")
//    private WebElement cadastroNome;
//    @FindBy(id="name")
//    private WebElement cadastroNome;
//    @FindBy(id="name")
//    private WebElement cadastroNome;
//    @FindBy(id="name")
//    private WebElement cadastroNome;
//    @FindBy(id="name")
//    private WebElement cadastroNome;


    public autoExPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void validarHome(){
        String titulo = "Automation Exercise";
        String tituloAtual = driver.getTitle();
        assertEquals(tituloAtual, titulo);
    }

    public void navegarSign(){
        wait.until(ExpectedConditions.elementToBeClickable(botaoSignupLogin));
        botaoSignupLogin.click();
    }

    public void visibleField(String campoVisivel) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + campoVisivel + "')]")));
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + campoVisivel + "')]")).isDisplayed());
    }

    public void preencherNomeEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(signupName));
        signupName.sendKeys("Teste qa");
        signupEmail.sendKeys("testeqa@testeqa.com.br");
    }

    public void clickSignupButton(){
        wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        signupButton.click();
    }

    public void cadastroNovo(){
        Select daysDropdown = new Select(cadastroDay);
        Select monthDropdown = new Select(cadastroMonth);
        Select yearDropdown = new Select(cadastroYears);

        cadastroGenero.click();
        cadastropassword.sendKeys("123456");
        daysDropdown.selectByValue("15");
        monthDropdown.selectByValue("5");
        yearDropdown.selectByValue("1989");
        cadastroCheckBox.click();
        ScreenshotUtils.takeScreenshot(driver);


    }




}
