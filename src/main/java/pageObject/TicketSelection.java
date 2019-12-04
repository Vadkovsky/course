package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class TicketSelection extends PageBase {
    private static final Logger log = Logger.getGlobal();
    //поле билета 1
    @FindBy(xpath = ".//form/table[1]/tbody/tr[5]/td[1]/input")
    private WebElement inputRadioButtonDepart2;
    //поле билета 2
    @FindBy(xpath = ".//form/table[2]/tbody/tr[5]/td[1]/input")
    private WebElement inputRadioButtonReturn2;
    //кнопка продполжить
    @FindBy(xpath = ".//input[@name='reserveFlights']")
    private WebElement buttonContiniue;

    /**
     * Выбираем билет 1.
     */
    public void selectRadioButtonDepart() {
        isWebElementExists(inputRadioButtonDepart2);
        log.info("Выбираем второй билет для первого перелета");
        inputRadioButtonDepart2.click();
    }

    /**
     * Выбираем билет 2.
     */
    public void selectRadioButtonReturn() {
        isWebElementExists(inputRadioButtonReturn2);
        log.info("Выбираем второй билет для второго перелета");
        inputRadioButtonReturn2.click();
    }

    /**
     * Нажимаем продолжить.
     */
    public void clickButtonContiniue() {
        isWebElementExists(buttonContiniue);
        log.info("Нажимаем кнопку 'Continiue'");
        buttonContiniue.click();
    }
}
