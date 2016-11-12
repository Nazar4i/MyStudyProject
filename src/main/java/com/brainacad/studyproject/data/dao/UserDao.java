package com.brainacad.studyproject.data.dao;

import com.brainacad.studyproject.data.domain.User;

/**
 * Created by ${UArabei}.
 */
public interface UserDao extends CrudDao<User> {

    User getUserByName(String username);

}
