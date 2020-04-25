package top.lking.db.interfaces;

import top.lking.bean.Page;
import top.lking.bean.User;

import java.util.List;

/**
 * JDBC控制层接口
 * @author Jason
 * @version 1.0
 * @date 4/7/2020 10:52 AM
 */
public interface LoveQQDBControlInterface {
    public int LOVE_QQ_USER_TABLE=111;
    /**
     * 规定每页显示多少条数据（分页）
     * @author Jason
     * @date 3:30 PM 4/25/2020
     */
    public int SHOW_PAGE_PAGINATION_COUNT=4;
     /**
      * 添加操作
      * @author Jason
      * @date 4:34 PM 4/23/2020
      * @param  user 用户实体
      * @return 返回布尔类型的添加结果
      */
     public boolean add(User user);

     /**
      * 删除操作
      * @author Jason
      * @date 4:35 PM 4/23/2020
      * @param  id 数据标识
      * @param sign 数据表标识
      * @return
      */
    public boolean del(int id,int sign);
   /**
    * 查询操作
    * @author Jason
    * @date 4:36 PM 4/23/2020
    * @param  userName 数据标识
    * @param sign 数据表标识
    * @return 返回查询对象
    */
    public Object query(String userName,int sign);
    /**
     * 模糊查询
     * @author Jason
     * @date 3:37 PM 4/25/2020
     * @param sign 查询标记
     * @param snippet 查询片段
     * @param currentPageCount 当前页码
     * @return 返回页面数据对象
     */
    public Page queryAll(int sign,String snippet,int currentPageCount);
    /**
     * 分页查询
     * @author Jason
     * @date 3:45 PM 4/25/2020
     * @param sign 查询标记
     * @param snippet 查询片段
     * @param currentPageCount 当前页码
     * @return 返回分页查询集合
     */
    public Page paginationQuery(int sign,String snippet,String currentPageCount);
}
