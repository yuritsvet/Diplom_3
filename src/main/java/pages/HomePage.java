package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String site = "https://stellarburgers.nomoreparties.site/";

    public void openSite() {
        driver.get(site);
    }
    public By personalOfficeButton = By.xpath("//*[@id=\"root\"]/div/header/nav/a"); //Кнопка Личный кабинет
    public By registrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a"); //Кнопка Зарегистрироваться внизу формы Вход
    public By nameRegistration = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input"); //поле ввода имени
    public By emailRegistration = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input"); //поле ввода почты
    public By passwordRegistration = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input"); //поле ввода пароля
    public By registrationConfirmButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button"); //Кнопка Зарегистрироваться в форме регистрации для подтверждения
    public By formEnterToAccountTitle = By.cssSelector(".Auth_login__3hAey > h2"); //заголовок формы Вход
    public By errorForInvalidPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");
    public By textEnterFormTitle = By.xpath("//*[text()='Вход']"); //локатор заголовка формы Вход
    public By enterToAccountButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button"); //Кнопка Войти в аккаунт на главной странице
    public By enterButtonDownForm = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a"); //Кнопка Войти внизу формы
    public By passwordRecoveryButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a"); //Кнопка Восстановить пароль
    public By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p"); //Кнопка Конструктор на главной странице
    public By textConstructorTitle = By.xpath("//*[@id=\"root\"]/div/main/section[1]/h1"); //Заголовок конструктора "Соберите бургер"
    public By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a"); //Логотип на главной странице
    public By emailEnter = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input"); //Поле ввода почты в форме Вход
    public By passwordEnter = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input"); //поле ввода пароля в форме Ввод
    public By enterButtonFormLogin = By.xpath("//*[@id=\"root\"]/div/main/div/form/button"); //Кнопка Войти внизу формы Вход на странице логина
    public By exitButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button"); //Кнопка Выход в разделе Личный кабинет
    public By textExitButtonTitle = By.xpath("//*[text()='Выход']"); //Кнопка Выход
    public By textCreateOrder = By.xpath("//*[text()='Оформить заказ']");

    private final By bunsButtonSection = By.xpath(".//span[text()='Булки']");
    private final By bunsButtonSectionClass = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    private final By saucesButtonSection = By.xpath(".//span[text()='Соусы']");
    private final By saucesButtonSectionClass = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    private final By fillingsButtonSection = By.xpath(".//span[text()='Начинки']");
    private final By fillingsButtonSectionClass = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");

    public void standBy(By element) {
        (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public void clickPersonalOfficeButton() {
        driver.findElement(personalOfficeButton).click();
    }
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    public void fillNameRegistration(String name) {
        driver.findElement(nameRegistration).sendKeys(name);
    }
    public void fillEmailRegistration(String email) {
        driver.findElement(emailRegistration).sendKeys(email);
    }
    public void fillPasswordRegistration(String password) {
        driver.findElement(passwordRegistration).sendKeys(password);
    }
    public String getNameFormEnterToAccount() {
        return driver.findElement(formEnterToAccountTitle).getText(); //геттер названия формы Вход
    }
    public String getNameErrorRegistration() {
        return driver.findElement(errorForInvalidPassword).getText(); //геттер текста ошибки при некорректном пароле
    }
    public void clickRegistrationConfirmButtonWithWait() {
        driver.findElement(registrationConfirmButton).click(); //клик по кнопке Зарегистрироваться
        standBy(textEnterFormTitle);
    }
    public void clickRegistrationConfirmButton() {
        driver.findElement(registrationConfirmButton).click(); //клик по кнопке Зарегистрироваться
    }
    public void clickEnterToAccountButtonWithWait() {
        driver.findElement(enterToAccountButton).click();
        standBy(textEnterFormTitle);
    }
    public void clickEnterButtonDownForm() {
        driver.findElement(enterButtonDownForm).click();
        standBy(textEnterFormTitle);
    }
    public void clickRecoveryPasswordButton() {
        driver.findElement(passwordRecoveryButton).click();
    }
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
        standBy(textConstructorTitle);
    }
    public String getTextConstructorTitle() {
        return driver.findElement(textConstructorTitle).getText(); //"Соберите бургер"
    }
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
        standBy(textConstructorTitle);
    }
    public void fillEmailEnter(String email) {
        driver.findElement(emailEnter).sendKeys(email);
    }
    public void fillPasswordEnter(String password) {
        driver.findElement(passwordEnter).sendKeys(password);
    }
    public void clickEnterButtonFormLogin() {
        driver.findElement(enterButtonFormLogin).click();
        standBy(textCreateOrder);
    }
    public void clickExitButton() {
        standBy(textExitButtonTitle);
        driver.findElement(exitButton).click();
        standBy(textEnterFormTitle);
    }
    public String getTextCreateOrder() {
        return driver.findElement(textCreateOrder).getText();
    }
    public void clickBunsButton() {
        driver.findElement(bunsButtonSection).click();
    }
    public void clickSaucesButton() {
        driver.findElement(saucesButtonSection).click();
    }
    public void clickFillingsButton() {
        driver.findElement(fillingsButtonSection).click();
    }
    public String getSauceClass() {
        return driver.findElement(saucesButtonSectionClass).getAttribute("class");
    }
    public String getBunClass() {
        return driver.findElement(bunsButtonSectionClass).getAttribute("class");
    }
    public String getFillingsClass() {
        return driver.findElement(fillingsButtonSectionClass).getAttribute("class");
    }
}