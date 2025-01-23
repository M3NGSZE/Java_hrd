import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookingSeat {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int convert = 0;
        int capacity = 0;
        int booking = 0;
        String sign = "+";

        while (true){
            System.out.print("\n\n-> Enter the Seat of bus between [25-45]: ");
            String seat = scanner.next();
            boolean matches = Pattern.matches("\\b(2[5-9]|3[0-9]|4[0-5])\\b", seat);
            if(matches){
                int[] bus = new int[Integer.parseInt(seat)];
                capacity = bus.length;


                System.out.println("\n---------------- Display Bus Information ----------------\n");

                for (int i =0; i < bus.length; i++){
                    bus[i] = i+1;
                    if(bus[i] == 0){
                        sign = "-";
                    }else {
                        sign = "+";
                    }
                    if(i < 9){
                        System.out.print("(" + sign+ ") 0" + (i+1) + " \t");
                    }else{
                        System.out.print("(" + sign+ ") " + (i+1) + " \t");
                    }
                    if(i % 5 == 4){
                        System.out.println("");
                    }
                }

                System.out.println("\n( - ) : Unavailable( " + booking + " ) \t" + "( + ) : Unavailable( " + capacity + " )");

                while (true){
                    System.out.print("\nDo you want to booking the chair (Y/N)?: ");
                    String option = scanner.next();
                    String message = Pattern.matches("[yYnN]", option) ? "" : "Wrong input. Please input only yes(y/Y) or no(n/N).";
                    System.out.println(message);

                    switch (option.toLowerCase()){
                        case "y":
                            while (true){
                                System.out.print("Enter Chair number to booking: ");
                                String numSeatCon = scanner.next();
                                message = Pattern.matches("\\d+\\d?", numSeatCon) ? "" : "Wrong input.";
                                System.out.println(message);

                                if(message.isEmpty()){
                                    int numSeat = Integer.parseInt(numSeatCon);

                                    if(numSeat < 1 || numSeat > bus.length){
                                        System.out.println("\nInvalid seat number. Please choose between 1 and " + bus.length + ".");
                                        break;
                                    }

                                    System.out.print("\nDo you want to book seat " + numSeat + "? (Y/N): ");
                                    String confirmBooking = scanner.next();
                                    if (!confirmBooking.equalsIgnoreCase("y")) {
                                        System.out.println("Booking canceled.");
                                        break;
                                    }

                                    if(bus[numSeat - 1] == 0){
                                        System.out.println("\nChair number " + numSeat + " is already booked.\n");
                                    }else {
                                        bus[numSeat - 1] = 0;
                                        capacity -= 1;
                                        booking += 1;

                                        System.out.println("\nChair number " + numSeat + " has been booked successfully!");

                                    }
                                    for(int i = 0; i < bus.length; i++){

                                        if(bus[i] == 0){
                                            sign = "-";
                                        }else {
                                            sign = "+";
                                        }
                                        if(i < 9){
                                            System.out.print("(" + sign+ ") 0" + (i+1) + " \t");
                                        }else{
                                            System.out.print("(" + sign+ ") " + (i+1) + " \t");
                                        }
                                        if(i % 5 == 4){
                                            System.out.println("");
                                        }
                                    }
                                    System.out.println("\n( - ) : Unavailable( " + booking + " ) \t" + "( + ) : Unavailable( " + capacity + " )");
                                    break;
                                }
                            }
                            break;
                        case "n":
                            System.out.println("Thank you! Good luck! ");
                            return;
                        default:
                            System.out.println("");
                    }
                }
            }else {
                System.out.println("Wrong input. Please input only number between [25-45]");
            }
        }

    }

}
