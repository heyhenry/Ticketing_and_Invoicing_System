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

        System.out.println("\n*** Regional Passenger Train Invoicing System ***\n");

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        name = sc.nextLine();

        System.out.print("Enter Customer Email Address: ");
        email = sc.nextLine();

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

        System.out.println("Customer Details: \n");

        System.out.printf("Name: %50s%n", name);
        System.out.printf("Email Address: %50s%n", email);
        System.out.printf("Mobile Phone Number: %50s%n", mobile);
        System.out.printf("Home Address: %50s%n", home);

        System.out.println("Card Details: \n");

        System.out.printf("Credit Card No: %50s%n", creditCardNo);
        System.out.printf("Expiry Date: %50s%n", cardExpiryDate);

        System.out.println("Trip Details: \n");

        System.out.printf("Date: %50s%n", tripDate);
        System.out.printf("Sectors Travelled: %50d%n", sectorsTravelled);
        System.out.printf("Basic Trip Fare: %50.2f%n", tripCharge);


    }

}
