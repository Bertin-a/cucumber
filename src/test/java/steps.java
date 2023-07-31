import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class steps {
    private WebDriver driver;

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_para_bank_application() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/");
    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        driver.findElement(By.name("username")).sendKeys("test-ignore");
        driver.findElement(By.name("password")).sendKeys("password");

    }
    @Then("I should be taken to the overview page")
    public void i_should_be_taken_to_the_overview_page() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[id='rightPanel']>h1")).isDisplayed();
        driver.findElement(By.linkText("Log out")).click();
    }
}
