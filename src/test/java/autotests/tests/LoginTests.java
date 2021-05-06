package autotests.tests;

import config.TestDataConfig;
import helpers.DriverHelper;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LoginTests {
    TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class, System.getProperties());

    @BeforeAll
    static void setup() {
        DriverHelper.setConfig();
        DriverHelper.setBrowserVersion();
        //DriverHelper.setBrowser();

    }

    @Test
    @DisplayName("Authorization with wrong data")
    void loginTest() {
        step("Open login page", () -> {
            open(testDataConfig.baseUrl());
            $(".body").shouldHave(text("личный кабинет"));
            $(byAttribute("data-tip", "Войти в личный кабинет")).click();
            $(".form__main").shouldHave(text("вход"));
        });
        step("Fill in login form", () -> {
            $(byAttribute("name", "login")).val(testDataConfig.userLogin());
            $(byAttribute("name", "password")).val(testDataConfig.userPassword());
            $(byText("Войти")).click();
        });
        step("Verify wrong data validating message", () ->
                $(".form__error-inner").shouldHave(text("Неправильный e-mail или пароль.")));
    }

}
