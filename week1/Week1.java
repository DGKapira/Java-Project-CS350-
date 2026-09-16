import java.util.Scanner;

public class Week1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String classroom;
        String userName;
        String date;

        int startHour;
        int endHour;

        System.out.print("Enter your name: ");
        userName = input.nextLine();

        System.out.print("Enter classroom: ");
        classroom = input.nextLine();

        System.out.print("Enter date: ");
        date = input.nextLine();

        System.out.print("Enter starting hour: ");
        startHour = input.nextInt();

        System.out.print("Enter ending hour: ");
        endHour = input.nextInt();

        int duration = endHour - startHour;

        System.out.println("\n--- Booking Details ---");
        System.out.println("Name: " + userName);
        System.out.println("Classroom: " + classroom);
        System.out.println("Date: " + date);
        System.out.println("Start time: " + startHour + ":00");
        System.out.println("End time: " + endHour + ":00");
        System.out.println("Duration: " + duration + " hours");

        input.close();
    }
}  