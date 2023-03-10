package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AlertHandle extends LoginTest {
    @Test(enabled = false)
    public void alert() throws InterruptedException {
        //Day 25|00:35:00
        driver.get("https://demoqa.com/alerts");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(1000);
        //driver.switchTo().alert().accept();
        //Wait for the alert and print the text in the alert
        Alert delayAlert=wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(delayAlert.getText());
        Thread.sleep(1000);
        delayAlert.accept();
        //-----------------------------------
        driver.findElement(By.id("confirmButton")).click();
        delayAlert=wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        delayAlert.accept();
        String alertTxt= driver.findElement(By.id("confirmResult")).getText();
        System.out.println("After accept the alert: "+alertTxt);
        Thread.sleep(1000);
        driver.findElement(By.id("confirmButton")).click();
        delayAlert=wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        delayAlert.dismiss();
        alertTxt= driver.findElement(By.id("confirmResult")).getText();
        System.out.println("After dismiss the alert: "+alertTxt);
        //-----------------------------------
        Thread.sleep(1000);
        driver.findElement(By.id("promtButton")).click();
        delayAlert=wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        String txtToAlert="Hello world";
        delayAlert.sendKeys(txtToAlert);
        Thread.sleep(2000);
        System.out.println("Text in the alert is: "+delayAlert.getText());
        delayAlert.accept();
        Thread.sleep(2000);
        //String enteredTxt=driver.findElement(By.xpath("//*[@id=\"promptResult\"]/text()[2]")).getText();
        String defaultTxt=driver.findElement(By.xpath("//*[@id=\"promptResult\"]")).getText();
        System.out.println(defaultTxt);
        if(defaultTxt.contains(txtToAlert)){
            System.out.println("Test is passed");
        }


    }
}
