import java.util.ArrayList;
import java.util.Scanner;

public class InvoicingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> tripList = new ArrayList<>();

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
        double tripFare;
        String bookingType;
        double surcharges = 0;
        double adjustedTripFare;
        double sectorRate = 0;
        char choice;
        String trip;

//        //TODO add formatting at a later date
//        // regexes
//        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
//        String accountRegex = "^[0-9]{2}+\\s+[0-9]{4}$";

        System.out.println("\n*** Regional Passenger Train Invoicing System ***\n");

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLine();

//        while(!accountNumber.matches(accountRegex)) {
//
//            System.out.println("User input format incorrect! Try again.");
//            accountNumber = sc.nextLine();
//
//        }

        System.out.print("Enter Customer Name: ");
        name = sc.nextLine();

        System.out.print("Enter Customer Email Address: ");
        email = sc.nextLine();

//        while(!email.matches(emailRegex)) {
//
//            System.out.println("Incorrect format! Try again");
//            email = sc.nextLine();
//
//        }

        System.out.print("Enter customer Mobile Phone No: ");
        mobile = sc.nextLine();

        System.out.print("Enter Customer Home Address: ");
        home = sc.nextLine();

        System.out.println();

        System.out.print("Enter Credit Card No: ");
        creditCardNo = sc.nextLine();

        System.out.print("Enter Expiry Date: ");
        cardExpiryDate = sc.nextLine();

        System.out.print("Enter Security Code: ");
        securityCode = sc.nextInt();

        System.out.println();
        sc.nextLine();

        do {

            System.out.println("*** Trip / Kiosk Purchase Recording Menu ***");
            System.out.println("A - Add Trip");
            System.out.println("B - Record Kiosk Purchase");
            System.out.println("C - Return to Menu");
            System.out.println("X - Exit Menu");

            System.out.println("Enter your selection: ");
            choice = sc.nextLine().charAt(0);

            switch(Character.toUpperCase(choice)) {

                case 'A' :

                    System.out.print("Enter Trip Date: ");
                    tripDate = sc.nextLine();

                    System.out.print("Enter start sector (1 - 10): ");
                    startSector = sc.nextInt();

                    System.out.print("Enter end sector (1 - 10): ");
                    endSector = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter Booking (S, RS or FC): ");
                    bookingType = sc.nextLine();

                    sectorsTravelled = (Math.abs(endSector - startSector) + 1);

                    if(sectorsTravelled <= 2) {

                        sectorRate = 2.50;

                    } else if(sectorsTravelled >= 3 && sectorsTravelled <= 4) {

                        sectorRate = 2.00;

                    } else if (sectorsTravelled >= 5 && sectorsTravelled <= 7) {

                        sectorRate = 1.90;

                    } else if(sectorsTravelled >= 8 && sectorsTravelled <= 10) {

                        sectorRate = 1.80;

                    }

                    tripFare = sectorsTravelled * sectorRate;

                    if(bookingType.equalsIgnoreCase("RS")) {

                        bookingType = "Reserved Seat";

                        if(2.00 < tripFare * 20 * 0.01) {

                            surcharges = tripFare * 20 * 0.01;

                        } else {

                            surcharges = 2.00;

                        }

                    } else if (bookingType.equalsIgnoreCase("FC")) {

                        bookingType = "First Class";

                        if(4.00 < tripFare / 2) {

                            surcharges = tripFare / 2;

                        } else {

                            surcharges = 4.00;

                        }

                    } else if (bookingType.equalsIgnoreCase("S")) {

                        bookingType = "Standard";

                    }

                    adjustedTripFare = tripFare + surcharges;

                    trip = String.format("%s%s%s%s%s%d%s%.2f%s%.2f%s%.2f","- ", tripDate, " ", bookingType, " - ", sectorsTravelled, " sectors : fare: $", tripFare,
                            ", surcharge: $", surcharges, ", total: $", adjustedTripFare);

                    tripList.add(trip);

                    System.out.println("\nAdding Trip...");
                    break;

                case 'B' :

                    System.out.println("Recording Kiosk Purchase...");
                    break;

                case 'C' :

                    System.out.println("Returning to menu...");
                    break;

                case 'X' :

                    System.out.println("Exiting menu....");

            }


        } while (Character.toUpperCase(choice) != 'X');

        System.out.println("\nCustomer Details: \n");

        System.out.printf("%-20s%50s\n", "Name:", name);
        System.out.printf("%-20s%50s\n", "Email Address:", email);
        System.out.printf("%-20s%50s\n", "Mobile Phone Number:", mobile);
        System.out.printf("%-20s%50s\n", "Home Address:", home);

        System.out.println("\nCard Details: \n");

        System.out.printf("%-20s%50s\n", "Credit Card No:", creditCardNo);
        System.out.printf("%-20s%50s\n", "Expiry Date:", cardExpiryDate);

        System.out.println("\nTrip Details: \n");

        for(String t : tripList) {

            System.out.println(t);

        }

    }

}
