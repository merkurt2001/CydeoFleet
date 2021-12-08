package com.fleet.step_definitions;

import com.fleet.pages.DashboardPage;
import com.fleet.pages.LoginPage;
import com.fleet.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginStepDefs {

    LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid credentials for each {string}")
    public void the_user_enters_valid_credentials_for_each(String userType) {
        UserUtils.UserGenerator(userType);
        loginPage= new PageObjectManager().getLoginPage();
        loginPage.userName.sendKeys(UserUtils.username);
        loginPage.password.sendKeys(UserUtils.password);

    }

    @When("the user clicks login button")
    public void the_user_clicks_login_button() {
        loginPage.submit.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the page subtitle is {string}")
    public void the_page_subtitle_is(String expectedSubtitle) {
        Assert.assertEquals(expectedSubtitle, new DashboardPage().pageSubTitle.getText());
    }

    @When("the user logs in using following credentials {string} and {string}")
    public void the_user_logs_in_using_following_credentials_and(String expectedUsername, String expectedPassword) {
        BrowserUtils.waitFor(3);
        loginPage= new PageObjectManager().getLoginPage();
        loginPage.login(expectedUsername, expectedPassword);
    }

    @Then("the following {string} should be displayed")
    public void the_following_should_be_displayed(String expectedMessage) {

        if (expectedMessage.equals("Invalid user name or password.")) {
            Assert.assertEquals(expectedMessage, loginPage.errorMessage.getText());
        } else if (expectedMessage.equals("Please fill out this field.")) {
            String actual1 = loginPage.userName.getAttribute("validationMessage");
            String actual2 = loginPage.password.getAttribute("validationMessage");


            if (loginPage.userName.getAttribute("value") == null && loginPage.password.getAttribute("value") == null) {
                Assert.assertEquals(expectedMessage, actual1);
            } else if (loginPage.password.getAttribute("value") == null) {
                Assert.assertEquals(expectedMessage, actual2);
            } else if (loginPage.userName.getAttribute("value") == null) {
                Assert.assertEquals(expectedMessage, actual1);
            }
        }
    }

    @When("the user clicks on Forgot your password link")
    public void the_user_clicks_on_Forgot_your_password_link() {
        loginPage.forgotPassword.click();
    }

    @Then("the user should land on {string} page")
    public void the_user_should_land_on_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @When("the user clicks Remember me on this computer checkbox")
    public void the_user_clicks_Remember_me_on_this_computer_checkbox() {
        BrowserUtils.clickWithJS(loginPage.rememberMe);
    }

    @Then("Remember me on this computer checkbox should be selected")
    public void remember_me_on_this_computer_checkbox_should_be_selected() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(loginPage.rememberMe.isSelected());
    }

    @Then("the user should see the password in bullet signs by default")
    public void the_user_should_see_the_password_in_bullet_signs_by_default() {
        Assert.assertEquals("password", loginPage.password.getAttribute("type"));
    }

    @When("the user clicks Enter button of keyboard")
    public void the_user_clicks_Enter_button_of_keyboard() {
        loginPage.submit.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(2);
    }


    @And("the user gets the current URL")
    public void theUserGetsTheCurrentURL() {
        BrowserUtils.waitFor(3);
        String currentUrl = Driver.get().getCurrentUrl();
        System.out.println(currentUrl);

    }
}
