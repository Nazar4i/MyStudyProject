package com.brainacad.studyproject.gui;

import com.brainacad.studyproject.gui.view.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${UArabei}.
 */
public class ViewFactory {

    private static ViewFactory instance;

    private Map<View, RefreshableView> holder = new HashMap<>();

    private ViewFactory() {
    }

    public static ViewFactory getInstance() {
        if (instance == null) {
            instance = new ViewFactory();
        }
        return instance;
    }

    public RefreshableView getView(View type) {
        RefreshableView refreshableView;
        switch (type) {
            case LOGIN:
                holder.putIfAbsent(type, new LoginView());
                return holder.get(type);
            case USERS:
                holder.putIfAbsent(type, new UsersView());
                return holder.get(type);
            case EDIT_USER:
                holder.putIfAbsent(type, new EditUserView());
                return holder.get(type);
            case ADD_USER:
                holder.putIfAbsent(type, new AddUserView());
                return holder.get(type);
            case ADS:
                holder.putIfAbsent(type, new AdsView());
                return holder.get(type);
            case ADD_AD:
                holder.putIfAbsent(type, new AddAdView());
                return holder.get(type);
            case EDIT_AD:
                holder.putIfAbsent(type, new EditAdView());
                return holder.get(type);
            default:
                throw new RuntimeException("TODO");
        }
    }


}