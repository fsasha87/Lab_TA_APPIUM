package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ModalPage extends BasePage{
    private static final Logger LOG = Logger.getLogger(String.valueOf(ModalPage.class));

    private By wEAllert = By.id("ua.com.rozetka.shop:id/banner_iv_close");

    public ModalPage shutModal(){
        getElement(wEAllert).click();
        LOG.info("Occured modal window is shut");
        return this;
    }
}
