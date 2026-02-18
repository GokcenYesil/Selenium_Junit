package tests.D02_Annotations;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class C04_BeforeAll_AfterAll {

    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
        ReusableMethods.wait(1);
        driver.quit();
    }


    @Test @Order(1)

    public void testOtomasyonuTesti() {


        driver.navigate().to("https://www.testotomasyonu.com/");

        String expectedUrlContent = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlContent)) {
            System.out.println("Url Content Test PASSED");
        } else System.out.println("Url Content Test FAILED");


    }

    @Test @Order(2)
    public void phoneSearchTest() {




        WebElement searchBox = driver.findElement(By.id("global-search"));

        searchBox.sendKeys("phone" + Keys.ENTER);

        List<WebElement> foundedElements = driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));

        if (!foundedElements.isEmpty()) {
            System.out.println("Finding Elements Test PASSED");
        } else System.out.println("Finding Elements Test FAILED");


    }

    @Test @Order(3)
    public void productNameTest() {
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement productText = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedTextContent = "phone";
        String actualText = productText.getText()
                .toLowerCase();


        if (actualText.contains(expectedTextContent)) {
            System.out.println("Product Name Test PASSED");
        } else System.out.println("Product Name Test FAILED");


    }

}





