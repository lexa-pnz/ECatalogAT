package ru.aleksei.autotests.ecatalog;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;


public class GenericMethods {

    public static final String NAME_PRODUCT = "NAME_PRODUCT";
    public static final String WEB_ELEMENT = "WEB_ELEMENT";
    public static final String URL = "URL";

    public static void clickWebElements(WebElement webElement, WebDriver driver){
        webElement.click();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
    }

    public static void clickWebElements(WebElement webElement){
        webElement.click();
    }

    public static void saveWebElementsInList(List<WebElement> listWebElement, List<Map<String, Object>> listProducts, String selectorURL, String selectorName){
        for (WebElement result : listWebElement) {
            listProducts.add(Map.of(
                    WEB_ELEMENT, result,
                    URL, checkSearchWebElement(result, selectorURL).getAttribute("href"),
                    NAME_PRODUCT, checkSearchWebElement(result, selectorName).getText()
            ));
        }
    }

    public static void saveWebElementsInList(List<WebElement> listWebElement, List<Map<String, Object>> listProducts, String selectorWE, String selectorURL, String selectorName){
        for (WebElement result : listWebElement) {
            listProducts.add(Map.of(
                    WEB_ELEMENT, checkSearchWebElement(result, selectorWE),
                    URL, checkSearchWebElement(result, selectorURL).getAttribute("href"),
                    NAME_PRODUCT, checkSearchWebElement(result, selectorName).getText()
            ));
        }
    }

    public static void saveWebElementsInList(List<WebElement> listWebElement, List<Map<String, Object>> listProducts){
        for (WebElement result : listWebElement) {
            listProducts.add(Map.of(
                    WEB_ELEMENT, result,
                    URL, result.getAttribute("href"),
                    NAME_PRODUCT, result.getText()
            ));
        }
    }

    public static WebElement searchNeededWE(List<Map<String, Object>> listProduct, String productName){
        for (Map<String, Object> str : listProduct){
            if (str.get(NAME_PRODUCT).toString().equals(productName))
                return (WebElement) str.get(WEB_ELEMENT);
        }
        return null;
    }

    public static List<WebElement> checkSearchListWebElement(WebDriver driver, String selector){
        List<WebElement> listElement = null;

        try {
            listElement = driver.findElements(By.xpath(selector));
        }
        catch (NoSuchElementException e){
            System.out.println("[NoSuchElementException]\n");
            System.out.println(e.getMessage());
            Assertions.fail();
        }

        return listElement;
    }

    public static WebElement checkSearchWebElement(WebDriver driver, String selector){
        WebElement element = null;

        try {
            element = driver.findElement(By.xpath(selector));
        }
        catch (NoSuchElementException e){
            System.out.println("[NoSuchElementException]\n");
            System.out.println(e.getMessage());
            Assertions.fail();
        }

        return element;
    }

    public static WebElement checkSearchWebElement(WebElement result, String selector){
        WebElement element = null;

        try {
            element = result.findElement(By.xpath(selector));
        }
        catch (NoSuchElementException e){
            System.out.println("[NoSuchElementException]");
            System.out.println(e.getMessage());
            Assertions.fail();
        }

        return element;
    }

}
