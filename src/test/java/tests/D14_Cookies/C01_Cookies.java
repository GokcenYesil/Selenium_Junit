package tests.D14_Cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_Cookies extends TestBase_Each {


    @Test
    public void cookiesTest (){
// Google anasayfaya gidin
        driver.get("https://www.google.com");


        // syfada kac adet cookies bulundugunu yazdirin
        Set<Cookie> cookieSet = driver.manage().getCookies();

        System.out.println("Quantity of cookie at the page : " + cookieSet.size());

        // sayfadaki cookie'leri yazdirin

        System.out.println(cookieSet);

        // daha anlasilir olmasi icin bir for-each loop ile cookie'leri yazdiralim

        System.out.println("===============");
        int num = 1;
        for (Cookie eachCookie :cookieSet){

            System.out.println(num +". cookie   : " + eachCookie);
            num++;
        }

        // cookie'lerin isimlerini yazdirin

        System.out.println("===============");
        num = 1;
        for (Cookie eachCookie :cookieSet){

            System.out.println(num +". cookie name : " + eachCookie.getName() );
            num++;
        }


        // ismi MyFavouriteCookie, degeri ChocolateCookie olan bir cookie olusturup
        // sayfaya ekleyin

        Cookie yeniCookie = new Cookie("MyFavouriteCookie","ChocolateCookie");
        driver.manage().addCookie(yeniCookie);


        // tum cookie'leri yazdiralim

        cookieSet = driver.manage().getCookies();
        System.out.println("===============");
        num = 1;
        for (Cookie eachCookie :cookieSet){

            System.out.println(num +". cookie   : " + eachCookie);
            num++;
        }

        // cookie'yi ekleyebildigimizi test edin

        Assertions.assertTrue(cookieSet.contains(yeniCookie));

        // ismi SOCS olan cookie'yi silin

        driver.manage().deleteCookieNamed("SOCS");

        cookieSet = driver.manage().getCookies();
        System.out.println("===============");
        num = 1;
        for (Cookie eachCookie :cookieSet){

            System.out.println(num +". cookie   : " + eachCookie);
            num++;
        }

        // ve silindigini test edin

        boolean hassocs = false;

        for (Cookie eachCookie :cookieSet){

            if (eachCookie.getName().equalsIgnoreCase("SOCS")){
                hassocs = true;
            }

        }

        /*
                tum cookie'lerin isimlerini kontrol ettik
                ismi SOCS olan varsa socsVarMi= true,
                ismi SOCS olan yoksa socsVarMi= false, olacak
         */

        Assertions.assertFalse( hassocs );


        // tum cookie'leri silin

        driver.manage().deleteAllCookies();

        // ve silindigini test edin
        cookieSet = driver.manage().getCookies();

        Assertions.assertEquals(0, cookieSet.size());


        ReusableMethods.wait(1);

    }
}
