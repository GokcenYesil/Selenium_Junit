package tests.D02_Annotations;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_SetupVeTeardownMetodlari {

    WebDriver driver;
    public void setUp (){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void tearDown (){
        ReusableMethods.wait(1);
        driver.quit();
    }


    @Test

    public void wisequartertest ( )  {
        setUp();

        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Test PASSED");
        } else System.out.println("Wisequarter Test FAILED");

        tearDown();


    }
    @Test
    public void youtubeTest ( )  {

        setUp();

        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        assert actualUrl != null;
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Test PASSED");
        } else System.out.println("Youtube Test FAILED");

        tearDown();

    }
    @Test
    public void testOtomasyonuTest ( )  {
        setUp();

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        assert actualUrl != null;
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test Otomasyonu Test PASSED");
        } else System.out.println("Test Otomasyonu Test FAILED");

        tearDown();


    }
}





