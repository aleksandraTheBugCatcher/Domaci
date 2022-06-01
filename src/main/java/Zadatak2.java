//Napisati dva smoke testa za https://www.telerik.com/support/demos:
//Proveriti da klikom na Desktop odlazimo na tu sekciju
//Proveriti da klikom na Mobile odlazimo na tu sekciju
//Koristiti TestNG, asserte.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Zadatak2 {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://www.telerik.com/support/demos");
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void clickDesktop(){
        String desktopBtn = driver.findElement(By.xpath(
                "//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]")).getText();
        String desktopTitle = driver.findElement(By.id("desktop")).getText();
        Assert.assertEquals(desktopBtn, desktopTitle);
    }

    @Test
    public void clickMobile(){
        String mobileBtn = driver.findElement(By.xpath(
                "//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]")).getText();
        String mobileTitle = driver.findElement(By.id("mobile")).getText();
        Assert.assertEquals(mobileBtn, mobileTitle);
    }
}
