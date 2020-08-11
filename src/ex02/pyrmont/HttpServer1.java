package ex02.pyrmont;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName HttpServer1
 * @Description
 * @Author changxuan
 * @Date 2020/8/11 下午9:53
 **/
public class HttpServer1 {

    // shutdown command
    private static final String SHUTDOWN_COMMAND = "shutdown";

    // shutdown init status
    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer1 httpServer1 = new HttpServer1();
        httpServer1.await();
    }

    public void await(){
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            // backlog:1 表示拒绝接收传入的请求之前，传入的连接请求的最大队列长度
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        while (!shutdown){
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                // Create Request Object and parse
                Request request  = new Request(input);
                request.parse();

                // Create Response Object
                Response response = new Response(output);
                response.setRequest(request);

                if (request.getUri().startsWith("/servlet/")){
                    ServletProcessor1 servletProcessor1 = new ServletProcessor1();
                    servletProcessor1.process(request, response);
                }else {
                    StaticResourceProcessor staticResourceProcessor = new StaticResourceProcessor();
                    staticResourceProcessor.process(request, response);
                }
                socket.close();
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            }catch (IOException e){
                e.printStackTrace();
                System.exit(1);
            }

        }
    }
}
