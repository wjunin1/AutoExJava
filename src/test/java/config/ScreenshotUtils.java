package config;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class ScreenshotUtils {
    private static final Logger logger = Logger.getLogger(ScreenshotUtils.class.getName());

    public static void takeScreenshot(WebDriver driver) {
        // Obtém o nome do método chamador automaticamente
        String callerMethodName = getCallingMethodName();
        takeScreenshot(driver, callerMethodName);
    }

    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Gera um timestamp para evitar sobrescritas
            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

            // Diretório onde os screenshots serão armazenados
            String directory = "./target/screenshots/";
            File screenshotDir = new File(directory);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs(); // Cria a pasta se não existir
            }

            // Define o nome final do arquivo
            String finalFileName = (fileName.isEmpty() ? "screenshot" : fileName) + "_" + timestamp + ".png";
            File finalDestination = new File(directory + finalFileName);

            // Captura a tela
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Copia para o destino
            FileUtils.copyFile(source, finalDestination);

            logger.info("Screenshot salvo em: " + finalDestination.getAbsolutePath());
        } catch (IOException e) {
            logger.severe("Erro ao capturar screenshot: " + e.getMessage());
        }
    }

    private static String getCallingMethodName() {
        // Captura o nome do método chamador
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[3].getMethodName(); // Obtém o método anterior ao takeScreenshot()
    }
}