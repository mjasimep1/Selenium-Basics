package Test.TestNGClasses;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
    //Day 35|00:50:00
  //  @Test()
    void assertWithFailMessage(){
       int x=10;
       int y=12;
       Assert.assertEquals(x>y,true,"x is less than y");
    }
    //@Test()
    void hardAssertions(){
        System.out.println("Testing...");
        System.out.println("Testing...");
        System.out.println("Testing...");
        System.out.println("Testing...");
        Assert.assertEquals(1,2); //if it will fail then below statement will not be executed..
        System.out.println("Hard assertion completed");
        Assert.assertEquals(5,5);

    }
   // @Test()
    void softAssertions(){
        System.out.println("Testing...");
        System.out.println("Testing...");
        System.out.println("Testing...");
        System.out.println("Testing...");

        SoftAssert sa=new SoftAssert();
        sa.assertEquals(1,2,"1 is not equal to 2");
        System.out.println("soft assertion completed");
        Assert.assertEquals(5,5);

        sa.assertAll(); //Mandatory
    }

}
