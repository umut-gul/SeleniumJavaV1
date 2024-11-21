package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.JobsPage;
import utils.BaseTest;

import java.time.Duration;

public class HomePageTC01 extends BaseTest {
    private WebDriverWait wait;

    @BeforeMethod
    public void setUpTest() {
        setUp();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testInsiderCareersFlow() {
        driver.get("https://useinsider.com/");

        // Home Page
        HomePage homePage = new HomePage(driver, wait);
        homePage.verifyHomePage();
        homePage.clickCompanyMenu();
        homePage.clickCareers();

    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}

