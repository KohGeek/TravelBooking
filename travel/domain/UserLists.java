/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingproject;

import java.util.List;

/**
 * 
 */
public class UserLists implements IUserList {

    /**
     * Default constructor
     */
    public UserLists() {
    }

    /**
     * 
     */
    private List<User> users;

    /**
     * 
     */
    private String userDataFile;


    /**
     * @param userDataFile
     */
    public void UserLists(String userDataFile) {
        // TODO implement here
    }

    /**
     * @param username 
     * @param password 
     * @return
     */
    public User login(String username, String password) {
        // TODO implement here
        
        for(User u : this.users)
        {
            if(u.getUsername().equals(username)&&u.getPassword().equals(password))
            {
                return u;
            }
        }
        
        return null;
    }

    /**
     * @param user 
     * @return
     */
    public User createClientProfile(User user) {
        boolean b=true;
        for(User u : this.users)
        {
            if(u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword()))
            {
                b=false;
            }
        }
        if(b)
        {
            this.users.add(user);
        }
        return user;
    }

    /**
     * @param username 
     * @param value  
     * @param type 
     * @return
     */
    public void updateClientProfile(String username, String value , int type) {
        // TODO implement here
        Client c = (Client)users.get(type);
        c.setAddress(value);
        
    }

    /**
     * @param user 
     * @return
     */
    public void updateUser(User user) {
        // TODO implement here
        boolean b=true;
        for(User u : this.users)
        {
            if(u.getUsername().equals(user.getUsername()))
            {
                u=user;
            }
        }
        
    }

    /**
     * @return
     */
    private void saveUserFile() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    private void loadUserFile() {
        // TODO implement here
        return;
    }


}
