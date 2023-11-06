import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

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
    public void i_enter_valid_credentials(DataTable dataTable){
        //List<List<String>> login = table.cell();
        //List<String> login = dataTable.asList();
        String username = dataTable.cell(1,0);
        String password= dataTable.cell(1,1);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[class='button']")).click();

    }
    @Then("I should be taken to the overview page")
    public void i_should_be_taken_to_the_overview_page() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.className("title")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
