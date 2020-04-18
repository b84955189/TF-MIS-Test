# TF-MIS
小型信息管理系统。
## 演示地址
[http://school.lking.top](http://school.lking.top)

## 配置
1. 重命名` src/main/resources `目录下的`example_loveqqsqlonfig.properties`文件为`loveqqsqlonfig.properties`
2. 打开填写数据库信息即可。
```
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://地址:端口/数据库?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8
jdbc.username=数据库账号
jdbc.password=数据库密码
```
## 用户数据表
```sql
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lq_users
-- ----------------------------
DROP TABLE IF EXISTS `lq_users`;
CREATE TABLE `lq_users` (
  `online_sign` tinyint(2) NOT NULL DEFAULT '0',
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_login` varchar(60) NOT NULL,
  `user_pass` varchar(255) NOT NULL,
  `user_email` varchar(100) NOT NULL DEFAULT '',
  `user_register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `display_name` varchar(250) NOT NULL DEFAULT 'Unnamed',
  `user_head_url` varchar(250) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_login` (`user_login`),
  KEY `user_login_index` (`user_login`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

```
