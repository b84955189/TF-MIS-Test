package top.lking.servlets.filters;

import top.lking.utils.R;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在线状态访问过滤
 * @author Jason
 * @version 1.0
 * @date 4/22/2020 11:53 AM
 */
public class OnlineFileter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //如果过滤器被关闭
        if(R.FilterDefaultParamValue.FILTER_SWITCH_OFF.equals(filterConfig.getInitParameter(R.FilterParamName.FILTER_SWITCH))){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;

        String forwardPage=filterConfig.getInitParameter(R.FilterParamName.FORWARD_PAGE);
        //如果用户已经登录
        if (request.getSession(true).getAttribute(R.SessionParamName.USER)!=null){
            request.getRequestDispatcher(forwardPage!=null?forwardPage:R.FilterDefaultParamValue.DEFAULT_FORWARD_PAGE).forward(request,response);
            return;
        }
            filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
