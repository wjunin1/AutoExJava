package pages;

import config.ScreenshotUtils;
import config.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class autoExPage {
    private WebDriver driver;
    private WebDriverWait wait;

    String randomEmail = Utils.generateRandomEmail();
    String nome = "Teste";
    String senha = "123456";


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

    @FindBy(id = "name")
    private WebElement cadastroNome;

    @FindBy(id = "email")
    private WebElement cadastroEmail;

    @FindBy(id = "password")
    private WebElement cadastropassword;

    @FindBy(id = "days")
    private WebElement cadastroDay;

    @FindBy(id = "months")
    private WebElement cadastroMonth;

    @FindBy(id = "years")
    private WebElement cadastroYears;

    @FindBy(xpath = ("//input[@type='checkbox']"))
    private List<WebElement> cadastroCheckBox;

    @FindBy(xpath = ("//input[@type='checkbox']"))
    private WebElement cadastroCheckBox2;

    @FindBy(id = "first_name")
    private WebElement cadastroFirstName;

    @FindBy(id = "last_name")
    private WebElement cadastroLastName;

    @FindBy(id = "address1")
    private WebElement cadastroAddress1;

    @FindBy(id = "country")
    private WebElement cadastroCountry;

    @FindBy(id = "state")
    private WebElement cadastroState;

    @FindBy(id = "city")
    private WebElement cadastroCity;

    @FindBy(id = "zipcode")
    private WebElement cadastroZipcode;

    @FindBy(id = "mobile_number")
    private WebElement cadastroMobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;


    public autoExPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void validarHome() {
        String titulo = "Automation Exercise";
        String tituloAtual = driver.getTitle();
        assertEquals(tituloAtual, titulo);
    }

    public void btnClick(String elemento) {
        WebElement btnclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + elemento + "')]")));
        btnclick.click();
    }

    public void visibleField(String campoVisivel) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + campoVisivel + "')]")));
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + campoVisivel + "')]")).isDisplayed());
        ////*[contains(text(), 'value')]
    }

    public void preencherNomeEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(signupName));
        signupName.sendKeys(nome);
        signupEmail.sendKeys(randomEmail);
        System.out.println(randomEmail);
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        signupButton.click();
    }

    public void cadastroNovo() {
        Select daysDropdown = new Select(cadastroDay);
        Select monthDropdown = new Select(cadastroMonth);
        Select yearDropdown = new Select(cadastroYears);
        cadastroGenero.click();
        cadastropassword.sendKeys(senha);
        daysDropdown.selectByValue("15");
        monthDropdown.selectByValue("4");
        yearDropdown.selectByValue("1989");
        ScreenshotUtils.takeScreenshot(driver);
    }

    public void selectCheckbox(String checkboxName) {
        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), '" + checkboxName + "')]"));
        checkbox.click();
        ScreenshotUtils.takeScreenshot(driver);
    }

    public void cadastroNovoAdress() {
        Select country = new Select(cadastroCountry);
        cadastroFirstName.sendKeys("TesteQA");
        cadastroLastName.sendKeys("Silva");
        cadastroAddress1.sendKeys("QS 05 rua 100");
        country.selectByValue("United States");
        cadastroState.sendKeys("New York");
        cadastroCity.sendKeys("Washington");
        cadastroZipcode.sendKeys("71963000");
        cadastroMobileNumber.sendKeys("5561987344433");
    }

    public void btnCreate() {
        createAccountButton.click();
    }

}
