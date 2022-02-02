import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.businessObject.SupportPageBO;
import pageObjects.businessObject.Verifier;
import utils.TestListener;

@Listeners(TestListener.class)
public class SupportPageTest extends BaseTest{
    @Test
    public void verifySupportPhones() {
        new SupportPageBO()
                .getToSupportPage();
        new Verifier()
                .verifyPhonesMeetPattern();
    }
}
