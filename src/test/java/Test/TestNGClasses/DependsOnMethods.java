package Test.TestNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {
    //Day 35|00:50:00

   // @Test(priority = 0)
    void login(){
        System.out.println("1.Login");
        Assert.assertTrue(false);
    }
   // @Test(priority = 1)
    void home(){
        System.out.println("2.Home");
        Assert.assertTrue(true);
    }
   // @Test(priority = 2, dependsOnMethods = "login")
    void search(){
        System.out.println("3.Search");
        Assert.assertTrue(true);
    }
   // @Test(priority = 3)
    void advSearch(){
        System.out.println("4.advSearch");
        Assert.assertTrue(true);
    }
   // @Test(priority = 4, dependsOnMethods = {"login","advSearch"})
    void logout(){
        System.out.println("5.Logout");
        Assert.assertTrue(true);
    }
}
