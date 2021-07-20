/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import labb2.Panel.FriendPanel;

/**
 *
 * @author Tiimm
 */
public class ChatReader {

    public ChatReader() {

        // Initialize with default public chat
        path = File.separator + "src" + File.separator + "labb2" + File.separator + "logs" + File.separator;

        // Default user
        user = "Eurakarte";

    }

    public ChatReader(String selectedUser) {
        // Initialize with default public chat
        path = File.separator + "src" + File.separator + "labb2" + File.separator + "logs" + File.separator;

        // Default user
        user = selectedUser;

    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLog() {

        try {

            file = new File(System.getProperty("user.dir") + path + user + ".log");
            //System.out.println(file);

            scanner = new Scanner(file);
            System.out.println(file);

            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append('\n');
            }
            scanner.close();

            chatContent = sb.toString();

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(FriendPanel.class.getName()).log(Level.SEVERE, null, ex);
            chatContent = "Not found.";
        }

        return chatContent;
    }
    
    private File file;
    private Scanner scanner;

    private String path;
    private String chatContent;
    private String user;
}
