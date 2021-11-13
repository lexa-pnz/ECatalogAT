package ru.aleksei.autotests.ecatalog;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import ru.aleksei.autotests.ecatalog.pageObjects.POMainPage;
import ru.aleksei.autotests.ecatalog.pageObjects.POProductType;
import ru.aleksei.autotests.ecatalog.pageObjects.POSmartphonesPage;

public class Tests extends WebDriverSettings{

    @Test
    @Description(value = "Test site E-Katalog")
    public void checkingPhoneModels() {
        POMainPage pOMainPage = new POMainPage(driver);
        Steps.openECatalog(driver, "e-Katalog - каталог товаров");
        Steps.searchProductGroup(driver, pOMainPage, "Связь и гаджеты", "мобильные и связь");

        POProductType pOProductType = new POProductType(driver);
        Steps.searchProductType(driver, pOProductType, "Мобильные телефоны", "мобильные телефоны");

        POSmartphonesPage poSmartphonesPage = new POSmartphonesPage(driver);
        Steps.openListAllProducer(poSmartphonesPage);
        Steps.selectProducerTel(poSmartphonesPage, driver, "Xiaomi");
        Steps.pressBtnSubmit(poSmartphonesPage, driver, "Xiaomi");
        Steps.checkCourse(poSmartphonesPage, "Xiaomi");
    }
}
