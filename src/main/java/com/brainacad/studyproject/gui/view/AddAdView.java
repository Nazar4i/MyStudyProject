package com.brainacad.studyproject.gui.view;

import com.brainacad.studyproject.data.domain.Ad;
import com.brainacad.studyproject.data.domain.Type;
import com.brainacad.studyproject.gui.ViewRouter;
import com.brainacad.studyproject.service.AdService;
import com.brainacad.studyproject.service.impl.AdServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.brainacad.studyproject.gui.view.View.ADD_AD;
import static com.brainacad.studyproject.gui.view.View.ADS;

/**
 * Created by ${UArabei}.
 */
public class AddAdView  extends  RefreshableView{

    private AdService adService;

    private JTextField adIdField;
    private JTextField shortDescField;
    private JTextField fullDescField;
    private JTextField userIdField;
    private JLabel adIdLabel;
    private JLabel shortDescLabel;
    private JLabel fullDescLabel;
    private JLabel  userIdLabel;
    private JButton createButton;
    private JButton backButton;

    public AddAdView(){

        adService = new AdServiceImpl();

        adIdLabel = new JLabel("AD ID");
        adIdLabel.setBounds(70, 54, 86, 14);
        content.add(adIdLabel);
        adIdField = new JTextField();
        adIdField.setColumns(10);
        content.add(adIdField);

        userIdLabel = new JLabel("USER ID");
        userIdLabel.setBounds(70,54,86,14);
        content.add(userIdLabel);
        userIdField = new JTextField();
        userIdField.setColumns(10);
        content.add(userIdField);



        shortDescLabel = new JLabel("SHORT");
        shortDescLabel.setBounds(70, 54, 86, 14);
        content.add(shortDescLabel);
        shortDescField = new JTextField();
        shortDescField.setColumns(10);
        content.add(shortDescField);

        fullDescLabel = new JLabel("FULL");
        fullDescLabel.setBounds(70, 54, 86, 14);
        content.add(fullDescLabel);
        fullDescField = new JTextField();
        fullDescField.setColumns(10);
        content.add(fullDescField);



        createButton = new JButton("CREATE");
        content.add(createButton);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adId = adIdField.getText();
                String shortDesc = shortDescField.getText();
                String fullDesc = fullDescField.getText();
                Ad ad = new Ad();
                ad.setShortDesc(shortDesc);
                ad.setFullDesc(fullDesc);
                ad.setType(Type.MY);

                if (adService.addAd(ad) == 1) {
                    JOptionPane.showMessageDialog(null, "Failed to create ADS");
                } else {
                    ViewRouter viewRouter = ViewRouter.getInstance();
                    viewRouter.switchView(ADD_AD, ADS);
                }
            }
        });
        backButton = new JButton("BACK");
        content.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewRouter viewRouter = ViewRouter.getInstance();
                viewRouter.switchView(ADD_AD, ADS);
            }
        });
    }

    @Override
    public View getName() {
        return ADD_AD;
    }

    @Override
    public void refresh(Object... params) {

    }
}
