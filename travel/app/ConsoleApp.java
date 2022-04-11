package travel.app;

/**
 * 
 */
public class ConsoleApp {

    /**
     * @return
     */
    public static void main() {
        String userDataFile = "user.txt";
        String travelDataFile = "travel.txt";
        ConsoleUI ui = new ConsoleUI(userDataFile, travelDataFile);

        ui.start();
    }

}