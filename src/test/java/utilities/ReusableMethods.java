package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    static WebDriver driver;

    public static void wait(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep Komutu Çalışmadı");


        }


    }

    public static List<String> returnStringList(List<WebElement> WebelementList) {

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement : WebelementList) {

            stringList.add(eachElement.getText());


        }

        return stringList;
    }

    public static void titleBasedWindowSwitch (WebDriver driver,String targetTitle){


        Set<String > allWindowWhv=driver.getWindowHandles();

        for (String eachWhv  :allWindowWhv ) {

            driver.switchTo().window(eachWhv);

            if (driver.getTitle().equals(targetTitle)){

                break;
            }


        }





    }

    public static void urlBasedWindowSwitch (WebDriver driver,String targetUrl){


        Set<String > allWindowsWhv=driver.getWindowHandles();

        for (String eachWdv  :allWindowsWhv ) {

            driver.switchTo().window(eachWdv);

            if (driver.getCurrentUrl().equals(targetUrl)){
                break;
            }

        }

    }

    public static void takeWholepageSS (WebDriver driver){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        String filePath="target/screenShots/wholePageSS.jpeg";

        File perpetualFile=new File(filePath);

        File temporaryFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile,perpetualFile);
        } catch (IOException e) {
            System.out.println("Couldn't capture screenshot");
        }


    }

    public static void takeWholepageSS (WebDriver driver,String reportName){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        String filePath="target/screenShots/"+reportName+".jpeg";

        File perpetualFile=new File(filePath);

        File temporaryFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile,perpetualFile);
        } catch (IOException e) {
            System.out.println("Couldn't capture screenshot");
        }






    }

    public static void datedTakeWholepageSS (WebDriver driver){


        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter formatedDate= DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String dateLabel=dateTime.format(formatedDate);



        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        String filePath="target/screenShots/wholePageSS"+dateLabel+".jpeg";

        File perpetualFile=new File(filePath);

        File temporaryFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile,perpetualFile);
        } catch (IOException e) {
            System.out.println("Couldn't capture screenshot");
        }


    }

    public static void datedtakeWholepageSS (WebDriver driver,String reportName){
        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter formatedDate= DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String dateLabel=dateTime.format(formatedDate);


        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        String filePath="target/screenShots/"+reportName+dateLabel+".jpeg";

        File perpetualFile=new File(filePath);

        File temporaryFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile,perpetualFile);
        } catch (IOException e) {
            System.out.println("Couldn't capture screenshot");
        }

    }

    public static void takeWebelementSS (WebElement webElement){
        String filePath="target/screenShots/WebElementss.jpeg";

        File perpetualFile=new File(filePath);

        File temporaryFile = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile,perpetualFile);
        } catch (IOException e) {
            System.out.println("Couldn't capture screenshot");
        }


    }

    public static void takeWebelementSS (WebElement webElement,String reportName){
        String filePath="target/screenShots/WebElementss"+reportName+".jpeg";

        File perpetualFile=new File(filePath);

        File temporaryFile = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile,perpetualFile);
        } catch (IOException e) {
            System.out.println("Couldn't capture screenshot");
        }


    }

    public static void datedtakeWebelementSS (WebElement webElement ){
        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter formatedDate= DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String dateLabel=dateTime.format(formatedDate);


        String filePath="target/screenShots/WebElementss"+dateLabel+".jpeg";

        File perpetualFile=new File(filePath);

        File temporaryFile = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile,perpetualFile);
        } catch (IOException e) {
            System.out.println("Couldn't capture screenshot");
        }


    }

    public static void datedtakeWebelementSS (WebElement webElement,String reportName){
        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter formatedDate= DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String dateLabel=dateTime.format(formatedDate);

        String filePath="target/screenShots/"+reportName+dateLabel+".jpeg";

        File perpetualFile=new File(filePath);

        File temporaryFile = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile,perpetualFile);
        } catch (IOException e) {
            System.out.println("Couldn't capture screenshot");
        }


    }
    }