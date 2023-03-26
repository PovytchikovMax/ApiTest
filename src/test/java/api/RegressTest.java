package api;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RegressTest {
    /**
     * Тестировались запросы на основе документации.
     * Для тестирования необходимы библиотеки "rest-assured" и "junit", выбраны последние релизы.
     */

    public final static String URL = "https://file.io/";

    @Test
    public void firstFileNotFoundTest(){

        Specifications.installSpec(Specifications.requestSpec(URL),Specifications.responseSpec404());

        given()
                .when()
                .get("2ojE41")
                .then()
                .body("code", equalTo("FILE_NOT_FOUND"));
    }

    @Test
    public void secondStatusCodeTest404(){

        Specifications.installSpec(Specifications.requestSpec(URL),Specifications.responseSpec404());

        given()
                .when()
                .get("pgiPc2")
                .then()
                .body("help", equalTo("https://file.io/help/api/errors/FILE_NOT_FOUND"));
    }
}
