package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentSteps {
    private Response response;

    @Before
    public void setup() {
        RestAssured.defaultParser = Parser.JSON;
    }

    @When("I check the details of student {int}")
    public void i_check_the_details_of_student(Integer studentId) {
        RestAssured.baseURI = "https://it-foundations.app.ap.assurity.cloud/";
        response = RestAssured.get("people/" + studentId);
        System.out.println(response.asString());
    }

    @Then("I can see that their name is {string}")
    public void i_can_see_that_their_name_is(String expectedName) {
        String firstName = response.path("firstName");
        String lastName = response.path("lastName");
        assertEquals(expectedName, firstName + ' ' + lastName);
    }

    @Then("they have a {string} from {string}")
    public void they_have_a_from(String expectedDegree, String expectedUniversity) {
        String degree = response.path("degree");
        String university = response.path("university");
        assertEquals(expectedDegree, degree);
        assertEquals(expectedUniversity, university);
    }
}
