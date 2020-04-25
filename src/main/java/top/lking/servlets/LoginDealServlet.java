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
            User user=null;
            String userName=null;
            String password=null;
            LoveQQDBControl loveQQDBControl=new LoveQQDBControl();

                //判断用户名或密码是否正确
                userName=request.getParameter(R.LoveQQSQLConfig.USER_LOGIN);
                password=request.getParameter(R.LoveQQSQLConfig.USER_PASS);
                //输入错误
                if(userName==null||password==null||userName.trim().equals("")||password.trim().equals("")){
                    request.getSession(true).setAttribute(R.MesString.MSG_KEY,R.MesString.NULL_ERROR_MEG_VALUE);
                    response.sendRedirect(request.getContextPath()+R.FilterDefaultParamValue.DEFAULT_REDIRECT_PAGE);
                    return;
                }
                user=(User) (loveQQDBControl.query(userName, LoveQQDBControlInterface.LOVE_QQ_USER_TABLE));
                //用户不存在
                if(user==null){
                    //设置错误信息
                    request.getSession(true).setAttribute(R.MesString.MSG_KEY,R.MesString.ACCOUNT_ERROR_MEG_VALUE);
                    //返回登录界面
                    response.sendRedirect(request.getContextPath()+R.FilterDefaultParamValue.DEFAULT_REDIRECT_PAGE);
                    return;
                }
                //密码错误
                if(!user.getUser_pass().equals(password)){
                    //设置错误信息
                    request.getSession(true).setAttribute(R.MesString.MSG_KEY,R.MesString.PASSWORD_ERROR_MEG_VALUE);
                    //返回登录界面
                    response.sendRedirect(request.getContextPath()+R.FilterDefaultParamValue.DEFAULT_REDIRECT_PAGE);
                    return;
                }




            //标记登录
            request.getSession(true).setAttribute(R.SessionParamName.USER,user);
            //Test
            //转发至搜索模块
            request.getRequestDispatcher(request.getContextPath()+R.ServletNames.SEARCH_SERVLET).forward(request,response);

    }
}
