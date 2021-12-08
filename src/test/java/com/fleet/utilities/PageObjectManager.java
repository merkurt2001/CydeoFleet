package com.fleet.utilities;

import com.fleet.pages.CreateCarPage;
import com.fleet.pages.DashboardPage;
import com.fleet.pages.LoginPage;
import com.fleet.pages.VehiclesPage;

public class PageObjectManager {

    private LoginPage loginPage;
    private CreateCarPage createCarPage;
    private DashboardPage dashboardPage;
    private VehiclesPage vehiclesPage;


    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
    }

    public CreateCarPage getCreateCarPage() {
        return (createCarPage == null) ? createCarPage = new CreateCarPage() : createCarPage;
    }

    public DashboardPage getDashboardPage() {
        return (dashboardPage == null) ? dashboardPage = new DashboardPage() : dashboardPage;
    }

    public VehiclesPage getVehiclesPage() {
       return (vehiclesPage == null) ? vehiclesPage = new VehiclesPage() : vehiclesPage;
    }


}
