package RestAssuredApi.Reqres.withPojo.PostLogin;

import RestAssuredApi.Reqres.withPojo.PostCreateUser.PostCreateUserRequest;
import RestAssuredApi.Reqres.withPojo.PostCreateUser.PostCreateUserResponse;
import RestAssuredApi.Reqres.withPojo.Specification;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostLoginTests {

    @BeforeTest
    static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    @Description("Тест проверяет создание нового пользователя")
    public void createNewUserTest() {
        PostLoginRequest request = new PostLoginRequest();
        request.setEmail("eve.holt@reqres.in");
        request.setPassword("cityslicka");
        Specification.InstallSpecification(Specification.requestSpec(request.URL_MAIN), Specification.responseSpecOK200());

        PostLoginResponse response = given()
                .body(request)
                .when()
                .post(request.LOGIN_API)
                .then().log().all()
                .extract().as(PostLoginResponse.class);

        Assert.assertEquals( "QpwL5tke4Pnpja7X4", response.getToken());
    }
}