package pageObjects.businessObject;


import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import pageObjects.BucketPage;
import pageObjects.SupportPage;

public class Verifier {
    private static final Logger LOG = Logger.getLogger(String.valueOf(Verifier.class));
    BucketPage bucketPage = new BucketPage();
    SupportPage supportPage = new SupportPage();
    SoftAssert softAssert = new SoftAssert();


    public Verifier verifyBucketIsNotEmpty() {
        int quantity = bucketPage.getQuantity();
        softAssert.assertTrue(quantity > 0, "Bucket is empty");
        softAssert.assertAll();
        return this;
    }

    public Verifier verifyBucketAmount() {
        int price = bucketPage.getAmount();
        softAssert.assertTrue(price < 100000, "Not enough money. Work more!");
        softAssert.assertAll();
        return this;
    }

    public Verifier verifyPhonesMeetPattern() {
        String pattern = "(\\+)38[- .]?(044|063|097|096|050|093)[- .]?\\d{3}[- .]?\\d{2}[- .]?\\d{2}$";
        boolean flag = false;
        for (String item : supportPage.getPhoneNumbersList()) {
            if (item.matches(pattern))
                flag = true;
        }
        softAssert.assertTrue(flag, "phones don't meet pattern");
        softAssert.assertAll();
        LOG.info(String.format("all phones meet pattern: %b", flag));
        return this;
    }
}
