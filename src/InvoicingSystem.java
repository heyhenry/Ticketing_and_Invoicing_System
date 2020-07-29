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


        System.out.print("Enter start sector (1 - 10): ");
        startSector = sc.nextInt();

        System.out.print("Enter end sector (1 - 10): ");
        endSector = sc.nextInt();



    }

}
