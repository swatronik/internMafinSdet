package AcmeStore.pages;

import static com.codeborne.selenide.Selenide.open;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcmeHomePage {

    private static final String HOME_PAGE_LINK = "https://litecart.stqa.ru/en/";

    public static void openPage() {
        open(HOME_PAGE_LINK);
    }

    public static String getMainPageLink() {
        return HOME_PAGE_LINK;
    }






}
