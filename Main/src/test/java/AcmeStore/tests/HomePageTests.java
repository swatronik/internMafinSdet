package AcmeStore.tests;

import AcmeStore.pages.AcmeHomePage;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePageTests extends AcmeHomePage {

    public static Logger logger = LoggerFactory.getLogger(HomePageTests.class);

    //какой нормальный логгер взять. Непонятно что происходит в логах теста?

    @Test(description = "тест проверяет ссылку на главной странице")
    void HomePageLinkTest() {
        AcmeHomePage.openPage();
        String currentLink = getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentLink, AcmeHomePage.getMainPageLink());
        logger.info(AcmeHomePage.getMainPageLink());
    }

    @Test(description = "тест нажимает кнопку HomePage и проверяет открывшуюся ссылку")
    void HomePageBottomTest() {
        AcmeHomePage.openPage();
        selectHomePageBottom.click();
        assertLink(getMainPageLink());
    }

    @Test(description = "тест нажимает кнопку RubberDuck и проверяет открывшуюся ссылку")
    void RubberDuckBottomTest() {
        AcmeHomePage.openPage();
        selectRubberDuckBottom.shouldHave(text("Rubber Ducks")).click();
        assertLink(RUBBER_DUCKS_LINK);
        checkRubberDuckElementList.shouldHave(text(" » Rubber Ducks"));
    }

    @Test(description = "тест нажимает кнопку Subcategory и проверяет открывшуюся ссылку")
    void SubcategoryBottomTest() {
        AcmeHomePage.openPage();
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(selectRubberDuckBottom).perform();
        selectSubcategoryBottom.shouldHave(text("Subcategory")).click();
        assertLink(SUBCATEGORY_LINK);
        checkSubcategoryElementList.shouldHave(text(" » Subcategory"));
    }
}