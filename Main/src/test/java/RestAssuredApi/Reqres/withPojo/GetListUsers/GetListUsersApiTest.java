package RestAssuredApi.Reqres.withPojo.GetListUsers;

import RestAssuredApi.Reqres.withPojo.Specification;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetListUsersApiTest {

    GetListUsersPojo getListUsersPojo = new GetListUsersPojo();

    @Test
    @Description("Тест проверяет поля Json файла, полученного в ответе")
    public void getAndCheckUsersListTest() {
        Specification.InstallSpecification(Specification.requestSpec(getListUsersPojo.URL_MAIN), Specification.responseSpecOK200());

        //проверка части json с Data
        List<GetListUsersPojo.UserData> usersData = given()
                .when()
                .get(getListUsersPojo.USERS_LIST_PAGE1)
                .then().log().all()
                .extract().body().jsonPath().getList("data", GetListUsersPojo.UserData.class);

        //проверка что у аватара есть ид
        usersData.stream().forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString()))); //стрим проверки(разобрать)
        //проверка что email оканчивается на @reqres.in
        Assert.assertTrue(usersData.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

        //проверка части Json с Root
        GetListUsersPojo.Root rootData = given()
                .when()
                .get(getListUsersPojo.USERS_LIST_PAGE1)
                .then().log().all()
                .extract().body().as(GetListUsersPojo.Root.class);

        Integer page = 1;
        Integer per_page = 6;
        Integer total = 12;
        Integer total_pages = 2;
        Assert.assertEquals(rootData.getPage(), page);
        Assert.assertEquals(rootData.getPer_page(), per_page);
        Assert.assertEquals(rootData.getTotal(), total);
        Assert.assertEquals(rootData.getTotal_pages(), total_pages);

        String urlSupport = "https://reqres.in/#support-heading";
        String textSupport = "To keep ReqRes free, contributions towards server costs are appreciated!";
        Assert.assertEquals(rootData.getSupport().getUrl(), urlSupport);
        Assert.assertEquals(rootData.getSupport().getText(), textSupport);
    }
}