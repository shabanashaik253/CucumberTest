package CucumberStepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

    public class GmailStepDef {
        public static WebDriver driver;

        @When("^data is sent as parameter$")
        public void data_is_sent_as_parameter(DataTable data) throws Throwable {

            List<List<String>> d=data.raw();
            int total=d.size();
            System.out.print(total+" elements are there in the datatable");
            for(int i=0;i<total;i++)
            {
                System.out.println("data "+i+" in the table is: "+d.get(i));
            }


        }

        @Then("^data should come$")
        public void data_should_come() throws Throwable {
            System.out.println("Data imported successfully");
        }


        @Given("^User is on Login Home Page$")
        public void loginhomepage() throws Throwable {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRINIDHI\\Downloads\\Browsers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://accounts.google.com/signin");
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        }

        @When("^User enters Valid \"([^\"]*)\" AND \"([^\"]*)\"$")
        public void user_enters_Valid_AND(String username, String password) throws Throwable {
            driver.findElement(By.id("identifierId")).sendKeys(username);
            driver.findElement(By.id("identifierNext")).click();
            driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
            driver.findElement(By.id("passwordNext")).click();
        }

        @Then("^User is successfully logged in$")
        public void user_is_successfully_logged_in() throws Throwable {
            System.out.println("Login Successfully");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        @Given("^user is logged in$")
        public void user_is_logged_in() throws Throwable {

            System.out.println("user is logged in successfully, Click on Gmail icon to go to mail page");
        }

        @When("^user clicks on the Gmail symbol$")
        public void user_clicks_on_the_Gmail_symbol() throws Throwable {
            driver.findElement(By.xpath("//div[@class='vmZ0T']/a[2]")).click();
        }

        @Then("^user is taken to the Gmail page$")
        public void user_is_taken_to_the_Gmail_page() throws Throwable {
            System.out.println("in gmail page now");
        }
    }

