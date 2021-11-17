package com.fleet.step_definitions;

import com.fleet.pages.CreateCarPage;
import com.fleet.pages.DashboardPage;
import com.fleet.utilities.BrowserUtils;
import com.fleet.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.Random;

public class CreateCarStepsDefs {

    CreateCarPage createCarPage = new CreateCarPage();


    @And("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String module) {
        new DashboardPage().navigateToModule(tab, module);
        BrowserUtils.waitFor(5);
    }

    @Then("the user clicks on Create Car button")
    public void theUserClicksOnCreateCarButton() {
        createCarPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.clickWithJS(createCarPage.createCarButton);
    }

    @And("the user enters new Car information")
    public void theUserEntersNewCarInformation() throws InterruptedException {
        Faker faker = new Faker();
        Random random = new Random();

        createCarPage.waitUntilLoaderScreenDisappear();

        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String date1 = month[random.nextInt(11) + 1] + " " + (random.nextInt(29) + 1) + ", " + (random.nextInt(40) + 1980);
        String date2 = month[random.nextInt(11) + 1] + " " + (random.nextInt(29) + 1) + ", " + (random.nextInt(40) + 1980);
        String licensePlate = faker.bothify("##????").toUpperCase();
        String driver = faker.name().fullName();
        String location = faker.address().city().toUpperCase();
        String chassisNumber = faker.bothify("######");
        int modelYear = random.nextInt(40) + 1980;
        int lastOdometer = random.nextInt(80 - 20) * 1000;
        int catalogValue = random.nextInt(80 - 5) * 1000;
        int seatsNumber = random.nextInt(4) + 3;
        int doorsNumber = random.nextInt(5) + 2;
        String color = StringUtils.capitalize(faker.color().name());
        double emissions = random.nextInt(9 - 1) * 0.1;
        int horsePower = random.nextInt(180) + 120;
        double horsePowerTaxation = random.nextInt(9 - 1) * 0.1;
        int power = random.nextInt(300 - 20);


        Driver.get().navigate().refresh();
        createCarPage.licence_plate_inputbox.sendKeys(licensePlate);
        createCarPage.myTags.get(random.nextInt(7)).click();
        createCarPage.driver_inputbox.sendKeys(driver);
        createCarPage.location_inputbox.sendKeys(location);
        createCarPage.chassis_inputbox.sendKeys(chassisNumber);
        createCarPage.modelYear_inputbox.sendKeys(modelYear + "");
        createCarPage.lastOdometer_inputbox.sendKeys(lastOdometer + "");
        BrowserUtils.scrollToElement(createCarPage.immatriculationDate_inputbox);
        createCarPage.immatriculationDate_inputbox.sendKeys(date1);
        createCarPage.immatriculationDate_inputbox.sendKeys(Keys.ESCAPE);
        createCarPage.firstContractDate_inputbox.sendKeys(date2);
        createCarPage.firstContractDate_inputbox.sendKeys(Keys.ESCAPE);
        createCarPage.catalogValue_inputbox.sendKeys(catalogValue + "");
        createCarPage.seatNumber_inputbox.sendKeys(seatsNumber + "");
        createCarPage.doorsNumber_inputbox.sendKeys(doorsNumber + "");
        createCarPage.color_inputbox.sendKeys(color);
        createCarPage.transmission.click();
        Driver.get().findElements(By.xpath("/html/body/div[8]/ul[2]/li")).get(random.nextInt(2)).click();
        Thread.sleep(1000);
        createCarPage.fuelType.click();
        Driver.get().findElements(By.xpath("/html/body/div[9]/ul[2]/li")).get(random.nextInt(4)).click();
        createCarPage.emissions_inputbox.sendKeys(emissions + "");
        createCarPage.horsePower_inputbox.sendKeys(horsePower + "");
        createCarPage.horsePowerTaxation_inputbox.sendKeys(horsePowerTaxation + "");
        createCarPage.power_inputbox.sendKeys(power + "");


    }

    @Then("the user clicks on save changes button")
    public void theUserClicksOnSaveChangesButton() {

        createCarPage.saveAndCloseButton.click();


    }
}
