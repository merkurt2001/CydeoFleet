package com.fleet.step_definitions;

import com.fleet.pages.DashboardPage;
import com.fleet.utilities.Driver;
import io.cucumber.java.en.When;

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

}
