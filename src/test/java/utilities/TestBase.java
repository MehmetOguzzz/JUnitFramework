package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         /*
        TestBase class'ini
        bu class'i parent edinecek class'larda
        driver olusturmamak ve ayarlari yeniden yapmamak icin kullaniyoruz
     */


    }
    @After
    public void tearndown(){
        driver.quit();
    }

}
