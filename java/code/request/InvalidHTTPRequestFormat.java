package code.request;

public class InvalidHTTPRequestFormat extends Exception {

    public InvalidHTTPRequestFormat() {
        this("HTTP request has invalid format");
    }

    public InvalidHTTPRequestFormat(String message) {
        super(message);
    }

    public InvalidHTTPRequestFormat(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidHTTPRequestFormat(Throwable cause) {
        super(cause);
    }
}
