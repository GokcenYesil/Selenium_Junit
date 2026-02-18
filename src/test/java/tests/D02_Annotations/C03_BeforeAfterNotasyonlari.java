package tests.D02_Annotations;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class C03_BeforeAfterNotasyonlari {



    WebDriver driver;

    @BeforeEach
    public void setUp (){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterEach
    public void tearDown (){
        ReusableMethods.wait(1);
        driver.quit();
    }


    @Test @Order(3)

    public void wisequartertest ( )  {

        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Test PASSED");
        } else System.out.println("Wisequarter Test FAILED");




    }
    @Test @Order(1)
    public void youtubeTest ( )  {



        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        assert actualUrl != null;
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Test PASSED");
        } else System.out.println("Youtube Test FAILED");



    }
    @Test @Order(2)
    public void testOtomasyonuTest ( )  {


        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        assert actualUrl != null;
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test Otomasyonu Test PASSED");
        } else System.out.println("Test Otomasyonu Test FAILED");




    }
}


