/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import labb2.Model.Friend;
import labb2.reader.ChatReader;
import labb2.reader.FriendReader;

/**
 *
 * @author Tiimm
 */
public class FriendPanel extends JPanel {

    public FriendPanel(HeaderPanel hp, ChatPanel chatPanel) {
        
        // Access the buttons
        this.hp = hp;
        this.chatPanel = chatPanel;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Instantiate Friend reader object
        fr = new FriendReader();

        // Create text label
        JLabel friendPanelText = new JLabel("Friend list");
        friendPanelText.setAlignmentX(CENTER_ALIGNMENT); // align text in center of the boxlayout
        this.add(friendPanelText); // add the text label to the parent JPanel (FriendPanel)

        // Create child panel to fill the friend list
        JPanel friendListPanel = new JPanel();

        // Change to borderlayout to "fill" the whole parent panel
        friendListPanel.setLayout(new BorderLayout());
        friendListPanel.setBorder(BorderFactory.createLineBorder(Color.black)); // add black border
        this.setBorder(new EmptyBorder(15, 15, 15, 15)); // add padding

        // Fetch the friendlist
        JList friendList;
        friendList = getFriendList();

        // Add the friendlist to the child panel
        friendListPanel.add(friendList);

        // Add selection listener
        friendList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ev) {
                if (!hp.isPublicButtonSelected()) {
                    if (!ev.getValueIsAdjusting()) {
                        String selectedFriend = friendList.getSelectedValue().toString();
                        System.out.println(selectedFriend);
                        
                        cr = new ChatReader(selectedFriend);
                        String buf = cr.getLog();
                        chatPanel.setChatContent(buf);
                        repaint();
                        
                    }
                }
            }
        });

        // Add the child panel to parent panel
        
        this.add(friendListPanel);
    }

    private JList getFriendList() {
        DefaultListModel<String> listModel = new DefaultListModel();

        Map<String, Friend> friendMap = fr.getFriendMap();

        for (String key : friendMap.keySet()) {
            listModel.addElement(key);
        }

        friendList = new JList<>(listModel);

        friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        return friendList;
    }

    private JList friendList;
    private FriendReader fr;
    private HeaderPanel hp;
    private ChatPanel chatPanel;
    private ChatReader cr;
}
