package Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class CaptureScreenShot extends LoginTest{
    @Test(enabled = false)
    public void FullPageScreenShot() throws IOException {
        //Day 31|00:43:00
        driver.get("https://www.toolsqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    //Capture full page screen shot
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trgt=new File("C:\\Users\\artdsktp44user\\IdeaProjects\\OrangeHRM\\screenshots\\FullPage.png");
        FileUtils.copyFile(src,trgt);
        driver.close();
    }
    @Test(enabled = false)
    public void screenShotSpecificArea() throws IOException {
        //Day 31|00:43:00
        driver.get("https://www.toolsqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement specificArea=driver.findElement(By.xpath("//div[@class='col-12 categories']"));
        File src=specificArea.getScreenshotAs(OutputType.FILE);
        File trgt=new File("C:\\Users\\artdsktp44user\\IdeaProjects\\OrangeHRM\\screenshots\\SpecificArea.png");
        FileUtils.copyFile(src,trgt);

    }

}
