package tests.D04_CheckBox_RadioButton_TestBase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C01_CheckBox {

    // a. Verilen web sayfasına gidin.
//    https://testotomasyonu.com/form

// b. Sirt Agrisi ve Carpinti checkbox’larini secin

// c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

// d. Seker ve Epilepsi checkbox’larininin seçili
//    olmadigini test edin

    WebDriver driver;

    @BeforeEach
    public void setup (){

        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void teardown (){
        driver.quit();
    }

    @Test

    public void checkBoxTest (){

        driver.get("https://testotomasyonu.com/form");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        WebElement backAche=driver.findElement(By.id("gridCheck5"));

        WebElement palp=driver.findElement(By.id("gridCheck4"));

        backAche.click();
        palp.click();


        Assertions.assertTrue(backAche.isSelected());
        Assertions.assertTrue(palp.isSelected());


        WebElement diabetes= driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsy= driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(diabetes.isSelected());
        Assertions.assertFalse(epilepsy.isSelected());

    }

}
