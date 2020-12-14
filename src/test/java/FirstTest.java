import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest
{
    WebDriver driver;


    public void highlightElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        // ustawiamy property na chromdrivera którego użyjemy.
        driver = new ChromeDriver();

    }

    @Test
    public void firstTest()
    {
        driver.get("https://dev.to");
        WebElement weekBtn = driver.findElement(By.cssSelector("#articles-list > header > nav > a:nth-child(2)"));
        weekBtn.click();

    }

    @Test
    public  void secondTest()
    {
        driver.get("https://dev.to");
        WebElement videoBtn = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/aside/nav[1]/div/a[3]"));
        highlightElement(videoBtn);
        videoBtn.click();
    }

    @Test
    public void openVideosBtnByText()  {
        driver.get("https://dev.to");
        WebElement videoBtn = driver.findElement(By.partialLinkText("Videos"));
        videoBtn.click();
        WebDriverWait wait3sec = (WebDriverWait) new WebDriverWait(driver, 3);
        wait3sec.until(ExpectedConditions.urlToBe("https://dev.to/videos"));
        WebElement video = driver.findElement(By.className("video-image"));
        video.click();
    }

    @Test
    public void highlightFisrtVideo()
    {
        driver.get("https://dev.to/videos");
        WebElement video = driver.findElement(By.className("video-image"));
        highlightElement(video);
        video.click();
    }





    @After
    public void tearDown()
    {
        driver.quit();
    }
}
