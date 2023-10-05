import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class MyTest {

    private final static String URL = "https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0";
    private final static String LOCATOR_SEARCH = "[name='search']";
    private final static String YEAR_MOSCOW = "[data-wikidata-property-id='P1249']";

    private WebDriver webDriver;

    @BeforeTest
    private void init() {
    }

    @BeforeMethod
    private void initWebDriver() throws MalformedURLException {
        String urlToRemoteWD = "http://192.168.1.150:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>(){{
            put("enableVNC", true);
        }});
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(urlToRemoteWD), capabilities);
        remoteWebDriver.manage().window().maximize();
        WebDriverRunner.setWebDriver(remoteWebDriver);
    }

    @Test
    public void test1() {
        Selenide.open(URL);
        SelenideElement search = $(By.name("search"));
        search.setValue("Москва");
        $(By.className("suggestions")).shouldBe(Condition.visible);
        search.sendKeys(Keys.ENTER);
        Assert.assertEquals(Selenide.webdriver().driver().url(), "https://ru.wikipedia.org/wiki/%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0");
        Assert.assertEquals($(By.cssSelector(YEAR_MOSCOW)).getText(), "1147 год");
    }

    @Test
    public void test2() {
        Selenide.open(URL);
        SelenideElement search = $(By.name("search"));
        search.setValue("Москва");
        $(By.className("suggestions")).shouldBe(Condition.visible);
        search.sendKeys(Keys.ENTER);
        Assert.assertEquals(Selenide.webdriver().driver().url(), "https://ru.wikipedia.org/wiki/%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0");
        Assert.assertEquals($(By.cssSelector(YEAR_MOSCOW)).getText(), "1147 год");
    }

    @AfterMethod
    private void closeWebDriver() {
        Selenide.webdriver().driver().close();
    }
}
