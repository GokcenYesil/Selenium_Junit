package tests.D05_DropDownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;

public class C02_DropDownMenu02 extends TestBase_Each {



    //● https://testotomasyonu.com/form adresine gidin.
    //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //4. Secilen değerleri konsolda yazdirin
    //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
    //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin



@Test
public void birthdate (){
    driver.navigate().to("https://testotomasyonu.com/form ");

    WebElement birthDay=driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
//1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    Select selectDay = new Select(birthDay);
    selectDay.selectByIndex(5);
    //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

    WebElement birthMonth= driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
    Select selectMonth = new Select(birthMonth);

    selectMonth.selectByValue("nisan");

ReusableMethods.wait(2);

    //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin


    WebElement birthYear= driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

    Select selectYear=new Select(birthYear);

    selectYear.selectByVisibleText("1990");

ReusableMethods.wait(2);
    //4. Secilen değerleri konsolda yazdirin

    System.out.println(selectDay.getFirstSelectedOption().getText());
    System.out.println(selectMonth.getFirstSelectedOption().getText());
    System.out.println(selectYear.getFirstSelectedOption().getText());


    //5. Ay dropdown menüdeki tum değerleri(value) yazdırın

    //System.out.println(birthMonth.getText());

    List<String> stringList= new ArrayList<>();

    List<WebElement> monthsElementList=selectMonth.getOptions();

    for (WebElement each  : monthsElementList) {

        stringList.add(each.getText());
    }


    Assertions.assertTrue(stringList.contains("Ocak"));

    Assertions.assertTrue(ReusableMethods.returnStringList(selectMonth.getOptions()).contains("Ocak"));

    //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

    int expectedMenuSize=13;
    int actualMenuSize=stringList.size();

    Assertions.assertEquals(expectedMenuSize,actualMenuSize);

    }


}
