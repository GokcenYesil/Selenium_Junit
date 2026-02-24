package tests.D10_actionsClass.K02_keyboardBasedActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_FormDoldurma extends TestBase_Each {

    @Test
    public void fillTheForm (){

//1- https://www.testotomasyonu.com adresine gidelim
        driver.navigate().to("https://www.testotomasyonu.com");

//2- Account linkine tiklayin

        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]"))
                .click();

//3- Sign Up linkine basalim

        driver.findElement(By.xpath("//*[.=' Sign Up']")).click();

//4- Ad, soyad, mail ve sifre kutularina deger yazalim

        WebElement firstNameBox=driver.findElement(By.xpath("//*[@id='firstName']"));
        firstNameBox.click();
        Actions actions = new Actions(driver);
        ReusableMethods.wait(2);

        actions.sendKeys("Gokcen").sendKeys(Keys.TAB)
                .sendKeys("Safel").sendKeys(Keys.TAB)
                .sendKeys("gokcens@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("123456").sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys("123456").sendKeys(Keys.PAGE_DOWN)
                .perform();
        ReusableMethods.wait(2);

//   ve Sign Up butonuna basalim
        WebElement signUpButton=driver.findElement(By.id("btn-submit-form"));
        signUpButton.click();

        ReusableMethods.wait(5);

//5- Kaydin olusturuldugunu test edin

        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        emailBox.sendKeys("gokcens@gmail.com");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("123456");

        driver.findElement(By.id("submitlogin")).click();


        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);

        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButton.isEnabled());


        logoutButton.click();


    }

}
