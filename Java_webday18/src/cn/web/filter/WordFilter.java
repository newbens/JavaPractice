package cn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class WordFilter implements Filter {
    //存放敏感词汇
    private List<String> list = new ArrayList<>();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //创建代理对象
        ServletRequest request = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                if (method.getName() == "getParameter") {
                    //增强返回值
                    String s = (String)method.invoke(req, args);
                    if (s != null) {
                        for (String li: list) {
                            if (s.contains(li)) {
                                s = s.replaceAll(li,"* ");
                            }
                        }
                    }
                    return s;
                }
                return method.invoke(req,args);
            }
        });
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        try {
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            InputStreamReader isr = new InputStreamReader(new FileInputStream(realPath), "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
