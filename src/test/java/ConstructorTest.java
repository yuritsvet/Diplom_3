import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

public class ConstructorTest {

    private WebDriver driver;
    private String expectedTextConstructorTitle = "Соберите бургер";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();
        homePage.openSite();
    }

    @Test
    @DisplayName("Тест перехода в конструктор по клику \"Конструктор\" из Личного кабинета")
    public void successEnterToConstructorByClickConstructorTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalOfficeButton();
        homePage.clickConstructorButton();
        String actualTextConstructorTitle = homePage.getTextConstructorTitle();
        assertEquals("Не корректный результат", expectedTextConstructorTitle, actualTextConstructorTitle);
    }

    @Test
    @DisplayName("Тест перехода в конструктор по клику логотипа из Личного кабинета")
    public void successEnterToConstructorByClickLogoTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalOfficeButton();
        homePage.clickLogoButton();
        String actualTextConstructorTitle = homePage.getTextConstructorTitle();
        assertEquals("Не корректный результат", expectedTextConstructorTitle, actualTextConstructorTitle);
    }
    @Test
    @DisplayName("Перелючение в раздел Булки")
    public void successEnterToBunsTest() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", homePage.getBunClass());
    }
    @Test
    @DisplayName("Переключение в раздел Соусы")
    public void successEnterToSauceTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSaucesButton();
        Assert.assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", homePage.getSauceClass());
    }
    @Test
    @DisplayName("Переключение в раздел Ингредиенты")
    public void successEnterToFillingsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFillingsButton();
        Assert.assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", homePage.getFillingsClass());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}