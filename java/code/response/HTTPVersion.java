package code.response;

import java.util.Arrays;
import java.util.Optional;

public enum HTTPVersion {

    HTTP0_9("HTTP/0.9"),
    HTTP1_0("HTTP/1.0"),
    HTTP1_1("HTTP/1.1"),
    HTTP2_0("HTTP/2.0");

    private String stringView;


    HTTPVersion(String stringView) {
        this.stringView = stringView;
    };

    public static Optional<HTTPVersion> of(String textView) {
        return Arrays.stream(values()).filter(e -> e.stringView.equals(textView)).findFirst();
    }

    @Override
    public String toString() {
        return stringView;
    }
}
