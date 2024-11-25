package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PracticeFormTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillPracticeForm() {
        Configuration.pageLoadStrategy="eager";
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Pushkin");
        $(byText("Male")).click();
        $("#userEmail").setValue("run@bk.com");
        $("#userNumber").setValue("84957777777");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__day--012").click();
        $("#currentAddress").setValue("Another address");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Test.jpg"));
        $("#react-select-3-input").setValue("ncr").pressEnter();
        $("#react-select-4-input").setValue("delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Pushkin"), text("run@bk.com"),text("Male"),text("8495777777"),text("12 November,2024"),text("Maths"),text("Sports"),text("Test.jpg"),text("Another address"), text("Another address"),text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}
