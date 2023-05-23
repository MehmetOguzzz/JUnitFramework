package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {
    @Test
    public void Test() throws InterruptedException {

        //Yeni bir class olusturalim: MouseActions2

        //1- https://demoqa.com/droppable adresine gidelim

        driver.get(" https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragmeElementi = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement dropHereElementi = dragmeElementi.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(dragmeElementi, dropHereElementi).perform();

        Thread.sleep(4000);


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement droppedYazisi=driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String expectedYazi="Dropped!";

        String actualYazi=droppedYazisi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);


    }
}
