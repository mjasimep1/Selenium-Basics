package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxes extends LoginTest{
    @Test(enabled = false)
    public void checkBox() throws InterruptedException {
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        Thread.sleep(3000);
       // JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> checkBoxesWeek=driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));
        //js.executeScript("arguments[0].scrollIntoView();", checkBoxesWeek);
        /*for(int i=0;i<checkBoxesWeek.size();i++){
            Thread.sleep(1000);
            checkBoxesWeek.get(i).click();
        }*/
    //Or
        for(WebElement chkBx:checkBoxesWeek){

                chkBx.click();
            System.out.println(chkBx.getAttribute("innerText"));
            Thread.sleep(1000);
        }
        for(WebElement chkBx:checkBoxesWeek){
            if(chkBx.isSelected()) {
                chkBx.click();
            }
            Thread.sleep(1000);
        }



    }
}
