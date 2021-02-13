package support;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebElement;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HxroRestWrapper {

    private String baseUrl = "https://uat.hxro.io/api/";
    private static String loginToken;

    private static Map<String, Object> userCreatedInfo;

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";
    private static JsonPath metadata;

    public static  Map<String, Object> getUserCreatedInfo() {
        return userCreatedInfo;
    }

    public void login(Map<String, Object> credentials) {

        // prepare

        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .header(CONTENT_TYPE, JSON)
                .body(credentials);

        // execute
        Response response = request
                .post(baseUrl + "Registration/register-user/");

        // verify and extract
        Map<String, String> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");
        loginToken = "Bearer " + result.get("token");
        // getMetadata();
    }

    public Map<String, Object> createUser(Map<String, String> userCreated) {


        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(userCreated);

        // execute
        Response resposne = request
                .post(baseUrl + " Account/by-user");

        // verify and extract
        Map<String, Object> result = resposne
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        userCreatedInfo = result;
        return result;
    }




















}
