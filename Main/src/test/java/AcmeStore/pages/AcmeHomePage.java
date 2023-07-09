package AcmeStore.pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AcmeHomePage {

    public static final String HOME_PAGE_LINK = "https://litecart.stqa.ru/en/";
    public static final String RUBBER_DUCKS_LINK = "https://litecart.stqa.ru/en/rubber-ducks-c-1/";
    public static final String SUBCATEGORY_LINK = "https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/";

    public SelenideElement
            selectHomePageBottom = $("nav#site-menu a i"),
            selectHomePageFooterBottom = $("nav#breadcrumbs ul li a"),
            selectRubberDuckBottom = $(".category-1 a"),
            checkRubberDuckElementList = $x("//ul[@class=\"list-horizontal\"]/li[3]"),
            selectSubcategoryBottom = $("ul li .category-2 a"),
            checkSubcategoryElementList = $x("//ul[@class=\"list-horizontal\"]/li[4]");

    public static void openPage() {
        open(HOME_PAGE_LINK);
    }

    public static String getMainPageLink() {
        return HOME_PAGE_LINK;
    }

    public static void assertLink(String link) {
        String currentLink = getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentLink, link);
    }
}