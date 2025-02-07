import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m";

        Book[] books = new Book[40];

        Service service = new Service();

        Book[] book1 = new Book[40];
        book1[0] = new Book(1,"Interstella", new Author("Mengse","2003-2025"), 2025,0);
        book1[1] = new Book(2,"Scarlet Witch", new Author("Elizabeth","2003-2025"), 2025,0);
        book1[2] = new Book(3,"Journey", new Author("Haerin","2003-2025"), 2025,1);
        book1[3] = new Book(4,"Moon Side", new Author("Chanelle","2003-2025"), 2025,0);
        book1[4] = new Book(5,"A Guy", new Author("Cheata","2003-2025"), 2025,0);



        System.out.println("========= SET UP LIBRARY =========");

//        String library = "Bruce Wayne", address = "Gotham";


        System.out.print("=> Enter Library's Name: ");
        String li = scanner.nextLine().trim();
        String library = service.libraryName(li, "Library").toUpperCase();

        System.out.print("=> Enter Library's Address: ");
        String ad = scanner.nextLine().trim();
        String address = service.libraryName(ad, "Address").toUpperCase();

        System.out.println("\"" + green + library + reset + "\" Library is already created in \"" + green + address + reset + "\" address successfully on " + service.setDate());

        while (true){
            System.out.println("\n========= " + library +" LIBRARY, " + address + "  =========");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Book");
            System.out.println("3. Show Available Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Set row to show Record");
            System.out.println("7. Delete Book by Id");
            System.out.println("8. Exit");
            System.out.println("===============================================================");

            System.out.print("\n->Enter your choice : ");
            String choice = scanner.nextLine().trim();
            boolean matches5 = Pattern.matches("^[1-9a-zA-Z]\\w*$", choice);
            if (matches5){
                switch (choice){
                    case "1":
                        System.out.println("\n========= ADD BOOK INFO =========");
//                        Book[] newBook = service.insertBook(books);
                        Book[] newBook = service.insertBook(book1);
//                        books = newBook;
                        book1 = newBook;
                        break;
                    case "2":
                        service.showBook(book1, "2");
//                        service.showBook(books, "2");
                        break;
                    case "3":
                        service.showBook(book1,"3");
//                        service.showBook(books, "3");
                        break;
                    case "4":
                        service.borrowAndReturn(book1, "borrow");
//                        service.borrowAndReturn(books, "borrow");
                        break;
                    case "5":
                        service.borrowAndReturn(book1, "return");
//                        service.borrowAndReturn(books, "return");
                        break;
                    case "6":
                        service.showBook(book1,"6");
//                        service.showBook(books,"6");
                        break;
                    case "7":
                        service.deleteBook(book1);
//                        service.deleteBook(books);
                        break;
                    case  "8":
                        System.out.println(green + "\n(^-^) Good Bye! (^-^)" + reset);
                        return;
                    default:
                        System.out.println(red + "\nInvalid option! Please choose again." + reset);
                }
            }else if (choice.isEmpty()){
                System.out.println(red + "\nOption can't be empty! Please choose again." + reset);
            }

        }

    }


}
