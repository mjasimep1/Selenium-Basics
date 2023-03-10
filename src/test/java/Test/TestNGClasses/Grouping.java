package Test.TestNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Grouping {

    //Day 36|00:10:00===>>> Run the grouping.xml file to run this grouping function <=====
    /*
    1.App open-Sanity
    2.Login-Sanity
    3.Home-
    4.Search-Regression
    5.Adv search-sanity&regression
    6.logout-sanity&regression
    7.app close-sanity
     */
    @Test(priority = 0,groups = {"sanity"})
    void appOpen(){
        System.out.println("1.App open");
    }
    @Test(priority = 1,groups = {"sanity"})
    void login(){
        System.out.println("2.Login");
    }
    @Test(priority = 2)
    void home(){
        System.out.println("3.Home");
    }
    @Test(priority = 3,groups = {"regression"})
    void search(){
        System.out.println("4.Search");
    }
    @Test(priority = 4,groups = {"sanity","regression"})
    void advSearch(){
        System.out.println("5.advSearch");
    }
    @Test(priority = 5,groups = {"sanity","regression"})
    void logout(){
        System.out.println("6.Logout");
    }
    @Test(priority = 6, groups = {"sanity"})
    void appClose(){
        System.out.println("7.App close");
    }
}
