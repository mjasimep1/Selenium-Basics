package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PaginationTable extends LoginTest {
    @Test(enabled = false)
    public void dynamicTable() throws InterruptedException {
        //Day 27|01:15:00
        driver.get("https://demo.opencart.com/admin");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        //WebElement activePage=driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()=3]"));
        //activePage.click();
        /*for(int i=4;i<6;i++) {
            if (totalPageNo > 1) {
                System.out.println("if starts");
                driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+i+"]")).click();
                Thread.sleep(1000);
            }
        }

*/
        /*String custName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tr[4]//td[2]")).getText();
        System.out.println(custName);*/
        for (int i = 1; i <= 2  ; i++) {
            if(totalPageNo>1) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")));    //for

                js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()=" + i + "]")));
                //loader_wait(5);      //wait
                Thread.sleep(2000);
            }
            int noOfRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tr")).size();
            for(int r=1;r<noOfRows;r++){

                String custName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
                String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
                String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
                System.out.println((10*(i-1))+(r)+"\t"+custName+"\t"+email+"\t"+status);
                //System.out.println(email);
            }
        }
    }

}
