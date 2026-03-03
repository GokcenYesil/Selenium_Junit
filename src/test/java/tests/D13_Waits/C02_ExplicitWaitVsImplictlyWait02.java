package tests.D13_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitWaitVsImplictlyWait02 {

WebDriver driver;

   @Test
   public void implicitlyWait (){

       driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

       driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");

//2. Remove butonuna basin.
       driver.findElement(By.xpath("//*[.='Remove']")).click();

//3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

       WebElement itsGoneText= driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));

       Assertions.assertTrue(itsGoneText.isDisplayed());

//4. Add buttonuna basin

       driver.findElement(By.xpath("//*[.='Add']")).click();

//5. It’s back mesajinin gorundugunu test edin

       WebElement itsBackText= driver.findElement(By.xpath("//*[.=\"It's back!\"]"));
       Assertions.assertTrue(itsBackText.isDisplayed());

driver.quit();

   }


    @Test
    public void explicitWait (){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));


//1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");

//2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']")).click();

//3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

//1.adim wait objesi olustur
// 2. ve 3.adim : bekleme yapmadan locate etmek mumkun olmadigindan
// bekleme ve locate'i tek adimda yapacagiz

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement itsGoneText=
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]")));

        Assertions.assertTrue(itsGoneText.isDisplayed());


//4. Add buttonuna basin

        driver.findElement(By.xpath("//*[.='Add']")).click();

//5. It’s back mesajinin gorundugunu test edin

        WebElement itsBackText =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's back!\"]")));

        driver.quit();



    }



}
