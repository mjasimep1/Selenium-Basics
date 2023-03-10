package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardActions extends LoginTest {
    @Test(enabled = false)
    public void keyboardAct() throws InterruptedException {
        //Day 30|00:00:00
        Actions act=new Actions(driver);
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        act.sendKeys(Keys.TAB).perform();
    }
}
