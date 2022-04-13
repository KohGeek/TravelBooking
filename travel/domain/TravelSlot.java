package travel.domain;

/**
 * 
 */
public class TravelSlot {

    public TravelSlot() {
    }

    /**
     * 
     */
    private int id;
    private String time;
    private String date;
    private String location;
    private float price;

    /**
     * @param id
     */
    public TravelSlot(int id, String time, String date, String location, float price) {
        this.id = id;
        this.time = time;
        this.date = date;
        this.location = location;
        this.price = price;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     * @param value
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * @param value
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param value
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param value
     */
    public void setPrice(float value) {
        this.price = value;
    }

}