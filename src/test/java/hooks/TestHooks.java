package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import config.DriverManager;

public class TestHooks {

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
