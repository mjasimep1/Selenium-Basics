package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Dropdowns extends LoginTest{
    @Test(enabled = false)
    public void dropDownWithSelectTag() throws InterruptedException {
        //Day 24
        driver.get("https://www.opencart.com/index.php?route=account/register");
        Thread.sleep(3000);
        WebElement drpDwn=driver.findElement(By.name("country_id"));
        Select s=new Select(drpDwn);
        s.selectByIndex(15);
        List<WebElement> elementsDropDown=s.getOptions();
        System.out.println(elementsDropDown.size());
    }
    @Test(enabled = false)
    public void dropDownWithoutSelectTag() throws InterruptedException {
        //Day 24|1:35:00
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
        List<WebElement> options=driver.findElements(By.xpath(" //ul[contains(@class,'multiselect')]//label"));
        System.out.println(options.size());
        for(WebElement element:options){
            String item=element.getText();
            Thread.sleep(1000);
            if(item.equals("Java")||item.equals("Python")){
                element.click();
            }
        }
    }
    @Test(enabled = false)
    public void dropDownAutoSuggest() throws InterruptedException {
        //Day 25|00:07:00
        driver.get("https://www.google.co.in/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("selenium");
        Thread.sleep(1000);
        List<WebElement> suggestions=driver.findElements(By.xpath("//div[@class='OBMEnb']/ul//span"));
        for (WebElement suggestion:suggestions){
            String result=suggestion.getText();
            System.out.println(result);
            if(result.contains("java")){
                suggestion.click();
            }
        }
    }
}
