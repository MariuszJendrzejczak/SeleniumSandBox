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
    WebDriverWait wait;


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
        wait = new WebDriverWait(driver, 10);

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
        wait.until(ExpectedConditions.urlToBe("https://dev.to/videos"));
        WebElement video = driver.findElement(By.className("video-image"));
        video.click();
    }

    @Test
    public void selectFirstPodcast(){
        driver.get("https://dev.to");
        WebElement podcasts = driver.findElement(By.partialLinkText("Podcasts"));
        podcasts.click();
        wait.until(ExpectedConditions.urlToBe("https://dev.to/pod"));
        WebElement firstPodcast = driver.findElement(By.cssSelector(".content > h3:first-child"));
        String podcastTitleFromList = firstPodcast.getText();
        String firstPodcastFromListLink = driver.findElement(By.cssSelector("#substories > a:first-child")).getAttribute("href");
//
//        WebElement linkToPodcast = driver.findElement(By.cssSelector("#substories > a:first-child"));
//        String linkToPodcastHref = linkToPodcast.getAttribute("href");
//
        firstPodcast.click();
        wait.until(ExpectedConditions.urlToBe(firstPodcastFromListLink));
        WebElement podcastTitle = driver.findElement(By.cssSelector(".title > h1:nth-child(2)"));
        String podcastTitleText = podcastTitle.getText();
        Assert.assertTrue(podcastTitleFromList.contains(podcastTitleText));
        WebElement record = driver.findElement(By.className("record"));
        record.click();
        WebElement initializing = driver.findElement(By.className("status-message"));
        wait.until(ExpectedConditions.invisibilityOf(initializing));
        WebElement recordWrapper = driver.findElement(By.className("record-wrapper"));
        String classAttribute = recordWrapper.getAttribute("class");
        Boolean isPodcastPlayed = classAttribute.contains("playing");
        Assert.assertTrue(isPodcastPlayed);
        //znajdz record
        //kliknij record :)
        //zadanko 2 : napisz na click meetingu, jak sprawdzić czy podcast jest "odpalony" XD
        //div zmienia nazwę klasy na record-wrapper playing
    }

    @Test
    public void highlightFisrtVideo()
    {
        driver.get("https://dev.to/videos");
        WebElement video = driver.findElement(By.className("video-image"));
        highlightElement(video);
        video.click();
    }

    private void sleep(int miliSec) {
        try {
            Thread.sleep(miliSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





    @After
    public void tearDown()
    {
    //    driver.quit();
    }
}
