package abc;
import java.io.IOException;
import javax.servlet.*;
        
public class MyFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void destroy() {}
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        System.out.println("before");
        chain.doFilter(request, response);
        System.out.println("after 21");
    }
}
