package travel.app;

import java.util.List;
import java.util.Scanner;
import travel.domain.*;

public class ConsoleUI {

    private User currentUser;
    private MainController mainController;
    private ProfileController profileController;
    private Scanner scanner;

    public ConsoleUI(String userDataFile, String travelDataFile) {
        this.mainController = new MainController(travelDataFile);
        this.profileController = new ProfileController(userDataFile);
        scanner = new Scanner(System.in);
    }

    /**
     * @return
     */
    private void adminUI() {

        int option = 0;
        do {
            System.out.println(
                    "Admin Menu\n1. Create new travel slot\n2. Edit travel slot\n3. View travel slot detail\n4. Search travel slots\n5. Remove travel slot\n9. Exit");

            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1: {
                    System.out.println("Create a new Travel Slot");
                    int newTravelSlotId = (int) scannerWrapperNum("Please enter the Travel Slot ID: ");
                    String time = this.scannerWrapper("Please enter the Travel Time: ");
                    String date = this.scannerWrapper("Please enter the Travel Date: ");
                    String location = this.scannerWrapper("Please enter the Travel Location: ");
                    float price = scannerWrapperNum("Please enter the Travel Price: ");
                    try {
                        mainController.createTravelSlot(newTravelSlotId, time, date, location, price);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Edit a travel slot details");
                    int travelSlotId = Integer.parseInt(this.scannerWrapper("Please enter the Travel Slot ID: "));
                    String value = this.scannerWrapper("Please enter the value: ");
                    int type = Integer.parseInt(
                            this.scannerWrapper("Please enter data to change (1 - Date, 2 - Time, 3 - Price):  "));
                    mainController.editTravelSlot(travelSlotId, value, type);
                    break;
                }
                case 3: {
                    System.out.println("View a travel slot details");
                    int travelSlotId = (int) scannerWrapperNum("Please enter the Travel Slot Id: ");
                    TravelSlot ts = mainController.getTravelSlotDetail(travelSlotId);
                    System.out.println("ID:" + ts.getId());
                    System.out.println("Time:" + ts.getTime());
                    System.out.println("Date:" + ts.getDate());
                    System.out.println("Location:" + ts.getLocation());
                    System.out.println("Price:" + ts.getPrice());
                    break;
                }
                case 4: {
                    System.out.println("Search for travel slots");
                    String location = this.scannerWrapper("Please enter location to search: ");
                    List<TravelSlot> tsList = mainController.searchTravelSlots(location);
                    for (TravelSlot ts : tsList) {
                        System.out.println("ID:" + ts.getId());
                        System.out.println("Time:" + ts.getTime());
                        System.out.println("Date:" + ts.getDate());
                        System.out.println("Location:" + ts.getLocation());
                        System.out.println("Price:" + ts.getPrice() + "\n");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Remove a travel slot");
                    int travelSlotId = Integer
                            .parseInt(scannerWrapper("Please enter the Travel Slot ID for removal: "));
                    mainController.removeTravelSlot(travelSlotId);
                    break;
                }
                case 9:
                    return;
                default:
                    System.out.println("Invalid option");
            }
        } while (option != 9);

    }

    /**
     * @return
     */
    private void clientUI() {
        int option = 0;
        do {
            System.out.println(
                    "Client Menu\n1. Book new trip\n2. Cancel booking\n3. View travel slot detail\n4. Search travel slots\n5. Update client profile\n9. Exit");

            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1: {
                    System.out.println("Book a travel trip");
                    int travelSlotId = (int) scannerWrapperNum("Please enter the Travel Slot ID for booking: ");
                    mainController.bookTrip(travelSlotId);
                    profileController.updateUser(currentUser);
                    break;
                }
                case 2: {
                    System.out.println("Cancel a booking travel trip");
                    int travelSlotId = (int) scannerWrapperNum("Please enter the Travel Slot ID for cancel: ");
                    mainController.cancelBooking(travelSlotId);
                    profileController.updateUser(currentUser);
                    break;
                }
                case 3: {
                    System.out.println("View a travel slot details");
                    int travelSlotId = (int) this.scannerWrapperNum("Please enter the Travel Slot ID : ");
                    TravelSlot ts = mainController.getTravelSlotDetail(travelSlotId);
                    System.out.println("ID:" + ts.getId());
                    System.out.println("Time:" + ts.getTime());
                    System.out.println("Date:" + ts.getDate());
                    System.out.println("Location:" + ts.getLocation());
                    System.out.println("Price:" + ts.getPrice());
                    break;
                }
                case 4: {
                    System.out.println("Search for travel slots");
                    String location = this.scannerWrapper("Please enter location to search: ");
                    List<TravelSlot> tsList = mainController.searchTravelSlots(location);
                    for (TravelSlot ts : tsList) {
                        System.out.println("ID:" + ts.getId());
                        System.out.println("Time:" + ts.getTime());
                        System.out.println("Date:" + ts.getDate());
                        System.out.println("Location:" + ts.getLocation());
                        System.out.println("Price:" + ts.getPrice() + "\n");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Update Client Profile");
                    String username = this.scannerWrapper("Please enter username: ");
                    int type = Integer.parseInt(this.scannerWrapper(
                            "Please enter data to change (1 - Email, 2 - Phone Number, 3 - Address): "));
                    String value = this.scannerWrapper("Please enter the value: ");

                    profileController.updateClientProfile(username, value, type);
                    break;
                }
                case 9:
                    return;
                default:
                    System.out.println("Invalid option");
            }
        } while (option != 9);

    }

    /**
     * @return
     */
    private void loginUI() {
        System.out.println("\n--Login--");
        String username = this.scannerWrapper("Enter username: ");
        String password = this.scannerWrapper("Enter password: ");
        currentUser = profileController.login(username, password);
        mainController.setCurrentUser(currentUser);
        if (currentUser instanceof Admin) {
            adminUI();
        } else if (currentUser instanceof Client) {
            clientUI();
        } else {
            System.out.println("Invalid username or password");
        }
    }

    /**
     * @return
     */
    public void start() {
        int choice = 0;
        while (choice != 9) {
            System.out.println("Welcome to Travel Booking System\n");
            choice = (int) scannerWrapperNum("1) Login \n2) Create Profile\n9) Exit");
            if (choice == 1) {
                loginUI();
            } else if (choice == 2) {
                String username = this.scannerWrapper("Enter username: ");
                String password = this.scannerWrapper("Enter password: ");
                String email = this.scannerWrapper("Enter email: ");
                String name = this.scannerWrapper("Enter name: ");
                String address = this.scannerWrapper("Enter address: ");
                String phonenumber = this.scannerWrapper("Enter phone number: ");
                profileController.createClientProfile(username, password, email, name, address, phonenumber);
                loginUI();
            } else if (choice == 9) {
                System.out.println("Bye");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    private String scannerWrapper(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private float scannerWrapperNum(String message) {
        float value = 0;
        boolean valid = false;
        System.out.println(message);
        do {
            try {
                value = Float.parseFloat(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, must be number");
            }
        } while (!valid);
        return value;
    }

}