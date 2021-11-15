package com.fleet.step_definitions;

import com.fleet.pages.DashboardPage;
import com.fleet.pages.LoginPage;
import com.fleet.utilities.BrowserUtils;
import com.fleet.utilities.ConfigurationReader;
import com.fleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid credentials for each {string}")
    public void the_user_enters_valid_credentials_for_each(String userType) {

        switch (userType){
            case "driver":

                loginPage.userName.sendKeys(ConfigurationReader.get("driver_username"));
                String actual1 = loginPage.userName.getAttribute("validationMessage");
                System.out.println(actual1);
                JavascriptExecutor js = (JavascriptExecutor) Driver.get();
                Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", loginPage.userName);
                System.out.println(isValidInput);
                String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", loginPage.userName);
                System.out.println(validationMessage);
                loginPage.password.sendKeys(ConfigurationReader.get("driver_password"));
                break;
            case "store manager":
                loginPage.userName.sendKeys(ConfigurationReader.get("store_manager_username"));
                loginPage.password.sendKeys(ConfigurationReader.get("store_manager_password"));
                break;
            case "sales manager":
                loginPage.userName.sendKeys(ConfigurationReader.get("sales_manager_username"));
                loginPage.password.sendKeys(ConfigurationReader.get("sales_manager_password"));
                break;
            default:
                System.out.println("INVALID user type");
                break;
        }

    }

    @When("the user clicks login button")
    public void the_user_clicks_login_button() {
        loginPage.submit.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the page subtitle is {string}")
    public void the_page_subtitle_is(String expectedSubtitle) {
        Assert.assertEquals(expectedSubtitle, dashboardPage.pageSubTitle.getText());
    }

    @When("the user logs in using following credentials {string} and {string}")
    public void the_user_logs_in_using_following_credentials_and(String expectedUsername, String expectedPassword) {
        loginPage.login(expectedUsername, expectedPassword);
    }

    @Then("the following {string} should be displayed")
    public void the_following_should_be_displayed(String expectedMessage) {

//        String errorMessage="";
//        try {
//            errorMessage = loginPage.errorMessage.getText();
//            System.out.println("errorMessage = " + errorMessage);
//            if (errorMessage.isEmpty()){
//                if (loginPage.userName.getAttribute("value") == null){
//                    errorMessage=loginPage.userName.getAttribute("validationMessage");
//                    System.out.println("errorMessage = " + errorMessage);
//                } else if (loginPage.password.getAttribute("value") == null){
//                    errorMessage=loginPage.password.getAttribute("validationMessage");
//                    System.out.println("errorMessage = " + errorMessage);
//                }
//            }
//        }catch (Exception e){
//            System.out.println("In the catch line");
//        }
//        Assert.assertEquals(expectedMessage, errorMessage);


        if (expectedMessage.equals("Invalid user name or password.")){
            Assert.assertEquals(expectedMessage, loginPage.errorMessage.getText());
        }else if (expectedMessage.equals("Please fill out this field.")){
            String actual1 = loginPage.userName.getAttribute("validationMessage");
            String actual2 = loginPage.password.getAttribute("validationMessage");


            if (loginPage.userName.getAttribute("value") == null && loginPage.password.getAttribute("value") == null){
                Assert.assertEquals(expectedMessage, actual1);
            }else if (loginPage.password.getAttribute("value") == null){
                Assert.assertEquals(expectedMessage, actual2);
            }else if (loginPage.userName.getAttribute("value") == null){
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


}
