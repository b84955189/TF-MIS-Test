package top.lking.db.control;

import top.lking.bean.User;
import top.lking.db.dao.loveqq.UserDao;
import top.lking.db.interfaces.LoveQQDBControlInterface;
import top.lking.db.utils.LoveQQDBUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * JDBC控制层
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 10:51 AM
 */
public class LoveQQDBControl implements LoveQQDBControlInterface {
    /**
     * 添加用户
     * @author Jason
     * @date 5:14 PM 4/19/2020
     * @param  user 用户实体类
     * @return true:成功 false:失败
     * @see UserDao#addUser(User)
     */
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
    /**
     * 实体类删除
     * @author Jason
     * @date 5:15 PM 4/19/2020
     * @param  id 实体类标识ID
     * @param sign 实体类标记
     * @return true:成功 false:失败
     */
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
    /**
     * 整体查询
     * @author Jason
     * @date 5:18 PM 4/19/2020
     * @param  sign 查询标记
     * @return 返回查询信息集合
     */
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
    /**
     * 模糊查询
     * @author Jason
     * @date 5:25 PM 4/19/2020
     * @param  sign 查询标记
     * @param snapshot 查询片段
     * @return 查询集合
     */
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
    /**
     * 单个实体查询
     * @author Jason
     * @date 5:26 PM 4/19/2020
     * @param  userName 用户名标识
     * @param sign 实体类标识
     * @return 返回一个Object类型的实体类对象
     */
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
    /**
     * 开发测试
     * @author Jason
     * @date 5:28 PM 4/19/2020
     * @param  args
     * @return
     */
    public static void main(String[] args) {
        LoveQQDBControl loveQQDBControl=new LoveQQDBControl();
        User user=new User();
        user.setUser_login("uasjlk");
        user.setUser_pass("2333ewe");
        System.out.println(loveQQDBControl.add(user));;
    }
}
