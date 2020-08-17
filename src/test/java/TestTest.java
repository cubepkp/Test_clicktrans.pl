import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

class TestTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:/Users/bart/Desktop/SeleniumBDD/geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        driver.get("https://dev-1.clicktrans.pl/register-test/courier");


        WebElement registrationForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_register")));

        registrationForm.findElement(By.xpath("//input[@id='user_register_company_name']")).sendKeys("Usługi Transportowe");
        registrationForm.findElement(By.xpath("user_register[email]")).sendKeys("jan.kowalski@email.com");
        registrationForm.findElement(By.name("user_register[name]")).sendKeys("Jan Kowalski");
        registrationForm.findElement(By.name("user_register[phone]")).sendKeys("543321123");
        registrationForm.findElement(By.name("user_register[plainPassword]")).sendKeys("87654321");
        registrationForm.findElement(By.name("user_register[settings][agreementRegulations]")).click();
        registrationForm.findElement(By.name("user_register[settings][agreementPersonalData]")).click();
        registrationForm.findElement(By.id("user_register_submit")).click();


        String success_message = driver.findElement(By.xpath("//div[@class='ui success message']")).getText();
        assertThat(success_message).isEqualTo("OK - some registration logic is mocked");

        driver.close();


    }
}