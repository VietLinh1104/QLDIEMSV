/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom3.qlsv.controller;

import com.nhom2.qlsv.bean.DanhMucBean;
import com.nhom2.qlsv.view.KhoaHocJPanel;
import com.nhom2.qlsv.view.SinhVienJPanel;
import com.nhom2.qlsv.view.TrangChuJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;
    
   public ChuyenManHinhController(JPanel jpnRoot){
       this.root = jpnRoot;
   }
    
    public void setview(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(Color.red);
        jlbItem.setBackground(Color.black);
    
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
        
    }
    
    public void setEvent(List<DanhMucBean> listItem){
            this.listItem = listItem;
        
            for(DanhMucBean item:listItem){
                item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
            }
    }
    
    
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case"TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case"SinhVien":
                    node = new SinhVienJPanel();
                    break;
                case"KhoaHoc":
                    node = new KhoaHocJPanel();
                    break;

                default:
                    node = new TrangChuJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(76,176,80));
                jlbItem.setBackground(new Color(76,176,80));
            }
        }
        
    }
    
    
    private void setChangeBackground(String kind){
        for (DanhMucBean item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191));
                
            }else {
                item.getJpn().setBackground(new Color(76,175,80));
                item.getJlb().setBackground(new Color(76,175,80));
                
            }
        }
    }
    
}
