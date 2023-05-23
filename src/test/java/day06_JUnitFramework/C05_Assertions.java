package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {
    // 1) Bir class oluşturun: BestBuyAssertions
    // 2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    //    asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    WebDriver driver;
    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void Test01(){

        mahserin4Atlisi();

        String expectedElement="https://www.bestbuy.com/ ";

        String actualElement= driver.getCurrentUrl();

        Assert.assertEquals(expectedElement,actualElement);

    }
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        @Test
    public void Test02(){

        mahserin4Atlisi();

        String unExpectedElement="Rest";

        String actualElement= driver.getTitle();

        Assert.assertFalse(actualElement.contains(unExpectedElement));


        }
}










