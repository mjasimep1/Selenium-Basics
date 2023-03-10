package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class HeadlessMode {
    WebDriver driver;
    @Test(enabled = false)
    public void headless() throws IOException, InterruptedException {
        //Day 31|01:20:00

    //Approach 1: Headless mode
        /*EdgeOptions options=new EdgeOptions();
        options.setHeadless(true);

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);*/

    //Approach 2: Headless mode
        EdgeOptions options=new EdgeOptions();
        options.setHeadless(true);

        driver=WebDriverManager.edgedriver().capabilities(options).create();

        driver.get("https://demo.opencart.com/admin");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userName = driver.findElement(By.xpath("//*[@name='username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("demo");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@type='submit']"));
        loginBtn.click();
        Thread.sleep(3000);




    }
}
