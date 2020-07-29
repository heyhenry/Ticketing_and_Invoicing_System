import java.util.Scanner;

public class InvoicingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // account related
        String accountNumber;

        // customer related
        String name;
        String email;
        String mobile;
        String home;

        // card related
        String creditCardNo;
        String cardExpiryDate;
        int securityCode;

        // sector related
        String tripDate;
        int startSector;
        int endSector;
        int sectorsTravelled;
        double tripCharge;

        // regexes
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String accountRegex = "^[0-9]{2}+\\s+[0-9]{4}$";

        System.out.println("\n*** Regional Passenger Train Invoicing System ***\n");

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLine();

        while(!accountNumber.matches(accountRegex)) {

            System.out.println("User input format incorrect! Try again.");
            accountNumber = sc.nextLine();

        }

        System.out.print("Enter Customer Name: ");
        name = sc.nextLine();

        System.out.print("Enter Customer Email Address: ");
        email = sc.nextLine();

        while(!email.matches(emailRegex)) {

            System.out.println("Incorrect format! Try again");
            email = sc.nextLine();

        }

        System.out.print("Enter customer Mobile Phone No: ");
        mobile = sc.nextLine();

        System.out.print("Enter Customer Home Address: ");
        home = sc.nextLine();

        System.out.println("");

        System.out.print("Enter Credit Card No: ");
        creditCardNo = sc.nextLine();

        System.out.print("Enter Expiry Date: ");
        cardExpiryDate = sc.nextLine();

        System.out.print("Enter Security Code: ");
        securityCode = sc.nextInt();

        System.out.println("");

        System.out.print("Enter Trip Date: ");
        tripDate = sc.nextLine();
        sc.nextLine();

        System.out.print("Enter start sector (1 - 10): ");
        startSector = sc.nextInt();

        System.out.print("Enter end sector (1 - 10): ");
        endSector = sc.nextInt();

        sectorsTravelled = (Math.abs(endSector - startSector) + 1);

        tripCharge = sectorsTravelled * 2.00;

        System.out.println("\nCustomer Details: \n");

        System.out.printf("%-40s%s\n", "Name:", name);
        System.out.printf("%-40s%s\n", "Email Address:", email);
        System.out.printf("%-40s%s\n", "Mobile Phone Number:", mobile);
        System.out.printf("%-40s%s\n", "Home Address:", home);

        System.out.println("\nCard Details: \n");

        System.out.printf("%-40s%s\n", "Credit Card No:", creditCardNo);
        System.out.printf("%-40s%s\n", "Expiry Date:", cardExpiryDate);

        System.out.println("\nTrip Details: \n");

        System.out.printf("%-40s%s\n", "Date:", tripDate);
        System.out.printf("%-40s%s\n", "Sectors Travelled:", sectorsTravelled);
        System.out.printf("%-39s%s%.2f\n", "Basic Trip Fare:", "$", tripCharge);


    }

}
