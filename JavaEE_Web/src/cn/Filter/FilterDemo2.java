package cn.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("要想过此路，流下买路钱");
        chain.doFilter(req, resp);
        System.out.println("好，你可以走了！");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init");
    }

}
