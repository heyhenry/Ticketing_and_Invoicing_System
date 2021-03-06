import java.util.ArrayList;
import java.util.Scanner;

public class InvoicingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> tripList = new ArrayList<>();
        ArrayList<String> kioskEntry = new ArrayList<>();

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
        String securityCode;

        // trip related
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
        double tripFareTotal = 0;

        // kiosk related
        String description;
        double kioskPrice;
        String kiosk;
        double kioskPurchaseTotal = 0;

        double finalInvoiceCharge;

        // regexes
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String accountRegex = "^[0-9]{15}$";
        String mobileRegex = "^[0-9]{10}$";
        String creditCardNoRegex = "^[0-9]{16}$";
        String cardExpiryDateRegex = "^[0-9]{6}$";
        String securityCodeRegex = "^[0-9]{3}$";

        System.out.println("\n*** Regional Passenger Train Invoicing System ***\n");

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLine();

        while(!accountNumber.matches(accountRegex)) {

            System.out.println("Needs to be 15 digits! Try again.");
            accountNumber = sc.nextLine();

        }

        System.out.print("Enter Customer Name: ");
        name = sc.nextLine();

        System.out.print("Enter Customer Email Address: ");
        email = sc.nextLine();

        while(!email.matches(emailRegex)) {

            System.out.println("Incorrect format! Try again");
            System.out.println("Ex. something@myemail.com");
            email = sc.nextLine();

        }

        System.out.print("Enter customer Mobile Phone No: ");
        mobile = sc.nextLine();

        while(!mobile.matches(mobileRegex)) {

            System.out.println("Needs to be 10 digits! Try again.");
            mobile = sc.nextLine();

        }

        System.out.print("Enter Customer Home Address: ");
        home = sc.nextLine();

        System.out.println();

        System.out.print("Enter Credit Card No: ");
        creditCardNo = sc.nextLine();

        while(!creditCardNo.matches(creditCardNoRegex)) {

            System.out.println("Needs to be 16 digits! Try again.");
            creditCardNo = sc.nextLine();

        }

        System.out.print("Enter Expiry Date: ");
        cardExpiryDate = sc.nextLine();

        while(!cardExpiryDate.matches(cardExpiryDateRegex)) {

            System.out.println("Needs to be 6 digits! Try again.");
            System.out.println("Ex. dd/yyyy");
            cardExpiryDate = sc.nextLine();

        }

        System.out.print("Enter Security Code: ");
        securityCode = sc.nextLine();

        while(!securityCode.matches(securityCodeRegex)) {

            System.out.println("Needs to be 3 digits! Try again.");
            securityCode = sc.nextLine();

        }

        System.out.println();

        do {

            System.out.println("Regional Passenger Train Data Entry Menu \n");
            System.out.println("--------------------------------------------------");
            System.out.println("A - Add Trip");
            System.out.println("B - Record Kiosk Purchase");
            System.out.println("C - Return to Menu");
            System.out.println("X - Exit Menu");

            System.out.println("\nEnter your selection: ");
            choice = sc.nextLine().charAt(0);

            switch(Character.toUpperCase(choice)) {

                case 'A' :

                    System.out.print("Enter Trip Date: ");
                    tripDate = sc.nextLine();

                    System.out.print("Enter start sector (1 - 10): ");
                    startSector = sc.nextInt();

                    while(startSector > 10 || startSector < 1) {

                        System.out.println("It needs to be a number between 1 - 10!");
                        startSector = sc.nextInt();

                    }

                    System.out.print("Enter end sector (1 - 10): ");
                    endSector = sc.nextInt();

                    while(endSector > 10 || endSector < 1) {

                        System.out.println("It needs to be a number between 1 - 10");
                        endSector = sc.nextInt();

                    }


                    sc.nextLine();
                    System.out.print("Enter Booking (S, RS or FC): ");
                    bookingType = sc.nextLine();

                    while(!bookingType.matches("S") && !bookingType.matches("RS") && !bookingType.matches("FC")
                     && !bookingType.matches("s") && !bookingType.matches("rs") && !bookingType.matches("fc")) {

                        System.out.println("It needs to be (S, RS, FC)! Try again.");
                        bookingType = sc.nextLine();

                    }

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

                    tripFareTotal = tripFareTotal + adjustedTripFare;
                    tripList.add(trip);

                    System.out.println("\nAdding Trip...");
                    break;

                case 'B' :

                    System.out.print("Enter Trip Date: ");
                    tripDate = sc.nextLine();

                    System.out.print("Enter Description: ");
                    description = sc.nextLine();

                    System.out.print("Cost of Kiosk Purchase: ");
                    kioskPrice = sc.nextDouble();
                    sc.nextLine();

                    kiosk = String.format("%s%s%s%s%s%.2f", "- ", tripDate, " - ", description, " : $", kioskPrice);

                    kioskPurchaseTotal = kioskPurchaseTotal + kioskPrice;
                    kioskEntry.add(kiosk);

                    System.out.println("Recording Kiosk Purchase...");
                    break;

                case 'C' :

                    System.out.println("Returning to menu...");
                    break;

                case 'X' :

                    System.out.println("Exiting menu....");
                    break;

                default :

                    System.out.println("Invalid input! Returning to menu...");
                    break;

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

        System.out.printf("\n%s%.2f\n", "Trip Fare Total: $", tripFareTotal);

        System.out.println("\nKiosk Purchases: \n");

        for(String k : kioskEntry) {

            System.out.println(k);

        }

        System.out.printf("\n%s%.2f\n", "Kiosk Total Purchase: $", kioskPurchaseTotal);

        finalInvoiceCharge = tripFareTotal + kioskPurchaseTotal;

        System.out.printf("\n%s%.2f\n", "Final Invoice Total: $", finalInvoiceCharge);

    }

}
