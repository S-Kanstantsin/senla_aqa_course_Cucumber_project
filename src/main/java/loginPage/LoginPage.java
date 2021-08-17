package loginPage;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage  extends BasePage{

    public SelenideElement loginField = $("#user-name");
    public SelenideElement passwordField = $("#password");
    public SelenideElement signInButton = $(By.name("login-button"));

    public void login() throws IOException {
        InputStream input = new FileInputStream("src/main/resources/user.properties");
        Properties prop = new Properties();
        prop.load(input);
        loginField.sendKeys(prop.getProperty("user.username"));
        passwordField.sendKeys(prop.getProperty("user.password"));
        signInButton.click();
    }
    public void openLoginPage(){
        open("https://www.saucedemo.com/");
    }
}
