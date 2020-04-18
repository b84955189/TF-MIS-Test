package top.lking.servlets;

import top.lking.bean.User;
import top.lking.db.control.LoveQQDBControl;
import top.lking.utils.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 7:50 PM
 * @describe:
 */
public class RegisterServlet extends HttpServlet {
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
                response.sendRedirect(request.getContextPath()+"/register.jsp");

                return;
            }
           //注册
            User user = new User();
            user.setUser_login(userName);
            user.setUser_pass(password);
            boolean result=loveQQDBControl.add(user);
            //如果注册成功
            if(result){
                request.getSession(true).setAttribute(R.MesString.MSG_KEY,R.MesString.REGISTER_SUCCESS_MEG_VALUE);
                response.sendRedirect(request.getContextPath());
                return;
            }else{
                request.getSession(true).setAttribute(R.MesString.MSG_KEY,R.MesString.REGISTER_FAIL_MEG_VALUE);
                response.sendRedirect(request.getContextPath()+"/register.jsp");
                return;
            }
        }




    }
}
