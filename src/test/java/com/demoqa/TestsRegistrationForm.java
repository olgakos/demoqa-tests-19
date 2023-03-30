package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestsRegistrationForm extends TestBase {

    //in work
    @Test
    void testFillRegForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mr");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("aa@aaa.com");
        $("#currentAddress").setValue("Some street 1");
        $("#uploadPicture").uploadFile(new File(("src/test/resources/foto.jpg")));
        //на разборе дз сегодня советовали юзать .uploadFromClasspath
        //.uploadFromClasspath("foto.jpg")
    }
}
