package logwire.orange_ihm_cucumber.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriverWait wait;

    @FindBy(name = "username")
    WebElement usernameElement;

    @FindBy(css = "input[type='password']")
    WebElement passwordElement;

    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void insertUsername(String s) {
        wait.until(ExpectedConditions.visibilityOf(usernameElement));
        usernameElement.sendKeys(s);
    }

    public void insertPassword(String s) {
        wait.until(ExpectedConditions.visibilityOf(passwordElement));
        passwordElement.sendKeys(s);
    }

    public void validLogin() {
        submitBtn.click();
    }

    public void doLogin(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameElement));
        usernameElement.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordElement));
        passwordElement.sendKeys(password);
        validLogin();
    }

}
