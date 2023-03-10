package ExtentReportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestClass extends BaseClass {

        @Test
        public void invalid_login() throws InterruptedException {
            logger = extent.createTest("To verify login with invalid data");
            WebElement userName = driver.findElement(By.xpath("//*[@name='username']"));
            userName.sendKeys("dsaf");
            WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
            password.sendKeys("deafdsmo");
            WebElement loginBtn = driver.findElement(By.xpath("//*[@type='submit']"));
            loginBtn.click();
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement prsnt=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='btn-close']"))));
            // Thread.sleep(3000);
            Assert.assertTrue(prsnt.isDisplayed());
            Assert.assertEquals(driver.getTitle(),"Administration");
        }
        @Test
        public void valid_login() throws InterruptedException {
            logger = extent.createTest("To verify login with valid data");
            WebElement userName = driver.findElement(By.xpath("//*[@name='username']"));
            userName.sendKeys("dsaf");
            WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
            password.sendKeys("demo");
            WebElement loginBtn = driver.findElement(By.xpath("//*[@type='submit']"));
            loginBtn.click();
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement prsnt=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='btn-close']"))));
           // Thread.sleep(3000);
            Assert.assertTrue(prsnt.isDisplayed());
            Assert.assertEquals(driver.getTitle(),"Administration");
        }
        @Test
    public void validateAlert() throws InterruptedException {
            logger = extent.createTest("To verify the alert");
            WebElement userName = driver.findElement(By.xpath("//*[@name='username']"));
            userName.sendKeys("demo");
            WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
            password.sendKeys("demo");
            WebElement loginBtn = driver.findElement(By.xpath("//*[@type='submit']"));
            loginBtn.click();
            Thread.sleep(3000);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='btn-close']")).isDisplayed());
        }
        @Test
        public void verifyInvalid_PageNo() throws InterruptedException {
            logger = extent.createTest("To verify with invalid page numebr");
            WebElement userName = driver.findElement(By.xpath("//*[@name='username']"));
            userName.sendKeys("demo");
            WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
            password.sendKeys("demo");
            WebElement loginBtn = driver.findElement(By.xpath("//*[@type='submit']"));
            loginBtn.click();
            if (driver.findElement(By.xpath("//*[@class='btn-close']")).isDisplayed()) {
                driver.findElement(By.xpath("//*[@class='btn-close']")).click();
            }
            driver.findElement(By.id("menu-customer")).click();
            driver.findElement(By.xpath("//*[@id=\"collapse-5\"]/li[1]/a")).click();
            //Get the page number text
            String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
            //Split the page number text to total number of pages only
            int totalPageNo = Integer.parseInt((text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1)));
            System.out.println("Total page number is: " + totalPageNo);
            Thread.sleep(2000);
            Assert.assertEquals(totalPageNo,"1010","Page no is not matching..");
        }
    @Test
    public void verify_valid_PageNo() throws InterruptedException {
        logger = extent.createTest("To verify with valid page numebr");
        WebElement userName = driver.findElement(By.xpath("//*[@name='username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("demo");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@type='submit']"));
        loginBtn.click();
        if (driver.findElement(By.xpath("//*[@class='btn-close']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@class='btn-close']")).click();
        }
        driver.findElement(By.id("menu-customer")).click();
        driver.findElement(By.xpath("//*[@id=\"collapse-5\"]/li[1]/a")).click();
        //Get the page number text
        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        //Split the page number text to total number of pages only
        int totalPageNo = Integer.parseInt((text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1)));
        System.out.println("Total page number is: " + totalPageNo);
        Assert.assertEquals(totalPageNo,1060,"Page no is not matching..");
        Thread.sleep(2000);

    }

        }

