package tests.D11_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_FakerVeActionsClassIleFormDoldurma extends TestBase_Each {

    @Test
    public void fakerAndActionFillingFormTest (){

//1- https://www.facebook.com adresine gidelim

        driver.get("https://www.facebook.com ");


//3- Yeni hesap olustur butonuna basalim

driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

//4- Ad, soyad, mail ve sifre kutularina deger yazalim,
//   tarih ve cinsiyet secimlerini yapalim
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        WebElement firstNameButton= driver.findElement(By.xpath("//*[@name='firstname']"));
        firstNameButton.click();

        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("30").sendKeys(Keys.TAB)
                .sendKeys("Tem").sendKeys(Keys.TAB)
                .sendKeys("2013").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).perform();

//5- Kaydol tusuna basalim
        driver.findElement(By.xpath("//*[@name='websubmit']")).click();

        ReusableMethods.wait(5);


    }

}
