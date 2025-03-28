package Windowhandle;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;


public class WhandlingExample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\mohan\\IdeaProjects\\AutpmationProject\\driver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        String oldwindow =driver.getWindowHandle();
       WebElement NewWindowClickBtn = driver.findElement(By.id("newWindowBtn"));

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
       // WebElement NewWindowClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("newWindowBtn")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", NewWindowClickBtn);
        NewWindowClickBtn.click();
        Set<String> handles =driver.getWindowHandles();

        for (String newwindow : handles) {
            driver.switchTo().window(newwindow);

        }
        //handling newwindow and fill the details in new windw

        driver.findElement(By.id("firstName")).sendKeys("priya");
        driver.findElement(By.id("lastName")).sendKeys("Ananth");
        driver.findElement(By.id("femalerb")).click();
        driver.findElement(By.id("englishchbx")).click();
        driver.findElement(By.id("email")).sendKeys("ananth@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("registerbtn")).click();
        driver.close();

        //opening newtab and handling alert
        driver.switchTo().window(oldwindow);
        Thread.sleep(1000);
        WebElement newtab = driver.findElement(By.id("newTabBtn"));
        newtab.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.id("alertBox")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().window(tabs.get(0));

        //multi windows





    }


}
