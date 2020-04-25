package top.lking.servlets;

import top.lking.bean.Page;
import top.lking.db.control.LoveQQDBControl;
import top.lking.db.interfaces.LoveQQDBControlInterface;
import top.lking.utils.R;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 信息搜索模块
 * @author Jason
 * @version 1.0
 * @date 4/14/2020 7:38 PM
 * @describe:
 */
@WebServlet("/search.do")
public class TestSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Page page=null;
        LoveQQDBControl loveQQDBControl = new LoveQQDBControl();
        String snippet=request.getParameter(R.RequestParamName.TYPE_USER_LOGIN);
        String currentCountString=request.getParameter(R.RequestParamName.PAGE_COUNT);
        page=loveQQDBControl.paginationQuery(LoveQQDBControlInterface.LOVE_QQ_USER_TABLE,snippet,currentCountString);



        //绑定数据
        request.setAttribute(R.RequestParamName.CURRENT_DATA,page);
        //转发至展示页---注意在服务器内部调用的路径与浏览器调用的路径问题--下面注释掉的，在服务器里是错误的，注意理解！！！之所以要加contextPath，是为了前端找资源的。
//        request.getRequestDispatcher(request.getContextPath()+R.FrontPageNames.SHOW_PAGE).forward(request,response);
          request.getRequestDispatcher(R.FrontPageNames.SHOW_PAGE).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
