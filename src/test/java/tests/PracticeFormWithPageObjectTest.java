package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TableOfDataPage;
import pages.components.CalendarComponent;



public class PracticeFormWithPageObjectTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TableOfDataPage tableOfDataPage = new TableOfDataPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Filipp")
                .setLastName("Fillipov")
                .setEmail("fil@bk.com")
                .setGender("Male")
                .setUserNumber("8999999999")
                .setDateOfBirth("12","July", "2023")
                .setSubject("Maths")
                .uploadFile("Test.jpg")
                .setAddress("Current Address")
                .chooseCountry("NCR")
                .chooseCity("Delhi")
                .setHobbies("Sports")
                .closeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable("Student Name","Filipp Fillipov");
        tableOfDataPage.checkDataTable("Student Email","fil@bk.com");
        tableOfDataPage.checkDataTable("Gender","Male");
        tableOfDataPage.checkDataTable("Mobile","8999999999");
        tableOfDataPage.checkDataTable("Date of Birth","12 July,2023");
        tableOfDataPage.checkDataTable("Subjects","Maths");
        tableOfDataPage.checkDataTable("Hobbies","Sports");
        tableOfDataPage.checkDataTable("Picture","Test.jpg");
        tableOfDataPage.checkDataTable("Address","Current Address");
        tableOfDataPage.checkDataTable("State and City","NCR Delhi");

    }
    @Test
    void negativeEmailTest() {
        registrationPage.openPage()
                .setFirstName(" ")
                .setLastName(" ")
                .setEmail("email")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("12","July", "2023")
                .setSubject("Maths")
                .uploadFile("Test.jpg")
                .chooseCountry("NCR")
                .chooseCity("Delhi")
                .setHobbies("Sports")
                .closeForm();

        registrationPage.checkUnsuccessPageWithTable();

    }
    @Test
    void minDataTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Fippov")
                .setGender("Male")
                .setEmail("fil@bk.com")
                .setUserNumber("8999999999")
                .closeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable("Student Name","Alex Fippov");
        tableOfDataPage.checkDataTable("Student Email","fil@bk.com");
        tableOfDataPage.checkDataTable("Gender","Male");
        tableOfDataPage.checkDataTable("Mobile","8999999999");

    }





}
