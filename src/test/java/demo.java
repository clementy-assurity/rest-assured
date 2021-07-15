import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class demo {
    private ValidatableResponse getStudentById(Integer studentId) {
        return given()
            .baseUri("https://it-foundations.app.ap.assurity.cloud/")
            .contentType(ContentType.JSON)
            .when()
            .get("people/" + String.valueOf(studentId))
            .then()
            .statusCode(200);
    }

    @Test
    public void myTest() {
        getStudentById(2);
    }

}
