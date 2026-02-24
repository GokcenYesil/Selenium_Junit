package tests.D09_toSwitchWindows.K02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C06_WindowDegistirme extends TestBase_Each {


    @Test

    public void toSwitchWindowsWithMethods (){

//● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");


// sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']"))
                .click();


// acilan yeni window'da buyuk basligin "Elemental Selenium" oldugunu test edin
// once title kullanarak yeni window'a gecelim

        ReusableMethods.titleBasedWindowSwitch(driver,"Home | Elemental Selenium");

        String expectedTitleText="Elemental Selenium";
        String actualTitleText = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedTitleText,actualTitleText);


// ilk window'a geri donun

        ReusableMethods.urlBasedWindowSwitch(driver,"https://the-internet.herokuapp.com/windows");

// "Opening a new window" yazisinin gorunur oldugunu test edin

        WebElement openWindowElement=driver.findElement(By.tagName("h3"));
        Assertions.assertTrue(openWindowElement.isDisplayed());


// Click here'a basin

        driver.findElement(By.xpath("//*[.='Click Here']"))
                .click();

// Acilan yeni window'a gecip,
// oradaki yazinin "New Window" oldugunu test edin

        ReusableMethods.titleBasedWindowSwitch(driver,"New Window");

        expectedTitleText="New Window";
        actualTitleText=driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedTitleText,actualTitleText);



// Elemental selenium'un acik oldugu window'a gecip
// Tips linkinin erisilebilir oldugunu test edin

        ReusableMethods.urlBasedWindowSwitch(driver,"https://elementalselenium.com/");

        WebElement tipsLink=driver.findElement(By.xpath("//*[.='Tips']"));

        Assertions.assertTrue(tipsLink.isEnabled());

    }

}
