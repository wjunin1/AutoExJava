package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class googlePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement botaoBusca;

    public googlePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void validarBuscaGoogle() {
        wait.until(ExpectedConditions.visibilityOf(botaoBusca));
    }

    public void validarTituloGoogle(){
       String titulo = driver.getTitle();
       String tituloEsperado = "Google";
        assertEquals(tituloEsperado, titulo);
    }
}
