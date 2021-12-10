package com.fleet.step_definitions;

import com.fleet.pages.CreateCarPage;
import com.fleet.pages.DashboardPage;
import com.fleet.utilities.BrowserUtils;
import com.fleet.utilities.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CreateCarStepsDefs {

    CreateCarPage createCarPage;
    DashboardPage dashboardPage;

    @And("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String module) {
        dashboardPage = new PageObjectManager().getDashboardPage();
        dashboardPage.navigateToModule(tab, module);
        BrowserUtils.waitFor(5);
    }

    @Then("the user clicks on Create Car button")
    public void theUserClicksOnCreateCarButton() {
        createCarPage = new PageObjectManager().getCreateCarPage();
        createCarPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.clickWithJS(createCarPage.createCarButton);
    }

    @And("the user enters new Car information")
    public void theUserEntersNewCarInformation() throws InterruptedException {
        createCarPage.newCarGenerator();

    }

    @Then("the user clicks on save changes button")
    public void theUserClicksOnSaveChangesButton() {
        Assert.assertTrue(false);
        createCarPage.saveAndCloseButton.click();


    }
}
