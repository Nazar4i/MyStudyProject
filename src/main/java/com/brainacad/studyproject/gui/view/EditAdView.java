package com.brainacad.studyproject.gui.view;

import com.brainacad.studyproject.data.domain.Ad;
import com.brainacad.studyproject.gui.ViewRouter;
import com.brainacad.studyproject.service.AdService;
import com.brainacad.studyproject.service.impl.AdServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.brainacad.studyproject.gui.view.View.ADS;
import static com.brainacad.studyproject.gui.view.View.EDIT_AD;

/**
 * Created by ${UArabei}.
 */
public class EditAdView  extends  RefreshableView{
    private AdService adService;

    private JTextField shortDescField;
    private JTextField fullDescField;
    private JLabel adIdLabel;
    private JLabel shortDescLabel;
    private JLabel fullDescLabel;
    private JButton updateButton;
    private JButton deleteButton;

    public EditAdView(){
        adService = new AdServiceImpl();


        adIdLabel = new JLabel("AD_ID");
        adIdLabel.setBounds(70, 54, 86, 14);
        content.add(adIdLabel);

        shortDescLabel = new JLabel("SHORT_Descr");
        shortDescLabel.setBounds(70, 54, 86, 14);
        content.add(shortDescLabel);
        shortDescField = new JTextField();
        shortDescField.setColumns(10);
        content.add(shortDescField);

        fullDescLabel = new JLabel("Full_Descr");
        fullDescLabel.setBounds(70, 54, 86, 14);
        content.add(fullDescLabel);
        fullDescField = new JTextField();
        fullDescField.setColumns(10);
        content.add(fullDescField);

        updateButton = new JButton("UPDATE");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = adIdLabel.getText();
                String shortDesc = shortDescField.getText();
                String fullDesc = fullDescField.getText();
                Ad ad = new Ad();
                ad.setAdID(Integer.parseInt(id));
                ad.setShortDesc(shortDesc);
                ad.setFullDesc(fullDesc);
                if (!adService.update(ad)) {
                    JOptionPane.showMessageDialog(null, "Failed to update ad");
                }
                ViewRouter viewRouter = ViewRouter.getInstance();
                viewRouter.switchView(getName(), ADS);
            }
        });
        content.add(updateButton);

        deleteButton = new JButton("DELETE");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = adIdLabel.getText();
                if (!adService.delete(Integer.parseInt(id))) {
                    JOptionPane.showMessageDialog(null, "Failed to delete user");
                };
                ViewRouter viewRouter = ViewRouter.getInstance();
                viewRouter.switchView(getName(), ADS);
            }
        });
        content.add(deleteButton);
    }

    @Override
    public View getName() {
        return EDIT_AD;
    }

    @Override
    public void refresh(Object... params) {
        Ad ad = adService.getAdById((Integer) params[0]);
        adIdLabel.setText("" + ad.getAdID());
        shortDescField.setText(ad.getShortDesc());
        fullDescField.setText(ad.getFullDesc());
    }
}
