package ru.aleksei.autotests.ecatalog.pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import ru.aleksei.autotests.ecatalog.GenericMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class POMainPage {

    private WebDriver driver;
    private final String selectorProductCatalog = "//table[@class='s-catalog-table']//div[@class='s-catalog-subcat']";
    private final String selectorProductCatalogWE = ".//a";
    private final String selectorProductCatalogURL = ".//a";
    private final String selectorProductCatalogName = ".//a";

    List<WebElement> listProductCatalog;
    private List<Map<String, Object>> listProductGroup = new ArrayList<>();

    public POMainPage(WebDriver driver){
        this.driver = driver;
    }

    public List<Map<String, Object>> getListProductGroup(){
        listProductCatalog = GenericMethods.checkSearchListWebElement(driver, selectorProductCatalog);

        GenericMethods.saveWebElementsInList(listProductCatalog, listProductGroup, selectorProductCatalogWE, selectorProductCatalogURL, selectorProductCatalogName);
        return listProductGroup;
    }
}
