package excelPanic;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;



public class GetRequestTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }

    @Test
    public void postNewEmployee() {
        // Установка базовой URL
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        // Запрос
        RequestSpecification httpRequest = RestAssured.given();

        // Создание объекта JSON
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "John");
        requestParams.put("salary", "123456");
        requestParams.put("age", "30");

        // Добавление заголовка с типом содержимого
        httpRequest.header("Content-Type", "application/json");

        // Добавление JSON в тело запроса
        httpRequest.body(requestParams.toString());

        // Отправка POST запроса
        Response response = httpRequest.request(Method.POST, "/create");

        // Получение тела ответа в формате JSON
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        // Проверка статуса кода ответа
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }













//
//
//    @Test
//    @DisplayName("Тестирование запроса Get c проверкой status code = 200")
//    public void getRequestCheckStatusCode() {
//        RestAssured.given()
//                .spec(requestSpecification())//---> Указание RequestSpecification для формирования request
//                .get("/api/users/2")//---> Endpoint для выполнения запроса GET
//                .then()
//                .statusCode(HttpStatus.SC_OK);//---> Проверка статус код
//    }
//
//    @Test
//    @DisplayName("Тестирование запроса Get c проверкой key/value по полям id, email, first_name, last_name")
//    public void getRequestCheckResponseJsonBody() {
//        RestAssured.given()
//                .spec(requestSpecification())//---> Указание RequestSpecification для формирования request
//                .get("/api/users/2")//---> Endpoint для выполнения запроса GET
//                .then()
//                .statusCode(HttpStatus.SC_OK)//---> Проверка статус код
//                .assertThat()
//                .body("data.id", Matchers.is(2))//---> Проверка Body по key и value в json
//                .body("data.email", Matchers.is("janet.weaver@reqres.in"))//---> Проверка Body по key и value в json
//                .body("data.first_name", Matchers.is("Janet"))//---> Проверка Body по key и value в json
//                .body("data.last_name", Matchers.is("Weaver"));//---> Проверка Body по key и value в json
//    }
//
//    @Test
//    @DisplayName("Тестирование запроса Get c валидацией ответа по json схеме")
//    public void getRequestCheckResponseWithJsonSchema() {
//        RestAssured.given()
//                .spec(requestSpecification())//---> Указание RequestSpecification для формирования request
//                .get("/api/users/2")//---> Endpoint для выполнения запроса GET
//                .then()
//                .spec(responseSpecificationScOk())//---> Указание ResponseSpecification
//                .assertThat();
//                //.body(matchesJsonSchemaInClasspath("SchemaUsersById.json"));//---> Валидация Response json по Json Schema.
//        // Сгенерировать Json Schema можно https://www.liquid-technologies.com/online-json-to-schema-converter и далее создать файл
//        // SchemaUsersById.json в каталоге src/test/resources.
//        // !!!Внимание по умолчанию вычитывается из папки resources помеченной как ресурсы тестов в проекте
//
//    }
}

