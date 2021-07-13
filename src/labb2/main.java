/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.*;
import javax.swing.RowFilter.Entry;
import labb2.window.GUIWindow;
/**
 *
 * @author Tiimm
 */
public class main extends JFrame {

    public static void main(String[] args) {
        new GUIWindow().start();
        /*FriendReader fr = new FriendReader();
        fr.readFriendList();
        Map<String, Friend> fMap = fr.getFriendMap();
        for (Map.Entry<String, Friend> entry : fMap.entrySet()) {
            System.out.println("Username: " + entry.getKey());
            System.out.println("Info: " + entry.getValue().getFullName());
            System.out.println("Info: " + entry.getValue().getUsername());
            System.out.println("Info: " + entry.getValue().getIp());
        }*/
        //new mainWindow();
    }
    
}
