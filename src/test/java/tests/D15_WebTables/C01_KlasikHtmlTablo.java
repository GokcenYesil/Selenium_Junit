package tests.D15_WebTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_KlasikHtmlTablo extends TestBase_Each {



    @Test
    public void htmlTableTest (){


//1. "https://testotomasyonu.com/webtables" adresine gidin

        driver.get("https://testotomasyonu.com/webtables");

//2. Web table tum body’sini yazdirin

WebElement allBodyElement= driver.findElement(By.xpath("//tbody"));
        System.out.println(allBodyElement.getText());

        System.out.println("===============================================");

//3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
    String expectedTableContent="Comfortable Gaming Chair";
    String actualAllTable= allBodyElement.getText();

        Assertions.assertTrue(actualAllTable.contains(expectedTableContent));


//4. Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> allRowElementsList=driver.findElements(By.xpath("//tbody/tr"));

        int expectedRowCount=5;
        int actualRowCount=allRowElementsList.size();

        Assertions.assertEquals(expectedRowCount,actualRowCount);

//5. Tum satirlari yazdirin

// eger satirlari belirterek yazdirmak isterseniz
// bir for-each loop ile satirlari yazdirabilirsiniz

        int rowNum=1;
        for (WebElement each  :allRowElementsList ) {

            System.out.println(rowNum+".row:\n "+each.getText());
            rowNum++;

        }


//6. Web table’daki sutun sayisinin 4 olduğunu test edin


        List<WebElement> firstRowElementsList=driver.findElements(By.xpath("//tr[1]//td"));

        int expectedColumnCount=4;
        int actualColumnCount= firstRowElementsList.size();

        Assertions.assertEquals(expectedColumnCount,actualColumnCount);
/*
   Web tablolarinda sutun olarak gruplama yoktur
   body / satirlar / datalar vardir
   eger sutun sayisini bulmak isterseniz
   her hangi bir satirdaki data sayisina bakabiliriz
   ornegin 1.satirdaki datalara bakalim
 */

//7. 3.sutunu yazdirin

        List<WebElement> thirdColumnList=driver.findElements(By.xpath("//tr[*]//td[3]"));

        System.out.println("Elements in the third column: \n"+ReusableMethods.returnStringList(thirdColumnList));


//8. Tablodaki basliklari yazdirin

        List<WebElement> tableTitles=driver.findElements(By.xpath("//thead//tr//th"));

        System.out.println("Table Titles: "+ReusableMethods.returnStringList(tableTitles));

//9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println("1.row, 2.column : " + getCellData(1,2)); // Electronics

//10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
//    4.satir , 2.sutundaki datanin "Furniture" oldugunu test edin

//      //tr[   4    ]/td[   2   ]

        String expected42 = "Furniture";
        String actual42 = getCellData(4,2);

        Assertions.assertEquals(expected42,actual42);


    }

    public String getCellData(int rowNum, int columnNum){

        String requestingCellData = "";

        //      //tr[   4    ]/td[   2   ]

        String dynamicXPath = "//tr[" + rowNum + "]/td[" + columnNum + "]";

        WebElement requestingCellElement = driver.findElement(By.xpath(dynamicXPath));
        requestingCellData = requestingCellElement.getText();

        return requestingCellData;
    }


}
