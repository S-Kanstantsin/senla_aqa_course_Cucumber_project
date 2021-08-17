package base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public  SelenideElement menuLink = $(By.id("react-burger-menu-btn"));
    public SelenideElement signOutLink = $(By.id("logout_sidebar_link"));
    public SelenideElement itemName = $("div[class='inventory_list']");
    public SelenideElement itemPrice = $("div[class='inventory_list']");

}
