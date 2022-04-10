package travel.domain;

import java.util.*;

/**
 * 
 */
public class MainController {

    /**
     * Default constructor
     */
    public MainController() {
    }

    /**
     * 
     */
    private IDataList travelSlotLists;

    /**
     * 
     */
    private User currentUser;




    /**
     * @param travelDataFile 
     * @param user
     */
    public void MainController(String travelDataFile, User user) {
        // TODO implement here
    }

    /**
     * @param location 
     * @return
     */
    public List<TravelSlot> searchTravelSlots(String location) {
        // TODO implement here
        return null;
    }

    /**
     * @param travelSlotId 
     * @return
     */
    public TravelSlot viewTravelSlotDetail(int travelSlotId) {
        // TODO implement here
        return null;
    }

    /**
     * @param travelSlotId 
     * @param value 
     * @param type 
     * @return
     */
    public void editTravelSlot(int travelSlotId, String value, int type) {
        // TODO implement here
        return null;
    }

    /**
     * @param travelSlotId 
     * @return
     */
    public void removeTravelSlot(int travelSlotId) {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @param time 
     * @param date 
     * @param location 
     * @param price 
     * @return
     */
    public void createTravelSlot(int id, String time, String date, String location, float price) {
        // TODO implement here
        return null;
    }

    /**
     * @param username 
     * @param travelSlotId 
     * @return
     */
    public void bookTrip(String username, int travelSlotId) {
        // TODO implement here
        return null;
    }

    /**
     * @param username 
     * @param travelSlotId 
     * @return
     */
    public void cancelBooking(String username, int travelSlotId) {
        // TODO implement here
        return null;
    }

}