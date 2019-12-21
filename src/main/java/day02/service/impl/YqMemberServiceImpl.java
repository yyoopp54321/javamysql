package day02.service.impl;

import day02.dao.YqMemberDao;

import java.sql.SQLException;

public class YqMemberServiceImpl implements YqMemberService {
    public void add() throws SQLException {
        YqMemberDao yqMemberDao = new YqMemberDao();
        yqMemberDao.insert();
    }

    public void delete() {

    }

    public void updata() {

    }

    public void get() {

    }
}

