package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class JobsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By jobList = By.xpath("//*[@id='jobs-list']/div/div");
    private By viewRoleButton = By.xpath("//*[@id='jobs-list']/div/div/a");
    private By departmentDropdown = By.xpath("//*[@id=\"select2-filter-by-department-container\"]");
    private By departmentOption = By.xpath("//*[@id=\"select2-filter-by-department-result-3t7w-Quality Assurance\"]");
    private By locationDropdown = By.xpath("//*[@id=\"top-filter-form\"]/div[1]/span/span[1]/span/span[2]/b");
    private By locationOption = By.xpath("//li[contains(text(),'Istanbul, Turkey')]");
    public JobsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void selectLocationOnly() {
        try {
            // Sayfayı 1000 piksel aşağı kaydır
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
            System.out.println("Sayfa 1000 piksel aşağı kaydırıldı.");

            // 10 saniye bekleme
            Thread.sleep(10000);

            // 3. Adım: İkinci combobox'ı bekle ve aç
            WebElement locationDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(locationDropdown));
            locationDropdownElement.click();
            System.out.println("İkinci combobox açıldı.");

            // 4. Adım: JavaScript ile sayfayı seçeneğe kaydır ve tıkla
            WebElement locationOptionElement = wait.until(ExpectedConditions.presenceOfElementLocated(locationOption));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationOptionElement);
            Thread.sleep(1000); // Scroll sonrası stabilite için bekleme
            locationOptionElement.click();
            System.out.println("Istanbul, Turkey seçildi.");
            // 10 saniye bekleme
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme sırasında bir hata oluştu: " + e.getMessage());
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Bekleme süresi aşıldı: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }

    }

    public void verifyJobs(String location, String department) {
        // İş ilanlarını listele
        List<WebElement> jobs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobList));
        Assert.assertTrue(jobs.size() > 0, "İş ilanları bulunamadı!");
        System.out.println("Bulunan iş ilanları: " + jobs.size());

        // Her bir iş ilanını kontrol et
        for (WebElement job : jobs) {
            // Lokasyon bilgisi
            String jobLocation = job.findElement(By.xpath(".//div[contains(@class, 'location')]")).getText();
            // Departman bilgisi
            String jobDepartment = job.findElement(By.xpath(".//span[contains(@class, 'department')]")).getText();

            // Lokasyonun doğruluğunu kontrol et
            if (jobLocation.contains(location)) {
                System.out.println("Lokasyon eşleşiyor: " + jobLocation);
            } else {
                System.out.println("Lokasyon eşleşmiyor: " + jobLocation);
            }

            // Departmanın doğruluğunu kontrol et
            if (jobDepartment.contains(department)) {
                System.out.println("Departman eşleşiyor: " + jobDepartment);
            } else {
                System.out.println("Departman eşleşmiyor: " + jobDepartment);
            }

            // Eğer her ikisi de eşleşiyorsa mesaj yazdır
            if (jobLocation.contains(location) && jobDepartment.contains(department)) {
                System.out.println("Eşleşen iş ilanı bulundu: " + jobLocation + " - " + jobDepartment);
            }
        }
    }


    public void clickViewRole() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(viewRoleButton));
        button.click();
        System.out.println("View Role tıklandı.");
    }
}
