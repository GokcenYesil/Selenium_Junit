package tests.D09_toSwitchWindows.K02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

import java.util.Set;

public class C05_HedefUrlIleWindowDegistirme  extends TestBase_Each {

    @Test
    public void toChangeWithUrl (){

//● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows ");

// sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']"))
                .click();

// acilan yeni window'a gecin
// url ile gecis yapalim

    String targetUrl="https://elementalselenium.com/";

        Set<String > allWindowsWhv=driver.getWindowHandles();

        for (String eachWdv  :allWindowsWhv ) {

            driver.switchTo().window(eachWdv);

            if (eachWdv.equals(targetUrl)){
                break;
            }

        }

// buyuk basligin "Elemental Selenium" oldugunu test edin

        String expectedHeadTitle="Elemental Selenium";
        String actualHeadTitle= driver.findElement(By.className("hero__title")).getText();

        Assertions.assertEquals(expectedHeadTitle,actualHeadTitle);


    }

}
