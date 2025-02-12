import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Student> students1 = new ArrayList<>();
//        students1.add(new Student(1, "mengse", 21, "male"));

        Service service = new Service();

        service.createStudents(students);

        System.out.println("\nbefore remove age below 20");
        System.out.println(students);
        service.countGender(students);
        System.out.println();

//        service.display(students);

        System.out.println("after remove age below 20");
        service.removeTwenty(students);
        System.out.println(students);
    }
}
