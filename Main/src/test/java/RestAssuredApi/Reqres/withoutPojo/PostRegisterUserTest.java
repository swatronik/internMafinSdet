package RestAssuredApi.Reqres.withoutPojo;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRegisterUserTest {

    public static Logger logger = LoggerFactory.getLogger(GetListUsersTest.class);

    UsersData usersData = new UsersData();

    @Test
    @Description("Тест проверяет регистрацию пользователя")
    public void registrationUserTest() {

        Response response = given()
                .baseUri(usersData.URL_MAIN)
                .contentType(ContentType.JSON)
                .body(usersData.getRegistrationUserDataList())
                .when()
                .post(usersData.REGISTER_USER_API)
                .then().log().all()
                .statusCode(200)
//                .body("id", equalTo(4))
//                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        String token = jsonPath.get("token");
        Assert.assertEquals(4, id);
        Assert.assertEquals("QpwL5tke4Pnpja7X4", token);
    }
}