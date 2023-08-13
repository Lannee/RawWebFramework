package code.server;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Server {

    private static Server instance = null;

    private Server() {
        instance = this;
    }

    public final static int DEFAULT_PORT = 8888;

    private ConnectionListener portListener;

    public static Server getInstance() {
        return instance != null ? instance : (instance = new Server());
    }

    public boolean start(int port) {
        try {
            portListener = new ConnectionListener(port);
            portListener.setDaemon(true);
            portListener.start();
            return true;
        } catch (IOException | IllegalArgumentException e) {
            return false;
        }
    }

    public boolean start() {
        return start(DEFAULT_PORT);
    }


    public boolean terminate() {
        portListener.interrupt();
        return true;
    }
}
