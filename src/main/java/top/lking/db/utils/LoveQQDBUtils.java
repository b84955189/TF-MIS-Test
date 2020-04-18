package top.lking.db.utils;

import top.lking.utils.R;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Jason
 * @version 1.0
 * @date 4/2/2020 10:27 PM
 * @describe:
 */
public class LoveQQDBUtils {
        private static String driver=null;
        private static String url=null;
        private static String userName=null;
        private static String password=null;

        //属性配置
        private static Properties properties=new Properties();
        //线程并发副本
        private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
        //静态代码块读取配置问价
        static{
                try {
                        //类加载器获取流
                        properties.load(LoveQQDBUtils.class.getClassLoader().getResourceAsStream("loveqqsqlonfig.properties"));
                        driver=properties.getProperty(R.LoveQQSQLConfig.DRIVER,"");
                        url=properties.getProperty(R.LoveQQSQLConfig.URL,"");
                        userName=properties.getProperty(R.LoveQQSQLConfig.USER_NAME,"");
                        password=properties.getProperty(R.LoveQQSQLConfig.PASSWORD,"");
                        //Test
                        //System.out.println(properties);
                        //加载JDBC驱动
                        Class.forName(driver);
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }
        }
        /*
            获取连接对象
         */
        public static Connection getCon() throws SQLException {
                Connection connection=null;
                //尝试从ThreadLocal（调用变量自身的本地变量副本）中获取
                connection=threadLocal.get();
               if(connection==null){
                       connection=DriverManager.getConnection(url,userName,password);
                       threadLocal.set(connection);
               }
               //Test
                System.out.println(connection);
               return connection;
        }
        /*
             关闭连接对象
         */
        public static void closeCon() throws SQLException {
                Connection connection=threadLocal.get();
                //Test
                System.out.println(connection);
                if(connection!=null){
                        connection.close();
                }
                threadLocal.set(null);
        }
        //Test
        public static void main(String[] args) throws SQLException {
                Connection connection1=LoveQQDBUtils.getCon();
                LoveQQDBUtils.closeCon();
                Connection connection2=LoveQQDBUtils.getCon();
                System.out.println(connection1==connection2);
        }
}
