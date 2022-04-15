package travel.app;

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
        System.out.println("Admin Menu");
        System.out.println("1 . Create New Travel Slot");
        System.out.println("2 . Edit Travel Slot");
        System.out.println("3 . View Travel Slot Detail");
        System.out.println("4 . Search Travel Slots");
        System.out.println("5 . Remove Travel Slot");
        System.out.println("9 . Exit");

        int option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                {
                    System.out.println("Create a new Travel Slot");
                    System.out.print("Please enter the Travel Slot Id : ");
                    int newTravelSlotId = scanner.nextInt();
                    System.out.print("Please enter the Travel Time : ");
                    String time = scanner.next();
                    System.out.print("Please enter the Travel Date : ");
                    String date = scanner.next();
                    System.out.print("Please enter the Travel Location : ");
                    String location = scanner.next();
                    System.out.print("Please enter the Travel Price : ");
                    float price = scanner.nextFloat();
                    mainController.createTravelSlot(newTravelSlotId, time, date, location, price);
                    break;
                }
                case 2:
                {
                    System.out.println("Edit a travel slot details");
                    System.out.print("Please enter the Travel Slot Id : ");
                    int travelSlotId = scanner.nextInt();
                    System.out.print("Please enter the detail value : ");
                    String value = scanner.next();
                    System.out.print("Please enter the type : ");
                    int type = scanner.nextInt();
                    mainController.editTravelSlot(travelSlotId, value, type);
                    break;
                }
                case 3:
                {
                    System.out.println("View a travel slot details");
                    System.out.print("Please enter the Travel Slot Id : ");
                    int travelSlotId = scanner.nextInt();
                    mainController.getTravelSlotDetail(travelSlotId);
                    break;
                }
                case 4:
                {
                    System.out.println("Search for travel slots");
                    System.out.print("Please enter location to search : ");
                    String location = scanner.next();
                    mainController.searchTravelSlots(location);
                    break;
                }
                case 5:
                {
                    System.out.println("Remove a travel slot");
                    System.out.print("Please enter the Travel Slot Id for removal : ");
                    int travelSlotId = scanner.nextInt();
                    mainController.removeTravelSlot(travelSlotId);
                    break;
                }
                case 9:
                    return;
            }
        } while (option != 9);

    }

    /**
     * @return
     */
    private void clientUI() {
        System.out.println("Client Menu");
        System.out.println("1 . Book New Trip");
        System.out.println("2 . Cancel Booking");
        System.out.println("3 . View Travel Slot Detail");
        System.out.println("4 . Update Client Profile");
        System.out.println("9 . Exit");

        int option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                {
                    System.out.println("Book a travel trip");
                    System.out.print("Please enter the Travel Slot Id for booking : ");
                    int travelSlotId = scanner.nextInt();
                    mainController.bookTrip(travelSlotId);
                    break;
                }
                case 2:
                {
                    System.out.println("Cancel a booking travel trip");
                    System.out.print("Please enter the Travel Slot Id for cancel : ");
                    int travelSlotId = scanner.nextInt();
                    mainController.cancelBooking(travelSlotId);
                    break;
                }
                case 3:
                {
                    System.out.println("View a travel slot details");
                    System.out.print("Please enter the Travel Slot Id : ");
                    int travelSlotId = scanner.nextInt();
                    mainController.getTravelSlotDetail(travelSlotId);
                    break;
                }
                case 4:
                {
                    System.out.println("Update Client Profile");
                    System.out.print("Please enter username: ");
                    String username = scanner.next();
                    System.out.print("Please enter the detail value : ");
                    String value = scanner.next();
                    System.out.print("Please enter the type : ");
                    int type = scanner.nextInt();
                    profileController.updateClientProfile(username, value, type);
                    break;
                }
                case 9:
                    return;
            }
        } while (option != 9);

    }

    /**
     * @return
     */
    private void loginUI() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        currentUser = profileController.login(username, password);
        if (currentUser instanceof Admin) {
            adminUI();
        } else {
            clientUI();
        }
    }

    /**
     * @return
     */
    public void start() {
        System.out.println(" 1 Login | 2 Create Profile");
        int choice = scanner.nextInt();
        if (choice == 1) {
            loginUI();
        }
        if (choice == 2) {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter address: ");
            String address = scanner.next();
            System.out.print("Enter phone number: ");
            String phonenumber = scanner.next();

            profileController.createClientProfile(username, password, email, name, address, phonenumber);
            loginUI();
        }
    }

}