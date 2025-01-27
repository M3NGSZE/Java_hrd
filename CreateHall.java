import java.util.Scanner;

public class CreateHall {
    public static void main(String[] args) {
        // Create Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input seat numbers separated by commas
        System.out.print("Enter seats (comma separated): ");
        String str = scanner.nextLine();

        // Split the input string by commas
        String[] seatStrings = str.split(",");

        // Convert each string to an integer
        int[] seat1 = new int[seatStrings.length];
        for (int i = 0; i < seatStrings.length; i++) {
            seat1[i] = Integer.parseInt(seatStrings[i].trim()); // Parse each string to integer
        }

        // Print each integer from the array
        for (int num : seat1) {
            System.out.println(num);
        }

        // Close the scanner
        scanner.close();

    }




}
