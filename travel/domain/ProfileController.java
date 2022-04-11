package travel.domain;

import java.util.*;

/**
 * 
 */
public class ProfileController {

    private IUserList userLists;

    /**
     * @param userDataFile
     */
    public ProfileController(String userDataFile) {
        this.userLists = new UserLists(userDataFile);
    }

    /**
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        return userLists.login(username, password);
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
    public User createClientProfile(String username, String password, String email, String name, String address,
            String phonenumber) {
        Client client = new Client(username, password);
        client.setEmail(email);
        client.setName(name);
        client.setAddress(address);
        client.setPhonenumber(phonenumber);
        return userLists.createClientProfile(client);
    }

    /**
     * @param username
     * @param value
     * @param type
     * @return
     */
    public void updateClientProfile(String username, String value, int type) {
        userLists.updateClientProfile(username, value, type);
    }

    /**
     * @param user
     * @return
     */
    public void updateUser(User user) {
        userLists.updateUser(user);
    }

}