package top.lking.servlets;

import top.lking.bean.User;
import top.lking.db.control.LoveQQDBControl;
import top.lking.db.interfaces.LoveQQDBControlInterface;
import top.lking.utils.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 1:26 PM
 * @describe:
 */
public class LoginDealServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //编码
            request.setCharacterEncoding("UTF-8");
            String userName=null;
            String password=null;
            LoveQQDBControl loveQQDBControl=new LoveQQDBControl();
            //判断是否已经登录
            if(request.getSession(true).getAttribute("online")!=null){
                request.getSession(true).removeAttribute(R.MesString.DATA_KEY);
            }else{
                //判断用户名或密码是否正确
                userName=request.getParameter(R.LoveQQSQLConfig.USER_LOGIN);
                password=request.getParameter(R.LoveQQSQLConfig.USER_PASS);
                //输入错误
                if(userName==null||password==null||userName.trim().equals("")||password.trim().equals("")){
                    request.getSession(true).setAttribute(R.MesString.MSG_KEY,R.MesString.NULL_ERROR_MEG_VALUE);
                    response.sendRedirect(request.getContextPath());
                    return;
                }
                User user=(User) (loveQQDBControl.query(userName, LoveQQDBControlInterface.LOVE_QQ_USER_TABLE));
                //用户不存在
                if(user==null){
                    request.getSession(true).setAttribute(R.MesString.MSG_KEY,R.MesString.ACCOUNT_ERROR_MEG_VALUE);
                    response.sendRedirect(request.getContextPath());
                    return;
                }
                //密码错误
                if(!user.getUser_pass().equals(password)){
                    request.getSession(true).setAttribute(R.MesString.MSG_KEY,R.MesString.PASSWORD_ERROR_MEG_VALUE);
                    response.sendRedirect(request.getContextPath());
                    return;
                }
            }



            //标记登录
            request.getSession(true).setAttribute("online","1");
            //将数据填充至session
            List<User> list=loveQQDBControl.queryAll(LoveQQDBControlInterface.LOVE_QQ_USER_TABLE);
            request.getSession(true).setAttribute(R.MesString.DATA_KEY,list);
            //转发至展示页
            response.sendRedirect(request.getContextPath()+"/show.jsp");

    }
}
