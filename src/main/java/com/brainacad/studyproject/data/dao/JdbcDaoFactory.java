package com.brainacad.studyproject.data.dao;

import com.brainacad.studyproject.data.dao.impl.JdbcUserDao;

/**
 * Created by ${UArabei}.
 */
public class JdbcDaoFactory extends DaoFactory {
    @Override
    public UserDao getUserDao() {
        return new JdbcUserDao();
    }
}
