import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Service {
    Scanner scanner = new Scanner(System.in);
    String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m", yellow = "\u001B[33m";
    String[] str;
    int[] activeYear;
//    private int countBook = 0, countID = 0;
    private int countBook = 5, countID = 5;

    public String libraryName(String library, String optional){
        while (true){
            boolean matches = Pattern.matches("^[a-zA-Z][a-zA-Z0-9 ]*$", library);
            if (matches){
                return library;
            } else if(library.isEmpty()){
                System.out.println(red + optional + " name can't be empty" + reset);
            }else {
                System.out.println(red + optional + " name can't be start with number or only number" + reset);
            }
            System.out.print("=> Enter " + optional +"'s Name: ");
            library = scanner.nextLine().trim();
        }
    }

    public String setDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        return sdf.format(new Date());
    }

    public Book[] insertBook(Book[] books){
        if (countBook >= books.length){
            System.out.println(red + "\nNo space for to add book" + reset);
        }else {
            for (int i = 0; i < 1; i++){
                books[countBook] = addBook();
            }

            System.out.println(green + "\nBook is added to library successfully" + reset);
        }
        return books;
    }

    private Book addBook(){
        System.out.print("=> Book ID : ");
        System.out.println(++countID);
        System.out.print("=> Enter Book's Title : ");
        String book = new Scanner(System.in).nextLine();// scanner.nextLine();
        String bookTile = bookName(book);
        System.out.print("=> Enter author's Name : ");
        String name = new Scanner(System.in).nextLine();
        String authorName = authorName(name);
        System.out.print("=> Enter author's Year Active ex:(1945-1989): ");
        String active = new Scanner(System.in).nextLine();
        String activeYear = activeYear(active);
        System.out.print("=> Enter Published Year : ");
        String publish = new Scanner(System.in).nextLine();
        int published = publishYear(publish);

        Author author = new Author(authorName, activeYear);
//        Book book1 = new Book(bookTile,author,published,0);
        Book book2 = new Book(countID,bookTile,author,published,0);
        countBook++;
        return book2;
    }

    private String bookName(String book){
        while (true){
            boolean matches2 = Pattern.matches("^[A-Za-z0-9]+(?:\\s[A-Za-z0-9]+)*$", book);
            if (matches2){
                return book;
            }else if(book.isEmpty()){
                System.out.println(red + "Book title can't be empty" + reset);
            }else {
                System.out.println(red + "Book title can't contain any special character" + reset);
            }
            System.out.print("=> Enter Book Title: ");
            book = scanner.nextLine();
        }
    }

    private String authorName(String name){
        while (true){
            boolean matches2 = Pattern.matches("^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$", name);
            if(matches2){
                return name;
            }else if(name.isEmpty()){
                System.out.println(red + "Author can't be empty" + reset);
            }else {
                System.out.println(red + "Author name can't contain number or special character" + reset);
            }
            System.out.print("=> Enter author's Name: ");
            name = scanner.nextLine().trim();
        }
    }

    private String activeYear(String active){
        while (true){
            boolean matches3 = Pattern.matches("^\\d{4}\\s*-\\s*\\d{4}$", active);
            if(matches3) {
                return validateActiveYear(active);
            }else {
                System.out.println(red + "Author Year Active can't be empty, letter or greater than current year ex:(1945-1989)" + reset);
            }
            System.out.print("=> Enter author's Year Active ex:(1945-1989): ");
            active = scanner.nextLine().trim();
        }
    }

    private String validateActiveYear(String active){
        boolean matches3 = true;
        while (true){
            if (matches3){
                str = active.split("-");
                activeYear = new int[str.length];
                for (int i =0; i < str.length; i++){
                    activeYear[i] = Integer.parseInt(str[i].trim());
                }

                for (int i =0; i < str.length-1; i++){
                    if (activeYear[i] > activeYear[i + 1]){
                        System.out.println(red + "First active year can't be greater than retire year ex:(1945-1989)" + reset);
                        break;
                    }
                    if((activeYear[i] > 2025) || (activeYear[i + 1]) > 2025) {
                        System.out.println(red + "Active can't be greater than current year" + reset);
                    }else if (activeYear[i] <= activeYear[i + 1]){
                        return active;
                    }else {
                        System.out.println(red + "First active year can't be greater than retire year ex:(1945-1989)" + reset);
                    }
                }
            }
            if (!matches3){
                System.out.println(red + "Author Year Active can't be empty, letter or greater than current year ex:(1945-1989)" + reset);
            }
            System.out.print("=> Enter author's Year Active ex:(1945-1989): ");
            active = scanner.nextLine().trim();
            matches3 = Pattern.matches("^\\d{4}\\s*-\\s*\\d{4}$", active);
        }
    }

    private int publishYear(String publish){
        while (true){
            boolean matches2 = Pattern.matches("^[1-9]\\d{0,3}$", publish);
            if (matches2){
                return  validatePublishYear(publish);
            }else if(publish.isEmpty()){
                System.out.println(red + "Publish Year can't be empty" + reset);
            }else {
                System.out.println(red + "Publish Year can't be letter or container any special character" + reset);
            }
            System.out.print("=> Enter Published Year : ");
            publish = scanner.next();
            matches2 = Pattern.matches("^[1-9]\\d{0,3}$", publish);
        }
    }

    private int validatePublishYear(String publish){
        int pub = Integer.parseInt(publish);
        boolean matches3 = true;
        while (true){
            if (matches3){
                for (int i = 0; i < str.length-1; i++){
                    if ((pub >= activeYear[i]) && (pub <= activeYear[i+1])){
                        return pub;
                    }else {
                        System.out.println(red + "Publish Year can't be smaller than first active year and greater retire year" + reset);
                    }
                }
            }
            System.out.print("=> Enter Published Year : ");
            publish = scanner.next();
            pub = Integer.parseInt(publish);
            matches3 = Pattern.matches("^[1-9]\\d{0,3}$", publish);
        }

    }

    public void showBook(Book[] books, String optional){
        if (countBook == 0){
            System.out.println(red + "\nNo book to show" + reset);
        }else {
            int itemPerPage =0;
            int currentPage = 0;
            if (optional.equals("6")){
                while (true){
                    System.out.print("enter row: ");
                    String item = scanner.nextLine().trim();
                    boolean regex = Pattern.matches("^[1-9]\\w*$", item);
                    if (regex){
                        if (Integer.parseInt(item) > countBook){
                            System.out.println(red + "Row is greater than amount of book" + reset);
                            return;
                        }
                        itemPerPage = Integer.parseInt(item);
                        optional = "2";
                        break;
                    }
                    System.out.println(red + "\nOption can't be empty! Please choose again.\n" + reset);

                }

            }else {
                itemPerPage = 3;
            }

            int totalPages = (int) Math.ceil((double) countBook / itemPerPage);

            while (true){
                showZ(books, optional, currentPage, itemPerPage);
                System.out.println("1. Next Page \t\t 2. Previous Page \t\t 3. First Page \t\t 4. Last Page \t\t 5. Exit");
                System.out.print("\n-> Enter your choice: ");
                String option = scanner.nextLine();
                switch (option){
                    case "1":
                        if (currentPage < totalPages - 1) {
                            currentPage++;
                        } else {
                            System.out.println(red + "You are on the last page." + reset);
                        }
                        break;
                    case "2":
                        if (currentPage > 0) {
                            currentPage--;
                        } else {
                            System.out.println(red + "You are on the first page." + reset);
                        }
                        break;
                    case "3":
                        currentPage = 0;
                        break;
                    case "4":
                        currentPage = totalPages - 1;
                        break;
                    case "5":
                        return;
                    default:
                        System.out.println(red + "You enter the wrong option" + reset);

                }
            }
        }
    }

    private void showZ(Book[] books, String optional, int currentPage, int itemPerpage){
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        t.setColumnWidth(0, 20, 20);
        t.setColumnWidth(1, 20, 40);
        t.setColumnWidth(2, 40, 50);
        t.setColumnWidth(3, 20, 20);
        t.setColumnWidth(4, 20, 20);

        t.addCell(green+"ID"+reset, numberStyle);
        t.addCell(green+"TITLE"+reset, numberStyle);
        t.addCell(green+"Author"+reset, numberStyle);
        t.addCell(green+"Publish Year"+reset, numberStyle);
        t.addCell(green+"Status"+reset, numberStyle);

        int start = currentPage * itemPerpage;
        int end = Math.min(start + itemPerpage, books.length);

        for (int i = start; i < end; i++){
            Book book = books[i];
            if (book == null) break;
            switch (optional){
                case "2":
                    if (book.isStatus() == 0){
                        t.addCell(yellow + String.valueOf(book.getId()) + reset, numberStyle);
                        t.addCell(green +  book.getTitle() + reset, numberStyle);
                        t.addCell(book.getAuthor().getName() + " (" + book.getAuthor().getActive() + ")", numberStyle);
                        t.addCell(yellow + String.valueOf(book.getPublished()) + yellow, numberStyle);
                        t.addCell(green+ "available" + reset, numberStyle);
                    }else if(book.isStatus() == 1){
                        t.addCell(yellow + String.valueOf(book.getId()) + reset, numberStyle);
                        t.addCell(green +  book.getTitle() + reset, numberStyle);
                        t.addCell(book.getAuthor().getName() + " (" + book.getAuthor().getActive() + ")", numberStyle);
                        t.addCell(yellow + String.valueOf(book.getPublished()) + reset, numberStyle);
                        t.addCell(red + "unavailable" + reset, numberStyle);
                    }else if(book.isStatus() == 2){
                        t.addCell(red + "REMOVE" + reset, numberStyle);
                        t.addCell(red + "REMOVE" + reset, numberStyle);
                        t.addCell(red + "REMOVE ( REMOVE )" + reset, numberStyle);
                        t.addCell(red + "REMOVE" + reset, numberStyle);
                        t.addCell(red + "REMOVE" + reset, numberStyle);
                    }

                    break;
                case "3":
                    if (book.isStatus() == 0){
                        t.addCell(yellow + String.valueOf(book.getId()) + reset, numberStyle);
                        t.addCell(green +  book.getTitle() + reset, numberStyle);
                        t.addCell(book.getAuthor().getName() + " (" + book.getAuthor().getActive() + ")", numberStyle);
                        t.addCell(yellow + String.valueOf(book.getPublished()) + yellow, numberStyle);
                        t.addCell(green+ "available" + reset, numberStyle);

                    }else if(book.isStatus() == 1){
                        continue;
                    }
                    break;

            }
        }
        System.out.println(t.render());
    }

    private int verifyID(String optional){
        while (true){
            System.out.print("-> Enter book id to " + optional + " : ");
            String id = new Scanner(System.in).nextLine();
            boolean matches5 = Pattern.matches("^[1-9]\\d*$", id);

            if (matches5){
                if (id.length() > countBook){
                    System.out.println(red+ "Book ID " + id + " doesn't exist" + reset);
                    continue;
                }
                return Integer.parseInt(id);
            }else {
                System.out.println(red + "ID is allowed only number and no space" + reset);
            }
        }
    }

    public void borrowAndReturn(Book[] books /*, String id*/, String optional){
        if (countBook == 0){
            System.out.println(red + "\nNo book to show" + reset);
            return;
        }
        int bookId = verifyID(optional);
        label:
        while (true){
            for (Book book: books){
                if (bookId > countBook){
                    System.out.println(red + "Book ID " + bookId + " doesn't exist" + reset);
                    break;
                }
                if (optional.equals("borrow")){
                    if (book.getId() == bookId){
                        if (book.isStatus() == 0){
                            book.setStatus(1);
                            System.out.println("\nBook ID: " + book.getId());
                            System.out.println("Book Title: " + book.getTitle());
                            System.out.println("Book Author: " + book.getAuthor().getActive() + " (" + book.getAuthor().getActive() + ")");
                            System.out.println("Published Year: " + book.getPublished());
                            System.out.println("\n==============================================");
                            System.out.println("||" + green + "\t\tBook is borrowed successfully\t\t" + reset + "||");
                            System.out.println("==============================================");
                            break label;
                        }else if (book.isStatus() == 1){
                            System.out.println("\nBook's id " + bookId + " status" + red + " unavailable" + reset);
                            System.out.println("Book is already borrowed");
                            break;
                        }
                    }
                }else if (optional.equals("return")){
                    if (book.getId() == bookId){
                        if (book.isStatus() == 0){
                            System.out.println("\nBook's id " + bookId + " status" + green + " available" + reset);
                            System.out.println("Fail to return. Because this book not yet borrowed...");
                            break;
                        }else if (book.isStatus() == 1){
                            book.setStatus(0);
                            System.out.println("\nBook ID: " + book.getId());
                            System.out.println("Book Title: " + book.getTitle());
                            System.out.println("Book Author: " + book.getAuthor().getActive() + " (" + book.getAuthor().getActive() + ")");
                            System.out.println("Published Year: " + book.getPublished());
                            System.out.println("\n==============================================");
                            System.out.println("||" + green + "\t\tBook is returned successfully\t\t" + reset + "||");
                            System.out.println("==============================================");
                            break label;
                        }
                    }
                }
            }
            String answer = yesNo();
            if (answer.equals("n")){
                break;
            }
            bookId = verifyID(optional);
        }
    }

    private String yesNo(){
       while (true){
           System.out.print(yellow + "Do you want to continue returning? [Y/N]: " + reset);
           String option = scanner.next().trim();
           String message = Pattern.matches("^[yYnN]$", option) ? "" : red + "Wrong input. Please input only yes(y/Y) or no(n/N)." + reset;
           if (message.isEmpty()){
               return option.toLowerCase();
           }else {
               System.out.println(message);
           }
       }
    }

    public void deleteBook(Book[] books){
        if (countBook == 0){
            System.out.println(red + "\nNo book to show" + reset);
            return;
        }

       while (true){
           showZ(books, "2",0, countBook);
           System.out.println("1. Enter Book Id for" + red + " delete" + reset + " \t\t2. Exit");

           System.out.print("\n-> Enter your choice: ");
           String option = new Scanner(System.in).nextLine();

           boolean regex = Pattern.matches("^[1-9a-zA-Z]\\w*$", option);

           if (regex){
               if (option.equals("1")){
                   int delete = verifyID("delete");
                   boolean find =  false;

                   if (delete > countBook){
                       System.out.println(red + "Book id " + delete + " doesn't exist" + reset);
                       return;
                   }

                   for (Book book : books){
                       if (book.getId() == delete){
                           find = true;
                           if (book.isStatus() == 1){
                               System.out.println(red + " You can't delete this book. Because it has been borrowing\n" + reset);
                           }else if (book.isStatus() == 0){
                               book.setStatus(2);
                               System.out.println(green + "\n<<<<<<<<<<The book id " + red + delete + green + " has been remove successfully.>>>>>>>>>>" + reset);
                           }
                           return;
                       }
                   }
                   if (!find){
                       System.out.println(red + "Book ID " + delete + " doesn't exist\n" + reset);
                   }
               }else if (option.equals("2")){
                   return;
               }else {
                   System.out.println(red + "Invalid option! Please try again.\n" + reset);
               }
           }else {
               System.out.println(red + "\nOption can't be empty! Please choose again.\n" + reset);
           }
       }
    }
}
