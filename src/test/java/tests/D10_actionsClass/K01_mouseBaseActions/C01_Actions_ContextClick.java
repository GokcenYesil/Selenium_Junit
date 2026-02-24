package tests.D10_actionsClass.K01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_Actions_ContextClick extends TestBase_Each {


    @Test
    public void mouseActions (){

//1- https://testotomasyonu.com/click sitesine gidin

        driver.navigate().to("https://testotomasyonu.com/click");

//2- “DGI Drones” uzerinde sag click yapin

        WebElement dgiDrones= driver.findElement(By.id("pic2_thumb"));

        Actions actions = new Actions(driver);
        ReusableMethods.wait(1);

        actions.contextClick(dgiDrones).perform();


//3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.



        String expectedAlertText="Tebrikler!... Sağ click yaptınız.";
        String actualAlertText= driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertText,actualAlertText);



//4- Tamam diyerek alert’i kapatin

        driver.switchTo().alert().accept();



    }

}
