package pyrmont.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName HttpConnector
 * @Description
 * @Author changxuan
 * @Date 2020/8/13 下午9:32
 **/
public class HttpConnector implements Runnable {
    boolean stopped;
    private String scheme = "http";

    public String getScheme(){
        return this.scheme;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        while (!stopped){
            // Accept the next incoming connection from the server socket
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            }catch (Exception e){
                continue;
            }
            // Hand this socket off to an HttpProcessor
            HttpProcessor processor = new HttpProcessor(this);
            processor.process(socket);
        }
    }

    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }
}
