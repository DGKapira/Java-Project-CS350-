// Scanner class so that keyboard input can be read
import java.util.Scanner;

public class ClassBookSystem {

    // Display the main menu
    static void displayMenu() {
        System.out.println("\nClassroom Booking System");
        System.out.println("1: View Classrooms Available");
        System.out.println("2: Booked Classrooms");
        System.out.println("3: Book a Classroom");
        System.out.println("4: Unbook Classroom");
        System.out.println("5: Exit");
        System.out.print("Select an option: ");
    }

    // Display all classrooms
    static void displayClassrooms() {
        System.out.println("\nGround floor classes");
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
    }

    // Display available classrooms
    static void displayAvailableClassrooms(boolean[] booked) {

        System.out.println("\nClassrooms Available:");

        System.out.println("Ground floor classes");

        for (int i = 0; i < 7; i++) {
            if (!booked[i]) {
                System.out.println((i + 1) + ": A10" + (i + 1));
            }
        }

        System.out.println("\nFirst floor classes");

        for (int i = 7; i < 14; i++) {
            if (!booked[i]) {
                System.out.println((i + 1) + ": B10" + (i - 6));
            }
        }
    }

    // Display booked classrooms
    static void displayBookedClassrooms(boolean[] booked) {

        System.out.println("\nBooked Classrooms:");

        boolean anyBooked = false;

        for (int i = 0; i < booked.length; i++) {

            if (booked[i]) {

                if (i < 7) {
                    System.out.println((i + 1) + ": A10" + (i + 1));
                } else {
                    System.out.println((i + 1) + ": B10" + (i - 6));
                }

                anyBooked = true;
            }
        }

        if (!anyBooked) {
            System.out.println("No classrooms are currently booked.");
        }
    }

    // Check whether a classroom is booked
    static boolean isClassroomBooked(boolean[] booked, int roomNumber) {
        return booked[roomNumber - 1];
    }

    // Book a classroom
    static void bookClassroom(boolean[] booked, Scanner input) {

        System.out.println("\n--- Book a Classroom ---");

        displayClassrooms();

        System.out.print("\nEnter the classroom number you want to book: ");
        int bookRoom = input.nextInt();

        if (bookRoom < 1 || bookRoom > 14) {
            System.out.println("That classroom does not exist.");
            return;
        }

        if (isClassroomBooked(booked, bookRoom)) {

            if (bookRoom <= 7) {
                System.out.println("Room A10" + bookRoom + " is already booked.");
            } else {
                System.out.println("Room B10" + (bookRoom - 7) + " is already booked.");
            }

            return;
        }

        System.out.print("Enter your lecturer ID: ");
        int lecturerId = input.nextInt();

        System.out.print("Enter the day of the month (1-31): ");
        int day = input.nextInt();

        System.out.print("Enter starting hour: ");
        int startHour = input.nextInt();

        System.out.print("Enter ending hour: ");
        int endHour = input.nextInt();

        int duration = endHour - startHour;

        booked[bookRoom - 1] = true;

        System.out.println("\n--- Booking Details ---");
        System.out.println("Lecturer ID: " + lecturerId);
        System.out.println("Classroom number: " + bookRoom);
        System.out.println("Day: " + day);
        System.out.println("Start time: " + startHour + ":00");
        System.out.println("End time: " + endHour + ":00");
        System.out.println("Duration: " + duration + " hours");

        System.out.println("\nClassroom number " + bookRoom + " has been booked.");
    }

    // Unbook a classroom
    static void unbookClassroom(boolean[] booked, Scanner input) {

        System.out.println("\n--- Unbook a Classroom ---");

        System.out.print("Enter the classroom number you want to unbook: ");
        int unbookRoom = input.nextInt();

        if (unbookRoom < 1 || unbookRoom > 14) {
            System.out.println("That classroom does not exist.");
            return;
        }

        if (booked[unbookRoom - 1]) {

            booked[unbookRoom - 1] = false;

            if (unbookRoom <= 7) {
                System.out.println("Room A10" + unbookRoom
                        + " has been unbooked.");
            } else {
                System.out.println("Room B10" + (unbookRoom - 7)
                        + " has been unbooked.");
            }

        } else {

            if (unbookRoom <= 7) {
                System.out.println("Room A10" + unbookRoom
                        + " is not currently booked.");
            } else {
                System.out.println("Room B10" + (unbookRoom - 7)
                        + " is not currently booked.");
            }
        }
    }

    // This is where the program starts
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // One boolean for each classroom
        boolean[] booked = new boolean[14];

        boolean running = true;

        do {

            displayMenu();

            int option = input.nextInt();

            switch (option) {

                case 1:
                    displayAvailableClassrooms(booked);
                    break;

                case 2:
                    displayBookedClassrooms(booked);
                    break;

                case 3:
                    bookClassroom(booked, input);
                    break;

                case 4:
                    unbookClassroom(booked, input);
                    break;

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