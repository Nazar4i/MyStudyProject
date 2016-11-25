package com.brainacad.studyproject.gui.view;

import com.brainacad.studyproject.data.domain.Role;
import com.brainacad.studyproject.data.domain.User;
import com.brainacad.studyproject.gui.ViewRouter;
import com.brainacad.studyproject.service.LoginService;
import com.brainacad.studyproject.service.UserService;
import com.brainacad.studyproject.service.impl.LoginServiceImpl;
import com.brainacad.studyproject.service.impl.UserServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.brainacad.studyproject.gui.view.View.*;

/**
 * Created by ${UArabei}.
 */
public class LoginView extends RefreshableView {

    private JTextField usernameField;

    private LoginService loginService;

    private JPasswordField passwordField;

    private User user;

    public LoginView() {
        loginService = new LoginServiceImpl();

        user = new User();

        content.setBorder(new EmptyBorder(5, 5, 5, 5));
        usernameField = new JTextField();
        usernameField.setBounds(188, 51, 99, 20);
        content.add(usernameField);
        usernameField.setColumns(10);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(70, 54, 86, 14);
        content.add(usernameLabel);

        passwordField= new JPasswordField();
        passwordField.setBounds(188, 106, 99, 20);
        content.add(passwordField);
        passwordField.setColumns(10);



        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(70, 109, 86, 14);
        content.add(passwordLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(131, 165, 89, 23);
        content.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = passwordField.getText().trim();
                boolean login = loginService.login(username, password);
                if (login) {

                    //TODO: check if ADMIN or USER? switch to USERS or ADS
                    UserService userService = new UserServiceImpl();
                    User user = userService.getUserByName(username);
                    ViewRouter viewRouter = ViewRouter.getInstance();
                    if (user.getRole().equals(Role.ADMIN)){
                        viewRouter.switchView(getName(), USERS);
                    }
                    else {
                        viewRouter.switchView(getName(), ADS);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Wrong username or password");
                    refresh();
                }
            }
        });

    }

    @Override
    public View getName() {
        return LOGIN;
    }

    @Override
    public void refresh(Object... params) {
        usernameField.setText("");
        passwordField.setText("");
    }

}