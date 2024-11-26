package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Pushkin");
        $(byText("Male")).click();
        $("#userEmail").setValue("run@bk.com");
        $("#userNumber").setValue("84957777777");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__day--012").click();
        $("#currentAddress").setValue("Another address");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Test.jpg");
        $("#react-select-3-input").setValue("ncr").pressEnter();
        $("#react-select-4-input").setValue("delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Alex Pushkin"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("run@bk.com"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("8495777777"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("12 November,2024"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("Test.jpg"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("Another address"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();
    }
}
