package ru.aleksei.autotests.ecatalog.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.aleksei.autotests.ecatalog.GenericMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class POProductType {
    private WebDriver driver;
    private final String selectorProductType = "//div[@class='brands-new mb30']//a";
    private List<WebElement> listProduct;
    private List<Map<String, Object>> listProductType = new ArrayList<>();

    public POProductType(WebDriver driver){
        this.driver = driver;
    }

    public List<Map<String, Object>> getProductType(){
        listProduct = GenericMethods.checkSearchListWebElement(driver, selectorProductType);
        GenericMethods.saveWebElementsInList(listProduct, listProductType);
        return listProductType;
    }
}
