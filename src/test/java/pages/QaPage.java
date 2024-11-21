package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By seeAllQaJobs = By.xpath("//*[@id=\"page-head\"]/div/div/div[1]/div/div/a");

    public QaPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void seeAllQaJobs() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(seeAllQaJobs));
        button.click();
        System.out.println("See all QA Jobs'a tıklandı.");
    }
}
