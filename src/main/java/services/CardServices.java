//package services;
//
//import client.TrelloClient;
//import io.restassured.response.Response;
//import responses.baseResponses.BoardBodyResponse;
//import responses.baseResponses.CardBodyResponse;
//import service.Parameters;
//
//
//public class CardServices extends TrelloClient {
//
//    public CardBodyResponse createCard(Parameters parameters) {
//        parameters.setBasePath("/1/cards");
//        parameters.setHttpMethod(Parameters.HttpMethod.POST);
//        Response response = getResponse(parameters);
//        return convertResponse(response, CardBodyResponse.class);
//    }
//}
