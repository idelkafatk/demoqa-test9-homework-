package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");

   public void setDate(String[] birthday) {
       String day = birthday[0],
              month = String.valueOf(Integer.parseInt(birthday[1]) - 1),
              year = birthday[2];

       dateOfBirthInput.click(); // birthdate
       $(".react-datepicker__month-select").selectOptionByValue(month); // month
       $(".react-datepicker__year-select").selectOptionByValue(year); //year
       $$(".react-datepicker__day").find(Condition.text(day)).click(); //day
    }
}
