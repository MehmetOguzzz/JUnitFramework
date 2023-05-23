package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionsClass extends TestBase {
    @Test
    public void Test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin

        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin

        WebElement ciziliAlanElementi = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(ciziliAlanElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedYazi = "You selected a context menu";

        String actualYazi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedYazi, actualYazi);

        //5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim

        //  linki tikladigimizda yeni window acildigindan

        //  tiklamadan once ilk window'un WHD almamiz gerekir

        String ilkWindowWHD = driver.getWindowHandle();

        driver.findElement(By.linkText("Elemental Selenium")).click();

        // ikinci sayfa biz newWindow() demeden acildigindan

        // ikinciWindow'un WHD'ini Java kullanarak bulmaliyiz

        String ikinciWindowWHd = "";

        Set<String> handleWhDegerleri = driver.getWindowHandles();

        for (String eachWHD : handleWhDegerleri
        ) {
            if (!eachWHD.contains(ilkWindowWHD)) {

                ikinciWindowWHd = eachWHD;
            }
        }
        driver.switchTo().window(ikinciWindowWHd);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        WebElement elementalYazi=driver.findElement(By.tagName("h1"));

        String expectedIcerik="Elemental Selenium";

        String actualIcerik= elementalYazi.getText();

        Assert.assertEquals(expectedIcerik,actualIcerik);

        Thread.sleep(5000);

    }
}
