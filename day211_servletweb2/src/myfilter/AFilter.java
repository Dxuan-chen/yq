package myfilter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(value = "/*")
public class AFilter implements Filter {

    /**
    * 过滤器核心方法，此方法处理拦截逻辑
    * 必须参数username=tom，才不作拦截处理，否则作拦截处理，重新返回登录页
    */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
