package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDownWithHiddenOptions extends LoginTest {
    @Test(enabled = false)
    public void dropDown() throws InterruptedException {
        //Day 28|01:00:00
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //Thread.sleep(1000);
        WebElement userName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
       // WebElement userName=driver.findElement(By.name("username"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement submitBtn=driver.findElement(By.xpath("//button[@type='submit']"));
        userName.sendKeys("admin");
        password.sendKeys("admin123");
        Thread.sleep(1000);
        submitBtn.click();
       // WebElement sidePIMBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")));
        WebElement sidePIMBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("PIM")));
        sidePIMBtn.click();
    //Click the drop down icon
        WebElement jobTitleDropDownBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]//div[2]/i")));
        jobTitleDropDownBtn.click();
        Thread.sleep(2000);
        List<WebElement> jobTitles=driver.findElements(By.xpath("//div[@role='listbox']//div"));
        System.out.println(jobTitles.size());
        for(WebElement jobTitle:jobTitles){
           if(jobTitle.getText().contains("Success")){
               jobTitle.click();
               break;
           }
        }
        //driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")).click();
    }
}
