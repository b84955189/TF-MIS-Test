package top.lking.servlets;

import top.lking.bean.User;
import top.lking.db.control.LoveQQDBControl;
import top.lking.db.interfaces.LoveQQDBControlInterface;
import top.lking.utils.R;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        List<User> list=new ArrayList<User>();
        LoveQQDBControl loveQQDBControl = new LoveQQDBControl();
        String snippet=request.getParameter(R.LoveQQSQLConfig.USER_LOGIN);
        //如果没有输入搜索片段---转发完整数据
        if(snippet==null||snippet.trim().equals("")){
            //list.addAll(loveQQDBControl.queryAll(LoveQQDBControlInterface.LOVE_QQ_USER_TABLE));
            snippet="";
        }
            //--转发检索数据
            //将数据填充至session
            list.addAll(loveQQDBControl.queryAll(LoveQQDBControlInterface.LOVE_QQ_USER_TABLE,snippet));

        //Test
        System.out.println("搜索模块执行了！");
        //绑定数据
        request.setAttribute(R.SessionParamName.DATA_KEY,list);
        //转发至展示页
        request.getRequestDispatcher(request.getContextPath()+R.FrontPageNames.SHOW_PAGE).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
