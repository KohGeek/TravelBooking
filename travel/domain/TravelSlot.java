package travel.domain;

/**
 * 
 */
public class TravelSlot {

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
    public TravelSlot(int id) {

        this.id = id;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public void setTime(String time) {
        this.time = time;
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
    public void setDate(String date) {
        this.date = date;
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
    public void setLocation(String location) {
        this.location = location;
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
    public void setPrice(float price) {
        this.price = price;
    }

}