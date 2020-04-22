package top.lking.servlets.filters;

import top.lking.utils.R;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 全局编码设置
 * @author Jason
 * @version 1.0
 * @date 4/21/2020 10:06 PM
 */
public class EncodingFilter implements Filter {
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

        String encoding=filterConfig.getInitParameter(R.FilterParamName.ENCODING);
        String contentType=filterConfig.getInitParameter(R.FilterParamName.CONTENT_TYPE);
        //设置请求与响应编码
        servletRequest.setCharacterEncoding(encoding!=null?encoding:R.FilterDefaultParamValue.DEFAULT_ENCODING);
        servletResponse.setContentType(contentType!=null?contentType:R.FilterDefaultParamValue.DEFAULT_CONTENT_TYPE);

        //Test
        System.out.println("EncodingFilter执行了！");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
