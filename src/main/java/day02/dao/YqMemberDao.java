package day02.dao;


import day02.model.YqMember;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class YqMemberDao {
    public static void main(String[] args) throws SQLException {
     insert();
     select();



    }
    /*
    * 增
    * */
    public static void insert()throws SQLException {
        JdbcUtils jdbcUtils = new JdbcUtils();
        ResultSet rs=null;
        Connection con=jdbcUtils.getConnection();
        Statement stm=con.createStatement();
        String sql="insert into yq_member values (null ,'65464','花非花','sdfs5555',1321,'男')";
        stm.execute(sql);
        jdbcUtils.closeResource(stm,con,rs);


    }
    /*
    * 删
    * */
    public static void delete()throws SQLException{
        JdbcUtils jdbcUtils=new JdbcUtils();
        ResultSet rs=null;
        Connection con=JdbcUtils.getConnection();
        Statement stm=con.createStatement();
        String sql="delete from yq_member where id=2";
        stm.execute(sql);
        jdbcUtils.closeResource(stm,con,rs);
    }
    /*
    * 改
    * */
    public static void update()throws SQLException{
        JdbcUtils jdbcUtils=new JdbcUtils();
        ResultSet rs=null;
        Connection con=JdbcUtils.getConnection();
        Statement stm=con.createStatement();
        String sql="update yq_member set password='1234565qq' where id=1";
        stm.execute(sql);
        jdbcUtils.closeResource(stm,con,rs);
    }
    /*
    * 查
    * */
    public static List<YqMember> select()throws SQLException{
      JdbcUtils jdbcUtils=new JdbcUtils();
      Connection con=jdbcUtils.getConnection();
      String sql= "select * from yq_member";
      PreparedStatement pstm=con.prepareStatement(sql);
      ResultSet rs=pstm.executeQuery();
        List<YqMember> list= new ArrayList<YqMember>();
      while (rs.next()){
          YqMember yqMember = new YqMember();
           int id=rs.getInt("id");
           String imgUrl=rs.getString("img_url");
           String nickName=rs.getString("nick_name");
           String password=rs.getString("password");
           int qqNumber=rs.getInt("qq_number");
           String sex=rs.getString("sex");
           yqMember.setId(id);
           yqMember.setImgUrl(imgUrl);
           yqMember.setNickName(nickName);
           yqMember.setPassword(password);
           yqMember.setQqNumber(qqNumber);
           yqMember.setSex(sex);
           list.add(yqMember);
          System.out.println(list);
      }
      jdbcUtils.closeResource(pstm,con,rs);


        return  list;
    }
}