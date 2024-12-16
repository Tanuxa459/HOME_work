package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TableOfDataPage;

import utils.RandomGenerate;


public class PracticeFormWithPageObjectTest extends TestBase{

    private String
            firstNameUser,
            lastNameUser,
            email,
            gender,
            phone,
            yearBirth,
            monthBirth,
            dayBirth,
            subjectOne,
            hobby,
            picture,
            address,
            state,
            city;




    RandomGenerate randomGenerateData = new RandomGenerate ();

    @BeforeEach
    public void setData() {
        firstNameUser = randomGenerateData.getFirstName();
        lastNameUser = randomGenerateData.getLastName();
        gender = randomGenerateData.getRandomGender();
        email = randomGenerateData.getUserEmail();
        phone = randomGenerateData.getUserPhone();
        yearBirth = randomGenerateData.getRandomYear();
        monthBirth = randomGenerateData.getRandomMonth();
        dayBirth = randomGenerateData.getRandomDay();
        subjectOne = randomGenerateData.getRandomSubject();
        hobby = randomGenerateData.getRandomHobbies();
        address = randomGenerateData.getStreetAddress();
        state = randomGenerateData.getRandomState();
        city = randomGenerateData.getRandomCity(state);
        picture = randomGenerateData.getRandomPicture();
    }


    RegistrationPage registrationPage = new RegistrationPage();
    TableOfDataPage tableOfDataPage = new TableOfDataPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth( dayBirth, monthBirth, yearBirth)
                .setSubject(subjectOne)
                .uploadFile(picture)
                .setAddress(address)
                .chooseCountry(state)
                .chooseCity(city)
                .setHobbies(hobby)
                .closeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable("Student Name", firstNameUser + " "+ lastNameUser);
        tableOfDataPage.checkDataTable("Student Email",email);
        tableOfDataPage.checkDataTable("Gender",gender);
        tableOfDataPage.checkDataTable("Mobile",phone);
        tableOfDataPage.checkDataTable("Date of Birth",dayBirth+" "+ monthBirth+","+yearBirth);
        tableOfDataPage.checkDataTable("Subjects",subjectOne);
        tableOfDataPage.checkDataTable("Hobbies",hobby);
        tableOfDataPage.checkDataTable("Picture",picture);
        tableOfDataPage.checkDataTable("Address",address);
        tableOfDataPage.checkDataTable("State and City",state + " " + city);

    }
    @Test
    void negativeEmailTest() {
        registrationPage.openPage()
                .removeBanner()
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .closeForm();

        registrationPage.checkUnsuccessPageWithTable();

    }
    @Test
    void minDataTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setGender(gender)
                .setEmail(email)
                .setUserNumber(phone)
                .closeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable("Student Name",firstNameUser+ " "+lastNameUser);
        tableOfDataPage.checkDataTable("Student Email",email);
        tableOfDataPage.checkDataTable("Gender",gender);
        tableOfDataPage.checkDataTable("Mobile",phone);

    }


}
