package Test.Practice;

import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteToFile {
    @Test
    public void writeToConfig() {
        Properties properties = new Properties();
        try (OutputStream outputStream = new FileOutputStream("src//test//resources//data.properties")) {
            properties.setProperty("prop1", "Value1");
            properties.setProperty("prop2", "Value2");
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
