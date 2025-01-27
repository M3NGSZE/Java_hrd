import java.util.Scanner;

public class ShowData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int age = 0;
        String gender = "";
        while (true){
            System.out.print("enter option: ");
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.print("how many time do want to enter your data: ");
                    int num = scanner.nextInt();

                    for (int i = 0; i < num; i++){
                        System.out.print("name: ");
                        name = scanner.next();
                        System.out.print("age: ");
                        age = scanner.nextInt();
                        System.out.print("gender: ");
                        gender = scanner.next();
                    }

                    System.out.println("show data");
                    System.out.println("name: " + name);
                    System.out.println("age: " + age);
                    System.out.println("gender: " + gender);
                    break;
                case 2:
                    System.out.println("show data");
                    System.out.println("name: " + name);
                    System.out.println("age: " + age);
                    System.out.println("gender: " + gender);
                    break;
                default:
                    System.out.println("invalid option");
            }

        }
    }
}
