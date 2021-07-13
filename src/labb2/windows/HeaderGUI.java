/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author Tiimm
 */
public class HeaderGUI extends JMenuBar {
    public HeaderGUI() {
        
        // Create JMenu objects for buttons
        fileMenu = new JMenu("File");
        showMenu = new JMenu("Show");
        
        // Create our buttongroup container for our radio buttons
        chatGroup = new ButtonGroup();
        
        // Instantiate public and private radio button
        privateButton = new JRadioButtonMenuItem("Private chat");
        publicButton  = new JRadioButtonMenuItem("Public chat");
        
        // Add radio buttons to buttongroup
        chatGroup.add(privateButton);
        chatGroup.add(publicButton);
        
        showMenu.add(publicButton);
        showMenu.add(privateButton);
        
        // Add exit button to File component
        exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        
        // Add buttons to header
        this.add(fileMenu);
        this.add(showMenu);
        
        // Add action listeners to chat radio buttons
        publicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Public chat selected.");
            }
        });
        
        privateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Private chat selected.");
            }
        });
    }
    
    private JMenu fileMenu;
    private JMenu showMenu;
    
    private ButtonGroup chatGroup;
    
    private JRadioButtonMenuItem privateButton;
    private JRadioButtonMenuItem publicButton;
    
    private JMenuItem exitItem;
    
}
