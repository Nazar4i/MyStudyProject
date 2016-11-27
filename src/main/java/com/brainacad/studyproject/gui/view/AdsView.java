package com.brainacad.studyproject.gui.view;

import com.brainacad.studyproject.data.domain.Ad;
import com.brainacad.studyproject.gui.ViewRouter;
import com.brainacad.studyproject.gui.editor.AdEditButtonEditor;
import com.brainacad.studyproject.gui.renderer.TableButtonCellRenderer;
import com.brainacad.studyproject.service.AdService;
import com.brainacad.studyproject.service.impl.AdServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.function.Consumer;

import static com.brainacad.studyproject.gui.view.View.ADD_AD;
import static com.brainacad.studyproject.gui.view.View.ADS;


public class AdsView extends RefreshableView {

    private JButton addButton;
    private JTable adsTable;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;
    private AdService adService;


    public AdsView() {


        String [] columns = {"ADID","SHORT","FULL","USERID","TYPE"};
        tableModel = new DefaultTableModel(columns, 0);
        adsTable = new JTable(tableModel);
        adsTable.getColumnModel().getColumn(4).setCellRenderer(new TableButtonCellRenderer());
        adsTable.getColumnModel().getColumn(4).setCellEditor(new AdEditButtonEditor(new JCheckBox()));
        content.add(adsTable);

        adService = new AdServiceImpl();


        tabbedPane = new JTabbedPane(JTabbedPane.TOP);


        tabbedPane.addTab("My descriptions",adsTable);{
            addButton = new JButton("ADD");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ViewRouter viewRouter = ViewRouter.getInstance();
                    viewRouter.switchView(ADS, ADD_AD);
                }
            }); tabbedPane.add(addButton);
        }

        tabbedPane.addTab("All descriptions", null);
        content.add(tabbedPane);



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
