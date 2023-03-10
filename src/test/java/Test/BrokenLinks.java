package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks extends LoginTest{
    @Test(enabled = false)
    public void brokenLink() throws InterruptedException, IOException {
        //Day 31|00:00:00
        driver.get("http://www.deadlinkcity.com/");
        Thread.sleep(2000);
        List<WebElement> links=driver.findElements(By.xpath("//a[@href]"));
        int brokenLinkCount=0;
        for(WebElement link:links) {
            try {
                String targetLink = link.getAttribute("href");
                //System.out.println(link.getText()+" --> "+targetLink);
                if (targetLink == null || targetLink.isEmpty()) {
                    System.out.println("href value is empty");
                    continue;
                }
                URL linkUrl = new URL(targetLink);
                // Send request to server-open, connect
                HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();
                conn.connect();
                if (conn.getResponseCode() >= 400) {
                    System.out.println(link.getText() + " --> " + targetLink + " --> " + "Broken link..");
                    brokenLinkCount++;
                } else {
                    System.out.println(link.getText() + " --> " + targetLink + " --> " + "Not broken link..");
                }
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("exception in this "+link.getText()+" link");
            }
            }

            System.out.println("Total broken links are: " + brokenLinkCount);

    }
}
