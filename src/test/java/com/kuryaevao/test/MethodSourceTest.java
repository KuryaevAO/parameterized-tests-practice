package com.kuryaevao.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MethodSourceTest extends TestBase {

    private static Object[][] getData() {
        return new Object[][]{
                {"MaxPayne", "PainKiller1965"},
                {"SamFisher", "GreenEyes1957"},
                {"SolidSnake", "IroquoisPliskin1972"},
        };
    }

    @ParameterizedTest
    @MethodSource("getData")
    public void inputTextTest(String userLogin, String userPassword) {


        open("/html/tryit.asp?filename=tryhtml_input_password");

        switchTo().frame("iframeResult");

        $("#username").setValue(userLogin);
        $("#pwd").setValue(userPassword).submit();

        $("div.w3-container").shouldHave(text("username=" + userLogin + "&pwd=" + userPassword));
    }
}
