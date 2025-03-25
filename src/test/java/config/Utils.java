package config;

import com.github.javafaker.Faker;

public class Utils {

    private static final Faker faker = new Faker();

    public static String generateRandomEmail() {
        return faker.name().firstName().toLowerCase() + faker.number().digits(4) + "@testemail.com";
    }

    public static String generateRandomName(){
        return faker.name().fullName().toLowerCase();
    }

    public static String generateRandomMessage(){
        return faker.lorem().sentence();
    }
}
