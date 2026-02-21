package tests.D07_basicAuthentications;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C01_BasicAuthentication extends TestBase_Each {



    //1- Bir class olusturun : BasicAuthentication
    //2- https://testotomasyonu.com/basicauth sayfasina gidin
    // driver.get("https://testotomasyonu.com/basicauth");
    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //
    //Html komutu : https://username:password@URL
    //	Username     : membername
    // 	password      : sunflower
    //

    @Test

        public void basicAuthentication (){
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");


        //4- Basarili sekilde sayfaya girildigini dogrulayin

        String expectedText = "Basic Auth";

        WebElement textElement = driver.findElement(By.tagName("h1"));
        String actualText = textElement.getText();

        Assertions.assertEquals(expectedText,actualText);

    }

}
