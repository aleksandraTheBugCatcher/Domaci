//Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru, izabrati opciju Lukovi -
// Bows iz leve navigacije, potom kliknuti na luk koji se zove Samick Sage,
// i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://www.strela.co.rs/");

        WebElement prodavnicaBtn = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span/strong"));
        prodavnicaBtn.click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "/html/body/form/div[4]/div/section/div/div[2]/div/div[1]/div[2]/ul/li[1]/div/span[3]")));

        WebElement lukoviBows = driver.findElement(By.xpath(
                "/html/body/form/div[4]/div/section/div/div[2]/div/div[1]/div[2]/ul/li[1]/div/span[3]"));
        lukoviBows.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")));
        WebElement samickSage = driver.findElement(By.xpath
                ("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        samickSage.click();

        String imeLuka = driver.findElement(By.id(
                "ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel")).getText();
        if (imeLuka.contains("Samick")){
            System.out.println("Ime luka zaista sadrzi rec Samick.");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();


    }

}
