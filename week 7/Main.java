
import java.util.Scanner;

class Classroom {

    // 1. Encapsulation: private fields
    private String name;
    private boolean booked;
    private int lecturerId;
    private int day;
    private int startHour;
    private int endHour;

    // 2. No-argument constructor
    public Classroom() {
        this("Unknown");
    }

    // 3. Parameterized constructor
    public Classroom(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Classroom name cannot be empty.");
        }

        this.name = name;
        this.booked = false;
        this.lecturerId = 0;
        this.day = 0;
        this.startHour = 0;
        this.endHour = 0;
    }

    // 4. Constructor overloading
    public Classroom(String name, boolean booked) {
        this(name);

        if (booked) {
            throw new IllegalArgumentException(
                "A classroom cannot start as booked without booking details."
            );
        }
    }

    // 5. Getters
    public String getName() {
        return name;
    }

    public boolean isBooked() {
        return booked;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public int getDay() {
        return day;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    // 6. Behaviour with validation
    public void book(int lecturerId, int day, int startHour, int endHour) {

        if (booked) {
            throw new IllegalArgumentException("Classroom is already booked.");
        }

        if (lecturerId <= 0) {
            throw new IllegalArgumentException("Lecturer ID must be positive.");
        }

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31.");
        }

        if (startHour < 0 || startHour > 23) {
            throw new IllegalArgumentException("Invalid starting hour.");
        }

        if (endHour < 1 || endHour > 24 || endHour <= startHour) {
            throw new IllegalArgumentException("Invalid ending hour.");
        }

        this.lecturerId = lecturerId;
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
        this.booked = true;
    }

    public void unbook() {

        if (!booked) {
            throw new IllegalArgumentException("Classroom is not booked.");
        }

        this.booked = false;
        this.lecturerId = 0;
        this.day = 0;
        this.startHour = 0;
        this.endHour = 0;
    }

    public int getDuration() {
        return endHour - startHour;
    }

    public void displayInfo() {
        System.out.println(name + " - Booked: " + booked);
    }

    public void displayBookingDetails() {

        if (!booked) {
            System.out.println(name + " is not currently booked.");
            return;
        }

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

        String[] names = {
            "A101", "A102", "A103", "A104", "A105", "A106", "A107",
            "B101", "B102", "B103", "B104", "B105", "B106", "B107"
        };

        // Array of Classroom objects
        Classroom[] classrooms = new Classroom[names.length];

        for (int i = 0; i < classrooms.length; i++) {
            classrooms[i] = new Classroom(names[i]);
        }

        int choice;

        do {
            System.out.println("\n=== Classroom Booking System ===");
            System.out.println("1. Display all classrooms");
            System.out.println("2. Book a classroom");
            System.out.println("3. Unbook a classroom");
            System.out.println("4. Search for a classroom");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    displayClassrooms(classrooms);
                    break;

                case 2:
                    System.out.print("Enter classroom index (0-13): ");
                    int bookIndex = scanner.nextInt();

                    bookClassroom(classrooms, bookIndex, scanner);
                    break;

                case 3:
                    System.out.print("Enter classroom index (0-13): ");
                    int unbookIndex = scanner.nextInt();

                    unbookClassroom(classrooms, unbookIndex);
                    break;

                case 4:
                    System.out.print("Enter classroom name: ");
                    String searchName = scanner.next();

                    int foundIndex = findClassroomIndex(classrooms, searchName);

                    if (foundIndex == -1) {
                        System.out.println("Classroom not found.");
                    } else {
                        classrooms[foundIndex].displayInfo();
                    }
                    break;

                case 5:
                    System.out.println("Exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }

    public static void displayClassrooms(Classroom[] classrooms) {

        for (int i = 0; i < classrooms.length; i++) {
            System.out.print(i + ": ");
            classrooms[i].displayInfo();
        }
    }

    public static void bookClassroom(
        Classroom[] classrooms, int index, Scanner scanner) {

        if (index < 0 || index >= classrooms.length) {
            System.out.println("Invalid classroom index.");
            return;
        }

        Classroom room = classrooms[index];

        try {
            System.out.print("Enter lecturer ID: ");
            int lecturerId = scanner.nextInt();

            System.out.print("Enter day (1-31): ");
            int day = scanner.nextInt();

            System.out.print("Enter starting hour (0-23): ");
            int startHour = scanner.nextInt();

            System.out.print("Enter ending hour (1-24): ");
            int endHour = scanner.nextInt();

            room.book(lecturerId, day, startHour, endHour);

            room.displayBookingDetails();
            System.out.println("\n" + room.getName() + " has been booked.");

        } catch (IllegalArgumentException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    public static void unbookClassroom(Classroom[] classrooms, int index) {

        if (index < 0 || index >= classrooms.length) {
            System.out.println("Invalid classroom index.");
            return;
        }

        Classroom room = classrooms[index];

        try {
            room.unbook();
            System.out.println(room.getName() + " has been unbooked.");

        } catch (IllegalArgumentException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }

    public static int findClassroomIndex(
        Classroom[] classrooms, String name) {

        for (int i = 0; i < classrooms.length; i++) {

            if (classrooms[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }
}
