package zdtest.devToPages.cucumbertests;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepsDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    String podcastTitleFromList;
    String firstPodcastFromListLink;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Given("DevTo main page is open")
    public void devto_main_page_is_open()
    {
        driver.get("https://dev.to");
    }

    @When("User click on podcasts")
    public void user_click_on_podcasts()
    {
        WebElement podcasts = driver.findElement(By.partialLinkText("Podcasts"));
        podcasts.click();
    }

    @When("User select first podcast")
    public void user_select_first_podcast()
    {
        wait.until(ExpectedConditions.urlToBe("https://dev.to/pod"));
        WebElement firstPodcast = driver.findElement(By.cssSelector(".content > h3:first-child"));
        podcastTitleFromList = firstPodcast.getText();
        firstPodcastFromListLink = driver.findElement(By.cssSelector("#substories > a:first-child")).getAttribute("href");
        firstPodcast.click();
    }

    @Then("User can see its title")
    public void user_can_see_its_title()
    {
        wait.until(ExpectedConditions.urlToBe(firstPodcastFromListLink));
        WebElement podcastTitle = driver.findElement(By.cssSelector(".title > h1:nth-child(2)"));
        String podcastTitleText = podcastTitle.getText();
        Assert.assertTrue(podcastTitleFromList.contains(podcastTitleText));
    }

    @Then("User can play it")
    public void user_can_play_it()
    {
        WebElement record = driver.findElement(By.className("record"));
        record.click();
        WebElement initializing = driver.findElement(By.className("status-message"));
        wait.until(ExpectedConditions.invisibilityOf(initializing));
        WebElement recordWrapper = driver.findElement(By.className("record-wrapper"));
        String classAttribute = recordWrapper.getAttribute("class");
        Boolean isPodcastPlayed = classAttribute.contains("playing");
        Assert.assertTrue(isPodcastPlayed);
    }

    @When("User click on videos")
    public void userClickOnVideos()
    {
        WebElement videoBtn = driver.findElement(By.partialLinkText("Videos"));
        videoBtn.click();
    }

    @And("User select first video")
    public void userSelectFirstVideo()
    {
        wait.until(ExpectedConditions.urlToBe("https://dev.to/videos"));
        WebElement video = driver.findElement(By.className("video-image"));
        video.click();
    }

    @Then("User can pay video")
    public void userCanPayVideo()
    {
    //assertion
    }

    String username = "tomsmith", password = "SuperSecretPassword!";
    String expectedMsg = "You logged into a secure area!";

    @Given("Open herokuapp.com page")
    public void openHerokuappComPage() 
    {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("Type valid userneme")
    public void typeValidUserneme() 
    {
        driver.findElement(By.name("username")).sendKeys(username);
    }

    @And("Typ valid password")
    public void typValidPassword() 
    {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("Click login button")
    public void clickLoginButton() 
    {
        driver.findElement(By.tagName("button")).click();    
    }

    @Then("Move to user dashboard")
    public void moveToUserDashboard() 
    {
        String actualMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMsg.contains(expectedMsg));
    }

    @And("Click logout button")
    public void clickLogoutButton()
    {
        driver.findElement(By.partialLinkText("Logout")).click();
    }

    @Given("Open automationpractice.com page")
    public void openAutomationpracticeComPage()
    {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }



    @When("User type {string} as email")
    public void userTypeAsEmail(String email)
    {
        driver.findElement(By.name("email_create")).sendKeys(email);
    }

    @And("User click Submit button")
    public void userClickSubmitButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @And("User type {string} as customer username")
    public void userTypeAsCustomerUsername(String firstName) {
        driver.findElement(By.name("customer_firstname")).sendKeys(firstName);
    }

    @And("User select male in gender selector radio button")
    public void userSelectMaleInGenderSelectorRadioButton() {
        driver.findElement(By.id("id_gender1")).click();
    }

    @And("User type {string} as customer lastname")
    public void userTypeAsCustomerLastname(String lastName) {
        driver.findElement(By.name("customer_lastname")).sendKeys(lastName);
    }


    @And("User click on email fieald to confirm provided addres")
    public void userClickOnEmailFiealdToConfirmProvidedAddres() {
        driver.findElement(By.name("email")).click();
    }

    @And("User type {string} as password")
    public void userTypeAsPassword(String pass) {
        driver.findElement(By.name("passwd")).sendKeys(pass);
    }

    @And("User select {int} as days value")
    public void userSelectAsDaysValue(int arg0) {
        new Select(driver.findElement(By.id("days"))).selectByValue("24");
    }

    @And("User select {int} as months value")
    public void userSelectAsMonthsValue(int arg0) {
        new Select(driver.findElement(By.id("months"))).selectByValue("3");
    }

    @And("User select {int} as years value")
    public void userSelectAsYearsValue(int arg0) {
        new Select(driver.findElement(By.id("years"))).selectByValue("1999");
    }

    @And("User mark newslater checkbox")
    public void userMarkNewslaterCheckbox() {
        driver.findElement(By.name("newsletter")).click();
    }


    @And("User click on username field")
    public void userClickOnUsernameField() {
        driver.findElement(By.id("firstname")).click();
    }

    @And("User click on lastname field")
    public void userClickOnLastnameField() {
        driver.findElement(By.id("lastname")).click();
    }

    @And("User type {string} as adress")
    public void userTypeAsAdress(String arg0) {
    }

    @And("User select America as coutry value")
    public void userSelectAmericaAsCoutryValue() {
        new Select(driver.findElement(By.id("id_country"))).selectByValue("21");
    }

    @And("User type {string} as city")
    public void userTypeAsCity(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }

    @And("User type {string} as phone number")
    public void userTypeAsPhoneNumber(String phone) {
        driver.findElement(By.id("phone_mobile")).sendKeys(phone);

    }

    @And("User type {string} as alias")
    public void userTypeAsAlias(String alias) {
        WebElement aliasField = driver.findElement(By.id("alias"));
        aliasField.clear();
        aliasField.sendKeys(alias);
    }

    @And("User click registration button")
    public void userClickRegistrationButton() {
    }

    @Then("User get verification email")
    public void userGetVerificationEmail() {
    }

    @And("User select {int} as State value")
    public void userSelectAsStateValue(int arg0) {
        new Select(driver.findElement(By.id("id_state"))).selectByValue("12");
    }
}
