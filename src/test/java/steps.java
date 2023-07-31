import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class steps {
    private WebDriver driver;

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_para_bank_application() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://parabank.parasoft.com/parabank/");
    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        driver.findElement(By.name("username")).sendKeys("test-ignore");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.cssSelector("input[class='button']")).click();

    }
    @Then("I should be taken to the overview page")
    public void i_should_be_taken_to_the_overview_page() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.className("title")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();
    }
}
