package day09_switchingWindow_actionsClass;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_NewWindow extends TestBase {
     /*
        Eger driver.switchTo().newWindow() kullanilirsa
        driver otomatik olarak acilan yeni sayfaya gecer

        eger gorevimizde yeni window'a gittik'ten sonra
        window'lar arasi gecis islemi varsa
        uzerinde calistigimiz window'larin
        windowHandleDegerlerini alip kaydetmekte fayda var

     */

    //● Yeni bir class olusturun: WindowHandle
    //● Amazon anasayfa adresine gidin.
    //● title'in Amazon kelimesi icerdigini test edin
    //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
    //● Sayfa title’nin “wisequarter” icerdigini test edin

    @Test
    public void Test01() throws InterruptedException {
        // ● Yeni bir class olusturun: WindowHandle ● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        String ilkWindowWHD = driver.getWindowHandle();

        //● title'in Amazon kelimesi icerdigini test edin

        String expectedIcerik="Amazon";

        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin

        driver.switchTo().newWindow(WindowType.TAB);

        Thread.sleep(1000);

        driver.get("https://www.wisequarter.com");

        String ikinciWindowWHD= driver.getWindowHandle();

        //● url'in “wisequarter” icerdigini test edin

        expectedIcerik="wisequarter";

        actualTitle= driver.getCurrentUrl();

        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        // tekrar amazon'un acik oldugu sayfaya gecin
        // ve url'in amazon icerdigini test edin

        driver.switchTo().window(ilkWindowWHD);

        expectedIcerik = "amazon";

        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        Thread.sleep(3000);


    }


}
