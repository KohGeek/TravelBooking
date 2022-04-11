package travel.domain;

import java.util.*;

public class Client extends User {

    private String email;
    private String name;
    private String address;
    private String phonenumber;
    private List<Integer> bookingList;

    // default constructor
    public Client(String username, String password) {
        super(username, password);
        this.bookingList = new ArrayList<>();
    }

    // getter
    public String getEmail() {
        return email;
    }

    // getter
    public String getName() {
        return name;
    }

    // getter
    public String getAddress() {
        return address;
    }

    // getter
    public String getPhonenumber() {
        return phonenumber;
    }

    // setter
    public void setEmail(String value) {
        email = value;
    }

    // setter
    public void setName(String value) {
        name = value;
    }

    // setter
    public void setAddress(String value) {
        address = value;
    }

    // setter
    public void setPhonenumber(String value) {
        phonenumber = value;
    }

    // getter
    public List<Integer> getAllBookedTrip() {
        return bookingList;
    }

    // Assume TravelSlotId is the index of the bookingList
    public void addTrip(int travelSlotId) {
        bookingList.add(travelSlotId);
    }

    // Assume TravelSlotId is the index of the bookingList
    public void removeTrip(int travelSlotId) {
        bookingList.remove(travelSlotId);
    }

}
