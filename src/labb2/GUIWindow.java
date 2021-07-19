/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import labb2.Panel.ChatPanel;
import labb2.Panel.FriendPanel;
import labb2.Panel.HeaderPanel;

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

        // add chat panel
        chatPanel = new ChatPanel();
        this.add(chatPanel, BorderLayout.WEST);

        // add Friend panel
        friendPanel = new FriendPanel(headPanel, chatPanel);
        this.add(friendPanel, BorderLayout.EAST);

        this.pack();

    }

    public void start() {
        this.setVisible(true);
    }

    private HeaderPanel headPanel;
    private ChatPanel chatPanel;
    private FriendPanel friendPanel;

}
