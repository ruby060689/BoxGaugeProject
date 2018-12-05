package com.box.steps;


import com.box.driver.DriverClass;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class CreateNewFolder{

    @FindBy(xpath = CreateNewFolder.dropdown_New)
    public WebElement dropdown_new;

    DriverClass driverObj = DriverClass.getInstance();
    WebDriver driver = driverObj.driver;
    WebDriverWait wait = driverObj.wait;

    String folderName = "NewFolder"+Math.random();

    @Step("Then create new Folder")
    public void create_new_folder() throws InterruptedException {

        // CreateNewFolder.newfolder();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("div[class=\"action-bar-create-buttons\"]"), "data-resin-feature", "createbuttons"));
        WebElement newoption= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-owns=\"menu-newdropdown\"]")));
        newoption.click();
        //Thread.sleep(2000);

        // click on Folder
        WebElement folder= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-resin-target=\"newfolder\"]")));
        folder.click();

        WebElement folderNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\'folderName\']")));
        folderNameField.sendKeys(folderName);

        WebElement btn_create = driver.findElement(By.xpath("//span[contains(text(),'Create')]"));
        btn_create.click();


        Thread.sleep(2000);
    }

    @Step("Then delete the new Folder")
    public void delete_folder() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='file-list-item-wrapper' and @role='row' and .//a[contains(text(),'"+folderName+"')]]/span[contains(text(),'Files')]")));
        WebElement selectElement = new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='file-list-item-wrapper' and @role='row' and .//a[contains(text(),'"+folderName+"')]]")));
        selectElement.click();
        WebElement trashBtn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class=\"btn delete-btn delete-svg\"]")));
        trashBtn.click();
        WebElement okay= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class=\"btn btn-primary popup-confirm-btn\"]")));
        okay.click();
        System.out.println("Folder Deleted Successfully");
    }

    public final static String dropdown_New = "//*[@id=\'mod-action-bar-1\']";

}
