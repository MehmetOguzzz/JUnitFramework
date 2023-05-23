package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_JSAlerts extends TestBaseBeforeClassAfterClass {
    /*
    Otomasyon yaparken iki tur alert ile karsilasabiliriz
        1- HTML alerts :
    //HTML kodlari ile olusturulmus alert'lerdir
    HTML ile olusturuldugu icin inspect edilebilir,
    locate edilebilir ve driver ile kullanilabilir

        2- JavaScript Alerts :
    Inspect yapilamaz, locate edilemez
    Testlerimiz sirasinda JS alert ile karsilasirsak
    driver.switchTo().alert() method'larini kullanarak
    alert'e gecis yapabilir ve alert uzerinde
    OK, Cancel, Alert yazisini alma getText()
    ve alert'e yazi yollama sendKeys()
    method'larini kullanabiliriz.
            */

    @Test
    public void Test01() throws InterruptedException {
        //1. Test
        //-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //-  1.alert'e tiklayin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        //-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        Thread.sleep(3000);
        String expectedYazi = "I am a JS Alert";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, actualYazi);

        //-  OK tusuna basip alert'i kapatin

        driver.switchTo().alert().accept();

    }

    @Test
    public void Test02() throws InterruptedException {

        //            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //            - 2.alert'e tiklayalim
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        //            - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi);


    }

    @Test
    public void Test03() throws InterruptedException {

        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);

        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);

        //- Cikan prompt ekranina "Abdullah" yazdiralim

        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(3000);
        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        Thread.sleep(3000);
        String expectedIcerik = "Abdullah";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));


    }

}
