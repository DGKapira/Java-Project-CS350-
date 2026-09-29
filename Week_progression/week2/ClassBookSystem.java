// Scanner class so that keyboard input can be read
import java.util.Scanner;

public class ClassBookSystem {

    // this is where the program starts
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ----- Classrooms -----
        // Ground floor: A101-A107 = rooms 1-7, First floor: B101-B107 = rooms 8-14
        // One boolean per room to track whether it's booked.
        boolean bookedA101 = false;
        boolean bookedA102 = false;
        boolean bookedA103 = false;
        boolean bookedA104 = false;
        boolean bookedA105 = false;
        boolean bookedA106 = false;
        boolean bookedA107 = false;
        boolean bookedB101 = false;
        boolean bookedB102 = false;
        boolean bookedB103 = false;
        boolean bookedB104 = false;
        boolean bookedB105 = false;
        boolean bookedB106 = false;
        boolean bookedB107 = false;

        boolean running = true;

        // Menu
        do {
            System.out.println("\nClassroom Booking System");
            System.out.println("1: View Classrooms Available");
            System.out.println("2: Booked Classrooms");
            System.out.println("3: Book a Classroom");
            System.out.println("4: Unbook Classroom");
            System.out.println("5: Exit");
            System.out.print("Select an option: ");

            int option = input.nextInt();

            // Decision Making on Menu
            switch (option) {

                // Show list of available classrooms
                case 1:
                    System.out.println("\nClassrooms Available:");

                    System.out.println("Ground floor classes");
                    if (!bookedA101) System.out.println("1: A101");
                    if (!bookedA102) System.out.println("2: A102");
                    if (!bookedA103) System.out.println("3: A103");
                    if (!bookedA104) System.out.println("4: A104");
                    if (!bookedA105) System.out.println("5: A105");
                    if (!bookedA106) System.out.println("6: A106");
                    if (!bookedA107) System.out.println("7: A107");

                    System.out.println("\nFirst floor classes");
                    if (!bookedB101) System.out.println("8: B101");
                    if (!bookedB102) System.out.println("9: B102");
                    if (!bookedB103) System.out.println("10: B103");
                    if (!bookedB104) System.out.println("11: B104");
                    if (!bookedB105) System.out.println("12: B105");
                    if (!bookedB106) System.out.println("13: B106");
                    if (!bookedB107) System.out.println("14: B107");

                    break;

                // Show booked classrooms
                case 2:
                    System.out.println("\nBooked Classrooms:");

                    // track whether we actually found any booked rooms
                    boolean anyBooked = false;

                    if (bookedA101) { System.out.println("1: A101"); anyBooked = true; }
                    if (bookedA102) { System.out.println("2: A102"); anyBooked = true; }
                    if (bookedA103) { System.out.println("3: A103"); anyBooked = true; }
                    if (bookedA104) { System.out.println("4: A104"); anyBooked = true; }
                    if (bookedA105) { System.out.println("5: A105"); anyBooked = true; }
                    if (bookedA106) { System.out.println("6: A106"); anyBooked = true; }
                    if (bookedA107) { System.out.println("7: A107"); anyBooked = true; }
                    if (bookedB101) { System.out.println("8: B101"); anyBooked = true; }
                    if (bookedB102) { System.out.println("9: B102"); anyBooked = true; }
                    if (bookedB103) { System.out.println("10: B103"); anyBooked = true; }
                    if (bookedB104) { System.out.println("11: B104"); anyBooked = true; }
                    if (bookedB105) { System.out.println("12: B105"); anyBooked = true; }
                    if (bookedB106) { System.out.println("13: B106"); anyBooked = true; }
                    if (bookedB107) { System.out.println("14: B107"); anyBooked = true; }

                    if (!anyBooked) {
                        System.out.println("No classrooms are currently booked.");
                    }

                    break;

                // Book a classroom
                case 3:
                    System.out.println("\n--- Book a Classroom ---");

                    System.out.println("Ground floor classes");
                    System.out.println("1: A101");
                    System.out.println("2: A102");
                    System.out.println("3: A103");
                    System.out.println("4: A104");
                    System.out.println("5: A105");
                    System.out.println("6: A106");
                    System.out.println("7: A107");

                    System.out.println("\nFirst floor classes");
                    System.out.println("8: B101");
                    System.out.println("9: B102");
                    System.out.println("10: B103");
                    System.out.println("11: B104");
                    System.out.println("12: B105");
                    System.out.println("13: B106");
                    System.out.println("14: B107");

                    // Allow the user to enter the classroom number they want
                    System.out.print("\nEnter the classroom number you want to book: ");
                    int bookRoom = input.nextInt();

                    if (bookRoom == 1 && bookedA101) {
                        System.out.println("Room A101 is already booked.");
                    } else if (bookRoom == 2 && bookedA102) {
                        System.out.println("Room A102 is already booked.");
                    } else if (bookRoom == 3 && bookedA103) {
                        System.out.println("Room A103 is already booked.");
                    } else if (bookRoom == 4 && bookedA104) {
                        System.out.println("Room A104 is already booked.");
                    } else if (bookRoom == 5 && bookedA105) {
                        System.out.println("Room A105 is already booked.");
                    } else if (bookRoom == 6 && bookedA106) {
                        System.out.println("Room A106 is already booked.");
                    } else if (bookRoom == 7 && bookedA107) {
                        System.out.println("Room A107 is already booked.");
                    } else if (bookRoom == 8 && bookedB101) {
                        System.out.println("Room B101 is already booked.");
                    } else if (bookRoom == 9 && bookedB102) {
                        System.out.println("Room B102 is already booked.");
                    } else if (bookRoom == 10 && bookedB103) {
                        System.out.println("Room B103 is already booked.");
                    } else if (bookRoom == 11 && bookedB104) {
                        System.out.println("Room B104 is already booked.");
                    } else if (bookRoom == 12 && bookedB105) {
                        System.out.println("Room B105 is already booked.");
                    } else if (bookRoom == 13 && bookedB106) {
                        System.out.println("Room B106 is already booked.");
                    } else if (bookRoom == 14 && bookedB107) {
                        System.out.println("Room B107 is already booked.");
                    } else if (bookRoom >= 1 && bookRoom <= 14) {

                        // The room number is valid and it is currently free, so collect booking details
                        System.out.print("Enter your lecturer ID: ");
                        int lecturerId = input.nextInt();

                        System.out.print("Enter the day of the month (1-31): ");
                        int day = input.nextInt();

                        System.out.print("Enter starting hour: ");
                        int startHour = input.nextInt();

                        System.out.print("Enter ending hour: ");
                        int endHour = input.nextInt();

                        int duration = endHour - startHour;

                        // Mark the matching room as booked
                        if (bookRoom == 1) bookedA101 = true;
                        else if (bookRoom == 2) bookedA102 = true;
                        else if (bookRoom == 3) bookedA103 = true;
                        else if (bookRoom == 4) bookedA104 = true;
                        else if (bookRoom == 5) bookedA105 = true;
                        else if (bookRoom == 6) bookedA106 = true;
                        else if (bookRoom == 7) bookedA107 = true;
                        else if (bookRoom == 8) bookedB101 = true;
                        else if (bookRoom == 9) bookedB102 = true;
                        else if (bookRoom == 10) bookedB103 = true;
                        else if (bookRoom == 11) bookedB104 = true;
                        else if (bookRoom == 12) bookedB105 = true;
                        else if (bookRoom == 13) bookedB106 = true;
                        else if (bookRoom == 14) bookedB107 = true;

                        // Display booking details
                        System.out.println("\n--- Booking Details ---");
                        System.out.println("Lecturer ID: " + lecturerId);
                        System.out.println("Classroom number: " + bookRoom);
                        System.out.println("Day: " + day);
                        System.out.println("Start time: " + startHour + ":00");
                        System.out.println("End time: " + endHour + ":00");
                        System.out.println("Duration: " + duration + " hours");

                        System.out.println("\nClassroom number " + bookRoom + " has been booked.");

                    } else {
                        // Number didn't match any of the 14 real classrooms
                        System.out.println("That classroom does not exist.");
                    }

                    break;

                // Unbook a classroom
                case 4:
                    System.out.println("\n--- Unbook a Classroom ---");

                    System.out.println("Enter the classroom number you want to unbook.");
                    int unbookRoom = input.nextInt();

                    if (unbookRoom == 1) {
                        if (bookedA101) { bookedA101 = false; System.out.println("Room A101 has been unbooked."); }
                        else System.out.println("Room A101 is not currently booked.");
                    } else if (unbookRoom == 2) {
                        if (bookedA102) { bookedA102 = false; System.out.println("Room A102 has been unbooked."); }
                        else System.out.println("Room A102 is not currently booked.");
                    } else if (unbookRoom == 3) {
                        if (bookedA103) { bookedA103 = false; System.out.println("Room A103 has been unbooked."); }
                        else System.out.println("Room A103 is not currently booked.");
                    } else if (unbookRoom == 4) {
                        if (bookedA104) { bookedA104 = false; System.out.println("Room A104 has been unbooked."); }
                        else System.out.println("Room A104 is not currently booked.");
                    } else if (unbookRoom == 5) {
                        if (bookedA105) { bookedA105 = false; System.out.println("Room A105 has been unbooked."); }
                        else System.out.println("Room A105 is not currently booked.");
                    } else if (unbookRoom == 6) {
                        if (bookedA106) { bookedA106 = false; System.out.println("Room A106 has been unbooked."); }
                        else System.out.println("Room A106 is not currently booked.");
                    } else if (unbookRoom == 7) {
                        if (bookedA107) { bookedA107 = false; System.out.println("Room A107 has been unbooked."); }
                        else System.out.println("Room A107 is not currently booked.");
                    } else if (unbookRoom == 8) {
                        if (bookedB101) { bookedB101 = false; System.out.println("Room B101 has been unbooked."); }
                        else System.out.println("Room B101 is not currently booked.");
                    } else if (unbookRoom == 9) {
                        if (bookedB102) { bookedB102 = false; System.out.println("Room B102 has been unbooked."); }
                        else System.out.println("Room B102 is not currently booked.");
                    } else if (unbookRoom == 10) {
                        if (bookedB103) { bookedB103 = false; System.out.println("Room B103 has been unbooked."); }
                        else System.out.println("Room B103 is not currently booked.");
                    } else if (unbookRoom == 11) {
                        if (bookedB104) { bookedB104 = false; System.out.println("Room B104 has been unbooked."); }
                        else System.out.println("Room B104 is not currently booked.");
                    } else if (unbookRoom == 12) {
                        if (bookedB105) { bookedB105 = false; System.out.println("Room B105 has been unbooked."); }
                        else System.out.println("Room B105 is not currently booked.");
                    } else if (unbookRoom == 13) {
                        if (bookedB106) { bookedB106 = false; System.out.println("Room B106 has been unbooked."); }
                        else System.out.println("Room B106 is not currently booked.");
                    } else if (unbookRoom == 14) {
                        if (bookedB107) { bookedB107 = false; System.out.println("Room B107 has been unbooked."); }
                        else System.out.println("Room B107 is not currently booked.");
                    } else {
                        System.out.println("That classroom does not exist.");
                    }

                    break;

                // Exit
                case 5:
                    running = false;
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (running);

        input.close();

    }
}