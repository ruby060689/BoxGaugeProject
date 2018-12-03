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
        WebElement dropdown_new = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='text'])[2]")));
        dropdown_new.click();
        //Thread.sleep(2000);

        // click on Folder
        WebElement folder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'menu-newdropdown\']/li[1]/button")));
        folder.click();

        WebElement folderNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\'folderName\']")));
        folderNameField.sendKeys(folderName);

        WebElement btn_create = driver.findElement(By.xpath("//span[contains(text(),'Create')]"));
        btn_create.click();


        Thread.sleep(2000);
    }

    @Step("Then delete the new Folder")
    public void delete_folder() throws InterruptedException {

        //WebElement folderlocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Ruby')]")));

        WebElement folderlocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'mod-file-list-minimal-1\']/div[1]/ol/li[2]")));


        folderlocation.click();

        // WebElement clickForMoreOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), '...')]")));
        WebElement clickForMoreOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@tabindex ='0'])[2]")));

        clickForMoreOptions.click();

        Actions action = new Actions(driver);
        action.contextClick(folderlocation);
        WebElement moreOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'More Actions')]")));
        moreOptions.click();

        WebElement trash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Trash')]")));
        trash.click();
        action.build().perform();

        Thread.sleep(2000);
    }

    public final static String dropdown_New = "//*[@id=\'mod-action-bar-1\']";

}
