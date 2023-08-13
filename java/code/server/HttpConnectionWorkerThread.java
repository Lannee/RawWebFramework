package code.server;

import code.request.HTTPRequest;
import code.request.InvalidHTTPRequestFormat;
import code.response.HTTPResponse;
import code.response.HTTPResponseStatus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread {
    private final Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try(socket;
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {

            HTTPRequest request = HTTPRequest.get(inputStream);

            HTTPResponse response = new HTTPResponse();
            try {
                request.parseRequest();

                System.out.println(request.getRequestPath());

                response.setContent("Hello");
                System.out.println(response);

                outputStream.write(response.toString().getBytes());

            } catch (InvalidHTTPRequestFormat e) {
                response.setContent("Invalid request");
                response.setStatus(HTTPResponseStatus.PAGE_NOT_FOUND);

                outputStream.write(response.toString().getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}