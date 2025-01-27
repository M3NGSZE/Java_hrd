import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MovieManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;
        String hall = "";
        String seat = "";
        String title = "";
        String type = "";
        String duration = "";
        String sign = "+";
        int id = 0, avaiable = 0, unavaiable = 0;
        int creasingTicket = 0;
        boolean success = false;

        String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m", blue = "\u001B[34m", purple = "\u001B[35m";

        System.out.println("==================== Setting up Cinema ====================");

        while (true){
            System.out.print("-> Enter number of Hall in Cinema: ");
            hall = scanner.next();
            message = Pattern.matches("^[1-9]\\d*$", hall) ? "" : red + "Number of hall is allowed only number and more then 0" + reset;
            System.out.println(message);
            if(message.isEmpty()){
                break;
            }
        }

        while (true){
            System.out.print("-> Enter number of seat in each Hall: ");
            seat = scanner.next();
            message = Pattern.matches("^([5-9]\\d|\\d{3,})$", seat) ? "" : red + "Number of hall is allowed only number and more then 0 and greater or equal 50!" + reset;
            System.out.println(message);
            if(message.isEmpty()){
                break;
            }
        }

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

        int numHall = 0;

        while (true){

            System.out.println("\n==========================================================\n");

            System.out.println(green+"\t\t\t\tCinema Management System"+reset);

            System.out.println("\n==========================================================\n");

            System.out.println(blue + "1, Insert Movie" + reset);
            System.out.println(blue + "2, Checking & Book Movie" + reset);
            System.out.println(blue + "3, Check Ticket" + reset);
            System.out.println(blue + "4, Reset Hall" + reset);
            System.out.println(blue+ "5, Set row to show record" + reset);
            System.out.println(blue + "6, Exit" + reset);

            System.out.println("\n----------------------------------------------------------\n");

            System.out.print("Please input your choice(1-6): ");

            String choice = scanner.next().trim();;

            switch (choice){
                case "1":
                    System.out.println("\n==========================================================\n");

                    System.out.println("\t\t\t\tINSERT INFORMATION FOR MOVIE");

                    System.out.println("\n==========================================================\n");

                    if(increasehall >= Integer.parseInt(hall)){
                        System.out.println(red + "Unavailable hall to show movie!" + reset);
                        System.out.println(red + "Please Press any key to continue!" + reset);
                        scanner.nextLine();
                        scanner.nextLine();
                        break;
                    }else {
                        while (true){
                            System.out.print("Enter Movie Name: ");
                            scanner.nextLine();
                            title = scanner.nextLine().trim();
                            if(title.isEmpty()){
                                System.out.println(red + "Movie name can't be empty" + reset);
                            }else {
                                break;
                            }
                        }

                        while (true){
                            System.out.print("Enter Movie Type: ");
                            type = scanner.nextLine().trim();
                            message = Pattern.matches("^[0-9]+", type) ? "" : red+ "Movie Type is allowed to insert only text"+ reset;
                            if(message.isEmpty()){
                                System.out.println(red+ "Movie Type is allowed to insert only text"+ reset);
                            }else {
                                break;
                            }
                        }

                        while (true){
                            System.out.print("Enter Duration (min): ");
                            duration = scanner.next().trim();
                            message = Pattern.matches("^(6[0-9]|[7-9][0-9]|1[0-7][0-9]|180)$", duration) ? "" : red+ "Duration is allowed to input only number and duration between 60 min - 180 min!" + reset;
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

                    }
                    while (true){
                        System.out.print("Do you want to continue? (y/n): ");
                        String option = scanner.next().toLowerCase().trim();
                        message = Pattern.matches("[yYnN]", option) ? option : red +"Wrong input. Please input only yes(y/Y) or no(n/N)." + reset;
                        if(message.equals("y")){
                            if(increasehall >= Integer.parseInt(hall)){
                                System.out.println(red+ "Unavailable hall to show movie!" + reset);
                                System.out.println(red+ "Please Press any key to continue!" + reset);
                                scanner.nextLine();
                                scanner.nextLine();
                                break;
                            }else {
                                System.out.print("Enter Movie Name: ");
                                scanner.nextLine();
                                title = scanner.nextLine();

                                while (true){
                                    System.out.print("Enter Movie Type: ");
                                    type = scanner.next().trim();
                                    message = Pattern.matches("^[a-zA-Z]+$", type) ? "" : red+ "Movie Type is allowed to insert only text" + reset;
                                    if(message.isEmpty()){
                                        break;
                                    }else {
                                        System.out.println(message);
                                    }
                                }

                                while (true){
                                    System.out.print("Enter Duration (min): ");
                                    duration = scanner.next().trim();
                                    message = Pattern.matches("^(6[0-9]|[7-9][0-9]|1[0-7][0-9]|180)$", duration) ? "" : red+ "Duration is allowed to input only number and duration between 60 min - 180 min!" + reset;
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
                        System.out.println(red+"\n\tNo data to show. Please input Movie first!"+reset);
                        break;
                    }

                    int itemsPerPage = 3;
                    int currentPage = 0;
                    int totalPages = (int) Math.ceil((double) increasehall / itemsPerPage);


                    goMenu:
                    while (true){
                        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);

                        Table t = new Table(8, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
                        t.setColumnWidth(0, 20, 20);
                        t.setColumnWidth(1, 20, 20);
                        t.setColumnWidth(2, 20, 20);
                        t.setColumnWidth(3, 20, 20);
                        t.setColumnWidth(4, 20, 20);
                        t.setColumnWidth(5, 20, 20);
                        t.setColumnWidth(6, 20, 20);
                        t.setColumnWidth(7, 20, 20);

//                        t.addCell("Display All Movies", numberStyle, 8);
                        t.addCell("Display All Movies (Page " + (currentPage + 1) + " of " + totalPages + ")", numberStyle, 8);
                        t.addCell(green+"ID"+reset, numberStyle);
                        t.addCell(green+"Movie"+reset, numberStyle);
                        t.addCell(green+"Type"+reset, numberStyle);
                        t.addCell(green+"Duration"+reset, numberStyle);
                        t.addCell(green+"Hall"+reset, numberStyle);
                        t.addCell(green+"Seat"+reset, numberStyle);
                        t.addCell(green+"Available"+reset, numberStyle);
                        t.addCell(red+"Unavailable"+reset, numberStyle);

                        // Display only the movies on the current page
                        int start = currentPage * itemsPerPage;
                        int end = Math.min(start + itemsPerPage, increasehall);

                        for (int i = start; i < end; i++) {
                            t.addCell(movie[i][0], numberStyle);
                            t.addCell(movie[i][1], numberStyle);
                            t.addCell(movie[i][2], numberStyle);
                            t.addCell(movie[i][3], numberStyle);
                            t.addCell(movie[i][4], numberStyle);
                            t.addCell(movie[i][5], numberStyle);
                            t.addCell(movie[i][6], numberStyle);
                            t.addCell(movie[i][7], numberStyle);
                        }

                        System.out.println(t.render());

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

                                numHall = Integer.parseInt(movieID);

                                if (numHall > movie.length){
                                    System.out.println("Movie id: "+ movieID +" doesn't exist1");
                                }else if(Integer.parseInt(movie[numHall-1][6]) == 0){
                                    System.out.println("No seat available in Hall #" + numHall);
                                    break;
                                }else if(numHall > id){
                                    System.out.println("Movie id: " + movieID + " doesn't exist");
                                } else {
                                    toMovie:
                                    while (true){
                                        Table t1 = new Table(8, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
                                        t1.setColumnWidth(0, 20, 20);
                                        t1.setColumnWidth(1, 20, 20);
                                        t1.setColumnWidth(2, 20, 20);
                                        t1.setColumnWidth(3, 20, 20);
                                        t1.setColumnWidth(4, 20, 20);
                                        t1.setColumnWidth(5, 20, 20);
                                        t1.setColumnWidth(6, 20, 20);
                                        t1.setColumnWidth(7, 20, 20);

                                        t1.addCell("SCREEN HALL #" + numHall, numberStyle, 8);

                                        for (int i = 0; i < cinema[numHall-1].length; i++) {
                                            if(cinema[numHall-1][i] == 0){
                                                sign = "-";
                                            }else {
                                                sign = "+";
                                            }
                                            if (sign.equals("-")){
                                                t1.addCell( red+ "( " + sign +" ) " + (i+1) +reset, numberStyle);
                                            }else {
                                                t1.addCell( green+"( " + sign +" ) " + (i+1) +reset, numberStyle);
                                            }

                                        }

                                        System.out.println(t1.render());

                                        System.out.println("1. Booking Ticket \t 2. Back");
                                        String bookingOption = scanner.next();
                                        switch (bookingOption){
                                            case "1":
                                                String bookSeat = "";
                                                while (true){
                                                    System.out.print("Choose seat that you want to booking(e.g:1,2,3,4): ");
                                                    bookSeat = scanner.next().trim();
                                                    String regex = "^[1-9]\\d*(?:,\\s?[1-9]\\d*)*$";
                                                    boolean isValid = Pattern.matches(regex, bookSeat);
                                                    if (isValid) {
                                                        break;
                                                    } else {
                                                        System.out.println(red + "Invalid input! Please use the format: 1,2,3 without trailing commas or invalid characters." + reset);
                                                    }
                                                }

                                                String[] str = bookSeat.split(",");

                                                int[] seat2 = new int[str.length];

                                                for(int i =0; i < str.length; i++){
                                                    seat2[i] = Integer.parseInt(str[i].trim());

                                                }

                                                for (int i = 0; i < seat2.length; i++) {
                                                    int j = seat2[i];

                                                    boolean booked = false;
                                                    for (int k = 0; k < i; k++) {
                                                        if (seat2[k] == j) {
                                                            booked = true;
                                                            break;
                                                        }
                                                    }

                                                    if (booked) {
                                                        continue;
                                                    }

                                                    if (j > cinema[numHall - 1].length){
                                                        System.out.println(red+ "\nSeat number " + j + " doesn't exist.\n"+ reset);
                                                    }else if (cinema[numHall - 1][j - 1] == 0) {
                                                        System.out.println(red+ "\nSeat number " + j + " is already booked! Please choose another seat.\n"+ reset);
                                                        success = false;
                                                        break;
                                                    } else {
                                                        cinema[numHall - 1][j - 1] = 0;
                                                        success = true;

                                                        if (seatNumber[numHall - 1] == null) {
                                                            seatNumber[numHall - 1] = String.valueOf(j);
                                                        } else {
                                                            seatNumber[numHall - 1] += ", " + j;
                                                        }

                                                        availableSeat[numHall - 1] = Integer.parseInt(seat);
                                                        unavailableSeat[numHall - 1]++;
                                                        availableSeat[numHall - 1] -= unavailableSeat[numHall - 1];
                                                        movie[numHall - 1][6] = String.valueOf(availableSeat[numHall - 1]);
                                                        movie[numHall - 1][7] = String.valueOf(unavailableSeat[numHall - 1]);

                                                        // Update or append to the information array
                                                        boolean hallExists = false;
                                                        for (int k = 0; k < creasingTicket; k++) {
                                                            if (information[k][0].equals(String.valueOf(numHall))) {
                                                                information[k][2] = seatNumber[numHall - 1];
                                                                hallExists = true;
                                                                break;
                                                            }
                                                        }

                                                        if (!hallExists) {
                                                            information[creasingTicket][0] = String.valueOf(numHall);
                                                            information[creasingTicket][1] = movie[numHall - 1][1];
                                                            information[creasingTicket][2] = seatNumber[numHall - 1];
                                                            creasingTicket++;
                                                        }

                                                    }
                                                }

                                                if (success){
                                                    System.out.println(green+ "\n==================== Booked is successfully ====================\n" + reset);
                                                }
                                                break toMovie;
                                            case "2":
                                                break toMovie;
                                            default:
                                                System.out.println(red+ "Only allow to input number" + reset);
                                        }
                                    }
                                }

                                break;
                            case "2":
                                currentPage = 0;
                                break;
                            case "3":
                                if (currentPage < totalPages - 1) {
                                    currentPage++;
                                } else {
                                    System.out.println(red + "You are already on the last page!" + reset);
                                }
                                break;
                            case "4":
                                if (currentPage > 0) {
                                    currentPage--;
                                } else {
                                    System.out.println(red + "You are already on the first page!" + reset);
                                }
                                break;
                            case "5":
                                currentPage = totalPages - 1;
                                break;
                            case  "6":
                                break goMenu;
                            default:
                                System.out.println(red + "Invalid option!Please choose a valid option (1-6)" + reset);
                        }
                    }

                    break;
                case "3":
                    if((increasehall != 0) && success){

                        System.out.println("\n===================================\n");

                        System.out.println("Your ticket has been booked");

                        System.out.println("\n===================================\n");

                        for (int i = 0; i < creasingTicket; i++) { // Loop through the information array
                            System.out.println("Hall: #" + information[i][0]);
                            System.out.println("\t " + information[i][1]);
                            System.out.println("Seat Booked: " + information[i][2]);
                            System.out.println("\n-----------------------------------------------\n");
                        }

                        break;
                    }
                    System.out.println(red+ "\n\tNo data to show!" + reset);
                    break;
                case "4":
                    if(!success){
                        System.out.println(red + "\n\tNo data to reset!" + reset);
                        break;
                    }
                    while (true){
                        System.out.print("\nDo you want to reset? (y/n): ");
                        String option = scanner.next().toLowerCase();
                        message = Pattern.matches("[yYnN]", option) ? option : red+ "Wrong input. Please input only yes(y/Y) or no(n/N)." +reset;
                        if(message.equals("y")){
                            for (int i = 0; i < cinema.length; i++){
                                for (int j = 0; j < cinema[i].length; j++) {
                                    cinema[i][j] = j + 1;
                                }
                                seatNumber[i] = null;
                                movie[i][6] = seat;
                                movie[i][7] = String.valueOf(unavaiable);
                            }

                            success = false;
                            creasingTicket = 0;
                            System.out.println("\nAll Hal is already reset");
                            break;
                        }else if(message.equals("n")){
                            break;
                        }else {
                            System.out.println(message);
                        }
                    }
                    break;
                case "5":
                    if(increasehall == 0){
                        System.out.println(red+ "\n\tNo data cannot set row to show movie!" + reset);
                        break;
                    }
                    System.out.println("Please input your choice(1-6): 5");
                    System.out.print("Enter number of row to show record : ");

                    int itemsPerPage1 = scanner.nextInt();
                    int currentPage1 = 0;
                    int totalPages1 = (int) Math.ceil((double) increasehall / itemsPerPage1);

                    exitRow:
                    while (true) {
                        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);

                        Table t = new Table(8, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
                        t.setColumnWidth(0, 20, 20);
                        t.setColumnWidth(1, 20, 20);
                        t.setColumnWidth(2, 20, 20);
                        t.setColumnWidth(3, 20, 20);
                        t.setColumnWidth(4, 20, 20);
                        t.setColumnWidth(5, 20, 20);
                        t.setColumnWidth(6, 20, 20);
                        t.setColumnWidth(7, 20, 20);

                        t.addCell("Display All Movies (Page " + (currentPage1 + 1) + " of " + totalPages1 + ")", numberStyle, 8);
                        t.addCell(green + "ID" + reset, numberStyle);
                        t.addCell(green + "Movie" + reset, numberStyle);
                        t.addCell(green + "Type" + reset, numberStyle);
                        t.addCell(green + "Duration" + reset, numberStyle);
                        t.addCell(green + "Hall" + reset, numberStyle);
                        t.addCell(green + "Seat" + reset, numberStyle);
                        t.addCell(green + "Available" + reset, numberStyle);
                        t.addCell(red + "Unavailable" + reset, numberStyle);

                        // Display only the movies on the current page
                        int start = currentPage1 * itemsPerPage1;
                        int end = Math.min(start + itemsPerPage1, increasehall);

                        for (int i = start; i < end; i++) {
                            t.addCell(movie[i][0], numberStyle);
                            t.addCell(movie[i][1], numberStyle);
                            t.addCell(movie[i][2], numberStyle);
                            t.addCell(movie[i][3], numberStyle);
                            t.addCell(movie[i][4], numberStyle);
                            t.addCell(movie[i][5], numberStyle);
                            t.addCell(movie[i][6], numberStyle);
                            t.addCell(movie[i][7], numberStyle);
                        }

                        System.out.println(t.render());
                        System.out.println("---------------------------------------------------------------------------------------------------------");
                        System.out.println("1. First \t 2. Next \t 3. Previous \t 4. Last \t 6. Exit");
                        System.out.print("Choose an option: ");
                        String option = scanner.next();

                        switch (option) {
                            case "1":
                                currentPage1 = 0;
                                break;
                            case "2":
                                if (currentPage1 < totalPages1 - 1) {
                                    currentPage1++;
                                } else {
                                    System.out.println(red + "You are already on the last page!" + reset);
                                }
                                break;
                            case "3":
                                if (currentPage1 > 0) {
                                    currentPage1--;
                                } else {
                                    System.out.println(red + "You are already on the first page!" + reset);
                                }
                                break;
                            case "4":
                                currentPage1 = totalPages1 - 1;
                                break;
                            case "5":
                                break exitRow;
                            default:
                                System.out.println(red + "Invalid option! Please choose again." + reset);
                                break;
                        }
                    }
                    break;
                case "6":
                    System.out.println("\n\tGood bye !");
                    return;
                default:
                    System.out.println(red + "Invalid option!" + reset);
            }

        }
    }
}
