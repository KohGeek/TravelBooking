package travel.domain;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.csv.*;

/**
 * 
 */
public class UserLists implements IUserList {

    private List<User> users;
    private String userDataFile;

    /**
     * @param userDataFile
     */
    public UserLists(String userDataFile) {
        this.users = new ArrayList<>();
        this.userDataFile = userDataFile;
        loadUserFile();
    }

    /**
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {

        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    /**
     * @param user
     * @return
     */
    public User createClientProfile(User user) {
        boolean uniqueUsername = true;
        for (User temp : this.users) {
            if (temp.getUsername().equals(user.getUsername())) {
                uniqueUsername = false;
            }
        }

        if (uniqueUsername) {
            this.users.add(user);
            this.saveUserFile();
            return user;
        } else {
            return null;
        }

    }

    /**
     * @param username
     * @param value
     * @param type
     * @return
     */
    public void updateClientProfile(String username, String value, int type) {
        for (User user : this.users) {
            if (user.getUsername().equals(username)) {
                Client client = (Client) user;
                if (type == 1) {
                    client.setEmail(value);
                } else if (type == 2) {
                    client.setPhonenumber(value);
                } else if (type == 3) {
                    client.setAddress(value);
                }
            }
        }
        this.saveUserFile();
    }

    /**
     * @param user
     * @return
     */
    public void updateUser(User user) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUsername().equals(user.getUsername())) {
                this.users.set(i, user);
                break;
            }
        }
        this.saveUserFile();
    }

    /**
     * @return
     */
    private void saveUserFile() {
        try (FileOutputStream fileOutput = new FileOutputStream(userDataFile)) {

            try (CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(fileOutput), CSVFormat.DEFAULT)) {
                for (User user : this.users) {
                    if (user instanceof Client) {
                        Client client = (Client) user;
                        csvPrinter.printRecord("client", client.getUsername(), client.getPassword(), client.getName(),
                                client.getEmail(), client.getPhonenumber(), client.getAddress(),
                                client.getAllBookedTrip());
                    } else if (user instanceof Admin) {
                        csvPrinter.printRecord("admin", user.getUsername(), user.getPassword(), "", "", "", "", "");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(userDataFile + " not found.");
        } catch (IOException e) {
            System.out.println("Error updating user list file.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    private void loadUserFile() {
        try (FileInputStream fileInput = new FileInputStream(userDataFile)) {

            try (CSVParser csvParser = new CSVParser(new InputStreamReader(fileInput), CSVFormat.DEFAULT)) {
                for (CSVRecord csvRecord : csvParser) {
                    String username = csvRecord.get(1);
                    String password = csvRecord.get(2);
                    if (csvRecord.get(0).matches("admin")) {
                        this.users.add(new Admin(username, password));
                    } else {
                        Client client = new Client(username, password);
                        if (!csvRecord.get(7).equals("[]")) {
                            String text = csvRecord.get(7);
                            text = text.substring(1, text.length() - 1);
                            List<String> bookedTrips = Arrays.asList(text.split(","));
                            bookedTrips.forEach(trip -> client.addTrip(Integer.parseInt(trip)));
                        }
                        client.setName(csvRecord.get(3));
                        client.setEmail(csvRecord.get(4));
                        client.setPhonenumber(csvRecord.get(5));
                        client.setAddress(csvRecord.get(6));
                        this.users.add(client);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(userDataFile + " not found.");
        } catch (IOException e) {
            System.out.println("Error updating user list file.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
