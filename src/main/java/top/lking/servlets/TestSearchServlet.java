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
import java.util.List;

/**
 * @author Jason
 * @version 1.0
 * @date 4/14/2020 7:38 PM
 * @describe:
 */
@WebServlet("/search.do")
public class TestSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String snapshot=request.getParameter(R.LoveQQSQLConfig.USER_LOGIN);
        if(snapshot==null){
            return;
        }
        LoveQQDBControl loveQQDBControl = new LoveQQDBControl();
        //将数据填充至session
        List<User> list=loveQQDBControl.queryAll(LoveQQDBControlInterface.LOVE_QQ_USER_TABLE,snapshot);
        request.getSession(true).removeAttribute(R.MesString.DATA_KEY);
        request.getSession(true).setAttribute(R.MesString.DATA_KEY,list);
        //转发至展示页
        response.sendRedirect(request.getContextPath()+"/show.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
