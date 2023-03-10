package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WindowHandles extends LoginTest{

    @Test(enabled = false)
    public void windowHandle() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    //Create s new tab
        /*driver.switchTo().newWindow(WindowType.TAB);
        //driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("www.samdsf.com");*/

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    //Implicit wait
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //fluent wait declaration
        FluentWait myWait=new FluentWait(driver);
                myWait.withTimeout(Duration.ofSeconds(30));
                myWait.pollingEvery(Duration.ofSeconds(5));
                myWait.ignoring(NoSuchElementException.class);

       String currentWindowId=driver.getWindowHandle();
        Thread.sleep(1000);
        WebElement footerTxtBtn=driver.findElement(By.linkText("OrangeHRM, Inc"));
        footerTxtBtn.click();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!currentWindowId.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println(driver.getTitle());
        driver.switchTo().window(currentWindowId);
        System.out.println(driver.getTitle());

    }
}
