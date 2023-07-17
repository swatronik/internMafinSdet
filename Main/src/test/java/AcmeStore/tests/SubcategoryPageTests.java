package AcmeStore.tests;

import AcmeStore.pages.AcmeHomePage;
import AcmeStore.pages.SubcategoryPage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static AcmeStore.pages.SubcategoryPage.SUBCATEGORY_PAGE_LINK;
import static com.codeborne.selenide.Selenide.$;

public class SubcategoryPageTests extends BaseTest {

    public static Logger logger = LoggerFactory.getLogger(SubcategoryPageTests.class);

    @BeforeMethod
    public void openSubcategoryPage() {
        subcategoryPage.openSubcategoryPage();
    }

    SubcategoryPage subcategoryPage = new SubcategoryPage(); //? правильно ли создавать обьект в before method ?

    @Test(description = "тест проверяет ссылку на странице: subcategory")
    public void SubcategoryPageLinkTest() {
        AcmeHomePage.assertLink(SUBCATEGORY_PAGE_LINK);
    }

    @Test(description = "тест проверяет заголовок страницы: subcategory")
    public void SubcategoryPageTitleTest() {
        subcategoryPage.subcategoryPageTitleCheck();
    }

    @Test(description = "тест проходит по кнопкам сортировки нажимая их и проверяя порядок сортировки")
    public void SortButtonsCheckTest() {
        subcategoryPage.nameButtonClick();
        $(By.xpath("//*[@id=\"box-category\"]/div/ul/li[1]")).shouldHave(Condition.text("Green Duck"));
        $(By.xpath("//*[@id=\"box-category\"]/div/ul/li[2]")).shouldHave(Condition.text("Yellow Duck"));
        subcategoryPage.priceButtonClick();
        $(By.xpath("//*[@id=\"box-category\"]/div/ul/li[2]")).shouldHave(Condition.text("Green Duck"));
        $(By.xpath("//*[@id=\"box-category\"]/div/ul/li[1]")).shouldHave(Condition.text("Yellow Duck"));
        subcategoryPage.popularityButtonClick();
        subcategoryPage.dateButtonClick();
    }

    @Test(description = "тест проверяем что у YellowDuck есть лейбл sale")
    public void SaleLabelYellowDuckCheckTest() {
        subcategoryPage.openSubcategoryPage();
        subcategoryPage.labelYellowDuckCheck();
    }
}