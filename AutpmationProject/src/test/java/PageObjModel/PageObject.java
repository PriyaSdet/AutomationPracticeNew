package PageObjModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class PageObject {

    @Test


    public static void main(String[] args) {


        //System.setProperty("webdriver.http.factory","jdk-http-client");
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohan\\IdeaProjects\\AutpmationProject\\driver\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote -allow-origins=*");
//        DesiredCapabilities capabilities = new DesiredCapabilities(options);
//        capabilities.setAcceptInsecureCerts(true);
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//       capabilities.setCapability("browser_version", "133.0.6998.166");
      //  WebDriver driver = new ChromeDriver();

        System.setProperty("webdriver.edge.driver","C:\\\\Users\\\\mohan\\\\IdeaProjects\\\\AutpmationProject\\\\driver\\msedgedriver.exe");
      WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");

       PageFactory.initElements(driver, Objects.class);
       Objects.Username.sendKeys("standard_user");
       Objects.Password.sendKeys("secret_sauce");
       Objects.Login.click();
        Assertion assertion = new Assertion();
         assertion.assertEquals(driver.getTitle(), "Swag Labs");
        {
            System.out.println(driver.getTitle());
        }
    }

}
