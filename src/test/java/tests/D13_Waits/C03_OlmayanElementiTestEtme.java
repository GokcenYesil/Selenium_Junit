package tests.D13_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C03_OlmayanElementiTestEtme extends TestBase_Each {


    @Test
    public void Test01 (){

//1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

driver.get("https://the-internet.herokuapp.com/dynamic_controls ");

//2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']")).click();

// it's gone yazisi gorununceye kadar bekleyin

        WebElement itsGoneText= driver.findElement(By.id("message"));


//3. checkbox'in gorunur olmadigini test edin
// locate edebildiyse, checkbox gorunuyor demektir
// bu da bizden istenen gorevin failed olmasi anlamina gelir
// Checkbox'i locate edemedigi icin NoSuchElementException olusur
// bu aslinda bizden istenen gorevin
// yani checkBox'in gorunemediginin ispatidir

        try {
            WebElement checkBox= driver.findElement(By.xpath("//*[@id='checkbox']"));
            Assertions.assertTrue(false,"Checkbox görünür durumda..");
        } catch (NoSuchElementException e) {
            Assertions.assertTrue(true);
        }

//4. Add buttonuna basin

        driver.findElement(By.xpath("//*[.='Add']")).click();

//5. checkbox'in gorunur oldugunu test edin
        WebElement checkBox= driver.findElement(By.xpath("//*[@id='checkbox']"));

        Assertions.assertTrue(checkBox.isDisplayed());


    }

}
