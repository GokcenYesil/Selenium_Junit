package tests.D10_actionsClass.K01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_Actions_DragAndDrop  extends TestBase_Each {


    @Test
    public void dragAndDrop (){



//1- https://testotomasyonu.com/droppable adresine gidelim

        driver.get("https://testotomasyonu.com/droppable");

//2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement acceptable= driver.findElement(By.id("draggable2"));
        WebElement dropHere= driver.findElement(By.xpath("//*[.='Drop Here']"));

        Actions actions = new Actions(driver);
        ReusableMethods.wait(1);

        actions.dragAndDrop(acceptable,dropHere).perform();

//3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedText="Dropped!";
        String actualtext= dropHere.getText();

        Assertions.assertEquals(expectedText,actualtext);

//4- Sayfayi yenileyin

        driver.navigate().refresh();

//5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement notAcceptable= driver.findElement(By.id("draggable-nonvalid2"));
        dropHere= driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptable,dropHere).perform();

        ReusableMethods.wait(2);


//6- “Drop Here” yazisinin degismedigini test edin

        expectedText="Drop Here";
        actualtext= dropHere.getText();

        Assertions.assertEquals(expectedText,actualtext);


    }

}
