package tests.D06_JsAllerts;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_All;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C02_JsAlerts extends TestBase_All {

    //1. Test


@Test
@Order(1)
    public void jsAlert (){

    //	-  https://testotomasyonu.com/javascriptAlert adresine gidin

    driver.get("https://testotomasyonu.com/javascriptAlert");

//	- 1.alert'e tiklayin

    driver.findElement(By.xpath("//*[@onclick='jsAlert()']"))
                        .click();


//	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin



    String expectedAlertText="I am a JS Alert";
    String actualAlertText= driver.switchTo().alert().getText();

    Assertions.assertEquals(expectedAlertText,actualAlertText);


//	-  OK tusuna basip alert'i kapatin

    driver.switchTo().alert().accept();


}



//2.Test
//	- https://testotomasyonu.com/javascriptAlert adresine gidin

@Test
@Order(2)
    public void resultText (){

    driver.navigate().to("https://testotomasyonu.com/javascriptAlert");

//	- 2.alert'e tiklayalim

    driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"))
            .click();


//	- Cancel'a basip,
    driver.switchTo().alert().dismiss();

//	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

    String expectedResultText="You clicked: Cancel";

    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    String actualResultText=driver.findElement(By.id("result")).getText();

    Assertions.assertEquals(expectedResultText,actualResultText);

}


//3.Test

    @Test
    @Order(3)
    public void textResultCheck (){

//	- https://testotomasyonu.com/javascriptAlert adresine gidin

        driver.get("https://testotomasyonu.com/javascriptAlert ");

//	- 3.alert'e tiklayalim

        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"))
                .click();

//	- Cikan prompt ekranina "Cansu" yazdiralim

        driver.switchTo().alert().sendKeys("Cansu");



//	- OK tusuna basarak alert'i kapatalim

        driver.switchTo().alert().accept();


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

//	- Cikan sonuc yazisinin Cansu icerdigini test edelim


        String expectedContainedText= "Cansu";
        String actualText=driver.findElement(By.id("result")).getText();

        Assertions.assertTrue(actualText.contains(expectedContainedText));

    }

}
