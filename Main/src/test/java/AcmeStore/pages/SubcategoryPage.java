package AcmeStore.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SubcategoryPage {
    public static final String SUBCATEGORY_PAGE_LINK = "https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/";

    public SelenideElement subcategoryPageTitle = $x("//*[@id=\"box-category\"]/h1");
    public SelenideElement nameButton = $x("//nav/a[text()='Name']");
    public SelenideElement priceButton = $x("//nav/a[text()='Price']");
    public SelenideElement popularityButton = $x("//nav/a[text()='Popularity']");
    public SelenideElement dateButton = $x("//nav/a[text()='Date']");

    public ArrayList<String> getListDuck() {
        ArrayList<String> listDuck = new ArrayList<>();
        listDuck.add("Green Duck");
        listDuck.add("Yellow Duck");
        return listDuck;
    }

    public ElementsCollection ducksList = $$x("//*[@id=\"box-category\"]/div/ul/li");

    public SelenideElement yellowDuckLabelSale = $x("//div/ul/li[1]/a[1]/div[1]/div");

    public void openSubcategoryPage() {
        open(SUBCATEGORY_PAGE_LINK);
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