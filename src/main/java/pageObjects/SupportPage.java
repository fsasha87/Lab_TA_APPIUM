package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SupportPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(SupportPage.class));
    By telephoneNumber = By.xpath("//android.widget.TextView[starts-with(@text, '+')]");

    public List<String> getPhoneNumbersList() {
        List<String> phonNumbersList = getElements(telephoneNumber).stream().map(e -> e.getText()).collect(Collectors.toList());
        LOG.info("Support phones are received");
        return phonNumbersList;
    }

}