package ru.aleksei.autotests.ecatalog.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.aleksei.autotests.ecatalog.GenericMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ru.aleksei.autotests.ecatalog.GenericMethods.checkSearchListWebElement;
import static ru.aleksei.autotests.ecatalog.GenericMethods.checkSearchWebElement;

public class POSmartphonesPage {
    private WebDriver driver;

    private final String selectorAllProducer = "//td[@class='rm']//div[@class='show-all']//em[text()='Все бренды']";
    private WebElement allProducer;

    private final String selectorCheckAllProducer = "//div[@class='show-all']//span[@id='br_best']";

    private final String selectorProducerTel = "//div[@id='manufacturers_presets']//li";
    private final String selectorProducerTelURL = "./label/a";
    private final String selectorProducerTelName = "./label/a";
    private List<WebElement> listProducerTelWE;
    private List<Map<String, Object>> listProducerTel = new ArrayList<>();

    private WebElement btnSubmit;
    private final String selectorBtnSubmit = "//div[@class='submit']";

    private final String selectorSmartphones = "//td[@class='main-part-content']//table[@class='model-short-block']";
    private final String selectorSmartphonesURL = ".//span[@class='u']/..";
    private final String selectorSmartphonesName = ".//span[@class='u']";
    private List<WebElement> listSmartphonesWE;
    private List<Map<String, Object>> listSmartphones = new ArrayList<>();

    private final String selectorCheckBoxProducer = "./input[@type='checkbox']";

    private final String selectorBtnNextPage = "//a[@class='ib pager-next']";
    boolean nextPage = true;

    public POSmartphonesPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectionAllProducer(){
        allProducer = checkSearchWebElement(driver, selectorAllProducer);
        GenericMethods.clickWebElements(allProducer);
    }

    public List<Map<String, Object>> getListProducerTel() {
        listProducerTelWE = checkSearchListWebElement(driver, selectorProducerTel);
        GenericMethods.saveWebElementsInList(listProducerTelWE, listProducerTel, selectorProducerTelURL, selectorProducerTelName);
        return listProducerTel;
    }

    public WebElement getBtnSubmit() {
        btnSubmit = checkSearchWebElement(driver, selectorBtnSubmit);
        return btnSubmit;
    }

    public List<Map<String, Object>> getListSmartphones() {

        while (nextPage) {
            listSmartphonesWE = checkSearchListWebElement(driver, selectorSmartphones);
            GenericMethods.saveWebElementsInList(listSmartphonesWE, listSmartphones, selectorSmartphonesURL, selectorSmartphonesName);
            goToNextPage();
        }
        System.out.println(listSmartphones.size());
        return listSmartphones;
    }

    private void goToNextPage(){

        if (checkSearchListWebElement(driver, selectorBtnNextPage).size() > 0)
            GenericMethods.clickWebElements(checkSearchWebElement(driver, selectorBtnNextPage));
        else
            nextPage = false;
    }

    public String checkOpenListAllProducer(){
        WebElement webElement = checkSearchWebElement(driver, selectorCheckAllProducer);
        return webElement.getAttribute("style");
    }

    public boolean checkCheckBoxProducer(WebElement element){
        return checkSearchWebElement(element, selectorCheckBoxProducer).isSelected();
    }
}
