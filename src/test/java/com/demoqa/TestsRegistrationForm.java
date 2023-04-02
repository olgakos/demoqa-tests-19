package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestsRegistrationForm extends TestBase {

    //in work
    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");

        //AdBlock!
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$ ('footer').remove ()");

        $("#firstName").setValue("Serge");
        $("#lastName").setValue("Lifar");
        $("#userEmail").setValue("paris@opera.com");

        //Gender (radio b)
        $("[type='radio'][value='Male']").parent().click();
        //$("#gender-radio-1").parent().click(); //another solution

        $("#userNumber").setValue("0123456789");

        //Date of Birth
        //the best practices:
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1905");
        $(".react-datepicker__month-select").selectOptionByValue("3"); //[3] = April!
        $(".react-datepicker__day--002").click();

        /*
        //another solutions:
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a"); //NB! для Linux-Mac OS заменить CONTROL на COMMAND
        $("#dateOfBirthInput").sendKeys("2 Apr 1905");
        $("#dateOfBirthInput").pressEnter(); //выход из формы календаря

        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a"); //NB! для Linux-Mac OS заменить CONTROL на COMMAND
        $("#dateOfBirthInput").sendKeys("2 April 1905");
        $("#dateOfBirthInput").pressEnter(); //выход из формы календаря

        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a"); //NB! для Linux-Mac OS заменить CONTROL на COMMAND
        $("#dateOfBirthInput").sendKeys("04.02.1905"); //NB! mm/dd/yyyy
        $("#dateOfBirthInput").pressEnter(); //выход из формы календаря
        */

        //Subjects (list)
        $("#subjectsInput").setValue("Arts").pressEnter();
        /*
        //Bad practices:
        $(".subjects-auto-complete__control").click();
        $("#subjectsInput").sendKeys("Ar"); //Ar = Arts
        $("#react-select-2-option-0").click(); //"Выбери позицию с индексом [0], факт№1"
        //OR
        $(".subjects-auto-complete__control").click();
        $("#subjectsInput").sendKeys("C"); //C = Computer science
        $("#react-select-2-option-2").click(); //"Выбери позицию с индексом [2], факт№3"
        */

        //Hobbies (checkbox)
        $("#hobbies-checkbox-3").parent().click(); //Music
       // $("[type='checkbox'][value='3']").parent().click(); //another solution

        //Picture
        $("#uploadPicture").uploadFromClasspath("foto.jpg");
        /*
        на разборе дз сегодня советовали юзать .uploadFromClasspath("foto.jpg")
        $("#uploadPicture").uploadFile(new File(("src/test/resources/foto.jpg"))); //another solution
        */

        //Address
        $("#currentAddress").setValue("Paris, France");

        //State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        /*
        Bad practices:
        $("#state").click();
        $(".css-11unzgr").$(byText("Rajasthan")).click();
        $("#city").click();
        $(".css-11unzgr").$(byText("Jaipur")).click();
        $(".btn-primary").click();
        */

        $("#submit").click();

        //check modal
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //check the results
        $(".table-responsive").shouldHave(
                text("Serge Lifar"),
                text("paris@opera.com"),
                text("Male"),
                text("0123456789"),
                text("2 April,1905"),
                text("Arts"),
                text("Music"),
                text("foto.jpg"),
                text("Paris, France"),
                text("NCR Delhi"));
    }
}
