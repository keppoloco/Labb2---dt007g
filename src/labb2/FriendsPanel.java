/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Tiimm
 */
public class FriendsPanel extends JPanel {
    private final JPanel friendPanel;
    private final JLabel friendLabel;
    private static JList<String> friendList;
    private static JScrollPane friendScroll;
    
    private Map<String,FriendInfo> friends;
    private File file;
    private Scanner scanner;
    // Constructor
    public FriendsPanel() {
        friends = new TreeMap<>();
        // Create label for friend panel
        friendLabel = new JLabel("Friends List");
        // Create panel, using border layout
        friendPanel = new JPanel(new BorderLayout());
        // Set label in north position
        friendPanel.add(friendLabel,BorderLayout.NORTH);
        // This not working lol
        friendPanel.setBackground(Color.white);
        
    }

    public JScrollPane getFriendPanel() {
        return this.friendScroll;
    }
    public void listFriends() {

        // Create List model
        DefaultListModel<String> ListModel = new DefaultListModel<>();
        for(String key : friends.keySet()) {
            ListModel.addElement(key);
        }
        // Create JList object
        friendList = new JList<>(ListModel);
        // Single selection
        friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Create scroll
        friendScroll = new JScrollPane(friendList);
    }
        // Scan file and fill treemap with key and values
     public void fillList() {
        file = new File("src"+File.separator+"labb2"+File.separator+"logs"+File.separator+"friends.list");
        Pattern p = Pattern.compile("<(.*?)>");
        friends = new TreeMap<>();
   
        try {
            // Open file
            scanner = new Scanner(file);
            // Read the whole find
            while(scanner.hasNextLine()) {
                Matcher m = p.matcher(scanner.nextLine());
                while(m.find()) {
                    String username = m.group(1);
                    String fullName = scanner.nextLine().substring(10);
                    String IP       = scanner.nextLine().substring(8);
                    String IMG      = scanner.nextLine();
                    friends.put(username,new FriendInfo(username,fullName,IP,IMG));
                }
            }
                scanner.close();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(FriendsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}

class FriendInfo {
    private final String Username;
    private final String FullName;
    private final String IP;
    private final String img;
    public FriendInfo(String Username, String FullName, String IP, String img) {
        this.Username = Username;
        this.FullName = FullName;
        this.IP       = IP;
        this.img      = img;
    }
    public void getUser() {
        System.out.println(this.Username);
    }
    public void getFullName() {
        System.out.println(this.FullName);
    }
    public void getIP() {
        System.out.println(this.IP);
    }
    public void getImg() {
        System.out.println(this.img);
    }
}
