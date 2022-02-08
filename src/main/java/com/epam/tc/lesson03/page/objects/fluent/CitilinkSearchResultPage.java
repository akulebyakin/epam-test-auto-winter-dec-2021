package com.epam.tc.lesson03.page.objects.fluent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CitilinkSearchResultPage extends AbstractCitilinkBasePage {

    private static final By PRODUCT_LIST_TITLE_LOCATOR = By.xpath("//div[contains(@class, 'product_data')]"
        + "//a[contains(@class, 'ProductCardVertical__name')]");

    @FindBy(xpath = "//div[contains(@class, 'product_data')]//a[contains(@class, 'ProductCardVertical__name')]")
    private List<WebElement> productList;

    public CitilinkSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductTitles() {
        List<WebElement> collect =
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(PRODUCT_LIST_TITLE_LOCATOR, 2));
        List<String> titles = new ArrayList<>();

        for (WebElement webElement : collect) {
            titles.add(webElement.getText());
        }

        return titles;
    }

    public List<String> getProductTitlesV2() {
        return productList
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
