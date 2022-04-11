package travel.domain;

/**
 * 
 */
public interface IUserList {

    /**
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password);

    /**
     * @param user
     * @return
     */
    public User createClientProfile(User user);

    /**
     * @param username
     * @param value
     * @param type
     * @return
     */
    public void updateClientProfile(String username, String value, int type);

    /**
     * @param user
     * @return
     */
    public void updateUser(User user);

}