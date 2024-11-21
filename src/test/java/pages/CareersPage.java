package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class CareersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By locations = By.xpath("//*[@id='location-slider']/div/ul/li");
    private By lifeAtInsider = By.xpath("//h2[contains(@class, 'elementor-heading-title') and text()='Life at Insider']");
    private By seeAllTeamsButton = By.xpath("//*[@id=\"career-find-our-calling\"]/div/div/a");
    private By clickQa = By.xpath("//*[@id=\"career-find-our-calling\"]/div/div/div[2]/div[12]/div[2]/a/h3");

    public CareersPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickSeeAllTeams() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Elementin tıklanabilir olmasını bekle
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='career-find-our-calling']/div/div/a")));

        try {
            // Scroll işlemi yap ve tıkla
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (ElementClickInterceptedException e) {
            // JavaScript ile zorla tıkla
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void verifyLocations() {
        List<WebElement> locationElements = driver.findElements(locations);
        Assert.assertTrue(locationElements.size() > 0, "Locations bulunamadı!");
        System.out.println("Locations doğrulandı: " + locationElements.size() + " adet.");
    }

    public void verifyLifeAtInsider() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lifeAtInsider));
        Assert.assertTrue(element.isDisplayed(), "Life at Insider bölümü bulunamadı!");
        System.out.println("Life at Insider doğrulandı.");
    }
    public void clickQa() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickQa));

        // Elementi görünür hale getir
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);

        // Tıklamayı dene
        try {
            button.click();
        } catch (ElementClickInterceptedException e) {
            // Eğer tıklama engellenirse, JavaScript ile tıkla
            js.executeScript("arguments[0].click();", button);
        }

        System.out.println("Quality Assurance tıklandı.");
    }


}
