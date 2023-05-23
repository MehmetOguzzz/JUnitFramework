package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {


    @Test

    public void Test01() throws InterruptedException {

        //1- https://www.amazon.com/ adresine gidin

        driver.get(" https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //   mouse’u bu menunun ustune getirin

        Actions actions = new Actions(driver);

        WebElement accountElementi = driver.findElement(By.xpath("//a[@id='nav-link-accountList'] "));

        actions.moveToElement(accountElementi).perform();


        //3- “Create a list” butonuna basin

        WebElement createListElementi = driver.findElement(By.xpath("//*[text()='Create a List']"));

        createListElementi.click();

        Thread.sleep(3000);

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        WebElement listElementi=driver.findElement(By.xpath("//div[@role='heading']"));

        String expectedYazi="Your Lists";

        String actualYazi=listElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);
    }


}
