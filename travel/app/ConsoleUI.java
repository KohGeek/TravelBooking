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
                    mainController.createTravelSlot();
                    break;
                case 2:
                    mainController.editTravelSlot();
                    break;
                case 3:
                    mainController.viewTravelSlots();
                    break;
                case 4:
                    mainController.searchTravelSlots();
                    break;
                case 5:
                    mainController.removeTravelSlot();
                    break;
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
        System.out.println("9 . Exit");

        int option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    mainController.bookTrip();
                    break;
                case 2:
                    mainController.cancelBooking();
                    break;
                case 9:
                    return;
            }
        } while (option != 9);

    }

    /**
     * @return
     */
    private void loginUI() {
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
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
            System.out.println("Enter username: ");
            String username = scanner.next();
            System.out.println("Enter password: ");
            String password = scanner.next();
            System.out.println("Enter email: ");
            String email = scanner.next();
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter address: ");
            String address = scanner.next();
            System.out.println("Enter phone number: ");
            String phonenumber = scanner.next();

            profileController.createClientProfile(username, password, email, name, address, phonenumber);
            loginUI();
        }
    }

}