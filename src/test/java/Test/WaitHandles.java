package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitHandles extends LoginTest {
    @Test(enabled = false)
    public void explicitWait() throws InterruptedException {
        //Day 23|00:00:00
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        WebElement disBtn=driver.findElement(By.id("disable"));
        WebElement btnEnableBtn=driver.findElement(By.id("enable-button"));
        if(disBtn.isEnabled()){
            System.out.println("Button is enabled");
        }
        else {
            System.out.println("Button is disabled");
        }
        btnEnableBtn.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(disBtn));
        if(disBtn.isEnabled()){
            System.out.println("Button is enabled");
        }
        else {
            System.out.println("Button is disabled");
        }
    }
    @Test(enabled = false)
    public void implicitWait() throws InterruptedException {
        //Day 23|00:00:00
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement disBtn=driver.findElement(By.id("hidden"));
        WebElement btnEnableBtn=driver.findElement(By.id("display-other-button"));
        if(disBtn.isDisplayed()){
            System.out.println("Button is showing");
        }
        else {
            System.out.println("Button is hidden");
        }
        btnEnableBtn.click();
        disBtn.click();
        if(disBtn.isEnabled()){
            System.out.println("Button is showing");
        }
        else {
            System.out.println("Button is hidden");
        }
    }




}
