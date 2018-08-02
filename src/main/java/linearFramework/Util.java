package linearFramework;

        import java.io.IOException;
        import java.text.SimpleDateFormat;
        import java.util.*;

public class Util {

    /**
     * method get the current date in below formats
     * MM-dd-YYYY ; dd-MMM-YYYY; YYYY-dd-MM; dd-MMM-YYYY:HH:MM:SS
     * @param dateFormat
     * @return
     */
    public static String getCurrentDateByFormat(String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat();
        try {
            formatter = new SimpleDateFormat(dateFormat);
        }catch(Exception e){
            System.err.format("Invalid date format "+dateFormat, e);
        }
        return formatter.format(new Date());
    }

    /**
     * method will generate a random integer in a range between min (inclusive) and max (inclusive)
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * method to generate a random number of given length
     * @param length
     * @return
     */
    public static String generateRandomNumber(int length) {
        Random r = new Random();
        List<Integer> digits=  new ArrayList<Integer>();
        String number = "";
        for (int i = 0; i < length; i++) {
            digits.add(i);
        }
        for (int i = length; i > 0; i--) {
            int randomDigit = r.nextInt(i);
            number+=digits.get(randomDigit);
            digits.remove(randomDigit);
        }
        return number;
    }


    /**
     * method to unit test the utility methods in Util class
     * @param args
     */
    /*public static void main(String[] args){
        Util util = new Util();
        *//*System.out.println( util.getCurrentDateByFormat("MM-dd-YYYY"));
        System.out.println( util.getCurrentDateByFormat("dd-MMM-YYYY"));
        System.out.println( util.getCurrentDateByFormat("YYYY-MM-dd"));
        System.out.println( util.getCurrentDateByFormat("YYYY-MM-dd:HH:MM:SS"));
        System.out.println(util.getRandomNumberInRange(3, 7));*//*
        //System.out.println(util.generateRandomNumber(10));
        System.out.println(System.getenv("KEYWORDEXCELPATH"));
    }*/
}
