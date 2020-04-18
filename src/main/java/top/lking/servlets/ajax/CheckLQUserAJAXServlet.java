package top.lking.servlets.ajax;

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

/**
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 8:42 PM
 * @describe:
 */
@WebServlet("/cheklquser.do")
public class CheckLQUserAJAXServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=null;
        User user=null;
        userName=req.getParameter(R.LoveQQSQLConfig.USER_LOGIN);
        if(userName==null)
            return;

        resp.setContentType("text/html;charset=utf-8");
        LoveQQDBControl loveQQDBControl = new LoveQQDBControl();
        String msg="";
       if( loveQQDBControl.query(userName, LoveQQDBControlInterface.LOVE_QQ_USER_TABLE)!=null){
                msg="用户名已存在！";
       }else{
           //可以注册
                msg="用户名可用！";
       }
       resp.getWriter().println(msg);

    }
}
