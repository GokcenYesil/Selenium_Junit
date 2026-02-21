package tests.D08_iFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class C01_IFrame extends TestBase_Each {


    @Test
    public void iframe (){

//1) https://demoqa.com/frames sitesine gidiniz

        driver.get("https://demoqa.com/frames ");

//2) This is a sample page yazisinin gorunur oldugunu test edin

        WebElement iframe= driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe);


        WebElement samplePageText = driver.findElement(By.xpath("(//h1[@id='sampleHeading'])[1]"));

        Assertions.assertTrue(samplePageText.isDisplayed());


//3) TOOLSQA logosunun gorunur oldugunu test edin


        driver.switchTo().defaultContent();

        WebElement tollsQa= driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));

        Assertions.assertTrue(tollsQa.isDisplayed());


//4) sayfadaki iframe sayısını yazdirin.

        List<WebElement> iframeList=driver.findElements(By.tagName("iframe"));

        System.out.println("Iframe quantity at the page: "+iframeList.size());

    }

}
