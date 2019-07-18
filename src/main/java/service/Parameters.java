package service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;



@Getter
@Setter
public class Parameters {
    private Map<String, String> pathParameters = new HashMap<>();
    private Map<String, String> queryParameters = new HashMap<>();
    private Map<String, String> headerParameters = new HashMap<>();
    private Map<String, String> cookieParameters = new HashMap<>();
    private String basePath = null;
    private String baseUrl = null;
    private HttpMethod httpMethod;
    private Object body = null;




    //<editor-fold desc="Enums">
    @AllArgsConstructor
    public enum ParameterType {
        EMPTY_PARAMETER(""),
        PATH_PARAMETER("pathParameter"),
        QUERY_PARAMETER("queryParameter"),
        HEADER_PARAMETER("headerParameter"),
        COOKIE_PARAMETER("cookieParameter"),
        BASE_PATH("basePath"),
        BASE_URL("baseUrl"),
        HTTP_METHOD("httpMethod"),
        BODY_CONTENT("bodyContent");

        private final String name;

        @Override
        public String toString() {
            return name;
        }
    }

    public enum HttpMethod {
        GET,
        POST,
        PUT,
        DELETE
    }
    //</editor-fold>


}
