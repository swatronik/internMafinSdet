package herokuapp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SelectCollectionTest {

    private final static String URL = "https://the-internet.herokuapp.com/";

    @Test
    public void openSiteAndParseLinks() {
        Selenide.open(URL);
        ElementsCollection collect = $$("div#content a[href]");
        List<String> listWithLinks = new ArrayList<>();
        for (SelenideElement el : collect) {
            listWithLinks.add(el.getAttribute("href"));
        }
        String drag_and_drop_URL = listWithLinks.get(9);
        open(drag_and_drop_URL);

        String currentLink = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentLink, drag_and_drop_URL);
    }
}