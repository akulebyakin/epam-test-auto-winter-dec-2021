package com.epam.tc.lesson03.page.objects.composite;

import com.epam.tc.lesson03.page.objects.composite.component.HorizontalProductComponent;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitilinkProductsPage extends AbstractCitilinkBasePage {

    @FindBy(xpath = "//div[contains(@class, 'product_data')]")
    private List<WebElement> productList;

    public CitilinkProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<HorizontalProductComponent> getProducts() {
        return productList
            .stream()
            .map(elem -> new HorizontalProductComponent(driver, elem))
            .collect(Collectors.toList());
    }
}
