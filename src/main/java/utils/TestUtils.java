package utils;

import com.github.javafaker.Faker;

import java.util.Random;


public class TestUtils {
    public static final long WAIT = 120;

    public static long generateNumber() {
        Random rnd = new Random();
        char [] digits = new char[11];
        digits[0] = (char) (rnd.nextInt(9) + '1');
        for(int i=1; i<digits.length; i++) {
            digits[i] = (char) (rnd.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }

    public static String generateName(){
        Faker faker = new Faker();
        String name = faker.name().fullName();
        return name;
    }

    public static String generateStreet(){
        Faker faker = new Faker();
        String streetAddress = faker.address().streetAddress();
        return streetAddress;
    }
}
