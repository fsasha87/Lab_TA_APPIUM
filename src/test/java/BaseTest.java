import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.ModalPage;
import utils.AndroidDriverSingleton;

public class BaseTest {
    @BeforeClass
    public void shutModal() {
        new ModalPage().shutModal();
    }


    @AfterClass
    public void quitDriver() {
        AndroidDriverSingleton.quitDriver();
    }
}
