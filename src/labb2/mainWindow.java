/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Tiimm
 */
public class mainWindow extends JFrame {
    private final int height;
    private final int width;
    private static menu menu;
    private static FriendsPanel friendPanel;
    public mainWindow() {
        this.height = 400;
        this.width  = 400;
        // Title of the application
        this.setTitle("Laboration 2");
        // Will eliminate the application process when exited
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Give window size
        this.setSize(height,width);
        // Create menu object and add it to main windows
        menu = new menu();
        this.setJMenuBar(menu.getMenu());
        // Create friend panel object and set position to east
        friendPanel = new FriendsPanel();
        friendPanel.fillList();
        friendPanel.listFriends();
        
        this.add(friendPanel.getFriendPanel(),BorderLayout.EAST);
        
        // Make main window visible
        this.setVisible(true);
        
    }
    
}