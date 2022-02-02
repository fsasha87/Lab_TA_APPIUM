package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class BucketPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(BucketPage.class));

    By bucketCost = By.id("ua.com.rozetka.shop:id/view_price_tv_price");
    By bucketQuantity = By.id("ua.com.rozetka.shop:id/bottom_badge_tv_count");

    public int getQuantity() {
        String str = getElement(bucketQuantity).getText();
        int quantity = Integer.parseInt(str);
        LOG.info(String.format("%d element is in the bucket", quantity));
        return quantity;
    }

    public int getAmount() {
        String st = getElement(bucketCost).getText();
        StringBuilder sb = new StringBuilder(st);
        sb.deleteCharAt(st.length()-4);
        int price = Integer.parseInt(sb.toString());
        LOG.info(String.format("The price of selected commodity is %d", price));
        return price;
    }
}
