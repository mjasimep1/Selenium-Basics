package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class samp extends LoginTest{
    @Test(enabled = false)
    public void dynam() throws InterruptedException {
        //Day 27|01:15:00
        driver.get("https://www.bing.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
        Thread.sleep(1000);
        List<WebElement> elements=driver.findElements(By.xpath("//ul[@class='sa_drw']//span"));
        for(WebElement element:elements){
            System.out.println(element.getText());
        }


    }
}
