package tests.D05_DropDownMenu;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_Each;

public class C01_DropDownMenu01 extends TestBase_Each {


    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın



@Test
    public void dropdown (){

    driver.get("https://the-internet.herokuapp.com/dropdown");

    WebElement ddm = driver.findElement(By.id("dropdown"));

    Select select = new Select(ddm);

    select.selectByIndex(1);
    System.out.println(select.getFirstSelectedOption().getText());

    select.selectByValue("2");
    System.out.println(select.getFirstSelectedOption().getText());

    select.selectByVisibleText("Option 1");
    System.out.println(select.getFirstSelectedOption().getText());

    System.out.println(ddm.getText());


}


}
