package steps;

import common.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static common.ScenarioContext.Context.*;
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


    @When("I create a new board with name {name}")
    public void i_create_a_new_board_with_name(Name name) {
        Map<String, String> boardParams = new HashMap<>();
        boardParams.put("name", name.toString());
        boardParams.put("key", PropertyLoader.getProperty("key"));
        boardParams.put("token", PropertyLoader.getProperty("token"));

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        response = given().headers(headers).queryParams(boardParams).when().post(PropertyLoader.getProperty("ROOT_API_URL") + "1/boards/");
    }

    @Then("I check that server handles it and returns a success status")
    public void serverHandlesItAndReturnASuccessStatus() {
        json = response.then().assertThat().statusCode(200);
    }

    @And("I check that the name {name} is set correctly")
    public void checksThatTheNameIsSetCorrectly(Name name) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get("name"), name.toString());
    }

    @And("I get id of board and save to context")
    public void iGetIdOfBoardAndSaveToContext()  {
        JsonPath jsonPathEvaluator = response.jsonPath();
        ScenarioContext.setContext(BOARD_ID,jsonPathEvaluator.get("id"));
        }

    @When("I create a new list with name {name}")
    public void iCreateANewListWithNameTO_DO(Name name)  {
            Map<String, String> listParams = new HashMap<>();
            listParams.put("name", name.toString());
            listParams.put("idBoard", ScenarioContext.getContext(BOARD_ID).toString());
            listParams.put("key", PropertyLoader.getProperty("key"));
            listParams.put("token", PropertyLoader.getProperty("token"));

            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");

            response = given().headers(headers).queryParams(listParams).when().post(PropertyLoader.getProperty("ROOT_API_URL") + "1/lists");

    }
}
