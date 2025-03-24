package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import config.DriverManager;
import io.cucumber.java.BeforeAll;

import java.io.File;

public class Hooks {

    @BeforeAll
    public static void beforeAllTests() {
        String directory = "./target/screenshots/";
        File screenshotDir = new File(directory);
        if (screenshotDir.exists()) {
            File[] files = screenshotDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
        System.out.println("Pasta de screenshots limpa antes de iniciar os testes.");
    }

    @Before
    public void iniciarTeste() {
        System.out.println("Iniciando o teste...");
    }

    @After
    public void finalizarTeste() {
        System.out.println("Finalizando o teste...");
        DriverManager.quitDriver();
    }
}