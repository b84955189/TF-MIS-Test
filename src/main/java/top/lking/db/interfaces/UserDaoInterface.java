package top.lking.db.interfaces;

import top.lking.bean.Page;
import top.lking.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * JDBC数据访问层接口
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 10:38 AM
 * @describe:
 */
public interface UserDaoInterface {
     /**
      * 用户添加
      * @author Jason
      * @date 5:30 PM 4/19/2020
      * @param  user 用户实体
      * @return true:成功 false:失败
      * @throws SQLException
      */
     public boolean addUser(User user) throws SQLException;
    /**
     * 用户删除
     * @author Jason
     * @date 5:31 PM 4/19/2020
     * @param  id 用户标识
     * @return true:成功 false:失败
     * @throws SQLException
     */
    public boolean delUser(int id) throws SQLException;
   /**
    * 用户信息更新
    * @author Jason
    * @date 5:31 PM 4/19/2020
    * @param  newUser 新用户信息实体
    * @return true:成功 false:失败
    */
    public boolean updateUser(User newUser);

    /**
     * 模糊查询用户信息
     * @author Jason
     * @date 5:33 PM 4/19/2020
     * @param snippet 查询片段
     * @param currentPageCount 当前页码
     * @return 返回页面数据对象
     * @throws SQLException
     */
    public Page queryAll(String snippet, int currentPageCount) throws SQLException;
    /**
     * 单个用户信息查询
     * @author Jason
     * @date 5:34 PM 4/19/2020
     * @param  userName 用户名
     * @return 返回用户实体对象
     */
    public User queryUser(String userName) throws SQLException;
}
