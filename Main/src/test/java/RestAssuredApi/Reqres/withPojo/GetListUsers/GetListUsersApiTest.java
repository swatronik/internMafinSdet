package RestAssuredApi.Reqres.withPojo.GetListUsers;

import RestAssuredApi.Reqres.withPojo.Specification;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListUsersApiTest {

    public String URL_MAIN = "https://reqres.in/";
    public String USERS_LIST_PAGE1 = "/api/users?page=1";

    @Test
    @Description("Тест проверяет поля Json файла, полученного в ответе")
    public void getAndCheckUsersListTest() {
        Specification.InstallSpecification(Specification.requestSpec(URL_MAIN), Specification.responseSpecOK200());

        Integer page = 1;
        Integer per_page = 6;
        Integer total = 12;
        Integer total_pages = 2;
        String urlSupport = "https://reqres.in/#support-heading";
        String textSupport = "To keep ReqRes free, contributions towards server costs are appreciated!";
        String endsWith = "@reqres.in";

        GetListUsers.Root rootData = given()
                .when()
                .get(USERS_LIST_PAGE1)
                .then().log().all()
                .extract().as(GetListUsers.Root.class);

        //Root
        Assert.assertEquals(rootData.getPage(), page);
        Assert.assertEquals(rootData.getPer_page(), per_page);
        Assert.assertEquals(rootData.getTotal(), total);
        Assert.assertEquals(rootData.getTotal_pages(), total_pages);
        //Support
        Assert.assertEquals(rootData.getSupport().getUrl(), urlSupport);
        Assert.assertEquals(rootData.getSupport().getText(), textSupport);
        //Datum
        rootData.getData().stream().forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));      //проверка что у аватара есть ид (стрим проверки разобрать)
        Assert.assertTrue(rootData.getData().stream().allMatch(x -> x.getEmail().endsWith(endsWith)));                  //проверка что email оканчивается на @reqres.in
    }
}