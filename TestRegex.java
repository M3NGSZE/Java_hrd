import java.util.Random;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
//        Random random = new Random(12345); // Fixed seed
//        int number = random.nextInt(184322577); // Upper bound is exclusive
//        System.out.println(number);

//        int max=100,min=1;
//        System.out.println("Generated numbers are within "+min+" to "+max);
//        System.out.println(min + (int)(Math.random() * ((max - min) + 1)));
//        System.out.println(min + (int)(Math.random() * ((max - min) + 1)));
//        System.out.println(min + (int)(Math.random() * ((max - min) + 1)));

//        Random random = new Random();
//        int number = random.nextInt(999999999)+1;
////                                            184322576
//        System.out.println(number);

//        boolean matches = Pattern.matches("^[1-9a-zA-Z]\\w*$", "123213asfsadf");
//        boolean matches = Pattern.matches("^\\d+$", " \n"); // ✅ True
//        System.out.println(matches);

//        boolean matches2 = Pattern.matches("^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$", "asdf asdf ");
//        System.out.println(matches2);

//        boolean matches = Pattern.matches("^(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])-\\d{4}$", "02-31-2001");
//        boolean matches = Pattern.matches("^(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])-\\d{4}$", "asdfadsf");
//        boolean matches = Pattern.matches("^(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-\\d{4}$", "31-12-2001");
//        boolean matches = Pattern.matches("^(?i)(male|female|other|m|f|o)$", "male");
//        boolean matches = Pattern.matches("^0\\d{8,9}$", "0883833888");
//
//
//        System.out.println(matches);

        boolean matches = Pattern.matches("^\\d+$", " 12312");
        System.out.println(matches);

    }
}
