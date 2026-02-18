package tests.D03_Assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C03_JUnitAssertions extends TestBase_All {

    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin


        @Test @Order(1)

        public void urlContentCheck (){
            driver.navigate().to("https://www.testotomasyonu.com/");

            String expectedUrlContent="testotomasyonu";
            String actualUrl= driver.getCurrentUrl();

            Assertions.assertTrue(actualUrl.contains(expectedUrlContent));


        }
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin

        @Test @Order(2)
        public void keySearch (){

            WebElement searchBox=driver.findElement(By.id("global-search"));

            searchBox.sendKeys("phone"+ Keys.ENTER);
            List<WebElement> foundedElementList =
                    driver.findElements(By.xpath("//*[@class='prod-img']"));


            Assertions.assertFalse(foundedElementList.isEmpty());

        }

    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        @Test @Order(3)

        public void productNameTest (){

            driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                    .click();
            WebElement firstProductText = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

            String expectedProductText="phone";

            String actualProductName=firstProductText.getText().toLowerCase();

            Assertions.assertTrue(actualProductName.contains(expectedProductText.toLowerCase()));


        }

}


