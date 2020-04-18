package top.lking.servlets.ajax;

import top.lking.db.control.LoveQQDBControl;
import top.lking.db.interfaces.LoveQQDBControlInterface;
import top.lking.utils.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 5:20 PM
 * @describe:
 */
public class DelLQUserAJAXServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession(true).getAttribute("online")!=null){
            try {
                int id=Integer.parseInt(req.getParameter(R.LoveQQSQLConfig.USER_ID));
                LoveQQDBControl loveQQDBControl=new LoveQQDBControl();
                loveQQDBControl.del(id, LoveQQDBControlInterface.LOVE_QQ_USER_TABLE);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            resp.sendRedirect("/"+req.getContextPath());
            return;
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
