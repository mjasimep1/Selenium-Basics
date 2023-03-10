package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptExec extends LoginTest {
    @Test(enabled = false)
    public void javaScriptExecutor() throws InterruptedException {
        //Day 30|01:00:00
        driver.get("https://testautomationpractice.blogspot.com");
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        List<WebElement> frames=driver.findElements(By.xpath("//iframe"));
        for(WebElement frame:frames) {
            System.out.println(frame.getAttribute("id"));
        }
        driver.switchTo().frame("frame-one1434677811");
        //First name-send keys
        WebElement fName=driver.findElement(By.xpath("//*[@id='RESULT_TextField-1']"));
        js.executeScript("arguments[0].setAttribute('value','John');",fName);
        WebElement maleRadio= driver.findElement(By.id("RESULT_RadioButton-7_0"));
        js.executeScript("arguments[0].click();",maleRadio);
    }
}

