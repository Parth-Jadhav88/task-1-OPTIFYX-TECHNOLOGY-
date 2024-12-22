import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class task1 {
    private static final int min = 1000;
    private static final int max = 9999;
    private static Map<Integer, PnrRecord> reservations = new HashMap<>();

    public static class User {
        private String username;
        private String password;

        Scanner sc = new Scanner(System.in);

        public User() {}

        public String getUsername() {
            System.out.print("Enter Username: ");
            username = sc.nextLine();
            return username;
        }

        public String getPassword() {
            System.out.print("Enter Password: ");
            password = sc.nextLine();
            return password;
        }
    }

    public static class PnrRecord {
        private int pnrNumber;
        private String passengerName;
        private String trainNumber;
        private String classType;
        private String journeyDate;
        private String from;
        private String to;

        Scanner sc = new Scanner(System.in);

        public int getPnrNumber() {
            Random random = new Random();
            pnrNumber = random.nextInt(max - min + 1) + min;
            return pnrNumber;
        }

        public void collectDetails() {
            System.out.print("Enter the passenger name: ");
            passengerName = sc.nextLine();
            System.out.print("Enter the train number: ");
            trainNumber = sc.nextLine();
            System.out.print("Enter the class type: ");
            classType = sc.nextLine();
            System.out.print("Enter the journey date (YYYY-MM-DD): ");
            journeyDate = sc.nextLine();
            System.out.print("Enter the starting place: ");
            from = sc.nextLine();
            System.out.print("Enter the destination place: ");
            to = sc.nextLine();
        }

        @Override
        public String toString() {
            return "PNR Number: " + pnrNumber + "\nPassenger Name: " + passengerName + "\nTrain Number: " + trainNumber +
                    "\nClass Type: " + classType + "\nJourney Date: " + journeyDate + "\nFrom: " + from + "\nTo: " + to;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        String username = user.getUsername();
        String password = user.getPassword();

        System.out.println("User Connection Granted.\n");
        
        while (true) {
            System.out.println("Enter the choice: ");
            System.out.println("1. Insert Record.");
            System.out.println("2. Delete Record.");
            System.out.println("3. Show All Records.");
            System.out.println("4. Exit.");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice == 1) {
                PnrRecord record = new PnrRecord();
                record.collectDetails();
                int pnrNumber = record.getPnrNumber();
                reservations.put(pnrNumber, record);
                System.out.println("Record added successfully with PNR: " + pnrNumber);
            } else if (choice == 2) {
                System.out.print("Enter the PNR number to delete the record: ");
                int pnrNumber = sc.nextInt();
                if (reservations.containsKey(pnrNumber)) {
                    reservations.remove(pnrNumber);
                    System.out.println("Record deleted successfully.");
                } else {
                    System.out.println("PNR not found.");
                }
            } else if (choice == 3) {
                if (reservations.isEmpty()) {
                    System.out.println("No records found.");
                } else {
                    System.out.println("\nAll records:");
                    for (PnrRecord record : reservations.values()) {
                        System.out.println(record);
                        System.out.println("--------------");
                    }
                }
            } else if (choice == 4) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
    }
}