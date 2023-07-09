package AcmeStore.tests;

import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static AcmeStore.pages.AcmeHomePage.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePageTests extends BaseTest {

    //какой нормальный логгер взять. Непонятно что происходит в логах теста?
    public static Logger logger = LoggerFactory.getLogger(HomePageTests.class);


    @BeforeMethod
    public void openMainPage() {
        acmeHomePage.openPage();
    }

    @Test(description = "тест проверяет ссылку на главной странице")
    public void HomePageLinkTest() {
        String currentLink = getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentLink, acmeHomePage.getMainPageLink());
        logger.info(acmeHomePage.getMainPageLink());
    }

    @Test(description = "тест нажимает кнопку HomePage и проверяет открывшуюся ссылку")
    public void HomePageBottomTest() {
        acmeHomePage.selectHomePageBottom.click();
        assertLink(acmeHomePage.getMainPageLink());
    }

    @Test(description = "тест нажимает кнопку RubberDuck и проверяет открывшуюся ссылку")
    public void RubberDuckBottomTest() {
        acmeHomePage.selectRubberDuckBottom.shouldHave(text("Rubber Ducks")).click();
        assertLink(RUBBER_DUCKS_LINK);
        acmeHomePage.checkRubberDuckElementList.shouldHave(text(" » Rubber Ducks"));
    }

    @Test(description = "тест нажимает кнопку Subcategory и проверяет открывшуюся ссылку")
    public void SubcategoryBottomTest() {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(acmeHomePage.selectRubberDuckBottom).perform();
        acmeHomePage.selectSubcategoryBottom.shouldHave(text("Subcategory")).click();
        assertLink(SUBCATEGORY_LINK);
        acmeHomePage.checkSubcategoryElementList.shouldHave(text(" » Subcategory"));
    }
}