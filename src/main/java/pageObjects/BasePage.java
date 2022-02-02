package pageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static utils.AndroidDriverSingleton.getDriver;

public class BasePage {
    WebDriverWait wait;
    TouchAction touchAction;
    int width;
    int height;


    {
        wait = new WebDriverWait(getDriver(), 10);
        touchAction = new TouchAction(getDriver());
        width = getDriver().manage().window().getSize().width;
        height = getDriver().manage().window().getSize().height;
    }

    public WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    public List<WebElement> getElements(By locator) {
        return getDriver().findElements(locator);
    }

    public WebElement getWhenPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return getDriver().findElement(locator);
    }

    public void shutQRWindow() {
        touchAction.tap(PointOption.point(10 * 1080 / width, 1000 * 2016 / height)).perform();
    }

    public void clickOnGlass() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        touchAction.tap(PointOption.point(1000 * 1080 / width, 1900 * 2016 / height)).perform();
    }

    public void scrollToEnd() {
        try {
            getDriver().findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().scrollToEnd(10)"));
         } catch (InvalidSelectorException e) {
            e.printStackTrace();
        }
    }
}
