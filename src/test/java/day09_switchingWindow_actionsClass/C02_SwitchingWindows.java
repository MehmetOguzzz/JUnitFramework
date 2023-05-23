package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwitchingWindows extends TestBase {
    /*
       driver.switchTo().newWindow() kullanarak actigimiz
       window'a driver otomatik olarak gecer

       ANCAKKKKK....
       biz newWindow() method'unu kullanmadan
       bir link tikladigimizda yeni window aciliyorsa
       driver eski window'da kalir
       Yeni window'a driver'i gecirebilmek icin
       yeni window'un WindowHandleDegerine ihtiyacimiz vardir.

    */
    @Test
    public void Test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        WebElement openingNewWindowElementi=driver.findElement(By.tagName("h3"));

        String expectedText = "Opening a new window";

        String actualIcerik = openingNewWindowElementi.getText();

        Assert.assertEquals(expectedText, actualIcerik);

        String ilkSayfaWND = driver.getWindowHandle();

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";

        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

        //● Click Here butonuna basın.

        driver.findElement(By.xpath("//*[text() = 'Click Here']")).click();

        Set<String> whDegerleriSet = driver.getWindowHandles();

        String ikinciWindowWHD = "";

        for (String eachWHD : whDegerleriSet
        ) {
            if (!eachWHD.equals(ilkSayfaWND)) {
                ikinciWindowWHD = eachWHD;

                // Artik acilan 2.window'un windowHandleDegerine sahibiz

            }
        }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        driver.switchTo().window(ikinciWindowWHD);

        expectedTitle="New Window";

        actualTitle= driver.getTitle();

        Assert.assertEquals(expectedText,actualIcerik);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement windowsYaziElementi=driver.findElement(By.tagName("h3"));

        String expectedYazi="New Window";

        String actualYazi= driver.getTitle();

        Assert.assertEquals(expectedYazi,actualYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaWND);

         expectedTitle = "The Internet";

         actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

        Thread.sleep(3000);






    }









}
