package step;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.ru.*;
import loginPage.LoginPage;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Steps {
    LoginPage loginPage = new LoginPage();

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void openPage(String pageUrl) {
        loginPage.openLoginPage();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(pageUrl, currentUrl, "Открыта неверная страница");
    }

    @Когда("^в поле логин введено значение \"([^\"]*)\"$")
    public void fillLoginField(String userLogin) {

        loginPage.loginField.setValue(userLogin);
    }

    @И("^в поле пароль введено значение \"([^\"]*)\"$")
    public void fillPasswordField(String userPassword) {
        loginPage.passwordField.setValue(userPassword);
    }

    @И("нажата кнопка \"Login\"")
    public void clickSignButton() {
        loginPage.signInButton.click();
    }

    @Тогда("^выполнен переход на страницу \"([^\"]*)\"$")
    public void openProductPage(String siteUrl) {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(siteUrl, currentUrl, "Значения ссылок не сопадают");
    }

    @Допустим("^авторизованный пользователь находится на странице \"([^\"]*)\"$")
    public void authorizeCheck(String productUrl) throws IOException {

        loginPage.openLoginPage();
        loginPage.login();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(productUrl, currentUrl, "Пользователь не авторизован");
    }

    @Когда("^пользователь нажимает на всплывающее меню \"Open Menu\"")
    public void openSiteMenu() {

        loginPage.menuLink.click();
        Selenide.sleep(2000);
    }

    @И("^в меню выбирает ссылку \"Logout\"")
    public void LogOutLink() {
        loginPage.signOutLink.click();
    }

    @Тогда("^открывается страница входа \"([^\"]*)\"$")
    public void openLoginPage(String loginUrl) {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(loginUrl, currentUrl, "Переход на страницу логина не произошел");
    }

    @Допустим("^авторизованный пользователь находится на странице каталога \"([^\"]*)\"$")
    public void authorizePageItemCheck(String productUrl) throws IOException {

        loginPage.openLoginPage();
        loginPage.login();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(productUrl, currentUrl, "Пользователь не авторизован");
    }


    @И("^выполнено нажатие на ссылку \"([^\"]*)\"$")
    public void clickOnItemLink(String link) {
        loginPage.itemName.click();
    }

    @Тогда("^цена товара равна \"([^\"]*)\"$")
    public void checkItemPrice(String price) {
        String actualPriceInfo = loginPage.itemPrice.getText();
        assertTrue(actualPriceInfo.contains(price), "Актуальная и ожидаемая цена не совпадают");
    }

}
