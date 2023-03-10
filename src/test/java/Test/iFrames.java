package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class iFrames extends LoginTest{
    @Test(enabled = false)
    public void iFramesHandle() throws InterruptedException {
        //Day 26|00:00:00
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Thread.sleep(3000);
        System.out.println(driver.findElements(By.xpath("//iframe")).size());
        for(WebElement iframe:driver.findElements(By.xpath("//iframe"))){
            System.out.println(iframe.getAttribute("name"));
        }
        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.linkText("org.openqa.selenium.chrome")).click();
        Thread.sleep(3000);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("ChromeDriver")).click();
        driver.switchTo().parentFrame();
       driver.switchTo().frame("classFrame");
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[1]/h2")));
        System.out.println(element.getText());

    }
}
