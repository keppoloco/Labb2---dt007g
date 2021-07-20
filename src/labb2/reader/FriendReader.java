/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import labb2.Model.Friend;
import labb2.Panel.FriendPanel;

/**
 *
 * @author Tiimm
 */
public class FriendReader {
    
    public FriendReader() {
        
        // Create TreeMap object
        friendMap = new TreeMap<>();
        
        // Set path
        path = File.separator+"src"+File.separator+"labb2"+File.separator+"logs"+File.separator+"friends.list";
        
        // Instantiate path for reading friendlist
        file = new File(System.getProperty("user.dir")+path);
        //System.out.println(file);
        
        readFriendList();
        
    }
    
    private void readFriendList() {
        // Pattern to search
        Pattern p = Pattern.compile("<(.*?)>");
        
        try {
            // Open friendlist
            scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                // finding matches of the pattern
                Matcher match = p.matcher(scanner.nextLine());
                
                while (match.find()) {
                    String username = match.group(1);
                    String fullName = scanner.nextLine().substring(10);
                    String IP       = scanner.nextLine().substring(8);
                    String IMG      = scanner.nextLine();
                    friendMap.put(username, new Friend(username,fullName,IP,IMG));
                }
            }
            scanner.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FriendPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Map getFriendMap() {
        return friendMap;
    }
    
    private Map<String, Friend> friendMap;
    private File file;
    private Scanner scanner;
    private String path;
}
