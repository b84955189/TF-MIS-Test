package top.lking.utils;

/**
 * 项目全局资源引用类
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 9:54 AM
 */
public class R {
    public interface LoveQQSQLConfig{
        //Config
        String DRIVER="jdbc.driver";
        String URL="jdbc.url";
        String USER_NAME ="jdbc.username";
        String PASSWORD="jdbc.password";
        //SQL TABLE
        String LQ_USERS="lq_users";
        //SQL FIELD
        String USER_ID="user_id";
        String USER_LOGIN="user_login";
        String USER_PASS="user_pass";
        String USER_REGISTER_TIME="user_register_time";
        //SQL Statement
        String PRE_ADD_USER_SQL="INSERT INTO lq_users("+USER_LOGIN+","+USER_PASS+") VALUES(?,?)";
        String PRE_QUERY_USER_SQL="SELECT * FROM "+LQ_USERS+" WHERE "+USER_LOGIN+"=?";
        String PRE_DEL_USER_SQL="DELETE FROM "+LQ_USERS+" WHERE "+USER_ID+" =?";
        String QUERY_ALL_USER_SQL="SELECT * FROM "+LQ_USERS;
        String LIMIT_QUERY_ALL_USER_SQL="SELECT * FROM "+LQ_USERS+" WHERE "+USER_LOGIN+" LIKE ?";
    }
    public interface MesString{
        String MSG_KEY ="session_msg";
        String DATA_KEY="data";
        String NULL_ERROR_MEG_VALUE="输入错误！";
        String REGISTER_SUCCESS_MEG_VALUE="注册成功，请登录！";
        String REGISTER_FAIL_MEG_VALUE="注册失败，请重试！";
        String ACCOUNT_ERROR_MEG_VALUE="用户不存在！";
        String PASSWORD_ERROR_MEG_VALUE="密码错误！";

    }

}
