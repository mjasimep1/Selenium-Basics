package Test.TestNGClasses;

import org.testng.annotations.Test;

public class RepeatSameTest {
    //Day 37|00:00:00

    @Test(invocationCount = 10)
    void test(){
        System.out.println("Testing..");
    }
}
