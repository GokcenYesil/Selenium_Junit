package tests.D11_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Each;

public class C02_FakerIleFormDoldurma  extends TestBase_Each {


    @Test
    public void fillTheForm (){



        driver.navigate().to("https://www.testotomasyonu.com");

        driver.findElement(By.xpath("//a[@class='e-cart'][1]")).click();

        driver.findElement(By.xpath("//*[.=' Sign Up']")).click();

        Actions actions=new Actions(driver);
        Faker faker = new Faker();
        String eMail=faker.internet().emailAddress();
        String password=faker.internet().password(8,9);

        WebElement firstNameButton=driver.findElement(By.xpath("//*[@id='firstName']"));

        firstNameButton.click();

        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(eMail).sendKeys(Keys.TAB)
                .sendKeys(password).sendKeys(Keys.TAB)
                .sendKeys(password).sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN).perform();


        driver.findElement(By.id("btn-submit-form")).click();

        WebElement eMailBox= driver.findElement(By.xpath("//*[@class='form-control'][1]"));
        eMailBox.click();
        actions.sendKeys(eMail).sendKeys(Keys.TAB)
              .sendKeys(password).perform();

        driver.findElement(By.xpath("//*[@class='submitbtn btn-lg']")).click();

        WebElement logOut= driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logOut.isDisplayed());



    }


}
