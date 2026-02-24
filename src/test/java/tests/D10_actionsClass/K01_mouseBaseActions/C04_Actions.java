package tests.D10_actionsClass.K01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Each;

public class C04_Actions extends TestBase_Each {

    @Test
    public void test01 (){
//1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

//2- Hover over Me First" kutusunun ustune gelin

        WebElement hoverFirst= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions= new Actions(driver);
        actions.moveToElement(hoverFirst).perform();

//3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"))
                .click();

//4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

//5- Popup'i tamam diyerek kapatin

        driver.switchTo().alert().accept();

//6- “Click and hold" kutusuna basili tutun

       WebElement clickAndHold=driver.findElement(By.id("click-box"));
       actions.clickAndHold(clickAndHold).perform();

//7-“Click and hold" kutusunda cikan yaziyi yazdirin

        System.out.println(clickAndHold.getText());

//8- “Double click me" butonunu cift tiklayin

        WebElement doubleClickElement= driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickElement).perform();



// cift tiklandigini test edin

        String expectedClassAttributeValue = "div-double-click double";
        String actualClassAttributeValue = doubleClickElement.getAttribute("class");

        Assertions.assertEquals(expectedClassAttributeValue,actualClassAttributeValue);


    }

}
