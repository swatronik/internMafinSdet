package AcmeStore.pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SubcategoryPage {
    public static final String SUBCATEGORY_PAGE_LINK = "https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/";

    public SelenideElement subcategoryPageTitle = $x("//*[@id=\"box-category\"]/h1");
    public SelenideElement nameButton = $x("//nav/a[text()='Name']");
    public SelenideElement priceButton = $x("//nav/a[text()='Price']");
    public SelenideElement popularityButton = $x("//nav/a[text()='Popularity']");
    public SelenideElement dateButton = $x("//nav/a[text()='Date']");

//    public SelenideElement greenDuckLink = $x("//*[@id=\"box-category\"]/div/ul/li[1]");
//    public SelenideElement yellowDuckLink = $x("//*[@id=\"box-category\"]/div/ul/li[2]");

    public SelenideElement yellowDuckLabelSale = $x("//div/ul/li[1]/a[1]/div[1]/div");


    public void openSubcategoryPage() {
        open(SUBCATEGORY_PAGE_LINK);
    }

    public String getMainPageLink() {
        return SUBCATEGORY_PAGE_LINK;
    }

    public static void assertLink(String link) {
        String currentLink = getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentLink, link);
    }

    public void subcategoryPageTitleCheck() {
        subcategoryPageTitle.shouldHave(text("Subcategory"));
    }

    public void nameButtonClick() {
        nameButton.shouldHave(text("Name")).click();
    }

    public void priceButtonClick() {
        priceButton.shouldHave(text("Price")).click();
    }

    public void popularityButtonClick() {
        popularityButton.shouldHave(text("Popularity")).click();
    }

    public void dateButtonClick() {
        dateButton.shouldHave(text("Date")).click();
    }

    public void labelYellowDuckCheck() {
        yellowDuckLabelSale.shouldHave(text("Sale"));
    }
}