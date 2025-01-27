import java.util.regex.Pattern;

public class TestRegex {

//    TestRegex(String name){
//        this(name, 21);
//    }
//    TestRegex(String name, int age){
//        this.name = name;
//        this.age = age;
//    }

    public static void main(String[] args) {
//        boolean matches = Pattern.matches("^[1-9]\\d*$", "12, 1");
//        System.out.println(matches);
//
//        boolean matches1 = Pattern.matches("^([5-9]\\d|\\d{3,})$", "150");
//        System.out.println(matches1);
//
//        boolean matches2 = Pattern.matches("^(6[0-9]|[7-9][0-9]|1[0-7][0-9]|180)$", "150");
//        System.out.println(matches2);
//
//        boolean matches3 = Pattern.matches("^[1-9]\\d*(?:,\\s?\\d+)*(?: \\d+)*$", "1, 2,3");
//        System.out.println(matches3); // This will now print true.

        boolean matches4 = Pattern.matches("^[a-zA-Z]+$", "trans fomers");
        System.out.println(matches4);

//        message = Pattern.matches("^[a-zA-Z]+$", type) ? "" : red+ "Movie Type is allowed to insert only text"+ reset;


    }
}
