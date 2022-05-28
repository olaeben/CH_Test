
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class WebTest {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);

    }

    @Test (testName = "Shop for Tv on Amazon")
    public static void shopTv() throws InterruptedException {
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".hm-icon")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.cssSelector("li:nth-child(16) > .hmenu-item > div")).click();
        driver.findElement(By.linkText("Televisions")).click();
        Thread.sleep(600);
        WebElement P = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[17]/ul/li[5]/span/a/div/label/i"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].scrollIntoView();", P);
        Actions a = new Actions(driver);
        a.moveToElement(P).click().build().perform();
        Thread.sleep(200);
        driver.findElement(By.id("a-autoid-0-announce")).click();
        driver.findElement(By.id("s-result-sort-select_2")).click();
        {
            WebElement element = driver.findElement(By.xpath("//img[@alt='Samsung 163 cm (65 inches) 4K Ultra HD Smart QLED TV QA65QN90AAKLXL (Black) (2021 Model)']"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }

    }
}