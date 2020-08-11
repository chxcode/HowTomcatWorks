package ex02.pyrmont;

import javax.servlet.Servlet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @ClassName ServletProcessor1
 * @Description 处理Servlet资源的HTTP请求
 * @Author changxuan
 * @Date 2020/8/11 下午10:20
 **/
public class ServletProcessor1 {
    public void process(Request request, Response response){
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/")+1);
        URLClassLoader loader = null;
        try {
            URL[] urls = new URL[1];
            URLStreamHandler urlStreamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);
            String repository = (new URL("file", null, classPath.getCanonicalPath()+File.separator)).toString();
            urls[0] = new URL(null, repository, urlStreamHandler);
            loader = new URLClassLoader(urls);
        }catch (IOException e){
            System.out.println(e.toString());
        }
        Class myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        }catch (ClassNotFoundException e){
            System.out.println(e.toString());
        }
        Servlet servlet = null;
        try {
            servlet = (Servlet) myClass.newInstance();
            servlet.service(request, response);
        }catch (Exception e){
            System.out.println(e.toString());
        }catch (Throwable t){
            System.out.println(t.toString());
        }
    }
}
