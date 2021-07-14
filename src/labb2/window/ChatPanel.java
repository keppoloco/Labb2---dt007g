/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2.window;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tiimm
 */
public class ChatPanel extends JPanel {
    public ChatPanel() {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       
        chatTextLabel = new JLabel("Chat");
        chatTextLabel.setAlignmentX(RIGHT_ALIGNMENT);
        
        // Add chat label
        this.add(chatTextLabel);
        
        
        
    }
    
    private JLabel chatTextLabel;
    private JPanel textPanel;
}
