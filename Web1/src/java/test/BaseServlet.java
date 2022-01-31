package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.*;

public class BaseServlet extends GenericServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Base init");
    }

    @Override
    public void destroy() {
        System.out.println("Base destroy");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<title>Servlet</title>");            
            out.print("</head>");
            out.print("<body>");
            out.print(new java.util.Date());
            out.print("</body>");
            out.println("</html>");  
        }
    }
}
