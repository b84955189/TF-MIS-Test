package top.lking.db.dao.loveqq;

import top.lking.bean.User;
import top.lking.db.interfaces.UserDaoInterface;
import top.lking.db.utils.LoveQQDBUtils;
import top.lking.utils.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 10:36 AM
 * @describe:
 */
public class UserDao implements UserDaoInterface {
    public boolean addUser(User user) throws SQLException {

        //获取数据库连接
        Connection connection=LoveQQDBUtils.getCon();
        //获取预编译执行对象
        PreparedStatement preparedStatement=connection.prepareStatement(R.LoveQQSQLConfig.PRE_ADD_USER_SQL);
        preparedStatement.setString(1,user.getUser_login());
        preparedStatement.setString(2,user.getUser_pass());
        int result=preparedStatement.executeUpdate();

        preparedStatement.close();
        if (result<=0)
            return false;
        return true;
    }

    public boolean delUser(int id) throws SQLException {
        Connection connection=LoveQQDBUtils.getCon();
        PreparedStatement preparedStatement=connection.prepareStatement(R.LoveQQSQLConfig.PRE_DEL_USER_SQL);
        preparedStatement.setInt(1,id);
        int result=preparedStatement.executeUpdate();
        if(result<=0)
            return false;
        return true;
    }

    public boolean updateUser(User newUser) {
        return false;
    }

    public List<User> queryAll() throws SQLException {
        List<User> list=new ArrayList<User>();
        Connection connection=LoveQQDBUtils.getCon();
        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(R.LoveQQSQLConfig.QUERY_ALL_USER_SQL);
        while(resultSet.next()){
            User user=new User();
            user.setUser_id(resultSet.getInt(R.LoveQQSQLConfig.USER_ID));
            user.setUser_login(resultSet.getString(R.LoveQQSQLConfig.USER_LOGIN));
            user.setUser_pass(resultSet.getString(R.LoveQQSQLConfig.USER_PASS));
            user.setUser_register_time(resultSet.getTimestamp(R.LoveQQSQLConfig.USER_REGISTER_TIME).toString());
            list.add(user);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    @Override
    public List<User> queryAll(String snapshot) throws SQLException {
        List<User> list=new ArrayList<User>();
        Connection connection=LoveQQDBUtils.getCon();
       PreparedStatement preparedStatement=connection.prepareStatement(R.LoveQQSQLConfig.LIMIT_QUERY_ALL_USER_SQL);
       preparedStatement.setString(1,"%"+snapshot+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            User user=new User();
            user.setUser_id(resultSet.getInt(R.LoveQQSQLConfig.USER_ID));
            user.setUser_login(resultSet.getString(R.LoveQQSQLConfig.USER_LOGIN));
            user.setUser_pass(resultSet.getString(R.LoveQQSQLConfig.USER_PASS));
            user.setUser_register_time(resultSet.getTimestamp(R.LoveQQSQLConfig.USER_REGISTER_TIME).toString());
            list.add(user);
        }
        resultSet.close();
        preparedStatement.close();
        return list;
    }

    public User queryUser(String userName) throws SQLException {
        Connection connection=LoveQQDBUtils.getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(R.LoveQQSQLConfig.PRE_QUERY_USER_SQL);
        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user=null;
        if(resultSet.next()){
            user=new User();
            user.setUser_login(resultSet.getString(R.LoveQQSQLConfig.USER_LOGIN));
            user.setUser_pass(resultSet.getString(R.LoveQQSQLConfig.USER_PASS));

        }
        resultSet.close();
        preparedStatement.close();

        return user;
    }
    //Test
    public static void main(String[] args)  {
        UserDao userDao=new UserDao();
        User user=new User();
        user.setUser_login("woai1");
        user.setUser_pass("123");
        try {
            System.out.println(userDao.queryAll());;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                LoveQQDBUtils.closeCon();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
