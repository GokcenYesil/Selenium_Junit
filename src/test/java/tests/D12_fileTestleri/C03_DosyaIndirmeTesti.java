package tests.D12_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_DosyaIndirmeTesti extends TestBase_Each {

    @Test
    public void downloadFile (){

//1. https://the-internet.herokuapp.com/download adresine gidelim.

        driver.navigate().to("https://the-internet.herokuapp.com/download");

//2. sample.pdf dosyasını indirelim

        //samplePdfPath="C:\\Users\\Gökçen\\Downloads\\sample.pdf";
        driver.findElement(By.xpath("//a[.='sample.pdf']")).click();
        ReusableMethods.wait(2);


//3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String samplePdfPath= System.getProperty("user.home")+"\\Downloads\\sample.pdf";

        Assertions.assertTrue(Files.exists(Paths.get(samplePdfPath)));


    }


}
