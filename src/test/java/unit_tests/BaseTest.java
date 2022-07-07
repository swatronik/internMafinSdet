package unit_tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("This method run before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This method run after test");

    }
}
