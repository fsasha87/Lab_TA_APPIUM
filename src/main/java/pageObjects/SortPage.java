package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SortPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(SortPage.class));

    private By sortFromCheaper = By.xpath("//android.widget.RadioButton[@index='0']");

    public SearchPage selectFromCheaper() {
        getElement(sortFromCheaper).click();
        LOG.info("Commodities are sorted from cheapper to expensiver");
        return new SearchPage();
    }
}
