package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeFrom extends TestBase {

    @BeforeAll
    static void maxSized() {
        Configuration.browserSize = "1400x1000";
    }

    @Test
    void formToFill() {

       open("https://demoqa.com/automation-practice-form"); //open form

        $(byId("firstName")).setValue("Idel"); //Name
        $(byId("lastName")).setValue("Fatk"); //last name
        $(byId("userEmail")).setValue("Idel@mail.ru"); // email
        $(byText("Male")).click(); //gender
        $(byId("userNumber")).setValue("9082888805"); //number

        $(byId("dateOfBirthInput")).click(); // birthdate
        $(".react-datepicker__month-select").selectOptionByValue("0"); // month
        $(".react-datepicker__year-select").selectOptionByValue("2000"); //year
        $$(".react-datepicker__day").find(Condition.text("5")).click(); //day

        $(byId("subjectsInput")).scrollIntoView(true).click();
        $(byId("subjectsInput")).sendKeys("Co"); //subject
        $(byText("Computer Science")).click();

        $(byText("Music")).click(); //hobbies
        $(byText("Reading")).click();


        $(byId("uploadPicture")).uploadFile(new File("src/test/java/resources/test.jpg")); //file
        $(byId("currentAddress")).setValue("Almaty"); //address

        $(byId("state")).click(); //state
        $(byText("NCR")).click();

        $(byId("city")).click(); //city
        $(byText("Delhi")).click();

        $(byId("submit")).click();

        // checks
        verify("Student Name", "Idel Fatk");
        verify("Student Email", "Idel@mail.ru");
        verify("Gender", "Male");
        verify("Mobile", "9082888805");
        verify("Date of Birth", "5 January,2000");
        verify("Subjects", "Computer Science");
        verify("Hobbies", "Music, Reading");
        verify("Picture", "test.jpg");
        verify("Address", "Almaty");
        verify("State and City", "NCR Delhi");
    }

    private void verify(String label, String value) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));
    }
}
