/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author Tiimm
 */
public class menu extends JMenu {
    private JMenuBar menubar;
    private JMenu    fileMenu;
    private JMenu    showMenu;
    private ButtonGroup group;
    private JRadioButtonMenuItem priv,pub;
    private JMenuItem item;
    public menu() {
        // Create JMenuBar object
        menubar = new JMenuBar();
        
        // Create JMenu objects
        fileMenu    = new JMenu("File");
        
        showMenu    = new JMenu("Show");
        
        //Buttongroup
        group = new ButtonGroup();
        
        // create menu item, private chat
        priv = new JRadioButtonMenuItem("Private chat"); 
        group.add(priv);
        showMenu.add(priv);
        
        // Create menu item, public chat
        pub = new JRadioButtonMenuItem("Public chat");     
        group.add(pub);
        showMenu.add(pub);
       
        pub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selecting public chat");
            }
            
        });
        
        
        // Add exit to fileMenu
        item = new JMenuItem("Quit");
        fileMenu.add(item);
        item.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        // menu to menubar
        menubar.add(fileMenu);
        menubar.add(showMenu);
         
    }
    public JMenuBar getMenu() {
        return this.menubar;
    }
}
