package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {
    @When("user enters {string} as username")
    public void user_enters_as_username(String userName) {
        sendText(userName,loginPage.usernameField);

    }
    @When("user enters {string} as password")
    public void user_enters_as_password(String Password) {
        sendText(Password,loginPage.passwordField);

    }
    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        click(loginPage.loginButton);
    }
    @Then("user should see the error message {string}")
    public void user_should_see_the_error_message(String error) {
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(error , actualMessage);
    }


}
