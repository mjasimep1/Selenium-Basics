package Test.TestNGClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
    //Day 36|00:50:00
    @DataProvider(name = "testData")
    public Object[][] provideData() {
        return new Object[][] {
                { "John", 25 },
                { "Jane", 30 },
                { "Bob", 35 }
        };
    }

    @Test(dataProvider = "testData")
    public void testMethod(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
