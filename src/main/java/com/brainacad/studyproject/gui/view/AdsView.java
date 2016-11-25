package com.brainacad.studyproject.gui.view;

import com.brainacad.studyproject.data.domain.Ad;

import com.brainacad.studyproject.gui.ViewRouter;
import com.brainacad.studyproject.gui.editor.AdEditButtonEditor;
import com.brainacad.studyproject.gui.editor.UserEditButtonEditor;
import com.brainacad.studyproject.gui.renderer.TableButtonCellRenderer;
import com.brainacad.studyproject.service.AdService;
import com.brainacad.studyproject.service.UserService;
import com.brainacad.studyproject.service.impl.AdServiceImpl;
import com.brainacad.studyproject.service.impl.UserServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.function.Consumer;


import static com.brainacad.studyproject.gui.view.View.ADD_AD;
import static com.brainacad.studyproject.gui.view.View.ADS;


public class AdsView extends RefreshableView {
    private JButton addButton;
    private JTable adsTable;
    private DefaultTableModel tableModel;

    private AdService adService;
    private JTabbedPane tabMy;
    private JTabbedPane tabAll;


    public AdsView(){
        adService = new AdServiceImpl();

        tabMy = new JTabbedPane();
        tabMy.addTab("My descriptions ", new JPanel());
        content.add(tabMy);
        tabMy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        tabAll = new JTabbedPane();
        tabAll.addTab("All descriptions", new JPanel());
        content.add(tabAll);





        String [] columns = {"ADID","SHORT","FULL","USERID","TYPE"};
        tableModel = new DefaultTableModel(columns, 0);
        adsTable = new JTable(tableModel);
        adsTable.getColumnModel().getColumn(4).setCellRenderer(new TableButtonCellRenderer());
        adsTable.getColumnModel().getColumn(4).setCellEditor(new AdEditButtonEditor(new JCheckBox()));
        content.add(adsTable);


        addButton = new JButton("ADD");
        content.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewRouter viewRouter = ViewRouter.getInstance();
                viewRouter.switchView(ADS, ADD_AD);
            }
        });

    }




    @Override
    public View getName() {
        return ADS;
    }

    @Override
    public void refresh(Object... params) {
        tableModel.setRowCount(0);
        Collection<Ad> ads = adService.getAllAds();
        ads.forEach(new Consumer<Ad>() {
            @Override
            public void accept(Ad ad) {
                tableModel.addRow(AdsView.this.map(ad));
            }
        });
    }
    public Object[] map(Ad ad) {
        return new Object[] {ad.getAdID(),ad.getUserId(), ad.getShortDesc(),ad.getFullDesc(),"EDIT"};
    }
}
