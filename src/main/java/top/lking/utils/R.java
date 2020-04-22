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
    public interface SessionParamName{
        String USER="user";
    }
    /**
     * 全局过滤器参数名称
     * @author Jason
     * @date 10:01 AM 4/22/2020
     */
    public interface FilterParamName{
        //过滤器开关
        String FILTER_SWITCH="filterSwitch";
        //过滤器重定向参数
        String REDIRECT_PAGE="RedirectPage";


        //全局编码过滤器
        String ENCODING="encoding";
        String CONTENT_TYPE="contentType";

        //离线状态过滤器
        String FILTER_PAGES="filterPages";

        //在线状态过滤器
        String FORWARD_PAGE="ForwardPage";

    }
    /**
     * 全局过滤器参数默认值
     * @author Jason
     * @date 10:00 AM 4/22/2020
     *
     */
    public interface FilterDefaultParamValue{
        //过滤器开关-关闭状态
        String FILTER_SWITCH_OFF="off";
        //过滤器重定向--默认
        String DEFAULT_REDIRECT_PAGE="/index.jsp";


        //全局编码过滤器-默认值
        String DEFAULT_ENCODING="UTF-8";
        String DEFAULT_CONTENT_TYPE="text/html;charset=UTF-8";

        //离线状态过滤器-默认值
        String DEFAULT_FILTER_PAGES="logout;show.jsp";

        //在线状态过滤器-默认值
        String DEFAULT_FORWARD_PAGE="/show.jsp";

    }

}
