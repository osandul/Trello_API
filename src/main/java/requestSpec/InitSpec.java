package requestSpec;

import basePage.BasePage;
import config.TimeOutConstantas;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import properties.PropertyLoader;

public class InitSpec {

    BasePage j = new BasePage();

    public static RestAssuredConfig getCustomTimeOut(RestAssuredConfig restAssuredConfig) {
        return restAssuredConfig.httpClient(HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout", TimeOutConstantas.DEFAULT_TIMEOUT_30_000_MS)
                .setParam("http.socket.timeout", TimeOutConstantas.DEFAULT_TIMEOUT_100_000_MS));
    }

    public static RequestSpecification createBoardSpec = new RequestSpecBuilder()
            .setConfig(getCustomTimeOut(RestAssuredConfig.config()))
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath(PropertyLoader.getProperty("board_path"))
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            //.setConfig(RestAssured.config = RestAssured.config().httpClient(HttpClientConfig.httpClientConfig().reuseHttpClientInstance()))
            .build();


    public static RequestSpecification deleteBoardSpec = new RequestSpecBuilder()
            .setConfig(getCustomTimeOut(RestAssuredConfig.config()))
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath(PropertyLoader.getProperty("board_path"))
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            .build();

    public static RequestSpecification getAllBoardsSpec = new RequestSpecBuilder()
            .setConfig(getCustomTimeOut(RestAssuredConfig.config()))
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath(PropertyLoader.getProperty("members_path") + "me/boards")
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            .build();

    public static RequestSpecification createListSpec = new RequestSpecBuilder()
            .setConfig(getCustomTimeOut(RestAssuredConfig.config()))
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath(PropertyLoader.getProperty("list_path"))
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            .build();


    public static RequestSpecification createCardSpec = new RequestSpecBuilder()
            .setConfig(getCustomTimeOut(RestAssuredConfig.config()))
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath(PropertyLoader.getProperty("card_path"))
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            .build();
}


