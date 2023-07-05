package AcmeStore.pages;

import AcmeStore.pages.AcmeHomePage;
import com.codeborne.selenide.WebDriverRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests {

    public static Logger logger = LoggerFactory.getLogger(HomePageTests.class);


    @Test
    void HomePageLinkTest() {
        AcmeHomePage.openPage();
        String currentLink = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentLink, AcmeHomePage.getMainPageLink());
        logger.info(AcmeHomePage.getMainPageLink());
    }

}
