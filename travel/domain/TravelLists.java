package travel.domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class TravelLists implements IDataList {
	
	private List<TravelSlot> travelSlots;

    /**
     * Default constructor
     */
    public TravelLists() {
    	this.travelSlots = new ArrayList<>();
    }
    
    /**
     * @param travelSlot 
     * @return
     */
    public void createTravelSlot(TravelSlot travelSlot) {
    	loadTravelFile();
        travelSlots.add(travelSlot);  
        saveTravelFile();
    }

    /**
     * @param travelSlotId 
     * @return
     */    
    public void removeTravelSlot(int travelSlotId) {    	
    	loadTravelFile();
    	for (TravelSlot travelSlot : travelSlots) {
			if (travelSlot.getId()== travelSlotId)
				travelSlots.remove(travelSlot);
		}       
        saveTravelFile();   
    }

    /**
     * @param location 
     * @return
     */
    public List<TravelSlot> searchTravelSlots(String location) {
        List <TravelSlot> selectedTravelSlot = new ArrayList<TravelSlot>();
        
        for (TravelSlot travelSlot : travelSlots) {
			if (travelSlot.getLocation().equals(location))
				selectedTravelSlot.add(travelSlot);
		}
        return selectedTravelSlot;
    }
     
    /**
     * @param travelSlotId 
     * @param value 
     * @param type , 1 = date, 2 = time, 3 = price
     * @return
     */
    public void editTravelSlot(int travelSlotId, String value, int type) {       
        
    	for (TravelSlot travelSlot : travelSlots) {
	    	if (travelSlot.getId()== travelSlotId) {
	    		if(type == 1) {
	    			travelSlot.setDate(value);
	    		}
	    		else if (type == 2) {
	    			travelSlot.setTime(value);
	    		}
	    		else if (type == 3) {
	    			travelSlot.setPrice(Float.parseFloat(value));
	    		}    				
	    	}
	    }
    }       
      
    /**
     * @return
     */    
    public TravelSlot getTravelSlotDetail(int id) {
    	TravelSlot selectedSlot = null;
    	
    	for (TravelSlot travelSlot : travelSlots) {
			if (travelSlot.getId()== id)
				selectedSlot = travelSlot;
		}
    	return selectedSlot;
    }
    
    private void saveTravelFile() {
        String fileName = "travelslots";
        
        try {
        	FileOutputStream fileOutput = new FileOutputStream(fileName);
        	ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        	
        	for (TravelSlot travelSlot: travelSlots) {
        		objectOutput.writeObject(travelSlot);
        	}
        	objectOutput.close();
        	
        }catch (FileNotFoundException exc) {
        	System.out.println(fileName + " not found.");
        }catch (IOException e) {
        	System.out.println("Error updating travel list.");
        }catch (Exception e) {
        	System.out.println("Error updating travel list.");
        }
    }

    /**
     * @return
     */
    private void loadTravelFile() {
    	String fileName = "travelslots";
    	
    	try {
    		FileInputStream fileInput = new FileInputStream(fileName);    	
        	ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        
        	while(true) {
        		Object obj = null;
	    	
        		try {
        			obj = objectInput.readObject();
        		}catch(ClassNotFoundException e) {
        			System.out.println("Document broke.");
        		}catch(IOException e) {
        			break;
        		}
        		travelSlots.add((TravelSlot)obj);
        	} 
        	objectInput.close();
        	
        }catch (FileNotFoundException exc) {
        	System.out.println(fileName + " not found.");
        }catch (Exception e) {
        	System.out.println("Error updating travel list.");
        }
    }
}
