package tests.D08_iFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C02_IFrame02 extends TestBase_Each {



    @Test
    public void iframe (){

//1- https://testotomasyonu.com/discount adresine gidin

      driver.navigate().to("https://testotomasyonu.com/discount");


//2- Elektronics Products yazisinin gorunur olduğunu test edin

        WebElement iframe = driver.findElement
                (By.xpath("//*[@src='https://testotomasyonu.com/disproduct']"));

        driver.switchTo().frame(iframe);

        WebElement electronicsProductText= driver.findElement
                (By.xpath("//*[.='Electronics Products']"));

        Assertions.assertTrue(electronicsProductText.isDisplayed());


//3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        String expectedProductName= "DELL Core I3 11th Gen";
        String actualProductName = driver.findElement(By.id("pictext1")) .getText();

        Assertions.assertEquals(expectedProductName,actualProductName);

//4- Sale Up To 50% yazisinin gorunur oldugunu test edin

        driver.switchTo().defaultContent();
        WebElement saleUpText= driver.findElement(By.xpath("//*[.='Sale Up To 50%']"));

        Assertions.assertTrue(saleUpText.isDisplayed());


//5- Fashion bolumundeki ilk urun ismini locate edin

        WebElement fashionFrame= driver.findElement
                (By.xpath("//iframe[@src='https://testotomasyonu.com/disproduct2']"));
        driver.switchTo().frame(fashionFrame);
        WebElement firstProductName = driver.findElement(By.xpath("(//p)[1]"));

// ve ilk urun isminde "Men Slim Fit" gectigini test edin

        String expectedFirstProductName="Men Slim Fit";
        String actualFirstProductName=firstProductName.getText();

        Assertions.assertTrue(actualFirstProductName.contains(expectedFirstProductName));

    }

}
