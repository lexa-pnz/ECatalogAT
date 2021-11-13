package ru.aleksei.autotests.ecatalog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    WebDriver driver;

    @BeforeEach
    public void installSettings(){
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

}
