package top.lking.db.control;

import top.lking.bean.Page;
import top.lking.bean.User;
import top.lking.db.dao.loveqq.UserDao;
import top.lking.db.interfaces.LoveQQDBControlInterface;
import top.lking.db.utils.LoveQQDBUtils;
import top.lking.utils.R;

import java.sql.SQLException;
import java.util.List;


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

    public synchronized boolean del(int id, int sign) {
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



    public Page queryAll(int sign,String snippet,int currentPageCount) {
       Page page=null;

        switch (sign){
            case LoveQQDBControl.LOVE_QQ_USER_TABLE:{

                UserDao userDao = new UserDao();
                try {

                    page=userDao.queryAll(snippet,currentPageCount);
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
        return page;
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


    @Override
    public Page paginationQuery(int sign, String snippet,String currentPageCountString) {

        //如果没有输入搜索片段---转发完整数据
        if(snippet==null||snippet.trim().equals("")){
            snippet="";
        }

        //*******处理当前页参数***********
        int currentPageCount;
        if(currentPageCountString ==null)
            currentPageCount=1;
        else {
            try {
                currentPageCount=Integer.parseInt(currentPageCountString);
            }catch (Exception e){
                currentPageCount=1;
            }

        }
        //*************************

        //获取到当前页面的数据对象
        Page page=this.queryAll(sign,snippet, currentPageCount);

        //数据总量
        int totalCount=page.getTotalData();
        //设置起始页码
        page.setStartPageCount(1);
        //设置当前页码--并判断是否已有页码
        page.setCurrentPageCount(currentPageCount);
        //设置终止页码
        page.setEndPageCount(totalCount%LoveQQDBControlInterface.SHOW_PAGE_PAGINATION_COUNT==0?totalCount/LoveQQDBControlInterface.SHOW_PAGE_PAGINATION_COUNT:totalCount/LoveQQDBControlInterface.SHOW_PAGE_PAGINATION_COUNT+1);
        //标记页面数据查询方式-------------后期搜索类型增加，会有所变动
        page.setQueryType(R.RequestParamName.TYPE_USER_LOGIN);
        //标记查询片段
        page.setSnippet(snippet);
        //Test
        System.out.println("页面："+page);


        return page;
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
