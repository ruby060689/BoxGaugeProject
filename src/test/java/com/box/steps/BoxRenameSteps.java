package com.box.steps;

import com.box.driver.DriverClass;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoxRenameSteps {

    DriverClass driverObj = DriverClass.getInstance();
    WebDriver driver = driverObj.driver;
    WebDriverWait wait = driverObj.wait;
    String folderName;


    @Step("When user rename the folder from <oldName> to <newName>")
    public void renameFolder(String oldName, String newName) {
        folderName = oldName;
        WebElement moreActionsElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='row']//a[contains(text(),'"+folderName+"')]")));

        Actions action =new Actions(driver);
        action.moveToElement(moreActionsElement).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-type=\"rename-btn\"]"))).click();
        WebElement renameTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[title*=\"alphanumeric characters\"]")));
        renameTextField.sendKeys(newName);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-event-type=\"ok\"]"))).click();
    }

    @Step("Then folder should be renamed to <newName>")
    public void verifyRename(String newName) throws InterruptedException {
        Thread.sleep(4000);
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role=\"alertdialog\"]")));
        System.out.println(alertMessage.getText());
        System.out.println(newName+ "  asasas");
        boolean equality = alertMessage.getText().contains("The folder has been renamed to");
        Assert.assertTrue("Folder  not renamed",equality);
        Thread.sleep(3000);

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class=\"notifications-wrapper\"] div[role=\"alertdialog\"]")));
        System.out.println(newName+ "  tttttt");
    }
}
