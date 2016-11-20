package com.brainacad.studyproject.gui.view;

import com.brainacad.studyproject.data.domain.Ad;

import com.brainacad.studyproject.gui.editor.UserEditButtonEditor;
import com.brainacad.studyproject.gui.renderer.TableButtonCellRenderer;
import com.brainacad.studyproject.service.UserService;
import com.brainacad.studyproject.service.impl.UserServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static com.brainacad.studyproject.gui.view.View.ADS;


public class AdsView extends RefreshableView {
    private JButton allButton;
    private JButton myButton;
    private JTable usersTable;
    private DefaultTableModel tableModel;

    private UserService userService;

    public AdsView(){
        userService = new UserServiceImpl();
        content.setBorder(new EmptyBorder(5, 5, 5, 5));
        myButton = new JButton("MY");
        content.add(myButton);

        myButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        content.setBorder(new EmptyBorder(5, 5, 5, 5));
        allButton = new JButton("ALL ");
        content.add(allButton);

        allButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

       String [] columns = {"WHAT","THE ", "FUCK", "BLAT"};
        tableModel = new DefaultTableModel(columns, 0);
        usersTable = new JTable(tableModel);
        usersTable.getColumnModel().getColumn(2).setCellRenderer(new TableButtonCellRenderer());
        usersTable.getColumnModel().getColumn(2).setCellEditor(new UserEditButtonEditor(new JCheckBox()));
        content.add(usersTable);

    }

    @Override
    public View getName() {
        return ADS;
    }

    @Override
    public void refresh(Object ... params) {

    }


    public Object[] map(Ad ad) {
        return new Object[] {ad.getUserID(), ad.getAdType(),ad.getAnnoucementID()};
    }

}
