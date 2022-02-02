package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(SearchPage.class));

    private By searchField = By.id("ua.com.rozetka.shop:id/search_et_query");
    private By filterButton = By.id("ua.com.rozetka.shop:id/section_iv_filter");
    private By sortButton = By.id("ua.com.rozetka.shop:id/section_iv_sort");
    private By elementsBucket = By.id("ua.com.rozetka.shop:id/section_offer_iv_cart");
    private By mainBucket = By.id("ua.com.rozetka.shop:id/bottom_badge_tv_count");


    public SearchPage enterCommodity(String commodity) {
        getElement(searchField).sendKeys(commodity);
        shutQRWindow();
        clickOnGlass();
        LOG.info(String.format("Comodity %s is entered to searchfield", commodity));
        return this;
    }

    public FilterPage clickFilter() {
        getElement(filterButton).click();
        getElement(filterButton).click();
        LOG.info("FilterPage is opened");
        return new FilterPage();
    }

    public SortPage clickSortButton() {
        getElement(sortButton).click();
        LOG.info("SortPage is opened");
        return new SortPage();
    }

    public SearchPage clickElementsBucket() {
        getElement(elementsBucket).click();
        LOG.info("Element is thrown to the bucket");
        return this;
    }

    public BucketPage clickMainBucket() {
        getElement(mainBucket).click();
        LOG.info("Mainpage is opened");
        return new BucketPage();
    }
}
