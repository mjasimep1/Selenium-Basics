package Test.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SampleBingSearch {
    public static void main(String[] arg) throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bing.com/?cc=in");

        Thread.sleep(3000);
        //To serach java
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("Java");
        //Thread.sleep(5000);
        //WebDriverWait(browser, 20).until(lambda browser: len(browser.find_elements_by_xpath("//img[@data-blabla]")) == int(myLength))
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        List<WebElement> counts=wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//ul[@class='sa_drw']//li"))));
        //To find count of search items
      // List<WebElement> counts = driver.findElements(By.xpath("//ul[@class='sa_drw']//li"));
        System.out.println("Total number :" + counts.size());

        //To capture all
        System.out.println("All options are:");
        for (WebElement count : counts) {
            count.getText();
        }

    }
    }
