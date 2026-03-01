package tests.D12_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C04_FileUploadTesti  extends TestBase_Each {


    @Test
    public void uploadTest (){

//https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

//chooseFile butonuna basalim

        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));

//Praje altindaki deneme.txt dosyayi secelim.

        String projeDenemeTxt= System.getProperty("user.dir")+"/src/test/java/tests/D12_fileTestleri/deneme.txt";

        chooseFileButton.sendKeys(projeDenemeTxt);


//Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

       

//“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileText= driver.findElement(By.tagName("h3"));


        String expectedfileUploadText="File Uploaded!";
        String actualfileUploadText=fileText.getText();


        Assertions.assertEquals(expectedfileUploadText,actualfileUploadText);


    }

}
