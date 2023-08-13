package code.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionListener extends Thread {


    private int port;

    private final ServerSocket serverSocket;


    public ConnectionListener(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try(serverSocket) {

            while ( serverSocket.isBound() && !serverSocket.isClosed() && !Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                if(Thread.interrupted()) break;

                HttpConnectionWorkerThread workerThread = new HttpConnectionWorkerThread(socket);
                workerThread.setDaemon(true);
                workerThread.start();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
