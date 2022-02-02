package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.AndroidDriverSingleton;

public class FilterPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(FilterPage.class));

    private By brandSearchField = By.id("ua.com.rozetka.shop:id/item_filter_search_et_search");
    private By checkboxBrand = By.xpath("//android.widget.CheckBox[@index='5']");
    private By shutFilterButton = By.id("ua.com.rozetka.shop:id/view_filters_tv_apply");
    private By goodPresent = By.xpath("//android.widget.CheckBox[contains(@text, 'Є в наявності')]");

    public FilterPage typeBrand(String brand) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement we = getWhenPresent(brandSearchField);
        we.sendKeys(brand);
        we.click();
        clickOnGlass();
        LOG.info(String.format("Brand %s is typed.", brand));
        return this;
    }

    public FilterPage clickCheckboxBrand() {
        getElement(checkboxBrand).click();
        LOG.info("Chexbox is selected");
        return this;
    }

    public FilterPage shutFilter() {
        scrollToEnd();
        getElement(shutFilterButton).click();
        LOG.info("Filter window is shut");
        return this;
    }

}
