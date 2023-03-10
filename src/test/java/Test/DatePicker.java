package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DatePicker extends LoginTest {
        @Test(enabled = false)
        public void datePicker() throws InterruptedException {
            //Day 28|00:15:00
            driver.get("https://jqueryui.com/datepicker/#default");
            driver.switchTo().frame(0);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='datepicker']")).click();
            String month="February";
            String year="2020";
            String day="22";
    //Month and year selection
            while(true){
                String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
                String yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
                if (mon.equals(month)&&yr.equals(year)){
                    break;
                }
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
                //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            }
    //Date selection
            for(WebElement date:driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"))){
                if(date.getText().equals(day)){
                    date.click();
                    break;
                }
                //System.out.println(date.getText());
            }

        }
}
