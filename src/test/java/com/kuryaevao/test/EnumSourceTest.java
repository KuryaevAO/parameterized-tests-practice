package com.kuryaevao.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class EnumSourceTest extends TestBase {

    enum TextEnum {WHO_IS_JOHN_MATRIX, HOW_I_CAN_BUY_SOME_MONEY, GIMME_DANGER, EYE_FOR_AN_EYE}

    @ParameterizedTest
    @EnumSource(TextEnum.class)
    public void inputTextTest(TextEnum searchLine) {

        //Заменяем все подчеркивания на пробелы и снижаем регистр текста
        String searchText = searchLine.name().toLowerCase().replaceAll("_", " ");
        //Открываем сайт
        open("/html/tryit.asp?filename=tryhtml_input_search");
        //Меняем фрейм на фрейм с результатом
        switchTo().frame("iframeResult");
        //Вводим поисковый запрос
        $("#gsearch").setValue(searchText).submit();
        //Проверяем корректность данных
        $("div.w3-container").shouldHave(text("gsearch=" + searchText));
    }
}