import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.assertj.core.api.Assertions.assertThat;



class TestTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:/Users/bart/Desktop/SeleniumBDD/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://dev-1.clicktrans.pl/register-test/courier");


        driver.findElement(By.xpath("//input[@id='user_register_company_name']")).sendKeys("Usługi Transportowe");
        driver.findElement(By.xpath("//input[@id='user_register_email']")).sendKeys("jan.kowalski@email.com");
        driver.findElement(By.xpath("//input[@id='user_register_name']")).sendKeys("Jan Kowalski");
        driver.findElement(By.xpath("//input[@id='user_register_phone']")).sendKeys("543321123");
        driver.findElement(By.xpath("//input[@id='user_register_plainPassword']")).sendKeys("87654321");
        driver.findElement(By.cssSelector("#user_register_settings_agreementRegulations")).click();
        driver.findElement(By.cssSelector("#user_register_settings_agreementPersonalData")).click();
        driver.findElement(By.id("user_register_submit")).click();


        String success_message = driver.findElement(By.xpath("//div[@class='ui success message']")).getText();
        assertThat(success_message).isEqualTo("OK - some registration logic is mocked");


        driver.quit();


    }
}