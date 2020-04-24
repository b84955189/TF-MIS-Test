package top.lking.db.interfaces;

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
    * @return
    */
    public Object query(String userName,int sign);
}
