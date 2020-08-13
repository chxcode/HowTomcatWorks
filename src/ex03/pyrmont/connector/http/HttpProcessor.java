package ex03.pyrmont.connector.http;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName HttpProcessor
 * @Description
 * @Author changxuan
 * @Date 2020/8/13 下午9:52
 **/
public class HttpProcessor {

    public void process(Socket socket){
        SocketInputStream input = null;
        OutputStream output = null;
        try {
            input = new SocketInputStream(socket.getInputStream(), 2048);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
