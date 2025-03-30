/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author kiman
 */
public class Func_class {
    public void disPlayImage(int width,int height,String linkImage,JLabel jlabel){
        ImageIcon imgIcon=new ImageIcon(linkImage);
        Image image=imgIcon.getImage().getScaledInstance(width, height,Image.SCALE_SMOOTH);
        jlabel.setIcon(new ImageIcon(image));
    }
    public void centerTable(JTable table){
        DefaultTableCellRenderer center=new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<table.getColumnCount();i++){
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        //lấy renderer mặc định của jtableHeader(jtableHeader có một renderer mặc định là DefaultTableCellRenderer)
        DefaultTableCellRenderer centerHeader=(DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        //Gán center cho các jlabel của header table
        centerHeader.setHorizontalAlignment(JLabel.CENTER);
    }
    public void setUpTable(JTable table){
        table.setRowHeight(25);
        table.setBackground(Color.white);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);
        table.setFillsViewportHeight(true);
        Font font_hearderTable=new Font("Arial",Font.BOLD,15);
        table.getTableHeader().setFont(font_hearderTable);
    }
    public void cursorPointer(JLabel label){
        label.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }
    public void notAllowText(JTextField jtf){
        jtf.addKeyListener(new KeyAdapter(){
           public void keyTyped(KeyEvent e){
               char c=e.getKeyChar();
               if(!Character.isDigit(c)){
                   e.consume(); 
               }
           }
        });
    }
    public void notAllowNumber(JTextField jtf){
        jtf.addKeyListener(new KeyAdapter(){
           public void keyTyped(KeyEvent e){
               char c=e.getKeyChar();
               if(Character.isDigit(c)){
                   e.consume(); 
               }
           }
        });
    }
}
