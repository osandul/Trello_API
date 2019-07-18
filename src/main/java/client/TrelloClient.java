//package client;
//
//import config.TimeOutConstantas;
//import exceptions.ApiException;
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.config.HttpClientConfig;
//import io.restassured.config.LogConfig;
//import io.restassured.config.RestAssuredConfig;
//import io.restassured.filter.log.LogDetail;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.joda.time.DateTime;
//import properties.PropertyLoader;
//import service.Parameters;
//
//import java.io.PrintStream;
//import java.io.StringWriter;
//import java.net.SocketTimeoutException;
//
//import static io.restassured.RestAssured.given;
//
//public class TrelloClient {
//
//    public Response getResponse(Parameters parameters) {
//        return getResponse(parameters);
//    }
//
//    public void completeWithDefaultParameters(Parameters parameters) {
//        parameters.setBaseUrl(PropertyLoader.getProperty("ROOT_API_URL"));
//    }
//
//    private RestAssuredConfig getCustomTimeOut(RestAssuredConfig restAssuredConfig) {
//        return restAssuredConfig.httpClient(HttpClientConfig.httpClientConfig()
//                .setParam("http.connection.timeout", TimeOutConstantas.DEFAULT_TIMEOUT_30_000_MS)
//                .setParam("http.socket.timeout", TimeOutConstantas.DEFAULT_TIMEOUT_100_000_MS));
//    }
//
//    private RequestSpecification requestGlobal(Parameters parameters, PrintStream captor) {
//        completeWithDefaultParameters(parameters);
//        RestAssuredConfig restAssuredConfig = getCustomTimeOut(RestAssuredConfig.config()
//                .logConfig(new LogConfig(captor, true)));
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        requestSpecBuilder.setConfig(restAssuredConfig);
//        requestSpecBuilder.addPathParams(parameters.getPathParameters());
//        requestSpecBuilder.addQueryParams(parameters.getQueryParameters());
//        requestSpecBuilder.addHeaders(parameters.getHeaderParameters());
//        requestSpecBuilder.addCookies(parameters.getCookieParameters());
//        requestSpecBuilder.setBasePath(parameters.getBasePath());
//        requestSpecBuilder.setBaseUri(parameters.getBaseUrl());
//        requestSpecBuilder.log(LogDetail.ALL);
//        return requestSpecBuilder.build();
//    }
//
//    public static <R> R convertResponse(Response response, Class<R> className) {
//        try {
//            return response.getBody().as(className);
//        } catch (Exception e) {
//            throw new ApiException(String.format("Cannot cast response to class '%s'. Response%n%s%nReason%n%s",
//                    className,
//                    response.prettyPrint(),
//                    e.getMessage()), response);
//        }
//    }
//}