import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Hall4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;
        String hall = "4";
        String seat = "30";
        String title = "";
        String type = "";
        String duration = "";
        String sign = "+";
        boolean booking = false, reset = false, show = false;
        int id = 0, avaiable = 0, unavaiable = 0;
        int creasingTicket = 0;
        boolean success = false;

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

        int[][] cinema = new int[Integer.parseInt(hall)][Integer.parseInt(seat)];

        int increasehall = 0;
        String[][] movie =  new String[Integer.parseInt(hall)][8];
        String [][] information = new String[Integer.parseInt(hall)][3];
        int[] availableSeat = new int[Integer.parseInt(hall)];
        int[] unavailableSeat = new int[Integer.parseInt(hall)];
        String[] seatNumber = new String[Integer.parseInt(hall)];

        for (int i = 0; i < cinema.length; i++){
            for (int j = 0; j < cinema[i].length; j++) {
                cinema[i][j] = j + 1;
            }
        }

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

                    if(increasehall >= Integer.parseInt(hall)){
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
                            System.out.print("Enter Duration (min): ");
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
                            movie[i][4] = String.valueOf(increasehall + 1);
                            movie[i][5] = seat;
                            movie[i][6] = seat;
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
                            if(increasehall >= Integer.parseInt(hall)){
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
                                    System.out.print("Enter Duration (min): ");
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
                                    movie[i][4] = String.valueOf(increasehall + 1);
                                    movie[i][5] = seat;
                                    movie[i][6] = seat;
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
                    if(increasehall == 0){
                        System.out.println("\n\tNo data to show. Please input Movie first!");
                        break;
                    }

                    goMenu:
                    while (true){
                        System.out.println("\nDisplay All Movies\n");
                        System.out.println("ID \t\t Movie \t\t Type \t\t Duration \t\t Hall \t\t Seat \t\t Available \t\t Unavailable");

                        for (int i = 0; i < increasehall; i++) {
                            System.out.println(movie[i][0] + " \t\t " + movie[i][1] + " \t\t " + movie[i][2] + " \t\t " + movie[i][3] + " \t\t " + movie[i][4] + " \t\t " + movie[i][5] + " \t\t " + movie[i][6] + " \t\t " + movie[i][7]);
                        }

                        System.out.println("---------------------------------------------------------------------------------------------------------");
                        System.out.println("1. Booking ticket \t 2. First \t 3. Second \t 4. Previous \t 5. Last \t 6. Exit");
                        String option = scanner.next();
                        switch (option){
                            case  "1":
                                String movieID = "";
                                while (true){
                                    System.out.print("Enter Movie ID: ");
                                    movieID = scanner.next();
                                    message = Pattern.matches("^[1-9]\\d*$", movieID) ? "" : "Movie ID is allowed to input only number";
                                    if (message.isEmpty()){
                                        break ;
                                    }else {
                                        System.out.println(message);
                                    }
                                }

                                int numHall = Integer.parseInt(movieID);

                                if(Integer.parseInt(movie[numHall-1][6]) == 0){
                                    System.out.println("No seat available in Hall #" + numHall);
                                    break;
                                }

                                if(numHall > id){
                                    System.out.println("Movie id: " + movieID + " doesn't exist");
                                }else {
                                    toMovie:
                                    while (true){
                                        System.out.println("SCREEN HALL #" + numHall);
                                        for (int i = 0; i < cinema[numHall-1].length; i++){
                                            if(cinema[numHall-1][i] == 0){
                                                sign = "-";
                                            }else {
                                                sign = "+";
                                            }
                                            if(i < 9){
                                                System.out.print("(" + sign+ ") 0" + (i+1) + " \t");
                                            }else{
                                                System.out.print("(" + sign+ ") " + (i+1) + " \t");
                                            }
                                            if (i % 5 == 4){
                                                System.out.println("");
                                            }
                                        }
                                        System.out.println("1. Booking Ticket \t 2. Back");
                                        String bookingOption = scanner.next();
                                        switch (bookingOption){
                                            case "1":
                                                String bookSeat = "";
                                                while (true){
                                                    System.out.print("Choose seat that you want to booking(e.g:1,2,3,4): ");
                                                    scanner.nextLine();
                                                    bookSeat = scanner.nextLine();
                                                    message = Pattern.matches("^[1-9]\\d*(?:,\\s?\\d+)*(?: \\d+)*$", bookSeat) ? "" : "Not allow input String and over then number of seat";
                                                    if (message.isEmpty()){
                                                        break ;
                                                    }else {
                                                        System.out.println(message);
                                                    }
                                                }

                                                String[] str = bookSeat.split(",");

                                                int[] seat2 = new int[str.length];

                                                for(int i =0; i < str.length; i++){
                                                    seat2[i] = Integer.parseInt(str[i].trim());
                                                }




                                                for(int i = 0; i < seat2.length; i++){
                                                    int j = seat2[i];
                                                    if(cinema[numHall-1][j-1] == 0){
                                                        System.out.println("\nSeat number " + j + " is already booked! please choose other seat");
                                                        break;
                                                    }else {
                                                        cinema[numHall-1][j-1] = 0;
//                                                        bookedSeat += String.valueOf(j) + ", ";
                                                        seatNumber[i] += bookSeat + ",";
                                                        availableSeat[numHall-1] = Integer.parseInt(seat);
                                                        unavailableSeat[numHall-1]++;
                                                        availableSeat[numHall-1] -= unavailableSeat[numHall-1];
                                                        movie[numHall -1][6] = String.valueOf(availableSeat[numHall-1]);
                                                        movie[numHall -1][7] = String.valueOf(unavailableSeat[numHall-1]);
                                                        information[i][0] = String.valueOf(numHall);
                                                        information[i][1] = movie[numHall-1][1];
                                                        information[i][2] = seatNumber[i];
                                                        success = true;
                                                    }
                                                }
                                                creasingTicket++;


                                                if (success){
                                                    System.out.println("\n==================== Booked is successfully ====================");
                                                }
                                                break toMovie;
                                            case "2":
                                                break toMovie;
                                            default:
                                                System.out.println("Only allow to input number");
                                        }
                                    }
                                }

                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                            case "5":
                                break;
                            case  "6":
                                break goMenu;
                            default:
                                System.out.println("Invalid option!Please choose a valid option (1-6)");
                        }
                    }

                    break;
                case "3":
                    if((increasehall != 0) && success){

                        System.out.println("\n===================================\n");

                        System.out.println("INSERT INFORMATION FOR MOVIE");

                        System.out.println("\n===================================\n");

                        for (int i = 0; i < creasingTicket; i++) {
                            System.out.println("Hall: #" + information[i][0]);
                            System.out.println("\t " +information[i][1]);
                            System.out.println("Seat Booked: " + information[i][2]);
                            System.out.println("\n-----------------------------------------------\n");
                        }

                        break;
                    }
                    System.out.println("\n\tNo data to show!");
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
