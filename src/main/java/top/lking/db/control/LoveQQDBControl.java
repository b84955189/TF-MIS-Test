package top.lking.db.control;

import top.lking.bean.User;
import top.lking.db.dao.loveqq.UserDao;
import top.lking.db.interfaces.LoveQQDBControlInterface;
import top.lking.db.utils.LoveQQDBUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 10:51 AM
 * @describe:
 */
public class LoveQQDBControl implements LoveQQDBControlInterface {

    public synchronized boolean add(User user) {
        UserDao userDao = new UserDao();
        try {
            userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                LoveQQDBUtils.closeCon();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean del(int id, int sign) {
        boolean result=false;
        UserDao userDao=new UserDao();
        switch (sign){
            case LoveQQDBControlInterface.LOVE_QQ_USER_TABLE:{
                try {
                    result=userDao.delUser(id);
                } catch (SQLException e) {
                    e.printStackTrace();

                }finally {
                    try {
                        LoveQQDBUtils.closeCon();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            };break;
        }
        return result;
    }

    public List queryAll(int sign) {
        List list=null;

        switch (sign){
            case LoveQQDBControl.LOVE_QQ_USER_TABLE:{
                UserDao userDao = new UserDao();
                try {
                    list=userDao.queryAll();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        LoveQQDBUtils.closeCon();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            };break;
        }
        return list;
    }
    public List queryAll(int sign,String snapshot) {
        List list=null;

        switch (sign){
            case LoveQQDBControl.LOVE_QQ_USER_TABLE:{
                UserDao userDao = new UserDao();
                try {
                    list=userDao.queryAll(snapshot);
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        LoveQQDBUtils.closeCon();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            };break;
        }
        return list;
    }

    public Object query(String userName,int sign) {
        Object obj=null;
       switch (sign){
           case LoveQQDBControlInterface.LOVE_QQ_USER_TABLE:{
               UserDao userDao = new UserDao();
               try {
                   obj=userDao.queryUser(userName);
               } catch (SQLException e) {
                   e.printStackTrace();
               }finally {
                   try {
                       LoveQQDBUtils.closeCon();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
           };break;
       }

        return obj;
    }
    //Test
    public static void main(String[] args) {
        LoveQQDBControl loveQQDBControl=new LoveQQDBControl();
        User user=new User();
        user.setUser_login("uasjlk");
        user.setUser_pass("2333ewe");
        System.out.println(loveQQDBControl.add(user));;
    }
}
