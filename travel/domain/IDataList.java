package travel.domain;

import java.util.List;

/**
 * 
 */
public interface IDataList {

    /**
     * @param travelSlot
     * @return
     */
    public void createTravelSlot(TravelSlot travelSlot);

    /**
     * @param travelSlotId
     * @return
     */
    public void removeTravelSlot(int travelSlotId);

    /**
     * @param location
     * @return
     */
    public List<TravelSlot> searchTravelSlots(String location);

    /**
     * @param travelSlotId
     * @param value
     * @param type
     * @return
     */
    public void editTravelSlot(int travelSlotId, String value, int type);

}