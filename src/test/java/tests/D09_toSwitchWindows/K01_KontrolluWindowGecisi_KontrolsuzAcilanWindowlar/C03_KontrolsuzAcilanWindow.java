package tests.D09_toSwitchWindows.K01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void uncontrolledSwitchWindow (){


//● https://the-internet.herokuapp.com/windows adresine gidin.

    driver.get("https://the-internet.herokuapp.com/windows");

//● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        WebElement openText= driver.findElement(By.tagName("h3"));

        String expectedText="Opening a new window";
        String actualText= openText.getText();

        Assertions.assertEquals(expectedText,actualText);

//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        String herOkuWhv= driver.getWindowHandle();
//● Click Here butonuna basın.


        driver.findElement(By.xpath("//*[.='Click Here']")).click();

//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin.

        Set<String> whvSet=driver.getWindowHandles();

        String secondPageWhv="";


        for (String each  :whvSet ) {

            if (!each.equals(herOkuWhv)){

                secondPageWhv=each;
            }


        }


        driver.switchTo().window(secondPageWhv);

        expectedTitle= "New Window";
        actualTitle=driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.


        WebElement pageText=driver.findElement(By.tagName("h3"));

        expectedText="New Window";
        actualText=pageText.getText();

        Assertions.assertEquals(expectedText,actualText);

//● Bir önceki pencereye geri dönun


        driver.switchTo().window(herOkuWhv);

//  ve sayfa başlığının “The Internet” olduğunu test edin.

        expectedTitle="The Internet";
        actualTitle=driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);


    }

}
