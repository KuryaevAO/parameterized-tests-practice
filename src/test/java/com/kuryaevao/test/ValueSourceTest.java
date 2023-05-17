package com.kuryaevao.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ValueSourceTest extends TestBase {

    @ParameterizedTest
    @ValueSource(strings = {"stormthatisapproaching@vergil.com", "jackpot@dante.com", "pullthedeviltrigger@nero.com"})
    public void inputTextTest(String userEmail) {

        //Открываем сайт
        open("/html/tryit.asp?filename=tryhtml_input_email");
        //Меняем фрейм на фрейм с результатом
        switchTo().frame("iframeResult");
        //Вводим почту
        $("input#email").setValue(userEmail).submit();
        //Проверяем корректность данных
        $("div.w3-container").shouldHave(text("email=" + userEmail));
    }
}
