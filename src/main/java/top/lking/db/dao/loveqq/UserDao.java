package top.lking.db.dao.loveqq;

import top.lking.bean.Page;
import top.lking.bean.User;
import top.lking.db.interfaces.LoveQQDBControlInterface;
import top.lking.db.interfaces.UserDaoInterface;
import top.lking.db.utils.LoveQQDBUtils;
import top.lking.utils.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC数据访问层
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


    @Override
    public Page queryAll(String snippet, int currentPageCount) throws SQLException {
        Page page=new Page();
        List<User> list=new ArrayList<User>();
        Connection connection=LoveQQDBUtils.getCon();
        //用来计算数据总量
        PreparedStatement totalCountPreparedStatement=connection.prepareStatement(R.LoveQQSQLConfig.PRE_LIMIT_QUERY_ALL_USER_COUNT_SQL);
        totalCountPreparedStatement.setString(1,"%"+snippet+"%");
        ResultSet totalResultSet=totalCountPreparedStatement.executeQuery();
        if(totalResultSet.next()){
            page.setTotalData(totalResultSet.getInt(1));
        }
        totalResultSet.close();
        totalCountPreparedStatement.close();
        //用来查询数据
        PreparedStatement preparedStatement=connection.prepareStatement(R.LoveQQSQLConfig.PRE_LIMIT_QUERY_ALL_USER_SQL);
        preparedStatement.setString(1,"%"+snippet+"%");
        preparedStatement.setInt(2,(currentPageCount-1)* LoveQQDBControlInterface.SHOW_PAGE_PAGINATION_COUNT);
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

        page.setCurrentPageData(list);
        return page;
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
    /**
     * 开发测试
     * @author Jason
     * @date 4:19 PM 4/23/2020
     * @param
     * @return
     */
    public static void main(String[] args)  {
        UserDao userDao=new UserDao();
        User user=new User();
        user.setUser_login("woai1");
        user.setUser_pass("123");
        try {
            System.out.println(userDao.queryAll("",1));;
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
