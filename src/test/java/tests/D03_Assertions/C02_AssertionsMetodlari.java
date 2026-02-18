package tests.D03_Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C02_AssertionsMetodlari {

    int a = 10;
    int b = 20;
    int c = 30;
    String url1 = "https://www.testotomasyonu.com";
    String url2 = "https://www.testotomasyonu.com/";




// c'nin a ile b'nin toplamina esit oldugunu test edin

    @Test
    public void Test01 (){

        Assertions.assertEquals(c,a+b);

    }


// c'nin a ile b'nin toplamina esit oldugunu test edin
    @Test
    public void Test02 (){

        Assertions.assertTrue(c==a+b);


    }

// b'nin a ile c'nin toplamina esit oldugunu test edin

    @Test
    public void Test03 (){

    Assertions.assertTrue(b==a+c);

    }

// equals mumkunse onceligimiz equals() kullanmaktir

    @Test
    public void Test04 (){

        Assertions.assertEquals(b,a+c);



    }

// b'nin a ile c'nin toplamina esit olmadigini test edin

    @Test
    public void Test05 (){

        Assertions.assertNotEquals(b,c+a);


    }

// url1 ile url2'nin ayni oldugunu test edin

    @Test
    public void Test06 (){
        Assertions.assertEquals(url1,url2);


    }

// url1 ile url2'nin ayni oldugunu test edin

    @Test
    public void Test07(){

        Assertions.assertTrue(url1.equals(url2));


    }

// url1 ile url2'nin ayni olmadigini test edin

    @Test
    public void Test08 (){

        Assertions.assertNotEquals(url1,url2);


    }

// url1'in "test" kelimesi icerdigini test edin

    @Test
    public void Test09 (){

        Assertions.assertTrue(url1.contains("test"));


    }

// url1'in "best" kelimesi icermedigini test edin

    @Test
    public void Test10 (){

        Assertions.assertFalse(url1.contains("best"));


    }


}
