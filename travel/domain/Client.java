package travel.domain;

import java.util.*;

public class Client extends User {

	//default constructor
    public Client(String username, String password, String email, String name, String address, String phonenumber, List<Integer> bookingList) {
    	super(username, password);
    	this.email = email;
    	this.name = name;
    	this.address = address;
    	this.phonenumber = phonenumber;
    	this.bookingList = new ArrayList<>();
    }

 

	private String email;
    //getter
    public String getEmail() {
        return email;
    }

    private String name;
    //getter
    public String getName() {
        return name;
    }

    private String address;
    //getter
    public String getAddress() {
        return address;
    }

    private String phonenumber;
    //getter
    public String getPhonenumber() {
        return phonenumber;
    }

    //setter
    public void setEmail(String value1) {
        email = value1;
    }

    //setter
    public void setName(String value2) {
        name = value2;
    }

    //setter
    public void setAddress(String value3) {
       address = value3;
    }


    public void setPhonenumber(String value4) {
        phonenumber = value4;
    }


    private List<Integer> bookingList;
    //getter
    public List<Integer> getAllBookedTrip() {
        return bookingList;
    }

    //Assume TravelSlotId is the index of the bookingList
    public void addTrip(int TravelSlotId) {
    	bookingList.add(TravelSlotId);
    }

    //Assume TravelSlotId is the index of the bookingList
    public void removeTrip(int TravelSlotId) {
        bookingList.remove(TravelSlotId-1);
    }

}
