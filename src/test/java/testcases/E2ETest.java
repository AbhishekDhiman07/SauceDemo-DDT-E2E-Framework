package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SaucePage;

public class E2ETest extends BaseTest {

    @DataProvider(name = "data", parallel = true)
    public Object[][] getData() {
        return new Object[][] { 
            {"standard_user", "secret_sauce"}, 
            {"problem_user", "secret_sauce"} 
        };
    }

    @Test(dataProvider = "data")
    public void validatePurchase(String u, String p) {
        SaucePage sauce = new SaucePage(getDriver());
        sauce.login(u, p);
        sauce.addToCart();
        sauce.goToCart();
        sauce.checkout();
        sauce.enterInformation("Gemini", "AI", "12345");
        Assert.assertTrue(sauce.finishOrder());
    }
}