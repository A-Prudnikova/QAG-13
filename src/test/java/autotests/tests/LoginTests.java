package autotests.tests;

import config.TestDataConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginTests  {

    TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class);

    @Test
    @DisplayName("Authorization with wrong data")
    void loginTest() {
        step("Open login page", () -> {
            open(testDataConfig.webUrl());
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


