package CucumberStepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApsrtcStepDef{

    private static WebDriver driver;
    @When("^user hits the Apsrtc url$")
    public void user_hits_the_Apsrtc_url()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRINIDHI\\Downloads\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.apsrtconline.in/oprs-web/");
        driver.manage().window().maximize();


    }
    @Then("^user should land on Apsrtc home page$")
    public void user_should_land_on_Apsrtc_home_page()
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("User is in home page!!");
    }
    @Given("^user is on Apsrtc home page$")
    public void user_is_on_Apsrtc_home_page()
    {
        System.out.println("Select from and to places!!");
    }

    @When("^user enter From and To places$")
    public void user_enter_From_and_To_places() {
        WebElement from = driver.findElement(By.id("fromPlaceName"));
        from.sendKeys("BENGA");
        from.sendKeys(Keys.ARROW_DOWN);
        from.sendKeys(Keys.ENTER);
        WebElement to = driver.findElement(By.id("toPlaceName"));
        to.sendKeys("ANANTAP");
        to.sendKeys(Keys.ARROW_DOWN);
        to.sendKeys(Keys.ENTER);
    }
    @When("^enter Depart on date$")
    public void enter_Depart_on_date() {
        driver.findElement(By.id("txtJourneyDate")).click();
        driver.findElement(By.linkText("25")).click();

    }

    @When("^click on Check Availability$")
    public void click_on_Check_Availability() {
        driver.findElement(By.className("chkavailabilityBtn")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @Then("^user should get the bus details related to the search$")
    @Given("^When user is in Bus details page$")
    public void user_should_get_the_bus_details_related_to_the_search() {
        System.out.println("Showing all the bus details!!!");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");

    }

    @When("^user Selects a particular bus service and enters all the details$")
    public void user_Selects_a_particular_bus_service_and_enters_all_the_details()
    {
        driver.findElement(By.id("SrvcSelectBtnForward26")).click();
        Select select=new Select(driver.findElement(By.id("ForwardBoardId")));
        List<WebElement> li=select.getOptions();
        for(int i=0;i<li.size();i++)
        {
            System.out.println("the options are: "+li.get(i).getText());
        }
        select.selectByVisibleText("BNG KEMPEGOWDA BS TERMINAL 1 - 21:00");


    }

    @When("^click on Show Layout$")
    public void click_on_Show_Layout()  {
        driver.findElement(By.id("fwLtBtn")).click();
    }

    @Then("^Seats page will be opened$")
    @Given("^Seats page is opened$")
    public void seats_page_will_be_opened()  {

        System.out.println("Seats are displayed!!Please select your seat: ");

    }
    @When("^user selects a seat & fills in all the details$")
    public void user_selects_a_seat_fills_in_all_the_details(DataTable data) throws Throwable {
        List<Map<String, String>> d= data.asMaps(String.class, String.class);

        driver.findElement(By.id("Forward9")).click();
        driver.findElement(By.id("bookedByName")).sendKeys(d.get(0).get("Passenger name"));
        driver.findElement(By.id("mobileNo")).sendKeys(d.get(0).get("Mobile No"));
        driver.findElement(By.id("email")).sendKeys(d.get(0).get("Email Id"));
        Select select=new Select(driver.findElement(By.name("genderCodeId")));
        select.selectByVisibleText("FEMALE");
        driver.findElement(By.name("passengerAge")).sendKeys("23");
    }

    @When("^click on Continue$")
    public void click_on_Continue()  {
        driver.findElement(By.id("BookNowBtn")).click();

    }

    @Then("^user should go to payment page$")
    public void user_should_go_to_payment_page() throws IOException {
        System.out.println("Payment page is opened");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("C:\\workspace\\MavenProjectExample\\screenshot\\Payment.png"));

    }






}