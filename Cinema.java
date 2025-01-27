import java.util.Scanner;
import java.util.regex.Pattern;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;
        String hall;
        String seat;
        String title;
        String type;
        String duration;
        boolean booking = false, ticket = false, reset = false, show = false;
        int id = 0, avaiable, unavaiable;

        System.out.println("==================== Setting up Cinema ====================");

        while (true){
            System.out.print("-> Enter number of Hall in Cinema: ");
            hall = scanner.next();
            message = Pattern.matches("^[1-9]\\d*$", hall) ? "" : "Number of hall is allowed only number and more then 0";
            System.out.println(message);
            if(message.isEmpty()){
                break;
            }
        }

        while (true){
            System.out.print("-> Enter number of seat in each Hall: ");
            seat = scanner.next();
            message = Pattern.matches("^([5-9]\\d|\\d{3,})$", seat) ? "" : "Number of hall is allowed only number and more then 0!";
            System.out.println(message);
            if(message.isEmpty()){
                break;
            }
        }

        int[][] cinema = new int[Integer.parseInt(hall)][Integer.parseInt(seat)];
        String[][] movie =  new String[Integer.parseInt(hall)][8];

        while (true){

            System.out.println("\n==========================================================\n");

            System.out.println("\t\t\t\tCinema Management System");

            System.out.println("\n==========================================================\n");

            System.out.println("1, Insert Movie");
            System.out.println("2, Checking & Book Movie");
            System.out.println("3, Check Ticket");
            System.out.println("4, Reset Hall");
            System.out.println("5, Set row to show record");
            System.out.println("6, Exit");

            System.out.print("Please input your choice(1-6): ");
            String choice = scanner.next();


            switch (choice){
                case "1":
                    System.out.println("\n==========================================================\n");

                    System.out.println("\t\t\t\tINSERT INFORMATION FOR MOVIE");

                    System.out.println("\n==========================================================\n");

                    System.out.print("Enter Movie Name: ");
                    scanner.nextLine();
                    title = scanner.nextLine();

                    while (true){
                        System.out.print("Enter Movie Type: ");
                        type = scanner.nextLine();
                        message = Pattern.matches("^[a-zA-Z]+$", type) ? "" : "Movie Type is allowed to insert only text";
                        System.out.println(message);
                        if(message.isEmpty()){
                            break;
                        }
                    }

                    while (true){
                        System.out.print("Enter Movie Type: ");
                        duration = scanner.nextLine();
                        message = Pattern.matches("^(6[0-9]|[7-9][0-9]|1[0-7][0-9]|180)$", duration) ? "" : "Duration is allowed to input only number and duration between 60 min - 180 min!";
                        System.out.println(message);
                        if(message.isEmpty()){
                            break;
                        }
                    }


                    break;
                case "2":
                    if(!booking){
                        System.out.println("\n\tNo data to show. Please input Movie first!");
                        break;
                    }
                    System.out.println("case 2");
                    break;
                case "3":
                    if(!booking){
                        System.out.println("\n\tNo data to show!");
                        break;
                    }
                    System.out.println("case 3");
                    break;
                case "4":
                    if(!booking){
                        System.out.println("\n\tNo data to reset!");
                        break;
                    }
                    System.out.println("case 4");
                    break;
                case "5":
                    if(!booking){
                        System.out.println("\n\tNo data cannot set row to show movie!");
                        break;
                    }
                    System.out.println("case 5");
                    break;
                case "6":
                    System.out.println("\n\tGood bye !");
                    return;
                default:
                    System.out.println("Invalid option!");
            }


        }
    }
}
