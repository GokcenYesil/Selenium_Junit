package tests.D09_toSwitchWindows.K01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class C01_AyniWindowdaGezinme extends TestBase_Each {

    @Test
    public void test01(){

        String targetUrl="https://www.testotomasyonu.com";

        // testotomasyonu sayfasina gidin
        driver.navigate().to(targetUrl);

        // windowhandle degerini ve url'i yazdirin
        System.out.println("testotomasyonu url : " + driver.getCurrentUrl());
        System.out.println("testotomasyonu window handle value : " + driver.getWindowHandle());

        // Electronics linkini tiklayin
        driver.findElement(By.xpath("(//a[.='Electronics'])[3]"))
                .click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Electronics url : " + driver.getCurrentUrl());
        System.out.println("Electronics window handle value : " + driver.getWindowHandle());


        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("First product url : " + driver.getCurrentUrl());
        System.out.println("First product window handle value : " + driver.getWindowHandle());


        // account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();


        // windowhandle degerini ve url'i yazdirin
        System.out.println("account url : " + driver.getCurrentUrl());
        System.out.println("account window handle value : " + driver.getWindowHandle());



    }
}
