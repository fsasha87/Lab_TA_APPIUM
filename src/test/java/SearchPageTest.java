import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.businessObject.SearchPageBO;
import pageObjects.businessObject.Verifier;
import utils.TestListener;

@Listeners(TestListener.class)
public class SearchPageTest extends BaseTest {

    @DataProvider(name = "dP1")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"Холодильник", "Bosch"}, {"Ноутбук", "Lenovo"}, {"Автошини", "Nokian"}};
    }

    @Test(dataProvider = "dP1", description = "Verify that mentioned good is in the bucket")
    public void putCommodityToBucket(String commodity, String brand) {
        new SearchPageBO()
                .typeCategory(commodity)
                .selectBrand(brand)
                .throwCheapestToBucket();
        new Verifier()
                .verifyBucketIsNotEmpty()
                .verifyBucketAmount();
    }

}