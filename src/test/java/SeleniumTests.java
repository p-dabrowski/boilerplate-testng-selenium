
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumTests {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://www.google.pl");
        driver.findElement(By.xpath("(//button)[last()]")).click();
    }

    @DataProvider(name="queries")
    public static Object[][] getQuery() {
        return new Object[][]{
                {"test1"},
                {"kotek"},
                {"piesek"}
        };
    }

    @Test(dataProvider = "queries")
    public void firstTest(String query) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(query);
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
