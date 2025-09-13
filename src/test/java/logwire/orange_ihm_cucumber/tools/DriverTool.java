package logwire.orange_ihm_cucumber.tools;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverTool {
private static WebDriver driver;

public static WebDriver initWebDriver() throws MalformedURLException{
    String browser = System.getProperty("browser", "chrome"); 
    switch (browser) {
        case "chrome":
            driver = new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"),
                            new ChromeOptions()
                    );
            break;
        case "firefox":
            driver = new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"),
                            new FirefoxOptions()
                    );
            break;
        case "edge":
            driver = new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"),
                            new EdgeOptions()
                    );
            break;
    
        default:
            throw new IllegalArgumentException(
                "Navigateur non supporté :"+browser
            );
    }

    return driver;
}

public static void destroyDriver(){
    if (driver != null) {
        driver.quit();
    }
}
}
