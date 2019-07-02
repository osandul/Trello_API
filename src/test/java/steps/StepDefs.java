package steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonObject;
import common.ScenarioContext;
import cucumber.api.java.en.And;
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
import java.util.List;
import java.util.Map;

public class StepDefs {

    private Response response;
    private ValidatableResponse validatableResponse;
    private RequestSpecification request;
    private String responseString;


    @When("I create a new board with name {name}")
    public void i_create_a_new_board_with_name(Name name) {
        Map<String, String> boardParams = new HashMap<>();
        boardParams.put("name", name.toString());
        boardParams.put("key", PropertyLoader.getProperty("key"));
        boardParams.put("token", PropertyLoader.getProperty("token"));

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        response = given().headers(headers).queryParams(boardParams).when().post(PropertyLoader.getProperty("ROOT_API_URL") + "/1/boards/");
    }

    @Then("I check that server handles it and returns a success status")
    public void serverHandlesItAndReturnASuccessStatus() {
        validatableResponse = response.then().assertThat().statusCode(200);
    }

    @And("I check that the name {name} is set correctly")
    public void checksThatTheNameIsSetCorrectly(Name name) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get("name"), name.toString());
    }

    @And("I get id of board and save to context")
    public void iGetIdOfBoardAndSaveToContext() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        ScenarioContext.setContext(BOARD_ID, jsonPathEvaluator.get("id"));
    }

    @When("I create a new list with name {name}")
    public void iCreateANewListWithNameTO_DO(Name name) {
        Map<String, String> listParams = new HashMap<>();
        listParams.put("name", name.toString());
        listParams.put("idBoard", ScenarioContext.getContext(BOARD_ID).toString());
        listParams.put("key", PropertyLoader.getProperty("key"));
        listParams.put("token", PropertyLoader.getProperty("token"));

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        response = given().headers(headers).queryParams(listParams).when().post(PropertyLoader.getProperty("ROOT_API_URL") + "/1/lists");

    }

    @And("I get id of the list and save to context")
    public void iGetIdOfTheListAndSaveToContext() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        ScenarioContext.setContext(LIST_ID, jsonPathEvaluator.get("id"));
    }

    @When("I create a new card with name {name}")
    public void iCreateANewCardWithNameCARD(Name name) {
        Map<String, String> cardParams = new HashMap<>();
        cardParams.put("name", name.toString());
        cardParams.put("idList", ScenarioContext.getContext(LIST_ID).toString());
        cardParams.put("key", PropertyLoader.getProperty("key"));
        cardParams.put("token", PropertyLoader.getProperty("token"));

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        response = given().headers(headers).queryParams(cardParams).when().post(PropertyLoader.getProperty("ROOT_API_URL") + "/1/cards");

    }

    @And("I get id of the card and save to context")
    public void iGetIdOfTheCardAndSaveToContext() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        ScenarioContext.setContext(CARD_ID, jsonPathEvaluator.get("id"));
    }

    @When("I get all board")
    public void iGetAllBoard()  {
        Map<String, String> baseParams = new HashMap<>();
        baseParams.put("key", PropertyLoader.getProperty("key"));
        baseParams.put("token", PropertyLoader.getProperty("token"));
        baseParams.put("fields","id");
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        response = given().headers(headers).queryParams(baseParams).when()
                .get(PropertyLoader.getProperty("ROOT_API_URL") + "/1/members/me/boards");
        String jsonExp = "$.delivery_codes";
        List<String> ids = JsonPath.read("$..id", response.body().asString());

        response.body().peek();
        JsonPath jsonPathEvaluator = response.jsonPath();
        validatableResponse = jsonPathEvaluator.get("id");

        response = given().headers(headers).queryParams(baseParams).when().delete(PropertyLoader.getProperty("ROOT_API_URL") + "1/boards/"+ validatableResponse);

    }
}
