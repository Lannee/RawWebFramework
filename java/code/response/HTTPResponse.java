package code.response;

import java.util.Map;
import java.util.TreeMap;

public class HTTPResponse {

    private final static String CRLF = "\r\n";

    private HTTPVersion protocolVersion = HTTPVersion.HTTP1_1;
    private HTTPResponseStatus status = HTTPResponseStatus.OK;
    private final Map<String, String> headers = new TreeMap<>();
    private String content;

    public HTTPVersion getProtocolVersion() {
        return protocolVersion;
    }

    public HTTPResponseStatus getStatus() {
        return status;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getContent() {
        return content;
    }

    public void setProtocolVersion(HTTPVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public void setStatus(HTTPResponseStatus status) {
        this.status = status;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder responseHead = new StringBuilder();
        responseHead.append(protocolVersion.toString()).append(" ").append(status.getCode()).append(" ").append(status).append(CRLF);
        headers.forEach((u, v) -> responseHead.append(u).append(":").append(v).append(CRLF));
        responseHead.append("Content-Length: ").append(content.length()).append(CRLF);
        responseHead.append(CRLF);
        responseHead.append(content);
        responseHead.append(CRLF).append(CRLF);
        return responseHead.toString();
    }
}
