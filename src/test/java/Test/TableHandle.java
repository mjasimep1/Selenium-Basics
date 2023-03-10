package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableHandle extends LoginTest{
    @Test(enabled = false)
    public void HtmlTable() throws InterruptedException {
        //Day 27|00:00:00
        driver.get("https://testautomationpractice.blogspot.com/");
        Thread.sleep(2000);
    //Number of rows
        List<WebElement> rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        System.out.println("Total number of rows are: "+rows.size());
    //Number of columns
        List<WebElement> columns=driver.findElements(By.xpath("//table[@name='BookTable']//th"));
        System.out.println("Total number of rows are: "+columns.size());
    //Print all the values in the table
        for(int r=2;r<=rows.size();r++){
            for(int c=1;c<=columns.size();c++){
                WebElement data=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]"));
                System.out.println(data.getText());
            }
        }
    //Print book names whose author is amit
        System.out.println("--------------book names whose author is amit----------------");
        for(int r=2;r<=rows.size();r++){
                WebElement data=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]"));
                if(data.getText().contains("Amit")){
                    WebElement specificData=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]"));
                    System.out.println(specificData.getText());
                }
            }
    //Find sum of prices for all the books
        int i=0;
        for(int r=2;r<=rows.size();r++){
            WebElement data=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]"));
            i=i+ Integer.parseInt(data.getText());
            }
        System.out.println("Total price is: "+i);

        }
    }

