import java.util.Scanner;

public class week_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] classrooms = { "A101", "A102", "A103", "A104", "A105", "A106", "A107",
                                 "B101", "B102", "B103", "B104", "B105", "B106", "B107" };
        boolean[] booked = new boolean[14];

        int choice;

        do {
            System.out.println("\n=== Classroom Booking System ===");
            System.out.println("1. Display all classrooms");
            System.out.println("2. Book a classroom");
            System.out.println("3. Unbook a classroom");
            System.out.println("4. Search for a classroom by name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayClassrooms(classrooms, booked);
                    break;

                case 2:
                    System.out.print("Enter the index of the classroom to book (0-13): ");
                    int bookIndex = scanner.nextInt();
                    bookClassroom(classrooms, booked, bookIndex);
                    break;

                case 3:
                    System.out.print("Enter the index of the classroom to unbook (0-13): ");
                    int unbookIndex = scanner.nextInt();
                    unbookClassroom(classrooms, booked, unbookIndex);
                    break;

                case 4:
                    System.out.print("Enter a classroom name to search (e.g. A104): ");
                    String searchName = scanner.next();
                    int foundIndex = findClassroomIndex(classrooms, searchName);
                    if (foundIndex == -1) {
                        System.out.println("Classroom not found.");
                    } else {
                        System.out.println(searchName + " found at index " + foundIndex
                                + ". Booked: " + booked[foundIndex]);
                    }
                    break;

                case 5:
                    System.out.println("Exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    // --- Methods below ---

    public static void displayClassrooms(String[] classrooms, boolean[] booked) {
        for (int i = 0; i < classrooms.length; i++) {
            System.out.println(i + ": " + classrooms[i] + " - Booked: " + booked[i]);
        }
    }

    public static void bookClassroom(String[] classrooms, boolean[] booked, int index) {
        if (index < 0 || index >= booked.length) {
            System.out.println("Invalid classroom index.");
            return;
        }
        if (booked[index]) {
            System.out.println(classrooms[index] + " is already booked.");
        } else {
            booked[index] = true;
            System.out.println(classrooms[index] + " has been booked.");
        }
    }

    public static void unbookClassroom(String[] classrooms, boolean[] booked, int index) {
        if (index < 0 || index >= booked.length) {
            System.out.println("Invalid classroom index.");
            return;
        }
        if (!booked[index]) {
            System.out.println(classrooms[index] + " is not currently booked.");
        } else {
            booked[index] = false;
            System.out.println(classrooms[index] + " has been unbooked.");
        }
    }

    public static int findClassroomIndex(String[] classrooms, String name) {
        for (int i = 0; i < classrooms.length; i++) {
            if (classrooms[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }
}