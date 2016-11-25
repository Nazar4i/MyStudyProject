package com.brainacad.studyproject.data.core;

import com.brainacad.studyproject.data.domain.Ad;

import com.brainacad.studyproject.data.domain.User;

import java.util.Collection;
import java.util.HashSet;

import static com.brainacad.studyproject.data.domain.Role.ADMIN;
import static com.brainacad.studyproject.data.domain.Role.USER;

/**
 * Created by ${UArabei}.
 */
public class StubDataHolder {

    private static Collection<User> users;
    //TODO: add collection with advertisement
    private static Collection<Ad>  ads;
    private static boolean created = false;

    public static void createData() {
        if (!created) {
            User admin = new User();
            admin.setId(1);
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setRole(ADMIN);

            User user = new User();
            user.setId(2);
            user.setUsername("user");
            user.setPassword("user");
            user.setRole(USER);

            users = new HashSet();
            users.add(admin);
            users.add(user);

            //TODO: fill ad collection
            Ad my = new Ad();
            my.setAdID(1);
            my.setUserId(2);
            my.setShortDesc("Продам");
            my.setFullDesc("Продам все");


            Ad all = new Ad();
            all.setAdID(2);
            all.setUserId(2);
            all.setShortDesc("a");
            all.setFullDesc("aaaaa");



            ads = new HashSet();
            ads.add(my);
            ads.add(all);


            created = true;
        }
    }

    public static int add(User user) {
        if (users.add(user)) {
            return user.getId();
        } else return 0;
    }

    public static int add(Ad ad){
        if (ads.add(ad)){
            return ad.getAdID();
        }else return 0;
    }

    public static Collection<User> getUsers() {
        return users;
    }

    public static Collection<Ad> getAds(){
        return ads;
    }
}