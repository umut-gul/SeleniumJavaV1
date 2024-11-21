package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LeverPage {
    private WebDriver driver;

    public LeverPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLeverPageUrl() {
        String expectedUrl = "https://useinsider.com/careers/open-positions/?department=qualityassurance";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Beklenen URL: " + expectedUrl);
        System.out.println("Gerçek URL: " + actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl, "Sayfa URL'si eşleşmiyor!");
        System.out.println("Sayfa URL'si doğrulandı.");
    }
}
