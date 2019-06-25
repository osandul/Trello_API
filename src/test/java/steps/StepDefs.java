package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
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

    private static final String ROOT_API_URL = "https://api.trello.com/";

    @When("I create a new board with name {string}")
    public void i_create_a_new_board_with_name(String boardName) {
        this.boardName = boardName;
        Map<String, String> params = new HashMap<>();
        params.put("name", boardName);
        params.put("key", PropertyLoader.getProperty("key"));
        params.put("token", PropertyLoader.getProperty("token"));

        response = given().header("Content-Type","application/json").queryParams(params).when().post(ROOT_API_URL + "1/boards/");
    }

    @Then("Server handles it and returns a success status")
    public void serverHandlesItAndReturnASuccessStatus() {
        json = response.then().assertThat().statusCode(200);
    }

    @And("Checks that the name is set correctly")
    public void checksThatTheNameIsSetCorrectly() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        String name = jsonPathEvaluator.get("name");
        Assert.assertTrue(name.equalsIgnoreCase(boardName));
    }
}
