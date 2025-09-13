package logwire.orange_ihm_cucumber.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import logwire.orange_ihm_cucumber.pages.LoginPage;
import logwire.orange_ihm_cucumber.tools.DriverTool;

public class LoginStep {
    WebDriver driver;
    LoginPage login;

    @Before
    public void testSetup() throws MalformedURLException {
        //driver = DriverTool.initWebDriver();
        driver = new ChromeDriver();
        login= new LoginPage(driver);

    }

    @After
    public void tearDown() {
        DriverTool.destroyDriver();
    }


    @Given("je me connecte sur {string}")
    public void je_me_connecte_sur(String s) {
        driver.get(s);
        
    }

    @When("je saisis le username {string}")
    public void je_saisis_le_username(String s) {
        login.insertUsername(s);
    }

    @When("je saisis le password {string}")
    public void je_saisis_le_password(String s) {
        login.insertPassword(s);
    }

    @When("je valide")
    public void je_valide() {
        login.validLogin();
    }

    @Then("je me redirige vers {string}")
    public void je_me_redirige_vers_(String s) {
        assertEquals(s,driver.getCurrentUrl());
    }


}
