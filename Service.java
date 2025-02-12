import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Service {
    String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m",yellow = "\u001B[33m", cyan = "\u001B[36m", purple = "\u001B[35m";
    int id;
    public ArrayList<Student> createStudents(ArrayList<Student> student){
        int round = validateAge("number of students");
        for (int i = 0; i < round; i++) {
            System.out.println("Student " + (i+1));
            student.add(createStudent());
        }
        return student;
    }
    private Student createStudent(){
        String name = validateUsername();
        int age = validateAge("student age");
        String gender = validateGender();
        ++id;
        Student student = new Student(id,name, age, gender);
        return student;
    }

    private void emptyString(){
        System.out.println(red + "Empty string or space won't allow" + reset);
    }

    private String validateUsername(){
        while (true){
            System.out.print("Enter student name: ");
            String name = new Scanner(System.in).nextLine();
            boolean matches = Pattern.matches("^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$", name);
            if (matches){
                return name;
            }
            emptyString();
        }
    }

    public int validateAge(String option){
        while (true){
            System.out.print("Enter " + option + ": ");
            String age = new Scanner(System.in).nextLine();
            boolean matches = Pattern.matches("^\\d+$", age);
            if (matches){
                return Integer.parseInt(age);
            }
            System.out.println(red + "Money can't be letter or space" + reset);
        }
    }

    private String validateGender(){
        while (true){
            System.out.print("Enter gender: ");
            String gender = new Scanner(System.in).nextLine();
            boolean matches = Pattern.matches("^(?i)(male|female|other|m|f|o)$", gender);
            if (matches){
                return gender;
            }
            emptyString();
        }
    }

    public void countGender(ArrayList<Student> students){
        int male = 0, female= 0;
        for (Student student1 : students){
            if ((student1.getGender().equals("male")) || (student1.getGender().equals("m"))){
                male += 1;
            }else if((student1.getGender().equals("female")) || (student1.getGender().equals("f"))) {
                female += 1;
            }
        }
        System.out.println("male student: " + male);
        System.out.println("female student: " + female);
    }

    public void display(ArrayList<Student> students){
        for (Student student : students){
            System.out.println("id: " + student.getId());
            System.out.println("name: " + student.getName());
            System.out.println("age: " + student.getAge());
            System.out.println("gender: " + student.getGender());
        }
    }

    public ArrayList<Student> removeTwenty(ArrayList<Student> students){
//        for (Student student1 : students){
//            if (student1.getAge() < 20){
//                students.remove(student1);
//            }
//        }
//        return students;

        students.removeIf(student1 -> student1.getAge() < 20);
        return students;
    }
}
