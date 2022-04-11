package travel.domain;

import java.util.*;

public class User {
	
	//constructor
    public User(String username, String password) {
    	this.username = username;
    	this.password = password;
    }

    private String username;  
    //getter
    public String getUsername() {
        return username;
    }

    private String password;
    //getter
    public String getPassword() {
        return password;
    }
    
//    //setter
//    public void setUsername(String value1) {
//    	username = value1;
//    }
//    
//    //setter
//    public void setPassword(String value2) {
//    	password = value2;
//    }
}
