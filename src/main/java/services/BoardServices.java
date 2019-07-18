//package services;
//
//
//import client.TrelloClient;
//import io.restassured.response.Response;
//import properties.PropertyLoader;
//import responses.baseResponses.BoardBodyResponse;
//import service.Parameters;
//
//public class BoardServices extends TrelloClient {
//
//    public BoardBodyResponse createBoard(Parameters parameters) {
//        parameters.setBasePath("/1/boards/");
//        parameters.setHttpMethod(Parameters.HttpMethod.POST);
//        Response response = getResponse(parameters);
//        return convertResponse(response, BoardBodyResponse.class);
//    }
//
//    public BoardBodyResponse deleteBoard(Parameters parameters){
//        parameters.setBasePath("/1/boards/");
//        parameters.setHttpMethod(Parameters.HttpMethod.DELETE);
//        Response response = getResponse(parameters);
//        return convertResponse(response, BoardBodyResponse.class);
//    }
//
//}
