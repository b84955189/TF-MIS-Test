package top.lking.bean;


import lombok.Data;

/**
 * 用户实体类
 * @author Jason
 * @version 1.0
 * @date 4/2/2020 10:24 PM
 */
@Data
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

}
