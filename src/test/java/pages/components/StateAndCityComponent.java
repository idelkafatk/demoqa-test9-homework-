package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {
    private SelenideElement
            stateInput = $("#state"),
            cityInput = $("`#city");

    public void setStateAndCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();

        cityInput.click();
        $(byText(city)).click();
    }


}
