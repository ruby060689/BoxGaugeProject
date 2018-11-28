package com.box.steps;


import com.box.driver.DriverClass;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class CreateNewFolder extends BoxLoginSteps{

    @FindBy(xpath = CreateNewFolder.dropdown_New)
    public WebElement dropdown_new;

   // @Step("When I click on logout")
   // public void logout() {
   //     WebElement optionsDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"menu-wrapper main-header-profile\"]")));
    //     optionsDropdown.click();
    //
    //      WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-resin-target=\"logout\"]")));
    //  logoutLink.click();
    // }


    public void newfolder() {

        dropdown_new.click();




    }

    public final static String dropdown_New = "//*[@id=\'mod-action-bar-1\']";

}
