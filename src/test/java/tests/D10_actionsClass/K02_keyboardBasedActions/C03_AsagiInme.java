package tests.D10_actionsClass.K02_keyboardBasedActions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_AsagiInme extends TestBase_Each {

    @Test
    public void pageDown (){
//1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

//2- video’yu gorecek kadar asagi inin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();


//3- videoyu izlemek icin Play tusuna basin

        WebElement iframe=driver.findElement(By.xpath("//iframe[@sandbox='allow-same-origin allow-scripts allow-popups allow-forms']"));

        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//*[@title='Oynat']")).click();

        ReusableMethods.wait(3);


    }

}
