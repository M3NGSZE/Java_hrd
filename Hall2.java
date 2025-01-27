import java.util.Scanner;
import java.util.regex.Pattern;

public class Hall2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;
        String hall;
        String seat = "";
        String title = "";
        String type = "";
        String duration = "";
        boolean booking = false, ticket = false, reset = false, show = false;
        int id = 0, avaiable = 0, unavaiable = 0;

        System.out.println("==================== Setting up Cinema ====================");

//        while (true){
//            System.out.print("-> Enter number of Hall in Cinema: ");
//            hall = scanner.next();
//            message = Pattern.matches("^[1-9]\\d*$", hall) ? "" : "Number of hall is allowed only number and more then 0";
//            System.out.println(message);
//            if(message.isEmpty()){
//                break;
//            }
//        }
//
//        while (true){
//            System.out.print("-> Enter number of seat in each Hall: ");
//            seat = scanner.next();
//            message = Pattern.matches("^([5-9]\\d|\\d{3,})$", seat) ? "" : "Number of hall is allowed only number and more then 0!";
//            System.out.println(message);
//            if(message.isEmpty()){
//                break;
//            }
//        }

//        int[][] cinema = new int[Integer.parseInt(hall)][Integer.parseInt(seat)];

        int thall = 2;
        int tseat = 30;
        int increasehall = 0;
        int movieamount = 0;
        int[][] cinema = new int[thall][tseat];
        String[][] movie =  new String[thall][8];

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

//                    while (true) {
//                        if (increasehall >= thall) {
//                            System.out.println("Unavailable hall to show movie!");
//                            System.out.println("Please Press any key to continue!");
//                            scanner.nextLine(); // Consume any leftover newline
//                            scanner.nextLine(); // Wait for user input
//                            break;
//                        }
//
//                        System.out.print("Enter Movie Name: ");
//                        scanner.nextLine(); // Consume any leftover newline before taking input
//                        title = scanner.nextLine();
//
//                        while (true) {
//                            System.out.print("Enter Movie Type: ");
//                            type = scanner.nextLine();
//                            if (Pattern.matches("^[a-zA-Z]+$", type)) {
//                                break;
//                            } else {
//                                System.out.println("Movie Type is allowed to insert only text.");
//                            }
//                        }
//
//                        while (true) {
//                            System.out.print("Enter Duration (Min): ");
//                            duration = scanner.nextLine();
//                            if (Pattern.matches("^(6[0-9]|[7-9][0-9]|1[0-7][0-9]|180)$", duration)) {
//                                break;
//                            } else {
//                                System.out.println("Duration must be between 60 min - 180 min and numeric!");
//                            }
//                        }
//
//                        // Store the movie details in the movie array
//                        movie[increasehall][0] = String.valueOf(id + 1);
//                        movie[increasehall][1] = title;
//                        movie[increasehall][2] = type;
//                        movie[increasehall][3] = duration;
//                        movie[increasehall][4] = String.valueOf(increasehall + 1);
//                        movie[increasehall][5] = String.valueOf(tseat);
//                        movie[increasehall][6] = String.valueOf(tseat);
//                        movie[increasehall][7] = String.valueOf(unavaiable);
//
////                        id++; // Increment the ID for the next movie
////                        increasehall++; // Increment the hall counter
//                        increasehall +=1;
//                        System.out.println("Movie added successfully to Hall " + increasehall);
//                        booking = true;
//
//                        // Ask user if they want to continue
//                        System.out.print("Do you want to continue? (y/n): ");
////                        scanner.nextLine(); // Consume leftover newline
//                        String option = scanner.nextLine().toLowerCase();
//
//                        if (option.equals("n")) {
//                            break; // Exit loop
//                        } else if (!option.equals("y")) {
//                            System.out.println("Invalid input. Exiting.");
//                            break; // Exit on invalid input
//                        }
//                    }
//                    break;

                    if(increasehall >= thall){
                        System.out.println("Unavailable hall to show movie!");
                        System.out.println("Please Press any key to continue!");
                        scanner.nextLine();
                        scanner.nextLine();
                        break;
                    }else {
                        System.out.print("Enter Movie Name: ");
                        scanner.nextLine();
                        title = scanner.nextLine();

                        while (true){
                            System.out.print("Enter Movie Type: ");
                            type = scanner.nextLine();
                            message = Pattern.matches("^[a-zA-Z]+$", type) ? "" : "Movie Type is allowed to insert only text";
                            if(message.isEmpty()){
                                break;
                            }else {
                                System.out.println(message);
                            }
                        }

                        while (true){
                            System.out.print("Enter Duration (Min): ");
                            duration = scanner.nextLine();
                            message = Pattern.matches("^(6[0-9]|[7-9][0-9]|1[0-7][0-9]|180)$", duration) ? "" : "Duration is allowed to input only number and duration between 60 min - 180 min!";
                            if(message.isEmpty()){
                                break;
                            }else {
                                System.out.println(message);
                            }
                        }

                        for (int i = increasehall; i < movie.length; i++) {
                            movie[i][0] = String.valueOf(id  + 1);
                            movie[i][1] = title;
                            movie[i][2] = type;
                            movie[i][3] = duration;
                            movie[i][4] = String.valueOf(i + 1);
                            movie[i][5] = String.valueOf(tseat);
                            movie[i][6] = String.valueOf(tseat);
                            movie[i][7] = String.valueOf(unavaiable);
                        }
                        id++;
                        increasehall++;
                        System.out.println("Movie " + title + " will show in in hall #" + increasehall);

                        booking = true;
                    }
                    while (true){
                        System.out.print("Do you want to continue? (y/n): ");
                        String option = scanner.next().toLowerCase();
                        message = Pattern.matches("[yYnN]", option) ? option : "Wrong input. Please input only yes(y/Y) or no(n/N).";
                        if(message.equals("y")){
                            if(increasehall >= thall){
                                System.out.println("Unavailable hall to show movie!");
                                System.out.println("Please Press any key to continue!");
                                scanner.nextLine();
                                scanner.nextLine();
                                break;
                            }else {
                                System.out.print("Enter Movie Name: ");
                                scanner.nextLine();
                                title = scanner.nextLine();

                                while (true){
                                    System.out.print("Enter Movie Type: ");
                                    type = scanner.nextLine();
                                    message = Pattern.matches("^[a-zA-Z]+$", type) ? "" : "Movie Type is allowed to insert only text";
                                    if(message.isEmpty()){
                                        break;
                                    }else {
                                        System.out.println(message);
                                    }
                                }

                                while (true){
                                    System.out.print("Enter Duration (Min): ");
                                    duration = scanner.nextLine();
                                    message = Pattern.matches("^(6[0-9]|[7-9][0-9]|1[0-7][0-9]|180)$", duration) ? "" : "Duration is allowed to input only number and duration between 60 min - 180 min!";
                                    if(message.isEmpty()){
                                        break;
                                    }else {
                                        System.out.println(message);
                                    }
                                }

                                for (int i = increasehall; i < movie.length; i++) {
                                    movie[i][0] = String.valueOf(id + 1);
                                    movie[i][1] = title;
                                    movie[i][2] = type;
                                    movie[i][3] = duration;
                                    movie[i][4] = String.valueOf(i + 1);
                                    movie[i][5] = String.valueOf(tseat);
                                    movie[i][6] = String.valueOf(tseat);
                                    movie[i][7] = String.valueOf(unavaiable);
                                }
                                id++;
                                increasehall++;
                                System.out.println("Movie " + title + " will show in in hall #" + increasehall);
                            }
                        }else if (message.equals("n")){
                            break;
                        }else {
                            System.out.println(message);
                        }
                    }

                    break;
                case "2":
                    if(!booking){
                        System.out.println("\n\tNo data to show. Please input Movie first!");
                        break;
                    }
                    System.out.println("\nDisplay All Movies\n");
                    System.out.println("ID \t\t Movie \t\t Type \t\t Duration \t\t Hall \t\t Seat \t\t Available \t\t Unavailable");
//
                    for (int i = 0; i < increasehall; i++) {
                        System.out.println(movie[i][0] + " \t\t " + movie[i][1] + " \t\t " + movie[i][2] + " \t\t " + movie[i][3] + " \t\t " + movie[i][4] + " \t\t " + movie[i][5] + " \t\t " + movie[i][6] + " \t\t " + movie[i][7]);
                    }
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
