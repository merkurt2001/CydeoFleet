package com.fleet.pages;

import com.fleet.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateCarPage extends BasePage {
    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarButton;

    @FindBy(xpath = "//td[@data-column-label=\"License Plate\"]")
    public WebElement row1;

    @FindBy(xpath = "//td[@data-column-label=\"Driver\"]")
    public WebElement row2;

    @FindBy(xpath = "//td[@data-column-label=\"Location\"]")
    public WebElement row3;

    @FindBy(xpath = "//td[@data-column-label=\"Chassis Number\"]")
    public WebElement row4;

    @FindBy(xpath = "//td[@data-column-label=\"Model Year\"]")
    public WebElement row5;

    @FindBy(xpath = "//td[@data-column-label=\"Last Odometer\"]")
    public WebElement row6;

    @FindBy(xpath = "//td[@data-column-label=\"Immatriculation Date\"]")
    public WebElement row7;

    @FindBy(xpath = "//td[@data-column-label=\"First Contract Date\"]")
    public WebElement row8;
    @FindBy(xpath = "//td[@data-column-label=\"Catalog Value (VAT Incl.)\"]")
    public WebElement row9;
    @FindBy(xpath = "//td[@data-column-label=\"Seats Number\"]")
    public WebElement row10;
    @FindBy(xpath = "//td[@data-column-label=\"Doors Number\"]")
    public WebElement row11;
    @FindBy(xpath = "//td[@data-column-label=\"Color\"]")
    public WebElement row12;
    @FindBy(xpath = "//td[@data-column-label=\"Transmission\"]")
    public WebElement row13;
    @FindBy(xpath = "//td[@data-column-label=\"Fuel Type\"]")
    public WebElement row14;
    @FindAll({
            @FindBy(xpath = "(//td[@data-column-label=\"CO2 Emissions\"])[1]"),
            @FindBy(xpath = "(//td[16])[1]"),
            @FindBy(xpath = "(//tbody/tr/td[16])[1]"),
            @FindBy(linkText = "22")
    })
    public WebElement row15;
    @FindBy(xpath = "//td[@data-column-label=\"Horsepower\"]")
    public WebElement row16;
    @FindBy(xpath = "//td[@data-column-label=\"Horsepower Taxation\"]")
    public WebElement row17;
    @FindBy(xpath = "//td[@data-column-label=\"Power (kW)\"]")
    public WebElement row18;

    @FindBy(css = "div[class='message-item message']")
    public WebElement savedTitleOnGeneralInformationPage;


    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[1]")
    public WebElement dropdownWebtableShowElement;

    @FindBy(xpath = "//input[@data-name='field__license-plate']")
    public WebElement licence_plate_inputbox;

    @FindBy(xpath = "//input[@data-name='field__driver']")
    public WebElement driver_inputbox;

    @FindBy(xpath = "//input[@data-name='field__location']")
    public WebElement location_inputbox;

    @FindBy(xpath = "//input[@data-name='field__chassis-number']")
    public WebElement chassis_inputbox;

    @FindBy(xpath = "//input[@data-name='field__model-year']")
    public WebElement modelYear_inputbox;

    @FindBy(xpath = "//input[@data-name='field__last-odometer']")
    public WebElement lastOdometer_inputbox;

    @FindBy(xpath = "//input[@data-name='field__catalog-value']")
    public WebElement catalogValue_inputbox;

    @FindBy(xpath = "//input[@data-name='field__seats-number']")
    public WebElement seatNumber_inputbox;

    @FindBy(xpath = "//input[@data-name='field__doors-number']")
    public WebElement doorsNumber_inputbox;

    @FindBy(xpath = "//input[@data-name='field__color']")
    public WebElement color_inputbox;

    @FindBy(xpath = "//input[@data-name='field__c-o2-emissions']")
    public WebElement emissions_inputbox;

    @FindBy(xpath = "//input[@data-name='field__horsepower']")
    public WebElement horsePower_inputbox;

    @FindBy(xpath = "//input[@data-name='field__horsepower-taxation']")
    public WebElement horsePowerTaxation_inputbox;

    @FindBy(xpath = "//input[@data-name='field__power']")
    public WebElement power_inputbox;

    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    public WebElement immatriculationDate_inputbox;

    @FindBy(className = "select2-chosen")
    public WebElement transmission;

    @FindBy(xpath = "(//*[@class='select2-chosen'])[2]")
    public WebElement fuelType;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[2]")
    public WebElement firstContractDate_inputbox;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement saveAndCloseButton;

    @FindAll(
            {@FindBy(css = "div.control-label"),
                    @FindBy(xpath = "//div[@class='control-group attribute-row']//div[@class='control-label']")})
    public List<WebElement> carGeneralInformationValues;


    @FindBy(css = ".icons-holder-text")
    public WebElement addEvent2;

    @FindBy(xpath = "(//tbody/tr[15]/td[4])[1]")
    public WebElement oneCarData;


//-Emine and Cansu---------------

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement gridSettingsButton;

    @FindBy(xpath = "//tbody//tr//td[@class='title-cell']")
    public List<WebElement> columnList;

    @FindBy(xpath = "//div//input[@placeholder='Quick Search']")
    public WebElement quickSearchInput;

    @FindBy(xpath = "//div[@class='table-wrapper']")
    public WebElement tableWrapper;

    @FindBy(xpath = "//div[@class='column-manager-no-columns']")
    public WebElement noColumnFoundMessage;

    @FindBy(css = "input[type='number']")
    public WebElement pageInputBox;

    @FindBy(xpath = "//div//a[@title='Refresh']")
    public WebElement refreshFilterButton;

    @FindBy(css = "div.oro-dropdown-toggle .fa-close")
    public WebElement resetButton;

    @FindBy(xpath = "//table//thead[@class='grid-header']/tr/th")
    public List<WebElement> tableColumnSize;

    @FindBy(xpath = "//a[@data-role='column-manager-select-all']")
    public WebElement selectAllButton;

    @FindBy(xpath = "//div//a[@title='Filters']")
    public WebElement filtersButton2;

    @FindAll({@FindBy(xpath = "//a[@title='Filters']"),
            @FindBy(xpath = "//a[contains(@class,'action btn')]")})
    public WebElement filtersButton;

    @FindBy(xpath = "//a[@class='add-filter-button']")
    public WebElement manageFilters;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement manageFilterSearchInput;

    @FindBy(xpath = "//ul[contains(@class, 'multiselect-checkboxes')]")
    public WebElement tableManageFilter;

    @FindBy(xpath = "(//ul[contains(@class, 'multiselect-checkboxes')])//li")
    public List<WebElement> listFilterOptions;

    @FindBy(xpath = "//div[contains(@class, 'btn filter-criteria-selector')]")
    public WebElement filterSelectorBox;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[1]")
    public WebElement containsDefault;

    @FindBy(xpath = "//a[@class='dropdown-item choice-value']")
    public List<WebElement> containsDropdownMenu;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement filterSelectorSearchInput;

    @FindBy(xpath = "//button[@class='btn btn-primary filter-update']")
    public WebElement updateButton;

    @FindBy(xpath = "(//table/tbody)/tr/td[5]")
    public List<WebElement> locationColumn;

    @FindBy(xpath = "(//table/tbody)/tr/td[4]")
    public List<WebElement> locationColumnDriver;

    //JS
    @FindBy(xpath = "(//div[@class='control-label'])[14]")
    public WebElement transmissionOutput;

    @FindBy(xpath = "(//div[@class='control-label'])[15]")
    public WebElement fuelTypeOutput;

    @FindBy(css = "div>a[title='Edit Car']")
    public WebElement editCar;

    @FindBy(xpath = "(//div[@class='control-label'])[2]")
    public WebElement tagsOutput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/form/div[2]/div[2]/div/div[1]/div[2]/div/fieldset/div/div[2]/div[2]/div/div/label")
    public List<WebElement> myTags;

//JS---------------------------

    //ME---------------------------
    @FindBy(xpath = "//tbody/tr[td='12,345']")
    public WebElement car1;

    @FindBy(xpath = "Florida")
    public WebElement car4;

    @FindBy(xpath = "//table//tr[3]")
    public WebElement car3;

    @FindBy(xpath = "//table//tr[2]")
    public WebElement car2;

    @FindBy(xpath = "//a[.='Activity']")
    public WebElement activity;

    @FindBy(css = "div.oro-dropdown-toggle")
    public WebElement dateRange;

    @FindBy(xpath = "//i[@class='date']")
    public WebElement dataRangeAttribute;

    @FindBy(css = "div.filter-start-date [placeholder='Choose a date']")
    public WebElement chooseDateStart;

    @FindBy(css = "div.filter-end-date [placeholder='Choose a date']")
    public WebElement chooseDateEnd;

    @FindBy(xpath = "//input[@value]")
    public List<WebElement> activityDropDown;

    @FindBy(css = "div.items > div:nth-of-type(1) .accordion-heading")
    public WebElement activityInside;

    @FindBy(xpath = "//i[@class='fa-refresh hide-text']")
    public WebElement refresh;

    @FindBy(css = "a[data-action-name='goto_next']")
    public WebElement olderButton;


    @FindBy(css = "a[data-action-name='goto_previous']")
    public WebElement newerButton;

    @FindBy(xpath = "//a[.='Close']")
    public WebElement closeButton;

    //-------------------ME


    @FindBy(xpath = "(//div[@class='container-fluid']//a)[1]")
    public WebElement generalTab;


//--Emine and Cansu----------------------

    public void clickColumn(String columnName) {

        String xpath = "(//tbody//tr)[normalize-space()='" + columnName + "']";
        Driver.get().findElement(By.xpath(xpath)).click();

    }

    public void selectManageFilterOptions(String filterOptions) {

        String xpath = "//label[@title='" + filterOptions + "']//input";
        Driver.get().findElement(By.xpath(xpath)).click();

    }

    public void manageSelectedFilter(String filterName) {

        String xpath = "//div[@class='filter-item oro-drop']";

        Driver.get().findElement(By.xpath(xpath)).click();
    }
//--------------------------

    /*-Emine*/
    @FindBy(xpath = "(//a[@href='#'])[23]")
    public WebElement forwardButton;

    @FindBy(xpath = "(//a[@href='#'])[22]")
    public WebElement backButton;

//    @FindBy (xpath = "//button[@class='btn dropdown-toggle ']")
//    public WebElement perPageButton2;

    @FindAll({@FindBy(xpath = "//button[@data-toggle='dropdown']"),
            @FindBy(css = "div.page-size .caret")})
    public WebElement perPageButton;

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr")
    public List<WebElement> tableRowSize;


    @FindAll({@FindBy(xpath = "(//a[@data-toggle='dropdown'])[4]"),
            @FindBy(xpath = "//a[contains(.,'Export Grid')]")})
    public WebElement exportGridButton;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement successMessage;


    public void selectPerPageItem(String item) {
        String xpath = "//ul//a[@class='dropdown-item'][normalize-space()='" + item + "']";
        Driver.get().findElement(By.xpath(xpath)).click();
    }

    public void selectFormat(String formatType) {
        String xpath = "//a[@title='" + formatType + "']";
        Driver.get().findElement(By.xpath(xpath)).click();
    }
    /*Emine-*/

    // -------------//
    //Cansu
    @FindBy(xpath = "//button[@class='sidebar__add-widget']")
    public WebElement plusSign;

    @FindBy(xpath = "(//h3)[2]")
    public WebElement recentEmailTitle;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement keywordInputBox;

    @FindBy(xpath = "(//td/a)[2]")
    public WebElement addBtnForRecent;

    @FindBy(xpath = "(//a[@class='btn widget-picker-add-btn btn-primary'])[2]")
    public WebElement addBtnForStickyNotes;

    @FindBy(xpath = "(//a[@class=\"btn widget-picker-add-btn btn-primary\"])[3]")
    public WebElement addBtnForTaskList;

    @FindBy(xpath = "//span[@class='added']")
    public WebElement addedSign;

    @FindBy(xpath = "(//a[@class='btn cancel'])[2]")
    public WebElement closeBtn;

    @FindBy(css = "a.close ")
    public WebElement closeGridSetBtn;

    @FindBy(xpath = "(//i[@title='Recent emails'])[1]")
    public WebElement recentEmailWidget;

    @FindBy(css = "div.sidebar-widget__icon")
    public WebElement stickNotesWidget;

    @FindBy(css = "div.sidebar-widget__icon")
    public WebElement taskListWidget;

    @FindBy(xpath = "//i[@class='fa-thumb-tack hide-text']")
    public WebElement pinBtn;

    @FindBy(xpath = "(//a[@title='Car - Entities - System - Car - Entities - System'])[1]")
    public WebElement pinnedPage;

    @FindBy(xpath = "//div//a[contains(text(), 'Learn how to use this space')]")
    public WebElement warningText;

    @FindBy(xpath = "//i[@class='fa-star hide-text']")
    public WebElement favoriteSignBtn;

    @FindBy(css = "i.fa-bars")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//a[@href='#favorite-content']")
    public WebElement Favorites;

    @FindBy(xpath = "//button[@class='close']/following-sibling::a[1]")
    public WebElement favoritePages;

    @FindBy(css = "button.close")
    public WebElement closeBTN;

    // @FindBy (xpath = "//div[@class='dot-menu-empty-message']")
    // public WebElement noItemsMessage;

    /*-EC */
    @FindBy(xpath = "//span[@class='close']")
    public WebElement closeGridSetting;

    @FindBy(xpath = "//div//a[@title='Reset']")
    public WebElement resetButton2;

    @FindBy(xpath = "//div[@class='column-manager-title']")
    public WebElement gridSettingsButtonTitle;
    /* EC-*/

    /* AZ-*/

    @FindBy(css = ".fa-chevron-right")
    public WebElement pageForwardButton;

    @FindBy(css = ".input-widget")
    public WebElement inputBox;

    @FindBy(css = "div.page-size .btn")
    public WebElement viewPerPageBox;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement viewPerPageBox1;

    @FindBy(css = "a[data-size='50']")
    public WebElement viewPerPageBox50;

    @FindBy(xpath = "//a[contains(.,'Export Grid')]")
    public WebElement exportGrid;

    @FindBy(xpath = "//a[contains(.,'CSV')]")
    public WebElement sendingEmail;

    @FindBy(xpath = "//div[@class='flash-messages-holder']")
    public WebElement greenBox;

    @FindBy(xpath = "//tr[25]//input[1]")
    public WebElement selectCheckBox;

    @FindBy(xpath = "//thead[@class='grid-header']//i[@class='fa-ellipsis-h']")
    public WebElement massActions;

    @FindBy(css = "ul.detach .fa-trash-o")
    public WebElement deleteButton;

    @FindBy(css = ".ok")
    public WebElement confirmationYesDelete;

    @FindBy(css = ".alert")
    public WebElement deleteGreen;
    /* AZ-*/


}
