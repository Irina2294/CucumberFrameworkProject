package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class AddEmployeeSteps extends CommonMethods {

   //@Given("user is able to access HRMS application")
   //public void user_is_able_to_access_hrms_application() {
   // driver = new ChromeDriver();
    //   driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
     //  driver.manage().window().maximize();
     //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   // }
    @When("user enters valid user name and password")
    public void user_enters_valid_user_name_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }
   // @Then("user is able to see dashboard page")
   // public void user_is_able_to_see_dashboard_page() {
      //  Assert.assertTrue(dashboardPage.welcomeText.isDisplayed());
     //   System.out.println("test passed");
   // }
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement PimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(PimOption);

    }
    @Then("user clicks add employee option")
    public void user_cilcks_add_employee_option() {
        WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmployeeOption);

    }
    @When("user enters firstname and lastname and middlename in the name fields")
    public void user_enters_firstname_and_lastname_and_middlename_in_the_name_fields() {
        sendText("Irina",addEmployeePage.firstnameLocator);
        sendText("VAL",addEmployeePage.middlenameLocator);
        sendText("Foster",addEmployeePage.lastnameLocator);
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }
    @Then("user added successfully")
    public void user_added_successfully() {
        System.out.println("test passed");
    }
    //**********************************************************************************************************************
   /* @When("user adds an employee with First Name {string}, Middle Name {string}, Last Name {string}, Employee ID {string}")
    public void user_adds_an_employee_with_first_name_middle_name_last_name_employee_id(String fn, String mn, String ln, String id) throws InterruptedException {
        addEmployeePage.employeeIDLocator.clear();
        sendText(fn,addEmployeePage.firstnameLocator);
        sendText(mn,addEmployeePage.middlenameLocator);
        sendText(ln,addEmployeePage.lastnameLocator);
        sendText(String.valueOf(RandomIDGenerator.generateRandomID(1_000_000)),addEmployeePage.employeeIDLocator);


    }*/

    @When("user adds an employee with First Name {string}, Middle Name {string}, Last Name {string}, Employee ID")
    public void user_adds_an_employee_with_first_name_middle_name_last_name_employee_id(String fn, String mn, String ln) {
        addEmployeePage.employeeIDLocator.clear();
        sendText(fn,addEmployeePage.firstnameLocator);
        sendText(mn,addEmployeePage.middlenameLocator);
        sendText(ln,addEmployeePage.lastnameLocator);
        sendText(String.valueOf(RandomIDGenerator.generateRandomID(1_000_000)),addEmployeePage.employeeIDLocator);

    }
    //*********************************************************************************************************************
    @When("doesn't enter {string} or {string} fields")
    public void doesn_t_enter_or_fields(String fn, String ln) {
        sendText(fn,addEmployeePage.firstnameLocator);
        sendText(ln,addEmployeePage.lastnameLocator);

    }
    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        String addEmployeeMsg = addEmployeePage.addEmployeeError.getText();
        Assert.assertEquals("Required", addEmployeeMsg);

    }




}
