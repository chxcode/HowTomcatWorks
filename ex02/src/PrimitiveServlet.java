import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * @ClassName PrimitiveServlet
 * @Description 简单的Servlet
 * @Author changxuan
 * @Date 2020/8/11 下午9:29
 **/
public class PrimitiveServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter printWriter = servletResponse.getWriter();
        printWriter.println("hello, Chang Xuan");
        printWriter.print("hello");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
