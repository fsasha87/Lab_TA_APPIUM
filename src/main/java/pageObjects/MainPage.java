package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.AndroidDriverSingleton;

public class MainPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(MainPage.class));

    private By mainPageButton = By.xpath("//android.widget.TextView[@text='Головна']");
    private By mainSearch = By.id("ua.com.rozetka.shop:id/view_search_tv");
    private By supportButton = By.id("ua.com.rozetka.shop:id/btn_contact_us");

    public MainPage proceedToMainPage() {
        getElement(mainPageButton).click();
        LOG.info("Proceeded to MainPage");
        return this;
    }

    public SearchPage clickSearchField() {
        getElement(mainSearch).click();
        LOG.info("Searchfield is clicked");
        return new SearchPage();
    }

    public MainPage scrollToTextSupport(){
        AndroidDriverSingleton.getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().scrollIntoView(new UiSelector().text(\"СЛУЖБА ПІДТРИМКИ\"))");
        LOG.info("Scrolled to text Support");
        return this;
    }

    public SupportPage proceedToSupportPage(){
        getElement(supportButton).click();
        LOG.info("Proceeded to SupportPage");
        return new SupportPage();
    }

}
