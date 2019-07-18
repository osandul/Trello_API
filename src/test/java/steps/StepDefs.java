package steps;

// import com.jayway.jsonpath.JsonPath;

import common.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import requestSpec.InitSpec;
import responses.baseResponses.BoardBodyResponse;
import responses.baseResponses.CardBodyResponse;
import responses.baseResponses.ListBodyResponse;
import service.Parameters;

import static org.hamcrest.CoreMatchers.is;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.*;

import static common.ScenarioContext.Context.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public final class StepDefs {


    private ValidatableResponse response;
    private BoardBodyResponse boardBodyResponse;
    private ListBodyResponse listBodyResponse;
    private CardBodyResponse cardBodyResponse;
    private BoardBodyResponse allBoardsResponse;

    private List<BoardBodyResponse> bodiesList;


    @When("I create a new board with name {name}")
    public void i_create_a_new_board_with_name(Name name) {

        Map<String, String> boardParams = new HashMap<>();
        boardParams.put("name", name.toString());

        boardBodyResponse =
                given()
                        .spec(InitSpec.createBoardSpec)
                        .queryParams(boardParams)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(BoardBodyResponse.class);
    }


    @Then("I check that the name {name} is set correctly")
    public void checksThatTheNameIsSetCorrectly(Name name) {
        assertThat(boardBodyResponse.getName()).isEqualTo(name.toString());
    }

    @Then("I check that the list name {name} is set correctly")
    public void checksThatTheListNameIsSetCorrectly(Name name) {
        assertThat(listBodyResponse.getName()).isEqualTo(name.toString());
    }

    @Then("I check that the card name {name} is set correctly")
    public void checksThatTheCardNameIsSetCorrectly(Name name) {
        assertThat(cardBodyResponse.getName()).isEqualTo(name.toString());
    }


    @And("I get id of board and save to context")
    public void iGetIdOfBoardAndSaveToContext() {

        ScenarioContext.setContext(BOARD_ID, boardBodyResponse.getId());
    }

    @When("I create a new list with name {name}")
    public void iCreateANewListWithNameTO_DO(Name name) {
        Map<String, String> listParams = new HashMap<>();
        listParams.put("name", name.toString());
        listParams.put("idBoard", ScenarioContext.getContext(BOARD_ID).toString());


        listBodyResponse =
                given()
                        .spec(InitSpec.createListSpec)
                        .queryParams(listParams)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ListBodyResponse.class);
    }

    @And("I get id of the list and save to context")
    public void iGetIdOfTheListAndSaveToContext() {
        ScenarioContext.setContext(LIST_ID, listBodyResponse.getId());
    }

    @When("I create a new card with name {name}")
    public void iCreateANewCardWithNameCARD(Name name) {
        Map<String, String> cardParams = new HashMap<>();
        cardParams.put("name", name.toString());
        cardParams.put("idList", ScenarioContext.getContext(LIST_ID).toString());

        cardBodyResponse =
                given()
                        .spec(InitSpec.createCardSpec)
                        .queryParams(cardParams)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(CardBodyResponse.class);
    }

    @And("I get id of the card and save to context")
    public void iGetIdOfTheCardAndSaveToContext() {

        ScenarioContext.setContext(CARD_ID, cardBodyResponse.getId());
    }

    @When("I get response data and set it into list")
    public void iGetAllBoard() {
        response = given()
                .spec(InitSpec.getAllBoardsSpec)
                .when()
                .get()
                .then()
                .statusCode(200);

        bodiesList = Arrays.asList(response.extract().as(BoardBodyResponse[].class));
    }

    @Then("I get board ids and delete all the boards")
    public void iDeleteAllTheBoardsUsingTheListWithTheirIds() {

        bodiesList.forEach(b -> allBoardsResponse = given()
                .spec(InitSpec.deleteBoardSpec)
                .when()
                .delete(b.getId())
                .then()
                .statusCode(200)
                .extract()
                .as(BoardBodyResponse.class));
    }

    @Then("Check that the list of boards is empty")
    public void checkThatTheListOfBoardsIsEmpty() {
        assertTrue(bodiesList.isEmpty());
    }
}

