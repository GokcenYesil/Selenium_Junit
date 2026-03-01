package tests.D12_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DosyaYolunuDinamikYapma {


    @Test
    public void dynamicFilePathTest (){

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String filePathMyPc="C:\\Users\\Gökçen\\Downloads\\deneme.txt";
        Assertions.assertTrue(Files.exists(Paths.get(filePathMyPc)));

        System.out.println(Files.exists(Paths.get(filePathMyPc)));


        // Dinamik olarak downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String dynamicPath= System.getProperty("user.home")+"\\Downloads\\deneme.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));

        System.out.println(Files.exists(Paths.get(dynamicPath)));

        // D12 package'i altinda deneme.txt dosyasinin
        // var oldugunu test edin

        String filePathPackage="C:\\Users\\Gökçen\\IdeaProjects\\Team168_JUnit\\src\\test\\java\\tests\\D12_fileTestleri\\deneme.txt";

        System.out.println(System.getProperty("user.dir"));

        String dynamicPathPackage= System.getProperty("user.dir")+"\\src\\test\\java\\tests\\D12_fileTestleri\\deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dynamicPathPackage)));

        System.out.println(dynamicPathPackage);


    }

}
