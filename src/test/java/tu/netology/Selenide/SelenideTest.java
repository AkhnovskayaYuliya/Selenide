package tu.netology.Selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    void testCorrectData() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $("[action]");
        form.$("[data-test-id=name] input").setValue("Блинов Никита");
        form.$("[data-test-id=phone] input").setValue("+79529529595");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
        Thread.sleep(5000);
    }

}
