/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import labb2.Panel.ChatPanel;
import labb2.Panel.FriendPanel;
import labb2.Panel.HeaderPanel;
import labb2.reader.ChatReader;

/**
 *
 * @author Tiimm
 */
public class GUIWindow extends JFrame {

    public GUIWindow() {
        // Add title to GUI
        this.setTitle("Chatbox");

        // Set background color
        this.setBackground(Color.LIGHT_GRAY);

        // Default exit option whenever GUI is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add head panel
        headPanel = new HeaderPanel();
        this.setJMenuBar(headPanel);
        
        publicButton = headPanel.getPublicButton();

        // add chat panel
        chatPanel = new ChatPanel();
        this.add(chatPanel, BorderLayout.WEST);

        // add Friend panel
        friendPanel = new FriendPanel(headPanel, chatPanel);
        this.add(friendPanel, BorderLayout.EAST);
        
        publicButton.addActionListener((ActionEvent e) -> {
            System.out.println("Public chat selected.");
            
            String chat = new ChatReader().getLog();
            chatPanel.setChatContent(chat);
                    
            repaint();
        });

        this.pack();

    }

    public void start() {
        this.setVisible(true);
    }

    private HeaderPanel headPanel;
    private ChatPanel chatPanel;
    private FriendPanel friendPanel;
    
    private JRadioButtonMenuItem privateButton;
    private JRadioButtonMenuItem publicButton;

}
