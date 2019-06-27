package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import properties.PropertyLoader;

import java.util.HashMap;
import java.util.Map;

public class StepDefs {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String boardName;

    @When("I create a new board with name {name}")
    public void i_create_a_new_board_with_name(Name name) {
        Map<String, String> params = new HashMap<>();
        params.put("name", name.toString());
        params.put("key", PropertyLoader.getProperty("key"));
        params.put("token", PropertyLoader.getProperty("token"));

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        response = given().headers(headers).queryParams(params).when().post(PropertyLoader.getProperty("ROOT_API_URL") + "1/boards/");
    }

    @Then("I check that server handles it and returns a success status")
    public void serverHandlesItAndReturnASuccessStatus() {
        json = response.then().assertThat().statusCode(200);
    }

    @And("I check that the name {name} is set correctly")
    public void checksThatTheNameIsSetCorrectly(Name name) {
        JsonPath jsonPathEvaluator = response.jsonPath();
       boardName = jsonPathEvaluator.get("name");
        Assert.assertEquals(boardName, name.toString());
    }

    @And("I get id of board {name}")
    public void iGetIdOfBoardBOARD()  {
        JsonPath jsonPathEvaluator = response.jsonPath();
   //     boardId = jsonPathEvaluator.get("id");

        }
}
