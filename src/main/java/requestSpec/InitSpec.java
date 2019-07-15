package requestSpec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import properties.PropertyLoader;


public class InitSpec {

    public static RequestSpecification spec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(PropertyLoader.getProperty("ROOT_URL"))
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", PropertyLoader.getProperty("key"))
            .addQueryParam("token",PropertyLoader.getProperty("token"))
            .build();
}


