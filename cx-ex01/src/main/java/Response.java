import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * @ClassName Reponse
 * @Description
 * @Author changxuan
 * @Date 2020/8/9 下午2:32
 **/
public class Response {

    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream outputStream;

    public Response (OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void setRequest(Request request){
        this.request = request;
    }

    public void sendStaticResource() throws Exception{
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()){
                String message = "HTTP/1.1 200 OK\r\n"+
                        "Content-Type: text/html\r\n"+
                        "\r\n";
                outputStream.write(message.getBytes());
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1){
                    outputStream.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            }else {
                // file not found
                String message = "HTTP/1.1 404 File Not Found\r\n"+
                        "Content-Type: text/html\r\n"+
                        "Content-Length: 23\r\n"+
                        "\r\n"+
                        "<h1>404 File Not Found</h1>by ChangXuan";
                outputStream.write(message.getBytes());
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            if (fis != null)
                fis.close();
        }
    }
}
