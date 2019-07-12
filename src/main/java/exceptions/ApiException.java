package exceptions;

import io.restassured.response.Response;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private Response response;
    private int statusCode;

    //<editor-fold desc="Constructors">
    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Response response) {
        super(message);
        this.response = response;
        this.statusCode = response.getStatusCode();
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    protected ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    //</editor-fold>
}