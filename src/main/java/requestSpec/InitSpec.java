package requestSpec;

import config.TimeOutConstantas;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.config.RequestConfig;
import properties.PropertyLoader;

public class InitSpec {

    public static RequestSpecification createBoardSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath("/1/boards/")
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            //.setConfig(RestAssured.config = RestAssured.config().httpClient(HttpClientConfig.httpClientConfig().reuseHttpClientInstance()))
            .build();


    public static RequestConfig config = RequestConfig.custom()
            .setConnectTimeout(TimeOutConstantas.DEFAULT_TIMEOUT_30_000_MS)
            .setConnectionRequestTimeout(TimeOutConstantas.DEFAULT_TIMEOUT_30_000_MS)
            .setSocketTimeout(TimeOutConstantas.DEFAULT_TIMEOUT_30_000_MS)
            .build();

    public static RequestSpecification deleteBoardSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath("/1/boards/")
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            .build();

    public static RequestSpecification getAllBoardsSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath("/1/members/me/boards")
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            .build();

    public static RequestSpecification createListSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath("/1/list")
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            .build();


    public static RequestSpecification createCardSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .setBasePath("/1/cards")
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token", PropertyLoader.getProperty("token"))
            .build();

}


