package PageObjModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Objects {


    //fakelandingpage
@FindBy(id = "user-name")
    public static WebElement Username;

@FindBy(name="password")
         public static WebElement Password;

@FindBy(id="login-button")
    public static WebElement Login;
}
