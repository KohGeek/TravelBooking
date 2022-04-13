package travel.app;

import java.util.Scanner;


public class ConsoleUI {

    public ConsoleUI() {
        start();
    }

    private User currentUser;
    public MainController mainController;
    public ProfileController profileController;
    private static Scanner scanner;
    
  
    /**
     * @return
     */
    private void adminUI() {
        scanner = new Scanner(System.in);
        System.out.println("Admin Menu");
        System.out.println("1 . Create New Travel Slot");
        System.out.println("2 . Edit Travel Slot");
        System.out.println("3 . View Travel Slot Detail");
        System.out.println("4 . Search Travel Slots");
        System.out.println("5 . Remove Travel Slot");
        System.out.println("9 . Exit");
        
        int option = scanner.nextInt();

        do{
        switch (option) {
            case 1:
                MainController.createTravelSlot();
                break;
            case 2:
                MainController.editTravelSlot();
                break;
            case 3:
                MainController.viewTravelSlots();
                break;
            case 4:
                MainController.searchTravelSlots();
                break;
            case 5:
                MainController.removeTravelSlot();
                break;
            case 9:
                return;
            }
        }while (option != 9);
        
    }

    /**
     * @return
     */
    private void clientUI() {
        scanner = new Scanner(System.in);
        System.out.println("Client Menu");
        System.out.println("1 . Book New Trip");
        System.out.println("2 . Cancel Booking");
        System.out.println("9 . Exit");
        
        int option = scanner.nextInt();

        do{
        switch (option) {
            case 1:
                MainController.bookTrip();
                break;
            case 2:
                MainController.cancelBooking();
                break;
            case 9:
                return;
            }
        }while (option != 9);
       
    }

    /**
     * @return
     */
    private void loginUI() {
        scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        User = ProfileController.login(name,password);
        if (User = "admin")
        {
            adminUI();
        }
        else
        {
            clientUI();
        }
    }

    /**
     * @return
     */
    public void start() {
        scanner = new Scanner(System.in);
        System.out.println(" 1 login | 2 Create Profile");
        int choice = scanner.nextInt();
        if (choice == 1)
        {
            loginUI();
        }
        if (choice == 2)
        {
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

            ProfileController.createClientProfile(username, password, email, name, address, phonenumber);
            loginUI();
        }
    }

}