package top.lking.db.interfaces;

import top.lking.bean.User;

import java.util.List;

/**
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 10:52 AM
 * @describe:
 */
public interface LoveQQDBControlInterface {
    public int LOVE_QQ_USER_TABLE=111;
     /*
      增
     */
     public boolean add(User user);
    /*
      删
     */
    public boolean del(int id,int sign);
    /*
      改
     */
    /*
      查
     */
    public List queryAll(int sign);
    public Object query(String userName,int sign);
}
