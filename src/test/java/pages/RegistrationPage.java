package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.StateAndCityComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("#submit"),
            resultsTable = $(".table-responsive");

    public RegistrationPage openPage(String url) {
        open(url);
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.scrollIntoView(true).click();
        subjectsInput.setValue(value);
        $("#react-select-2-option-0").click();
        return this;
    }

    public RegistrationPage setHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            $(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationPage setPicture(String path) {
        uploadPictureInput.uploadFile(new File(path));
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage setStateAndCity (String state, String city) {
        StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
        stateAndCityComponent.setStateAndCity(state, city);
        return this;
    }

    public RegistrationPage setDate(String[] birthday) {
        CalendarComponent calendar = new CalendarComponent();
        calendar.setDate(birthday);
        return this;
    }


    public RegistrationPage verifyData(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
//    open("https://demoqa.com/automation-practice-form"); //open form
//
//    $(byId("firstName")).setValue("Idel"); //Name
//    $(byId("lastName")).setValue("Fatk"); //last name
//    $(byId("userEmail")).setValue("Idel@mail.ru"); // email
//    $(byText("Male")).click(); //gender
//    $(byId("userNumber")).setValue("9082888805"); //number
//
//    $(byId("dateOfBirthInput")).click(); // birthdate
//    $(".react-datepicker__month-select").selectOptionByValue("0"); // month
//    $(".react-datepicker__year-select").selectOptionByValue("2000"); //year
//    $$(".react-datepicker__day").find(Condition.text("5")).click(); //day
//
//    $(byId("subjectsInput")).scrollIntoView(true).click();
//    $(byId("subjectsInput")).sendKeys("Co"); //subject
//    $(byText("Computer Science")).click();
//
//    $(byText("Music")).click(); //hobbies
//    $(byText("Reading")).click();
//
//
//    $(byId("uploadPicture")).uploadFile(new File("src/test/java/resources/test.jpg")); //file
//    $(byId("currentAddress")).setValue("Almaty"); //address
//
//    $(byId("state")).click(); //state
//    $(byText("NCR")).click();
//
//    $(byId("city")).click(); //city
//    $(byText("Delhi")).click();
//
//    $(byId("submit")).click();
//
//    // checks
//    verify("Student Name", "Idel Fatk");
//    verify("Student Email", "Idel@mail.ru");
//    verify("Gender", "Male");
//    verify("Mobile", "9082888805");
//    verify("Date of Birth", "5 January,2000");
//    verify("Subjects", "Computer Science");
//    verify("Hobbies", "Music, Reading");
//    verify("Picture", "test.jpg");
//    verify("Address", "Almaty");
//    verify("State and City", "NCR Delhi");
//}
//
//    private void verify(String label, String value) {
//        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));
}
