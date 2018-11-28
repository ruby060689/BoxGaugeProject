package com.box.steps;

import com.box.driver.DriverClass;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BoxLoginSteps {
    DriverClass driverObj = DriverClass.getInstance();

    WebDriver driver = driverObj.driver;
    WebDriverWait wait = driverObj.wait;

    @Step("I navigate to box app")
    public void navigate() {
        String appUrl = "https://app.box.com";
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Step("Then box <pageName> page should display")
    public void verifyPage(String pageName) {
        System.out.println("\n" + pageName);
        boolean titleFlag = false;
        if (pageName.equals("Login"))
            titleFlag = wait.until(ExpectedConditions.titleIs("Box | Login"));
        if (pageName.equals("Home"))
            titleFlag = wait.until(ExpectedConditions.titleIs("All Files | Powered By Box"));
        if (titleFlag) {
            System.out.println("Success Correct page displayed\n");
        } else {
            System.out.println("Fail:-Title doesnt match with expectation");

        }
    }

    @Step("I login with following credentials <table>")
    public void login(Table table) {
        for (TableRow row : table.getTableRows()) {
            System.out.println(row.getCell("username") + "      " + row.getCell("password"));
            WebElement userName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=\"login\"]")));
            userName.clear();
            userName.sendKeys(row.getCell("username"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Next')]"))).click();
            WebElement passWord = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=\"password\"]")));
            passWord.clear();
            passWord.sendKeys(row.getCell("password"));
            WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class=\"btn btn-primary btn-full-width\"]")));
            signIn.click();
        }
    }

    @Step("When I click on logout")
    public void logout() {
        WebElement optionsDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"menu-wrapper main-header-profile\"]")));
        optionsDropdown.click();

        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-resin-target=\"logout\"]")));
        logoutLink.click();
    }

    @Step("Then create new Folder")
    public void create_new_folder() throws InterruptedException {

        // CreateNewFolder.newfolder();
        WebElement dropdown_new = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='text'])[2]")));
        dropdown_new.click();
        //Thread.sleep(2000);

// click on Folder
        WebElement folder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'menu-newdropdown\']/li[1]/button")));
        folder.click();

        WebElement folderName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\'folderName\']")));
        folderName.sendKeys("Ruby");

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


    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
            //driver = null;
        }
    }}

