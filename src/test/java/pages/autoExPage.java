package pages;

import config.ScreenshotUtils;
import config.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class autoExPage {
    private WebDriver driver;
    private WebDriverWait wait;

    String randomEmail = Utils.generateRandomEmail();
    String randomName = Utils.generateRandomName();
    String randomMessage = Utils.generateRandomMessage();
    String nome = "Teste";
    String senha = "123456";
    String emailCriado = "fixo@teste.com";
    String senhaCriado = "jr2311";


    @FindBy(xpath = "//a[contains(text(), 'Signup / Login')]")
    private WebElement botaoSignupLogin;

    //tela de signin signup
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement signinEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement signinPass;

    @FindBy(xpath = "//input[@data-qa='login-button']")
    private WebElement signinBtn;

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

    //Contact US
    @FindBy(xpath = "//input[@data-qa='name']")
    private WebElement contactUsName;

    @FindBy(xpath = "//input[@data-qa='email']")
    private WebElement contactUsEmail;

    @FindBy(xpath = "//input[@data-qa='subject']")
    private WebElement contactUsSubject;

    @FindBy(xpath = "//textarea[@data-qa='message']")
    private WebElement contactUsMessage;

    @FindBy(name = "upload_file")
    private WebElement contactUploadBtn;

    @FindBy(xpath = "//textarea[@data-qa='submit-button']")
    private WebElement contactUsSubmitBtn;

    @FindBy(xpath = ("//input[contains(@value,'Submit')]"))
    private WebElement btnsubmit;

    public autoExPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void validarHome() {
        String titulo = "Automation Exercise";
        String tituloAtual = driver.getTitle();
        assertEquals(titulo, tituloAtual);
        System.out.println("Home Automation Exercise confirmada");
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void btnClick(String elemento) {
        WebElement btnclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + elemento + "')]")));
        btnclick.click();
        System.out.println("Click realizado no botão " + elemento);
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void visibleField(String campoVisivel) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + campoVisivel + "')]")));
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + campoVisivel + "')]")).isDisplayed());
        ////*[contains(text(), 'value')]
        System.out.println("Campo visível = " + campoVisivel);
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void preencherNomeEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(signupName));
        signupName.sendKeys(nome);
        signupEmail.sendKeys(randomEmail);
        System.out.println(randomEmail);
        System.out.println("Email " + randomEmail + " e nome " + nome + " digitados");
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        signupButton.click();
        System.out.println("Click no botão " + signupButton);
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
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
        System.out.println("Campos preenchidos");
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void selectCheckbox(String checkboxName) {
        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), '" + checkboxName + "')]"));
        checkbox.click();
        System.out.println("Checkbox marcado");
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void cadastroNovoAddress() {
        Select country = new Select(cadastroCountry);
        cadastroFirstName.sendKeys("TesteQA");
        cadastroLastName.sendKeys("Silva");
        cadastroAddress1.sendKeys("QS 05 rua 100");
        country.selectByValue("United States");
        cadastroState.sendKeys("New York");
        cadastroCity.sendKeys("Washington");
        cadastroZipcode.sendKeys("71963000");
        cadastroMobileNumber.sendKeys("5561987344433");
        System.out.println("Campos de address preenchidos");
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void btnCreate() {
        createAccountButton.click();
        System.out.println("Conta criada");
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void loginCredencials() {
        signinEmail.sendKeys(emailCriado);
        signinPass.sendKeys(senhaCriado);
        System.out.println("Preenchido email e senha");
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void btnLogin(String btn) {
        WebElement btnclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'" + btn + "')]")));
        btnclick.click();
        System.out.println("Btn de login");
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void loginInvalidCredencial() {
        try {
            signinEmail.sendKeys("qa123@gmail.com");
            signinPass.sendKeys("1234");
            System.out.println("Login inválido");
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void validarLoginPage() {
        String titulo = "Automation Exercise - Signup / Login";
        String tituloAtual = driver.getTitle();
        try {
            assertEquals(titulo, tituloAtual);
            System.out.println("Tela de login");
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void loginCredenciaisValidas() {
        wait.until(ExpectedConditions.elementToBeClickable(signupName));
        try {
            signupName.sendKeys(nome);
            signupEmail.sendKeys(emailCriado);
            System.out.println("Email " + emailCriado + " e nome " + nome + " digitados");
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void preencherDadosContact() {
        try {
            contactUsName.sendKeys(randomName);
            contactUsEmail.sendKeys(randomEmail);
            contactUsSubject.sendKeys("Suporte");
            contactUsMessage.sendKeys(randomMessage);
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void uploadFile() {
        try {
            File file = new File("src/test/java/files/uploadFileModel.png");
            String caminho = file.getAbsolutePath();
            contactUploadBtn.sendKeys(caminho);
            System.out.println("Arquivo anexado");
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    public void btnSubmit() {
        btnsubmit.click();
    }

    public void contactAlert() {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();

        if (text.equals("Press OK to proceed!")) {
            alert.accept();
        } else {
            btnsubmit.click();
            alert.accept();
        }
    }

    public void testCasePage() {
        String titulo = "Automation Practice Website for UI Testing - Test Cases";
        String tituloAtual = driver.getTitle();
        assertEquals(titulo, tituloAtual);
        System.out.println("Test Cases Page confirmada");
        try {
            ScreenshotUtils.takeScreenshot(driver);
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
        }
    }
}
