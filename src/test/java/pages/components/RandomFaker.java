package pages.components;

import com.github.javafaker.Faker;

public class RandomFaker {
    static private Faker faker = new Faker();
    static public String
        firstName = faker.name().firstName(),
        lastName = faker.name().lastName(),
        userEmail = faker.internet().emailAddress(),
        userNumber = faker.number().digits(9),
        userAddress = faker.address().streetAddress();
}
