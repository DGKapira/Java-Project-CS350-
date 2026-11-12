import java.util.Scanner;

// WEEK 9: Interface = a shared capability (contract). Any room that can be
// booked promises to provide these operations.
interface Bookable {
    String getName();
    boolean isBooked();
    void book(int lecturerId, int day, int startHour, int endHour);
    void unbook();
    String describe();
    void displayInfo();
    void displayBookingDetails();
}

// WEEK 9: Room is now ABSTRACT - a generic "room" should not be created
// directly. It still keeps the fields/constructor from Week 8.
abstract class Room {

    private String name;

    public Room(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Classroom name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // WEEK 9: Abstract method - every concrete room MUST implement this
    public abstract String getRoomType();

    public String describe() {
        return name;
    }
}

// WEEK 8: Classroom IS-A Room | WEEK 9: Classroom also implements Bookable
class Classroom extends Room implements Bookable {

    // 1. Encapsulation: private fields
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
        super(name); // WEEK 8: Room constructor runs first
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

    // WEEK 9: Implements the abstract method declared in Room
    @Override
    public String getRoomType() {
        return "Classroom";
    }

    // 5. Getters (getName() is inherited from Room)
    // WEEK 9: @Override because these now fulfil the Bookable contract
    @Override
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
    @Override // WEEK 9: Bookable
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

    @Override // WEEK 9: Bookable
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

    // WEEK 8: Method overriding + super.method()
    @Override
    public String describe() {
        return super.describe() + " - Booked: " + booked;
    }

    @Override // WEEK 9: Bookable
    public void displayInfo() {
        System.out.println(describe());
    }

    @Override // WEEK 9: Bookable
    public void displayBookingDetails() {

        if (!booked) {
            System.out.println(getName() + " is not currently booked.");
            return;
        }

        System.out.println("\n--- Booking Details ---");
        System.out.println("Lecturer ID: " + lecturerId);
        System.out.println("Classroom: " + getName());
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

        // WEEK 9: Array of the INTERFACE type (was Classroom[])
        Bookable[] classrooms = new Bookable[names.length];

        for (int i = 0; i < classrooms.length; i++) {
            // WEEK 9: Upcasting - a Classroom object stored as a Bookable
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

    // WEEK 9: Parameter type changed Classroom[] -> Bookable[] (polymorphism)
    public static void displayClassrooms(Bookable[] classrooms) {

        for (int i = 0; i < classrooms.length; i++) {
            System.out.print(i + ": ");
            classrooms[i].displayInfo(); // each object runs its own describe()
        }
    }

    public static void bookClassroom(
        Bookable[] classrooms, int index, Scanner scanner) {

        if (index < 0 || index >= classrooms.length) {
            System.out.println("Invalid classroom index.");
            return;
        }

        Bookable room = classrooms[index]; // WEEK 9: declared type Bookable

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

    public static void unbookClassroom(Bookable[] classrooms, int index) {

        if (index < 0 || index >= classrooms.length) {
            System.out.println("Invalid classroom index.");
            return;
        }

        Bookable room = classrooms[index]; // WEEK 9

        try {
            room.unbook();
            System.out.println(room.getName() + " has been unbooked.");

        } catch (IllegalArgumentException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }

    public static int findClassroomIndex(
        Bookable[] classrooms, String name) {

        for (int i = 0; i < classrooms.length; i++) {

            if (classrooms[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }
}
