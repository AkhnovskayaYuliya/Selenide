package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.ExactText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    void testCorrectData() {
        open("http://localhost:9999");
        SelenideElement form = $("[action]");
        form.$("[data-test-id=name] input").setValue("Блинов Никита");
        form.$("[data-test-id=phone] input").setValue("+79529529595");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void enterDataIncorrect() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $("[action]");
        form.$("[data-test-id=name] input]").setValue("Blinov Nikita");
        form.$("[data-test-id=phone] input").setValue("+9999999999999999");
        form.$("button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

}
