package tests.D09_toSwitchWindows.K02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

import java.util.Set;

public class C04_TitledanKontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void Test01 (){

//● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.navigate().to("https://the-internet.herokuapp.com/windows");


// sayfadaki elemental selenium linkini tiklayin

        driver.findElement(By.xpath("//*[.='Elemental Selenium']"))
                .click();

// acilan yeni window'a gecip
// gecisi yeni window'un title'ini kullanarak yapin

        String targetTitle="Home | Elemental Selenium";

        Set<String > allWindowWhv=driver.getWindowHandles();

        for (String eachWhv  :allWindowWhv ) {

            driver.switchTo().window(eachWhv);

        if (driver.getTitle().equals(targetTitle)){

            break;
        }


        }

// buyuk basligin "Elemental Selenium" oldugunu test edin


        String expectedHeadTitle="Elemental Selenium";
        String actualHeadTitle= driver.findElement(By.className("hero__title")).getText();

        Assertions.assertEquals(expectedHeadTitle,actualHeadTitle);



    }

}
