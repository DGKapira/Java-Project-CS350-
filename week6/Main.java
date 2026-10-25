import java.util.Scanner;

// Only one class per file can be public, so Classroom has no "public" keyword here
class Classroom {
    // State: what a classroom knows
    String name;
    boolean booked;
    int lecturerId;
    int day;
    int startHour;
    int endHour;

    // Behaviour: what a classroom can do
    void book(int lecturerId, int day, int startHour, int endHour) {
        this.lecturerId = lecturerId;
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
        booked = true;
    }

    void unbook() {
        booked = false;
        lecturerId = 0;
        day = 0;
        startHour = 0;
        endHour = 0;
    }

    int getDuration() {
        return endHour - startHour;
    }

    void displayInfo() {
        System.out.println(name + " - Booked: " + booked);
    }

    void displayBookingDetails() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Lecturer ID: " + lecturerId);
        System.out.println("Classroom: " + name);
        System.out.println("Day: " + day);
        System.out.println("Start time: " + startHour + ":00");
        System.out.println("End time: " + endHour + ":00");
        System.out.println("Duration: " + getDuration() + " hours");
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = { "A101", "A102", "A103", "A104", "A105", "A106", "A107",
                           "B101", "B102", "B103", "B104", "B105", "B106", "B107" };

        // An array of Classroom objects: one object per room
        Classroom[] classrooms = new Classroom[14];
        for (int i = 0; i < classrooms.length; i++) {
            classrooms[i] = new Classroom();
            classrooms[i].name = names[i];
        }

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
                    displayClassrooms(classrooms);
                    break;

                case 2:
                    System.out.print("Enter the index of the classroom to book (0-13): ");
                    int bookIndex = scanner.nextInt();
                    bookClassroom(classrooms, bookIndex, scanner);
                    break;

                case 3:
                    System.out.print("Enter the index of the classroom to unbook (0-13): ");
                    int unbookIndex = scanner.nextInt();
                    unbookClassroom(classrooms, unbookIndex);
                    break;

                case 4:
                    System.out.print("Enter a classroom name to search (e.g. A104): ");
                    String searchName = scanner.next();
                    int foundIndex = findClassroomIndex(classrooms, searchName);
                    if (foundIndex == -1) {
                        System.out.println("Classroom not found.");
                    } else {
                        System.out.println(searchName + " found at index " + foundIndex
                                + ". Booked: " + classrooms[foundIndex].booked);
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

    public static void displayClassrooms(Classroom[] classrooms) {
        for (int i = 0; i < classrooms.length; i++) {
            System.out.print(i + ": ");
            classrooms[i].displayInfo();
        }
    }

    public static void bookClassroom(Classroom[] classrooms, int index, Scanner scanner) {
        if (index < 0 || index >= classrooms.length) {
            System.out.println("Invalid classroom index.");
            return;
        }

        Classroom room = classrooms[index];

        if (room.booked) {
            System.out.println(room.name + " is already booked.");
            return;
        }

        System.out.print("Enter your lecturer ID: ");
        int lecturerId = scanner.nextInt();

        System.out.print("Enter the day of the month (1-31): ");
        int day = scanner.nextInt();

        System.out.print("Enter starting hour: ");
        int startHour = scanner.nextInt();

        System.out.print("Enter ending hour: ");
        int endHour = scanner.nextInt();

        room.book(lecturerId, day, startHour, endHour);

        room.displayBookingDetails();
        System.out.println("\n" + room.name + " has been booked.");
    }

    public static void unbookClassroom(Classroom[] classrooms, int index) {
        if (index < 0 || index >= classrooms.length) {
            System.out.println("Invalid classroom index.");
            return;
        }

        Classroom room = classrooms[index];

        if (!room.booked) {
            System.out.println(room.name + " is not currently booked.");
        } else {
            room.unbook();
            System.out.println(room.name + " has been unbooked.");
        }
    }

    public static int findClassroomIndex(Classroom[] classrooms, String name) {
        for (int i = 0; i < classrooms.length; i++) {
            if (classrooms[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }
}