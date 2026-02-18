package tests.D03_Assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class C05_AssertionsClassWork {

    // https://www.bestbuy.com/ Adresine gidin
    // farkli test method’lari olusturarak asagidaki testleri yapin

    static WebDriver driver;


@BeforeAll
    public static void setup (){

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.bestbuy.com/");
    }
@AfterAll
    public static void teardown (){
    driver.quit();
    }


    //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin


@Test
    @Order(1)
    public void urlTest (){

    String expectedUrl="https://www.bestbuy.com/";
    String actualUrl=driver.getCurrentUrl();

    Assertions.assertEquals(expectedUrl,actualUrl);


    }
    //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
@Test
    @Order(2)
    public void titleTest (){

    String expextedTitleContent="Rest";
    String  actualTitle= driver.getTitle();

    if (actualTitle != null) {
        Assertions.assertFalse(actualTitle.contains(expextedTitleContent));
    }

}
    //	○ logoTest => BestBuy logosunun görüntülendigini test edin
@Test
    @Order(3)
    public void logoTest (){

        WebElement logoElement= driver.findElement(By.xpath("//img[@class='logo'][1]"));

        Assertions.assertTrue(logoElement.isDisplayed());

    }
    //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
@Test
    @Order(4)
    public void languageTest (){

    WebElement languageButton= driver.findElement(By.xpath("//*[.='Français']"));

    Assertions.assertTrue(languageButton.isDisplayed());

    }

}
