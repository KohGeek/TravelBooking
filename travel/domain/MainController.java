package travel.domain;

import java.util.List;

/**
 * 
 */
public class MainController {

    private IDataList travelSlotLists;
    private User currentUser;

    /**
     * @param travelDataFile
     * @param user
     */
    public MainController(String travelDataFile) {
        this.travelSlotLists = new TravelLists(travelDataFile);
    }

    /**
     * @param location
     * @return List<TravelSlot>
     */
    public List<TravelSlot> searchTravelSlots(String location) {
        return travelSlotLists.searchTravelSlots(location);
    }

    /**
     * @param travelSlotId
     * @return TravelSlot
     */
    public TravelSlot getTravelSlotDetail(int travelSlotId) {
        return travelSlotLists.getTravelSlotDetail(travelSlotId);
    }

    /**
     * @param travelSlotId
     * @param value
     * @param type
     */
    public void editTravelSlot(int travelSlotId, String value, int type) {
        travelSlotLists.editTravelSlot(travelSlotId, value, type);
    }

    /**
     * @param travelSlotId
     */
    public void removeTravelSlot(int travelSlotId) {
        travelSlotLists.removeTravelSlot(travelSlotId);
    }

    /**
     * @param id
     * @param time
     * @param date
     * @param location
     * @param price
     */
    public void createTravelSlot(int id, String time, String date, String location, float price)
            throws IllegalArgumentException {
        TravelSlot newTravelSlot;
        newTravelSlot = new TravelSlot(id);
        newTravelSlot.setTime(time);
        newTravelSlot.setDate(date);
        newTravelSlot.setLocation(location);
        newTravelSlot.setPrice(price);
        travelSlotLists.createTravelSlot(newTravelSlot);
    }

    /**
     * @param travelSlotId
     */
    public void bookTrip(int travelSlotId) {
        if (currentUser instanceof Client) {
            Client user = (Client) currentUser;
            user.addTrip(travelSlotId);
        } else {
            throw new IllegalArgumentException("Only client can book trip");
        }
    }

    /**
     * @param travelSlotId
     */
    public void cancelBooking(int travelSlotId) {
        if (currentUser instanceof Client) {
            Client user = (Client) currentUser;
            user.removeTrip(travelSlotId);
        } else {
            throw new IllegalArgumentException("Only client can cancel booking");
        }
    }

    /**
     * @param user
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}