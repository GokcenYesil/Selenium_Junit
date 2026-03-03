package tests.D13_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ExplicitWaitVsImplictlyWait {
    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.


    WebDriver driver;

    @Test
    public void implictlyWaitTest (){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini dogrulayın
        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("//*[@onclick='swapInput()']")).click();
        ReusableMethods.wait(3);


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue(textBox.isEnabled());


        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledText= driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledText.isDisplayed());

        driver.quit();

    }

@Test

   public void explicitWaitTest (){

    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));



    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

    driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
    //2. Textbox’in etkin olmadigini dogrulayın
    WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));

    Assertions.assertFalse(textBox.isEnabled());

    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    driver.findElement(By.xpath("//*[@onclick='swapInput()']")).click();

    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(textBox));
    Assertions.assertTrue(textBox.isEnabled());
    WebElement itsEnabledText= driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));

    Assertions.assertTrue(itsEnabledText.isDisplayed());


    driver.quit();


}



}
