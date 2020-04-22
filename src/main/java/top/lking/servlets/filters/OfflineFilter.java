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
import java.util.Arrays;

/**
 * 登录状态过滤器
 * @author Jason
 * @version 1.0
 * @date 4/21/2020 9:49 PM
 */
public class OfflineFilter implements Filter {
    private  FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }
    /**
     * 离线状态访问过滤
     * @author Jason
     * @date 10:14 AM 4/22/2020
     * @param  uri 访问页面标识
     * @param filterPages 过滤页面集
     * @return 返回是否为过滤页面
     */
    private boolean isContains(String uri,String filterPages){
        boolean result=false;
        for (String tempUri:filterPages.split(";")){
            if (uri.endsWith(tempUri))
                result=true;
        }
        return result;
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

        String uri=request.getRequestURI();
        String filterPages=filterConfig.getInitParameter(R.FilterParamName.FILTER_PAGES);
        String redirectPage=filterConfig.getInitParameter(R.FilterParamName.REDIRECT_PAGE);
        //如果所访问的页面为过滤页面
        if(isContains(uri,filterPages!=null?filterPages:R.FilterDefaultParamValue.DEFAULT_FILTER_PAGES)){

            //如果用户没有登录
            if (request.getSession(true).getAttribute(R.SessionParamName.USER)==null){

                response.sendRedirect(request.getContextPath()+redirectPage!=null?redirectPage:R.FilterDefaultParamValue.DEFAULT_REDIRECT_PAGE);
                return;
            }

        }
        //Test
        System.out.println("OfflineFilter执行了！");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
