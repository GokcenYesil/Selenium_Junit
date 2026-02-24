package tests.D10_actionsClass.K01_mouseBaseActions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Each;

public class C03_Actions_MoveToElement  extends TestBase_Each {


    @Test
    public void moveToElement (){

//1- https://www.testotomasyonu.com/ adresine gidin

        driver.navigate().to("https://www.testotomasyonu.com/");

//2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin

        WebElement kidsButton= driver.findElement(By.xpath("(//a[.='Kids Wear'])[3]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(kidsButton).perform();

//3- “Boys” linkine basin

        driver.findElement(By.linkText("Boys")).click();

//4- Acilan sayfadaki ilk urunu tiklayin

       driver.findElement(By.xpath("//img[@class='lazy']"))
                .click();

//5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

        String expectedProductName= "Boys Shirt White Color";
        String actualProductName= driver.findElement
                (By.xpath("//div[@class=' heading-sm mb-4']")).getText();


    }

}
