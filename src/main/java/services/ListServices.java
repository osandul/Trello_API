package services;

import client.TrelloClient;
import io.restassured.response.Response;
import responses.baseResponses.ListBodyResponse;
import service.Parameters;

public class ListServices extends TrelloClient {


    public ListBodyResponse createList(Parameters parameters) {
        parameters.setBasePath("/1/lists");
        parameters.setHttpMethod(Parameters.HttpMethod.POST);
        Response response = getResponse(parameters);
        return convertResponse(response, ListBodyResponse.class);
    }
}
