package code.request;

import code.response.HTTPVersion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTTPRequest {

    private HTTPVersion version;
    private HTTPRequestMethod method;
    private String requestPath;
    private Map<String, String> headers = new TreeMap<>();
    private String requestText;

    public HTTPRequest(String text) {
        requestText = text;
    }

    public HTTPRequest(byte[] byteText) {
        this(new String(byteText));
    }

    public static HTTPRequest get(InputStream stream) throws IOException {
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        return new HTTPRequest(bytes);
    }

    @Override
    public String toString() {
        return requestText;
    }

    public void parseRequest() throws InvalidHTTPRequestFormat {
        parseRequest(requestText);
    }

    public void parseRequest(String request) throws InvalidHTTPRequestFormat {

        String methods = String.join("|", Arrays.stream(HTTPRequestMethod.values())
                .map(Enum::toString)
                .toList());
        
        Pattern httpMatchPattern = Pattern.compile("(" + methods +") (/[^\s\n]*) (HTTP/(0\\.9|1\\.0|1\\.1|2\\.0))\r\n" +
                "Host: ([-A-Za-z0-9$_.+!*'()]+)(:(\\d{1,5}))?\r\n");

        Matcher matcher = httpMatchPattern.matcher(request);
        if(!matcher.find()) throw new InvalidHTTPRequestFormat(request);

        try {

            Optional<HTTPVersion> requestVersion = HTTPVersion.of(matcher.group(3));
            if (requestVersion.isPresent())
                version = requestVersion.get();
            else
                throw new InvalidHTTPRequestFormat("Invalid protocol version");

            method = HTTPRequestMethod.valueOf(matcher.group(1));
            requestPath = matcher.group(2);
        } catch (IllegalStateException e) {
            throw new InvalidHTTPRequestFormat("Request has invalid format");
        }
    }

    public HTTPVersion getVersion() {
        return version;
    }

    public HTTPRequestMethod getMethod() {
        return method;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getRequestText() {
        return requestText;
    }
}
