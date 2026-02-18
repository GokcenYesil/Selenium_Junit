package tests.D01_JUnitFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CokluTest {
    public static void main(String[] args) throws InterruptedException {

    wisequartertest();
    youtubeTest();
    testOtomasyonuTest();


    }
    public static void wisequartertest ( ) throws InterruptedException {

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

    public static void youtubeTest ( )  {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Test PASSED");
        } else System.out.println("Youtube Test FAILED");


        driver.quit();
    }

    public static void testOtomasyonuTest ( )  {

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
