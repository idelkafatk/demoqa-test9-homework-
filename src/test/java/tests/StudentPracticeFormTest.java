package tests;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static pages.components.RandomFaker.*;

public class StudentPracticeFormTest extends TestBase {
    private final String url ="https://demoqa.com/automation-practice-form";

    private String[]
            genders = {"Male", "Female", "Other"},
            hobbies = {"Music", "Reading"},
            birthday = "15.06.2000".split("[.]");
    private String
            userGender = genders[new Random().nextInt(genders.length)],
            userSubject = "Computer Science",
            picturePath = "src/test/java/resources/test.jpg",
            state = "NCR",
            city = "Delhi";

    @Test
    public void fillFormTest() {

        registrationPage
                .openPage(url)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDate(birthday)
                .setSubjects(userSubject)
                .setHobbies(hobbies)
                .setPicture(picturePath)
                .setCurrentAddress(userAddress)
                .setStateAndCity(state, city)
                .clickSubmit()
        //verify
                .verifyData("Student Name", firstName + " " + lastName)
                .verifyData("Student Email", userEmail)
                .verifyData("Gender", userGender)
                .verifyData("Mobile", userNumber)
                .verifyData("Date of Birth", "15 June, 2000")
                .verifyData("Subjects", userSubject)
                .verifyData("Hobbies", String.join(", ", hobbies))
                .verifyData("Picture", "test.jpg")
                .verifyData("Address", userAddress)
                .verifyData("State and City", state + " " + city);
    }
}


