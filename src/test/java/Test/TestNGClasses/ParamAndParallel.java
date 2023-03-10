package Test.TestNGClasses;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamAndParallel {
    //Day 37|00:50:00
    @Parameters({"browser"})
    @Test
    void test(String browser){
        if(browser.equalsIgnoreCase("edge")){
            System.out.println("Edge browser is launching..");
        }
        else if(browser.equalsIgnoreCase("chrome")){
            System.out.println("Chrome browser is launching..");
        }
        else{
            System.out.println("Browser launch failed");
        }
    }
}
