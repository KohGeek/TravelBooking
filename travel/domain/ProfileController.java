package travel.domain;

import java.util.*;

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
        // TODO implement here
        return null;
    }

    /**
     * @param username 
     * @param value 
     * @param type 
     * @return
     */
    public void updateClientProfile(String username, String value, int type) {
        // TODO implement here
        return null;
    }

    /**
     * @param user 
     * @return
     */
    public void updateUser(User user) {
        // TODO implement here
        return null;
    }

}