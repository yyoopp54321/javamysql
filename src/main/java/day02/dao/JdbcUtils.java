package day02.dao;


import java.sql.*;

public class JdbcUtils {
    //把几个字符串定义变成常量：URL,账户，密码，驱动类
    private static final String URL="jdbc:mysql://101.132.33.149:3306/ypp";
    private static final String PWD="123456";
    private static final String USER="root";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    /*
    *注册驱动
    * */
  static {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    *得到数据库的连接
    * */
      public static Connection getConnection() throws SQLException {
          return DriverManager.getConnection(URL,USER,PWD);
      }
      /*
      * 关闭所有打开的资源
      * */
      public static void closeResource(Statement con , Connection stmt , ResultSet rs){
          if (stmt!=null){
              try {
                  stmt.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }

          }
          if (con!=null){
              try {
                  con.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
          if (rs!=null){
              try {
                  rs.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }

      }


}
