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
    String username = "tomsmith", password = "SuperSecretPassword!";
    String expectedMsg = "You logged into a secure area!";

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

    @Test
    public void podcastTest()
    {
        driver.get("https://dev.to");
        driver.findElement(By.partialLinkText("Podcasts")).click();
        sleep(2000);
        WebElement podcast = driver.findElement(By.cssSelector(".content > h3:first-child"));
        String podcastdiscription = podcast.getText();
        System.out.println(podcastdiscription);
        podcast.click();
        sleep(4000);
        String actualMsg = driver.findElement(By.className("smaller")).getText();
        Assert.assertTrue(podcastdiscription.contains(actualMsg));
        driver.findElement(By.className("play-butt")).click();
    }

    @Test
    public void searchTest()
    {
        driver.get("https://dev.to");
        driver.findElement(By.name("q")).sendKeys("testing\n");
        sleep(4000);
        String firstResultText = driver.findElement(By.id("article-link-57091")).getText();
        Assert.assertTrue(firstResultText.contains("testing")||firstResultText.contains("Testing"));
        String secondResultText = driver.findElement(By.id("article-link-81023")).getText();
        Assert.assertTrue(secondResultText.contains("testing")||secondResultText.contains("Testing"));
        String thirdResultText = driver.findElement(By.id("article-link-267204")).getText();
        Assert.assertTrue(thirdResultText.contains("testing")||thirdResultText.contains("Testing"));


    }
    @Test
    public void loginTest()
    {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
        String actualMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        driver.findElement(By.partialLinkText("Logout")).click();
    }


    private void sleep(int miliSec) {
        try {
            Thread.sleep(miliSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


/*
    @After
    public void tearDown()
    {
        driver.quit();
]    }*/
}
