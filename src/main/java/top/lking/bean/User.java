package top.lking.bean;




/**
 * @author Jason
 * @version 1.0
 * @date 4/2/2020 10:24 PM
 * @describe:lq_user table
 */

public class User {
    private Integer online_sign;
    private Integer user_id;
    private String user_login;
    private String user_pass;
    private String user_email;
    private String user_register_time;
    private String display_name;
    private String user_head_url;

    public Integer getOnline_sign() {
        return online_sign;
    }

    public void setOnline_sign(Integer online_sign) {
        this.online_sign = online_sign;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_register_time() {
        return user_register_time;
    }

    public void setUser_register_time(String user_register_time) {
        this.user_register_time = user_register_time;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getUser_head_url() {
        return user_head_url;
    }

    public void setUser_head_url(String user_head_url) {
        this.user_head_url = user_head_url;
    }
}
