/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2.windows;

import javax.swing.JFrame;

/**
 *
 * @author Tiimm
 */
public class GUIWindow extends JFrame {

    public GUIWindow() {
        // Add title to GUI
        this.setTitle("Chatbox");

        // Default exit option whenever GUI is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set default size on GUI
        this.setSize(WIDTH, HEIGHT);
        
        // Fetch header gui
        this.setJMenuBar(new HeaderGUI());

        
    }

    public void start() {
        // Make GUI visible
        this.setVisible(true);
    }

    private final int WIDTH = 400;
    private final int HEIGHT = 400;

}
