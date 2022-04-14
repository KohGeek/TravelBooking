/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingproject;

/**
 * 
 */
public class ProfileController {

    /**
     * Default constructor
     */
    public ProfileController() {
    }

    /**
     * 
     */
    private IUserList userLists;


    /**
     * @param userDataFile
     */
    public void ProfileController(String userDataFile) {
        // TODO implement here
    }

    /**
     * @param username 
     * @param password 
     * @return
     */
    public User login(String username, String password) {
        // TODO implement here
        return null;
    }

    /**
     * @param username 
     * @param password 
     * @param email 
     * @param name 
     * @param address 
     * @param phonenumber 
     * @return
     */
    public User createClientProfile(String username, String password, String email, String name, String address, String phonenumber) {
        
        Client client=new Client();
        client.User(username, password);
        client.setEmail(email);
        client.setName(name);
        client.setAddress(address);
        client.setPhonenumber(phonenumber);
        return client;
    }

    /**
     * @param username 
     * @param value 
     * @param type 
     * @return
     */
    public void updateClientProfile(String username, String phone, String  address) {
        // TODO implement here
        Client client=new Client();
        client.User(username, "");
        client.setName(username);
        client.setAddress(address);
    }

    /**
     * @param user 
     * @return
     */
    public void updateUser(User user) {
        // TODO implement here
        return;
    }

}
