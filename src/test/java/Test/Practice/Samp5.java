package Test.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Samp5 {

public String finalString=RandomStringUtils.randomAlphabetic(5);
    public static String randomString(){
        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
    @Test
    public void test(){
       // System.out.println(randomString());
        System.out.println(finalString);
    }
    @Test
    public void test1(){
       // System.out.println(randomString());
        System.out.println(finalString);
    }
    @Test
    public void test2(){
        System.out.println(randomString());
    }
}
