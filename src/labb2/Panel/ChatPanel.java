/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import labb2.reader.ChatReader;

/**
 *
 * @author Tiimm
 */
public class ChatPanel extends JPanel {

    public ChatPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        chatTextLabel = new JLabel("Public Chat");
        chatTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add chat label
        this.add(chatTextLabel);

        chatPanel = new JPanel(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        this.setBorder(new EmptyBorder(15, 15, 15, 15));

        cr = new ChatReader();

        chatContent = new JTextArea(cr.getLog());
        chatContent.setEditable(false);
        chatContent.setWrapStyleWord(true);
        chatContent.setBorder(new EmptyBorder(2, 2, 2, 2));

        JScrollPane chatScroll = new JScrollPane(chatContent);
        chatScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        chatPanel.add(chatScroll);
        this.add(chatPanel);

    }

    public void setChatContent(String chatBuffer) {
        chatContent.setText(chatBuffer);
    }

    private JLabel chatTextLabel;
    private JPanel chatPanel;
    private JTextArea chatContent;

    private ChatReader cr;
}
