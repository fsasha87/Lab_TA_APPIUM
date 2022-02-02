package HardCode;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HardCodeTest {
    @Test
    public void testSmth() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("appPackage", "ua.com.rozetka.shop");
        capabilities.setCapability("appActivity", "ua.com.rozetka.shop.screen.MainActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(10000);

        //MainPage
        WebElement wEAllert = driver.findElement(By.id("ua.com.rozetka.shop:id/banner_iv_close"));
        wEAllert.click();

        WebElement search = driver.findElement(By.id("ua.com.rozetka.shop:id/view_search_tv"));
        search.click();

        //searchPage
        WebElement searchField = driver.findElement(By.id("ua.com.rozetka.shop:id/search_et_query"));
        searchField.sendKeys("Холодильник}");
        Thread.sleep(3000);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(10, 1000)).perform();//клик в пустом месте убирает зеленое окно
        Thread.sleep(3000);
        touchAction.tap(PointOption.point(1000, 1900)).perform();//клик по лупе
        Thread.sleep(3000);

        WebElement filterButton = driver.findElement(By.id("ua.com.rozetka.shop:id/section_iv_filter"));
        filterButton.click();

        //filterPage
        WebElement brandSearchField = driver.findElement(By.id("ua.com.rozetka.shop:id/item_filter_search_et_search"));
        brandSearchField.sendKeys("Bosch");
        brandSearchField.click();
        Thread.sleep(3000);
        touchAction.tap(PointOption.point(1000, 1900)).perform();//клик по лупе

        Thread.sleep(3000);

        WebElement checkboxBrand = driver.findElement(By.xpath("//android.widget.CheckBox[@index='5']"));
        checkboxBrand.click();

        WebElement shutFilter = driver.findElement(By.id("ua.com.rozetka.shop:id/view_filters_tv_apply"));
        shutFilter.click();

        //searchPage
        WebElement sortButton = driver.findElement(By.id("ua.com.rozetka.shop:id/section_iv_sort"));
        sortButton.click();

        //sortPage
        WebElement sortFromCheaper = driver.findElement(By.xpath("//android.widget.RadioButton[@index='0']"));
        sortFromCheaper.click();

        //searchPage
        WebElement firstButton = driver.findElement(By.id("ua.com.rozetka.shop:id/section_offer_iv_cart"));
        firstButton.click();

        WebElement mainBucket = driver.findElement(By.id("ua.com.rozetka.shop:id/bottom_badge_tv_count"));
        mainBucket.click();
        Thread.sleep(3000);

        //bucketPage
        WebElement bucketCost = driver.findElement((By.id("ua.com.rozetka.shop:id/view_price_tv_price")));
        String amount = bucketCost.getText();
        System.out.println(amount);

    }
}
