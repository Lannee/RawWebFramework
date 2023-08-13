package code.response;

import java.util.Optional;
import java.util.stream.Stream;

public enum HTTPResponseStatus {
    CONTINUE(100),
    OK(200),
    CREATED(201),
    PAGE_NOT_FOUND(404);

    private final int code;

    HTTPResponseStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Optional<HTTPResponseStatus> getStatus(int code) {
        return Stream.of(HTTPResponseStatus.values()).filter(e -> e.getCode() == code).findFirst();
    }


    @Override
    public String toString() {
        return name().replace('_', ' ');
    }
}
