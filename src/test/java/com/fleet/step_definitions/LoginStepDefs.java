package com.fleet.step_definitions;

import com.fleet.pages.DashboardPage;
import com.fleet.pages.LoginPage;
import com.fleet.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

public class LoginStepDefs {

    LoginPage loginPage = new PageObjectManager().getLoginPage();
    DashboardPage dashboardPage = new PageObjectManager().getDashboardPage();
    String currentUrl;


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid credentials for each {string}")
    public void the_user_enters_valid_credentials_for_each(String userType) {
        UserUtils.UserGenerator(userType);
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
        BrowserUtils.waitFor(2);
        Assert.assertEquals(expectedSubtitle, dashboardPage.pageSubTitle.getText());
    }

    @When("the user logs in using following credentials {string} and {string}")
    public void the_user_logs_in_using_following_credentials_and(String expectedUsername, String expectedPassword) {
        BrowserUtils.waitFor(3);
        loginPage.login(expectedUsername, expectedPassword);
    }

    @Then("the following {string} should be displayed")
    public void the_following_should_be_displayed(String expectedMessage) {

        if (expectedMessage.equals("Invalid user name or password.")) {
            Assert.assertEquals(expectedMessage, loginPage.errorMessage.getText());
        } else if (expectedMessage.equals("Please fill out this field.")) {
            String actual1 = loginPage.userName.getAttribute("validationMessage");
            String actual2 = loginPage.password.getAttribute("validationMessage");
            System.out.println("actual2 = " + actual2);

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
        BrowserUtils.waitFor(2);
        loginPage.forgotPassword.click();
    }

    @Then("the user should land on {string} page")
    public void the_user_should_land_on_page(String expectedTitle) {
        System.out.println(Driver.get().getTitle());
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
        currentUrl = Driver.get().getCurrentUrl();
        System.out.println(currentUrl);

    }

    //not related to the feature
    @Given("the user enter valid credentials through command prompt")
    public void the_user_enter_valid_credentials_through_command_prompt() {
        loginPage.login();
//        mvn verify -Dcucumber.options="--tags @command" -Dusername=salesmanager101 -Dpassword=UserUser123
//        if the user do not assign the username and password via command line it gets from confg.reader

    }

    @Given("the user should see the background color of {string} button as {string}")
    public void the_user_should_see_the_background_color_of_button_as(String LoginBtn, String colorCode) {
        BrowserUtils.waitFor(2);
        String cssValue = loginPage.submit.getCssValue("background-color");
        System.out.println(cssValue);

        String asHex = Color.fromString(cssValue).asHex();
        System.out.println(asHex);
        Assert.assertEquals(colorCode, asHex);

    }

    @Given("the user enters valid credentials to {string} input box")
    public void the_user_enters_valid_credentials_to_input_box(String userName) {
        loginPage.userName.sendKeys(userName);
    }


    @Given("the user enters valid credentials to password input box")
    public void the_user_enters_valid_credentials_to_password_input_box() {
        loginPage.password.sendKeys("UserUser123");
    }


    @Given("the password is not visible in the Page Source")
    public void the_password_is_not_visible_in_the_Page_Source() {
        String pageSource = Driver.get().getPageSource();
        Assert.assertFalse(pageSource.contains("UserUser123"));
    }


    @Given("the system should not allow user to copy password")
    public void the_system_should_not_allow_user_to_copy_password() throws IOException, UnsupportedFlavorException {
        BrowserUtils.waitFor(3);
        loginPage.password.sendKeys(Keys.chord(Keys.CONTROL, "A"));
        loginPage.password.sendKeys(Keys.chord(Keys.CONTROL, "C"));
        String localClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        Assert.assertNotEquals("UserUser123", localClipboardData);
        System.out.println(localClipboardData);

//        loginPage.password.click();
//        loginPage.password.sendKeys(Keys.CONTROL, "a");
//        loginPage.password.sendKeys(Keys.CONTROL, "c");
//        loginPage.userName.clear();
//        loginPage.userName.click();
//        loginPage.userName.sendKeys(Keys.CONTROL, "v");
//        String passwordAttribute = loginPage.password.getAttribute("value");
//        String userNameAttribute = loginPage.userName.getAttribute("value");
//        System.out.println(userNameAttribute);
//        System.out.println(passwordAttribute);
//        Assert.assertNotEquals(userNameAttribute, passwordAttribute);

    }

    @Given("Username and password input boxes have proper placeholders")
    public void username_and_password_input_boxes_have_proper_placeholders() {
        String userNameAttribute = loginPage.userName.getAttribute("placeholder");
        String passwordAttribute = loginPage.password.getAttribute("placeholder");

        Assert.assertEquals(userNameAttribute, "Username or Email");
        Assert.assertEquals(passwordAttribute, "Password");


    }

    @Then("the user should see following modules")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
        //get the list of webelement and convert them to list of string and assert
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
    }

    @Given("Page element  {string}  {string}  {string}  {string} is as expected")
    public void page_element_is_as_expected(String expectedBreadCrumb, String expectedHeading, String expectedURL, String expectedTitle) {
        String actualBreadCrumb = new DashboardPage().breadCrumb.getText();
        Assert.assertEquals(expectedBreadCrumb, actualBreadCrumb);
        Assert.assertEquals(Driver.get().getCurrentUrl(), expectedURL);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
        Assert.assertEquals(expectedHeading, new DashboardPage().pageSubTitle.getText());

    }

    @Given("the user log out and paste the current URL")
    public void the_user_log_out_and_paste_the_current_URL() {

        dashboardPage.waitUntilLoaderScreenDisappear();
//        dashboardPage.userName.click();
//        dashboardPage.logOutLink.click();
        Driver.closeDriver();
//        BrowserUtils.waitFor(2);
//        Driver.get().navigate().to(currentUrl);

    }

    @Given("User should not inside the main page")
    public void user_should_not_inside_the_main_page() {
        Driver.get().get(currentUrl);
//        String lastCurrentUrl = Driver.get().getCurrentUrl();
//        Assert.assertNotEquals(lastCurrentUrl, currentUrl);
    }

    @Given("the user hits keyboard {string}")
    public void the_user_hits_keyboard(String keyboardButton) {
        WebElement currentElement = Driver.get().switchTo().activeElement();
        switch (keyboardButton) {
            case "ENTER":
                currentElement.sendKeys(Keys.ENTER);
                break;
            case "TAB":
                currentElement.sendKeys(Keys.TAB);
        }
    }

    @Given("the cursor should be in password input box")
    public void the_cursor_should_be_in_password_input_box() {
//        with JS methods
//        String str ="return document.querySelector(\"#prependedInput2\")";
//        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
//        WebElement passwordInputBox = (WebElement) js.executeScript(str);
//        Assert.assertEquals(passwordInputBox, loginPage.password);
//        System.out.println("passwordInputBox = " + passwordInputBox);
//        System.out.println(loginPage.password);

        Assert.assertEquals(loginPage.password, Driver.get().switchTo().activeElement());

    }

}
