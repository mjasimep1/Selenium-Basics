package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Test.ColorUtils.stringToColor;

public class LoginTest {
    WebDriver driver;
    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }
    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }
    public void implicitWait(int k) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(k));
       // driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void launchBrowser() throws InterruptedException {
        System.out.println("Hello world!");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    //OR
        //driver=WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();

    }

    @Test(enabled = false)
    public void login() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(2000);
        WebElement submitBtn=driver.findElement(By.xpath("//*[@type='submit']"));
        WebElement userName=driver.findElement(By.name("username"));
        String colour=userName.getCssValue("border");
        System.out.println(colour);
        implicitWait(10);
        click(submitBtn);
        colour=userName.getCssValue("border");
//Split the hex value
        String strBeforeBracket = colour.substring(0, colour.lastIndexOf("(") - 1);
        String strInBracket ="rgb"+colour.substring(colour.lastIndexOf("("),
                colour.lastIndexOf(")") + 1);
        System.out.println(strBeforeBracket);
        System.out.println(strInBracket);
//Convert to the rgb to hex
        String hex = Color.fromString(strInBracket).asHex();
        System.out.println(hex);
        //java.awt.Color c = stringToColor(hex);
        //System.out.println(c);

        WebElement loginTxt=driver.findElement(By.xpath("//*[@class='orangehrm-login-slot']/h5"));
        System.out.println(loginTxt.getText());
//xpath using function with inner text
    //Full inner text
        WebElement footerTxt=driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']"));
       // WebElement footerTxt=driver.findElement(By.xpath("//*[text()='OrangeHRM, Inc']"));
        System.out.println("Xpath using full inner text: "+footerTxt.getText());

    //Partial inner Text
        WebElement footerTxt1=driver.findElement(By.xpath("//a[contains(text(),'OrangeHR')]"));
        //WebElement footerTxt1=driver.findElement(By.xpath("//*[contains(text(),'ngeHRM, Inc')]"));
        System.out.println("Xpath using partial inner text: "+footerTxt1.getText());

    //Inner text starts with
        WebElement footerTxt2=driver.findElement(By.xpath("//a[starts-with(text(),'Oran')]"));
        //WebElement footerTxt2=driver.findElement(By.xpath("//*[starts-with(text(),'ngeHRM, Inc')]"));
        System.out.println("Xpath using partial inner text starts with: "+footerTxt2.getText());

    //xpath using input tag and placeholder attribute of the user name field
        WebElement userName1=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        System.out.println("xpath using input tag and placeholder attribute of the user name field: "+userName1.getAttribute("placeholder"));


    }

    @AfterMethod
    public void close(){
        //driver.close();
    }
}