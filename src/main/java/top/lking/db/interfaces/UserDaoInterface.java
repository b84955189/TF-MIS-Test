package top.lking.db.interfaces;

import top.lking.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 10:38 AM
 * @describe:
 */
public interface UserDaoInterface {
     /*
      增
     */
     public boolean addUser(User user) throws SQLException;
    /*
      删
     */
    public boolean delUser(int id) throws SQLException;
    /*
      改
     */
    public boolean updateUser(User newUser);
    /*
      查
     */
    public List<User> queryAll() throws SQLException;
    public List<User> queryAll(String snapshot) throws SQLException;
    public User queryUser(String userName) throws SQLException;
}
