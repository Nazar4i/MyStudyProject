package com.brainacad.studyproject.data.dao.impl;

import com.brainacad.studyproject.data.dao.DaoFactory;
import com.brainacad.studyproject.data.dao.UserDao;

/**
 * Created by ${UArabei}.
 */
public class StubDaoFactory extends DaoFactory {

    @Override
    public UserDao getUserDao() {
        return new StubUserDao();
    }

}
