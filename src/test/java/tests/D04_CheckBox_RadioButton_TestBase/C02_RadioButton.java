package tests.D04_CheckBox_RadioButton_TestBase;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C02_RadioButton extends TestBase_All {

//	a. Verilen web sayfasına gidin.
//https://testotomasyonu.com/form



        @Test
        @Order(1)


        public void choiceFormButton() {

            //	b. Cinsiyet Radio button elementlerini locate edin
            driver.get("https://testotomasyonu.com/form");

            WebElement womanButton= driver.findElement(By.id("inlineRadio1"));
            WebElement manButton= driver.findElement(By.id("inlineRadio2"));
            WebElement otherButton= driver.findElement(By.id("inlineRadio3"));

            //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
            //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

       driver.findElement(By.xpath("//label[@for='inlineRadio1']")).click();

            Assertions.assertTrue(womanButton.isSelected());
            Assertions.assertFalse(manButton.isSelected());
            Assertions.assertFalse(otherButton.isSelected());

        }


    @Test
    @Order(2)

    public void choiceFromText(){

        WebElement womanText= driver.findElement(By.id("inlineRadio1"));
        WebElement manText= driver.findElement(By.id("inlineRadio2"));
        WebElement otherText= driver.findElement(By.id("inlineRadio3"));

        womanText.click();

        Assertions.assertTrue(womanText.isSelected());
        Assertions.assertFalse(manText.isSelected());
        Assertions.assertFalse(otherText.isSelected());

    }


    }



















