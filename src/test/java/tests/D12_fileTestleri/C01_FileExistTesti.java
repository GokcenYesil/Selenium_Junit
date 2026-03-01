package tests.D12_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExistTesti {


    @Test
    public void fileTest01 (){


// D12 package'i altinda deneme.txt dosyasinin
        // var oldugunu test edin

        String filePath="C:\\Users\\Gökçen\\IdeaProjects\\Team168_JUnit\\src\\test\\java\\tests\\D12_fileTestleri\\deneme.txt";

        System.out.println(Files.exists(Paths.get(filePath)));

        Assertions.assertTrue(Files.exists(Paths.get(filePath)));


// D12 package'i altinda deneme1.txt dosyasinin
        // var olmadigini test edin
        String filePath2="C:\\Users\\Gökçen\\IdeaProjects\\Team168_JUnit\\src\\test\\java\\tests\\D12_fileTestleri\\deneme1.txt";

        System.out.println(Files.exists(Paths.get(filePath2)));

        Assertions.assertFalse(Files.exists(Paths.get(filePath2)));



// downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

    String filePathMyPc="C:\\Users\\Gökçen\\Downloads\\deneme.txt";

    Assertions.assertTrue(Files.exists(Paths.get(filePathMyPc)));


    }


}
