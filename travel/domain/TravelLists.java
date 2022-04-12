package travel.domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.*;

/**
 * 
 */
public class TravelLists implements IDataList {

    private List<TravelSlot> travelSlots;
    private String travelDataFile;

    /**
     * Default constructor
     */
    public TravelLists(String travelDataFile) {
        this.travelSlots = new ArrayList<>();
        this.travelDataFile = travelDataFile;
        this.loadTravelFile();
    }

    /**
     * @param travelSlot
     * @return
     */
    public void createTravelSlot(TravelSlot travelSlot) {
        travelSlots.add(travelSlot);
        saveTravelFile();
    }

    /**
     * @param travelSlotId
     * @return
     */
    public void removeTravelSlot(int travelSlotId) {
        for (TravelSlot travelSlot : travelSlots) {
            if (travelSlot.getId() == travelSlotId)
                travelSlots.remove(travelSlot);
        }
        saveTravelFile();
    }

    /**
     * @param location
     * @return
     */
    public List<TravelSlot> searchTravelSlots(String location) {
        List<TravelSlot> selectedTravelSlot = new ArrayList<>();

        for (TravelSlot travelSlot : travelSlots) {
            if (travelSlot.getLocation().equals(location))
                selectedTravelSlot.add(travelSlot);
        }
        return selectedTravelSlot;
    }

    /**
     * @param travelSlotId
     * @param value
     * @param type         , 1 = date, 2 = time, 3 = price
     * @return
     */
    public void editTravelSlot(int travelSlotId, String value, int type) {

        for (TravelSlot travelSlot : travelSlots) {
            if (travelSlot.getId() == travelSlotId) {
                if (type == 1) {
                    travelSlot.setDate(value);
                } else if (type == 2) {
                    travelSlot.setTime(value);
                } else if (type == 3) {
                    travelSlot.setPrice(Float.parseFloat(value));
                }
            }
        }
        saveTravelFile();
    }

    /**
     * @param id
     * @return TravelSlot
     */
    public TravelSlot getTravelSlotDetail(int id) {
        TravelSlot selectedSlot = null;

        for (TravelSlot travelSlot : travelSlots) {
            if (travelSlot.getId() == id)
                selectedSlot = travelSlot;
        }
        return selectedSlot;
    }

    private void saveTravelFile() {
        try (FileOutputStream fileOutput = new FileOutputStream(travelDataFile)) {

            CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(fileOutput), CSVFormat.DEFAULT);
            for (TravelSlot travelSlot : travelSlots) {
                csvPrinter.printRecord(travelSlot.getId(), travelSlot.getTime(), travelSlot.getDate(),
                        travelSlot.getLocation(), travelSlot.getPrice());
            }

        } catch (FileNotFoundException e) {
            System.out.println(travelDataFile + " not found.");
        } catch (IOException e) {
            System.out.println("Error updating travel list file.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    private void loadTravelFile() {
        try (FileInputStream fileInput = new FileInputStream(travelDataFile)) {
            CSVParser csvParser = new CSVParser(new InputStreamReader(fileInput), CSVFormat.DEFAULT);
            for (CSVRecord csvRecord : csvParser) {
                TravelSlot travelSlot = new TravelSlot(Integer.parseInt(csvRecord.get(0)));
                travelSlot.setTime(csvRecord.get(1));
                travelSlot.setDate(csvRecord.get(2));
                travelSlot.setLocation(csvRecord.get(3));
                travelSlot.setPrice(Float.parseFloat(csvRecord.get(4)));
                travelSlots.add(travelSlot);
            }
        } catch (FileNotFoundException exc) {
            System.out.println(travelDataFile + " not found.");
        } catch (IOException e) {
            System.out.println("Error reading travel list file.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
