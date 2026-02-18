package tests.D02_Annotations;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class C01_TestNotasyonu {


@Test @Order(3)
    public void wisequartertest ( ) throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Test PASSED");
        } else System.out.println("Wisequarter Test FAILED");

        Thread.sleep(1000);
        driver.quit();
    }
@Test @Order(2)
    public void youtubeTest ( )  {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

    assert actualUrl != null;
    if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Test PASSED");
        } else System.out.println("Youtube Test FAILED");


    driver.quit();
    }
@Test @Order(1)
    public void testOtomasyonuTest ( )  {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        assert actualUrl != null;
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test Otomasyonu Test PASSED");
        } else System.out.println("Test Otomasyonu Test FAILED");


        driver.quit();
}
}