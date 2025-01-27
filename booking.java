public class booking {
    public static void main(String[] args) {
        int hall = 2;
        int seat = 30;
        int[][] cinema = new int[hall][seat];

        for (int i = 0; i < cinema.length; i++){
            for (int j = 0; j < cinema[i].length; j++) {
                cinema[i][j] = j + 1;
            }
        }

        int numhall = 1;

        if(numhall <= cinema.length){
            System.out.println("exist");
            for (int i = 0; i < cinema[numhall-1].length; i++){
                System.out.print(" + "+ (i+1) +" \t");
                if (i % 5 == 4){
                    System.out.println("");
                }
            }

            int bookseat = 12;

            String bookseat2 = "5,9";

            String[] str = bookseat2.split(",");

            int[] seat3 = new int[str.length];

            for(int i =0; i < str.length; i++){
                seat3[i] = Integer.parseInt(str[i].trim());
            }

            for (int num : seat3) {
                System.out.println(num);
            }

            for (int i = 0; i < seat3.length; i++){
                int j = seat3[i];
                if(cinema[numhall-1][j-1] == 0){
                    System.out.println("booked");
                }else {
                    cinema[numhall-1][j-1] = 0;
                    System.out.println("successfully");
                }
            }

//            if(cinema[numhall-1][bookseat-1] == 0){
//                System.out.println("booked");
//            }else {
//                cinema[numhall-1][bookseat-1] = 0;
//                System.out.println("successfully");
//            }

            System.out.println("\n======================================\n");

            // booking

            for (int i = 0; i < cinema.length; i++){
                for (int j = 0; j < cinema[i].length; j++) {
                    System.out.print(cinema[i][j] + " ");
                }
                System.out.println("");
            }

            System.out.println("=========================================");

            for (int i = 0; i < cinema[numhall-1].length; i++){
                System.out.print(" + "+ (i + 1) +" \t");
                if (i % 5 == 4){
                    System.out.println("");
                }
            }

            System.out.println("\n======================================\n");

            // reset hall
            for (int i = 0; i < cinema.length; i++){
                for (int j = 0; j < cinema[i].length; j++) {
                    cinema[i][j] = j + 1;
                    System.out.print(cinema[i][j] + " ");
                }
                System.out.println("");
            }

        }else {
            System.out.println("hall "+ numhall+" don't exist");
        }
    }
}
