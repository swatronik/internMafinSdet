package RestAssuredApi.Reqres.withPojo.GetSingleUser;

import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleUserApiTest {

    GetSingleUserPojo getSingleUserPojo = new GetSingleUserPojo();

    @Test
    @Description("Тест проверяет поля Json в ответе")
    public void getSingleUserTest() {

        GetSingleUserPojo.Root getDataSingleUser = given()
                .baseUri(getSingleUserPojo.URL_MAIN)
                .contentType(ContentType.JSON)
                .when()
                .get(getSingleUserPojo.USER_ONE)
                .then().log().all()
                .statusCode(200)
                .extract().body().as(GetSingleUserPojo.Root.class);

        //тестовые данные: ожидаемые результаты (куда спрятать?)
        Integer idData = 1;
        String email = "george.bluth@reqres.in";
        String first_name = "George";
        String last_name = "Bluth";
        String avatar = "https://reqres.in/img/faces/1-image.jpg";
        String url = "https://reqres.in/#support-heading";
        String text = "To keep ReqRes free, contributions towards server costs are appreciated!";

        //проверки
        Assert.assertEquals(getDataSingleUser.getData().getId(), idData.intValue());
        Assert.assertEquals(getDataSingleUser.getData().getEmail(), email);
        Assert.assertEquals(getDataSingleUser.getData().getFirst_name(), first_name);
        Assert.assertEquals(getDataSingleUser.getData().getLast_name(), last_name);
        Assert.assertEquals(getDataSingleUser.getData().getAvatar(), avatar);

        Assert.assertEquals(getDataSingleUser.getSupport().getUrl(), url);
        Assert.assertEquals(getDataSingleUser.getSupport().getText(), text);
        Assert.assertTrue(getDataSingleUser.getSupport().getText().contains("To keep ReqRes free"));
        Assert.assertTrue(getDataSingleUser.getSupport().getText().endsWith("appreciated!"));
        Assert.assertTrue(getDataSingleUser.getSupport().getText().equals(text));
        Assert.assertFalse(getDataSingleUser.getSupport().getText().isEmpty());
    }
}