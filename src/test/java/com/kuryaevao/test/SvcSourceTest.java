package com.kuryaevao.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SvcSourceTest extends TestBase {

    @ParameterizedTest
    @CsvSource({
            "Alex, Murphy",
            "John, Rico",
            "Mike , Wazowski",
            "John, Matrix"
    })
    public void inputTextTest(String fName, String lName) {

        //Открываем сайт
        open("/html/tryit.asp?filename=tryhtml_input_text");
        //Меняем фрейм на фрейм с результатом
        switchTo().frame("iframeResult");
        //Вводим имя и фамилию
        $("#fname").setValue(fName);
        $("#lname").setValue(lName).submit();
        //Проверяем корректность данных
        $("div.w3-container").shouldHave(text("fname=" + fName + "&lname=" + lName));
    }
}
