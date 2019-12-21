package day02.model;

import day02.dao.YqMemberDao;
import lombok.Data;

@Data
public class YqMember extends YqMemberDao {

  private Integer id;
  private String imgUrl;
  private String nickName;
  private String password;
  private long qqNumber;
  private String sex;




}
