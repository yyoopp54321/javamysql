package day01.Dao;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.select();
        /*test.insert();
        test.updata();
        test.delete();*/
    }
    /*
     * 查询
     * */
    public void select(){
        //获取连接
        Connection con=null;
        //连接数据库获得语句执行
        PreparedStatement stmt=null;
        //执行后获得结果集
        ResultSet rs=null;
        try {
            con=JdbcUtils.getConnection();
            String sql="select * from t_animal";
            stmt=con.prepareStatement(sql);
            rs= stmt.executeQuery();
            while (rs.next()){
                int  id=rs.getInt("id");
                String  name=rs.getString("name");
                int age=rs.getInt("age");
                String sex=rs.getString("sex");
                System.out.println("编号：" + id + ", 姓名：" + name +",年龄："+age+ ", 性别：" + sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(con, stmt,rs);
        }
    }
    /*
     * 插入
     * */
    public void insert(){
        Connection  con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            con= JdbcUtils.getConnection();
            String  sql="insert into t_animal VALUES(null,?,?,?)";
            stmt=con.prepareStatement(sql);
            stmt.setString(1,"猪");
            stmt.setInt(2,1);
            stmt.setString(3,"母");
            int low=stmt.executeUpdate();
            if (low>0){
                System.out.println("插入了"+low+"条数据");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(con, stmt,rs);
        }


    }
    /*
     * 修改
     * */
    public void updata(){
        Connection con=null;
        PreparedStatement  stmt=null;
        ResultSet rs=null;
        try {
            con=JdbcUtils.getConnection();
            String sql="update t_animal set name = ? age =? sex=? where id = ? ";
            stmt=con.prepareStatement(sql);
            stmt.setString(1,"驴");
            stmt.setInt(2,3);
            stmt.setString(3,"公");
            stmt.setInt(4,4);
            int low=stmt.executeUpdate();
            if (low>0){
                System.out.println("更新" + low + "条记录");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(con,stmt,rs);
        }

    }
    /*
     * 删除
     * */
    public void delete(){
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            con=JdbcUtils.getConnection();
            String  sql="delete from t_animal where id=?";
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(con,stmt,rs);
        }

    }

}
