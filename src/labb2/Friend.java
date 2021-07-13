/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

/**
 *
 * @author Tiimm
 */
public class Friend {
    
    public Friend(String username, String fullName, String ip, String image) {
        this.username = username;
        this.fullName = fullName;
        this.ip = ip;
        this.image = image;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public String getIp() {
        return ip;
    }
    
    public String getImage() {
        return image;
    }
    
    private String username;
    private String fullName;
    private String ip;
    private String image;
}
