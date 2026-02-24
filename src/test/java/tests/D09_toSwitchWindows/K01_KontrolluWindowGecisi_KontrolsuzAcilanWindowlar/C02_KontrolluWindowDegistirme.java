package tests.D09_toSwitchWindows.K01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase_Each;

public class C02_KontrolluWindowDegistirme extends TestBase_Each {


    @Test
    public void toSwitchWindow (){

// testotomasyonu sayfasina gidin

        driver.navigate().to("https://www.testotomasyonu.com");

// whd'ini kaydedin ve yazdirin

        String testotomasyonuWhv= driver.getWindowHandle();
        System.out.println(testotomasyonuWhv);

       

// yeni bir tab acip, yeni tab'da wisequarter sayfasina gidin

        driver.switchTo().newWindow(WindowType.TAB)
                .get("https://www.wisequarter.com");

// whd'ini kaydedin ve yazdirin

        String wisequarterWhv=driver.getWindowHandle();
        System.out.println(wisequarterWhv);
       

// yeni bir window acarak, arabam.com sayfasina gidin

       driver.switchTo().newWindow(WindowType.WINDOW)
               .navigate().to("https://www.arabam.com");

// whd'ini kaydedin ve yazdirin

        String arabamWhv= driver.getWindowHandle();
        System.out.println(arabamWhv);
       

// wisequarter'in acik oldugu window'a donun

        driver.switchTo().window(wisequarterWhv);
// ve url'in wisequarter icerdigini test edin

        String expectedUrlText="wisequarter";
        String actualUrl=driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlText));
       

// testotomasyonu'nun acik oldugu window'a donun

        driver.switchTo().window(testotomasyonuWhv);

// ve url'in testotomasyonu icerdigini test edin

      expectedUrlText="testotomasyonu";
      actualUrl=driver.getCurrentUrl();

      Assertions.assertTrue(actualUrl.contains(expectedUrlText));



    }

}
