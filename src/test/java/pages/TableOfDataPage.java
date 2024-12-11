package pages;

import pages.components.CalendarComponent;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TableOfDataPage {

    private final static String title = "Thanks for submitting the form";
    private SelenideElement titleOfPage = $("#example-modal-sizes-title-lg");

    public TableOfDataPage checkSuccessPageWithTable() {
        titleOfPage.shouldHave(text(title));
        return this;
    }


    public void checkDataTable(String key, String value) {
        $(".table").$(byText(key)).parent().shouldHave(text(value));
    }


}
