package pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TableOfDataPage {

    private final static String TITLE = "Thanks for submitting the form";
    private final SelenideElement titleOfPage = $("#example-modal-sizes-title-lg");

    public TableOfDataPage checkSuccessPageWithTable() {
        titleOfPage.shouldHave(text(TITLE));
        return this;
    }


    public void checkDataTable(String key, String value) {
        $(".table").$(byText(key)).parent().shouldHave(text(value));
    }


}
