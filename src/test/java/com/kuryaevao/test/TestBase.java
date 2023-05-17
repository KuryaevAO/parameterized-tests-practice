package com.kuryaevao.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.startMaximized = true;
        Configuration.browserSize = "1920×1080";
        Configuration.pageLoadTimeout = 600000;
        Configuration.baseUrl = "https://www.w3schools.com";
        Configuration.pageLoadStrategy = "eager";
    }
}
