package com.brainacad.studyproject.service;

import com.brainacad.studyproject.data.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;

/**
 * Created by UArabei on 11/10/2016.
 */
public interface UserService {



    Collection<User> getAllUsers();

    User getUserById(int id);

    int addUser(User user);

    boolean update(User user);

    boolean delete(int id);

    User getUserByName(String username);
}
