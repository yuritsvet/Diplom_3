import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.assertEquals;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.User;
import pages.UserClient;
import java.util.Random;

public class EnterTest {
    private WebDriver driver;
    private String expectedTextCreateOrder = "Оформить заказ";
    private String name = "Иван";
    Random random = new Random();
    private String email = random.nextInt(1000000) + "@ya.ru";
    private String password = "111111";
    private String accessToken;

    @Before
    public void setUp() {
        UserClient userClient = new UserClient();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        ValidatableResponse response = userClient.create(user);
        accessToken = response.extract().path("accessToken").toString();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();
        homePage.openSite();
    }

    @Test
    @DisplayName("Проверка входа по кнопке \"Войти\" в аккаунт на главной")
    public void successEnterToAccountButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickEnterToAccountButtonWithWait();
        homePage.fillEmailEnter(email);
        homePage.fillPasswordEnter(password);
        homePage.clickEnterButtonFormLogin();
        String actualEnterToAccountButton = homePage.getTextCreateOrder();
        assertEquals("Не корректный результат", expectedTextCreateOrder, actualEnterToAccountButton);
    }

    @Test
    @DisplayName("Проверка входа через кнопку Личный кабинет")
    public void successEnterToPersonalOfficeTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalOfficeButton();
        homePage.fillEmailEnter(email);
        homePage.fillPasswordEnter(password);
        homePage.clickEnterButtonFormLogin();
        String actualEnterToAccountButton = homePage.getTextCreateOrder();
        assertEquals("Не корректный результат", expectedTextCreateOrder, actualEnterToAccountButton);
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void successEnterToRegistrationFormTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickEnterToAccountButtonWithWait();
        homePage.clickRegistrationButton();
        homePage.clickEnterButtonDownForm();
        homePage.fillEmailEnter(email);
        homePage.fillPasswordEnter(password);
        homePage.clickEnterButtonFormLogin();
        String actualEnterToAccountButton = homePage.getTextCreateOrder();
        assertEquals("Не корректный результат", expectedTextCreateOrder, actualEnterToAccountButton);
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void successEnterToPasswordRecoveryFormTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickEnterToAccountButtonWithWait();
        homePage.clickRecoveryPasswordButton();
        homePage.clickEnterButtonDownForm();
        homePage.fillEmailEnter(email);
        homePage.fillPasswordEnter(password);
        homePage.clickEnterButtonFormLogin();
        String actualEnterToAccountButton = homePage.getTextCreateOrder();
        assertEquals("Не корректный результат", expectedTextCreateOrder, actualEnterToAccountButton);
    }

    @After
    public void teardown() {
        UserClient userClient = new UserClient();
        driver.quit();
        if (accessToken != null) {
            userClient.delete(accessToken);
        }
    }
}