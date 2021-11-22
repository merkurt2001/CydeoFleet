package com.fleet.step_definitions;

import com.fleet.pages.DashboardPage;
import com.fleet.pages.LoginPage;
import com.fleet.utilities.BrowserUtils;
import com.fleet.utilities.ConfigurationReader;
import com.fleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class LogoutStepDefs {

    DashboardPage dashboardPage = new DashboardPage();

    @When("the user clicks on logout link under username")
    public void the_user_clicks_on_logout_link_under_username() {
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.userName.click();
        dashboardPage.logOutLink.click();
    }

    @When("the user clicks step back button")
    public void the_user_clicks_step_back_button() {
        Driver.get().navigate().back();
    }



    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        new LoginPage().login(username, password);
        new DashboardPage().waitUntilLoaderScreenDisappear();


    }

    @And("the user closes the tab")
    public void theUserClosesTheTab() {
        ((JavascriptExecutor) Driver.get()).executeScript("window.open('about:blank','_blank');");
        new WebDriverWait(Driver.get(), 3).until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> tabs2 = new ArrayList<>(Driver.get().getWindowHandles());
        Driver.get().close();
        Driver.get().switchTo().window(tabs2.get(1));

        BrowserUtils.waitFor(2);

    }

    @Then("the user is again on the login page")
    public void theUserIsAgainOnTheLoginPage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }
    @And("the user should not login the page successfully")
    public void theUserShouldNotLoginThePageSuccessfully() {
        BrowserUtils.waitFor(2);
        System.out.println(Driver.get().getCurrentUrl());
        Assert.assertEquals("https://qa.translantik.com/user/login", Driver.get().getCurrentUrl());
    }

}

