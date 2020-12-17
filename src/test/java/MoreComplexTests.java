import io.cucumber.java.eo.Se;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MoreComplexTests {



    WebDriver driver;
    String username = "tomsmith", password = "SuperSecretPassword!";
    String expectedMsg = "You logged into a secure area!";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        String firstResultText = driver.findElement(By.id("article-link-57091")).getText().toLowerCase();
        Assert.assertTrue(firstResultText.contains("testing"));
        String secondResultText = driver.findElement(By.id("article-link-81023")).getText().toLowerCase();
        Assert.assertTrue(secondResultText.contains("testing"));
        String thirdResultText = driver.findElement(By.id("article-link-267204")).getText().toLowerCase();
        Assert.assertTrue(thirdResultText.contains("testing"));

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

    String firstName = "Mariusz", lastName = "Jakistam", email = "daliah17@zwwaltered.com", pass = "qwerty1234";
    String addres = "Przyokopowa 17", city = "Szczecin", phone = "123456798", alias = "razdwatrzy";

    @Test
    public void regstrationTest() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.name("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();
        sleep(4000);
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.name("customer_firstname")).sendKeys(firstName);
        driver.findElement(By.name("customer_lastname")).sendKeys(lastName);
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("passwd")).sendKeys(pass);
        new Select(driver.findElement(By.id("days"))).selectByValue("24");
        new Select(driver.findElement(By.id("months"))).selectByValue("3");
        new Select(driver.findElement(By.id("years"))).selectByValue("1999");
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("optin")).click();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("lastname")).click();
        driver.findElement(By.name("address1")).sendKeys(addres);
        new Select(driver.findElement(By.id("id_country"))).selectByValue("21");
        sleep(2000);
        driver.findElement(By.id("city")).sendKeys(city);
        new Select(driver.findElement(By.id("id_state"))).selectByValue("12");
        driver.findElement(By.id("phone_mobile")).sendKeys(phone);
        WebElement aliasField = driver.findElement(By.id("alias"));
        aliasField.clear();
        aliasField.sendKeys(alias);
        //click reg button

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
    } */
}
