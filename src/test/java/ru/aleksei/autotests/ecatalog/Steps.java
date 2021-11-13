package ru.aleksei.autotests.ecatalog;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.aleksei.autotests.ecatalog.pageObjects.POMainPage;
import ru.aleksei.autotests.ecatalog.pageObjects.POProductType;
import ru.aleksei.autotests.ecatalog.pageObjects.POSmartphonesPage;

import java.util.Map;

public class Steps extends Tests{


    @Step("Step 1. Open E-Catalog")
    public static void openECatalog(WebDriver driver, String namePage){
        driver.get("https://www.e-katalog.ru/");
        Assertions.assertTrue(driver.getTitle().contains(namePage));
    }

    @Step("Step 2. Open group page")
    public static void searchProductGroup(WebDriver driver, POMainPage poMainPage, String productGroupName, String namePage){
        WebElement product = GenericMethods.searchNeededWE(poMainPage.getListProductGroup(), productGroupName);

        if (product != null) GenericMethods.clickWebElements(product, driver);
        else System.out.println("Product Group not found");

        Assertions.assertTrue(driver.getTitle().contains(namePage));
    }

    @Step("Step 3. Open type page")
    public static void searchProductType(WebDriver driver, POProductType pOProductType, String productTypeName, String namePage){
        WebElement product = GenericMethods.searchNeededWE(pOProductType.getProductType(), productTypeName);

        if (product != null) GenericMethods.clickWebElements(product, driver);
        else System.out.println("Product Type not found");

        Assertions.assertTrue(driver.getTitle().contains(namePage));
    }

    @Step("Step 4. Open list all model smartphones")
    public static void openListAllProducer(POSmartphonesPage poSmartphonesPage){
        poSmartphonesPage.selectionAllProducer();
        Assertions.assertEquals("display: inline;", poSmartphonesPage.checkOpenListAllProducer());
    }

    @Step("Step 5. Select model smartphone")
    public static void selectProducerTel(POSmartphonesPage poSmartphonesPage, WebDriver driver, String producerName){
        WebElement producer = GenericMethods.searchNeededWE(poSmartphonesPage.getListProducerTel(), producerName);
        boolean assertionCheckBoxProducer = false;

        if (producer != null) {
            GenericMethods.clickWebElements(producer, driver);
            assertionCheckBoxProducer = poSmartphonesPage.checkCheckBoxProducer(producer);
        }
        else System.out.println("Producer not found");

        Assertions.assertTrue(assertionCheckBoxProducer);
    }

    @Step("Step 6. Press button Submit")
    public static void pressBtnSubmit(POSmartphonesPage poSmartphonesPage, WebDriver driver, String namePage){
        GenericMethods.clickWebElements(poSmartphonesPage.getBtnSubmit());
        Assertions.assertTrue(driver.getTitle().contains(namePage));
    }

    @Step("Step 7. Check results")
    public static void checkCourse(POSmartphonesPage poSmartphonesPage, String smartphoneName){
        boolean checkSmartphonesName = true;

        for (Map<String, Object> listSmartphone: poSmartphonesPage.getListSmartphones()){
            if (!listSmartphone.get("NAME_PRODUCT").toString().contains(smartphoneName)) {
                checkSmartphonesName = false;
            }
        }

        Assertions.assertTrue(checkSmartphonesName);
    }

}
