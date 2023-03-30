package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormFillingTests extends FormTestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Pimenova");
        $("#userEmail").setValue("kitty@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1357924680");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1997")).click();
        $(".react-datepicker__month-select").$(byText("December")).click();
        $(".react-datepicker__day--031").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images/batty.jpg");
        $("#currentAddress").setValue("Baker Street, 221B");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();


        $(".modal-body").shouldHave(text("Maria"), text("Pimenova"),
                text("kitty@gmail.com"), text("Female"), text("1357924680"),
                text(31 + " " + "December" + "," + 1997),
                text("Physics"), text("Music"), text("Sports"),
                text("batty.jpg"), text("Baker Street, 221B"),
                text("Haryana" + " " + "Karnal"));

    }
}
