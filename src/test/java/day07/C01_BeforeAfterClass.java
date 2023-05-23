package day07;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

    public class C01_BeforeAfterClass {

    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    @BeforeClass
        public static void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }
    @AfterClass
        public static void tearndown(){
        driver.close();
    }

        //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        @Test
        public void titleTest(){

        String expectedTitle="YouTube";

        String actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }
        //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        @Test
        public void imageTest(){
        WebElement logoTest= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));

        Assert.assertTrue(logoTest.isDisplayed());

        }
        @Test
        public void SearchBoxTest(){

            //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())

            WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='search']"));

            Assert.assertTrue(aramaKutusu.isEnabled());

        }
        @Test
        public void wrongTitleTest(){

            //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

            String expectedTitle="youtube";

            String actualTitle= driver.getTitle();

            Assert.assertNotEquals(expectedTitle,actualTitle);
        }


    }




