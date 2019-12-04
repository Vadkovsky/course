package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class BookAFlinght extends PageBase {
    //логируем действия
    private static final Logger log = Logger.getGlobal();
    //поле имя
    @FindBy(xpath = ".//input[@name='passFirst0']")
    private WebElement inputFirstName;
    //поле фамилия
    @FindBy(xpath = ".//input[@name='passLast0']")
    private WebElement inputLastName;
    //поле номер карты
    @FindBy(xpath = ".//input[@name='creditnumber']")
    private WebElement inputCreditNumber;
    //кнопка продолжить
    @FindBy(xpath = ".//input[@name='buyFlights']")
    private WebElement buttonBuyFlights;

    /**
     * Вводим имя.
     * @param firstName .
     */
    public void setInputFirstName(final String firstName) {
        isWebElementExists(inputFirstName);
        log.info("Вводим имя");
        inputFirstName.sendKeys(firstName);
    }

    /**
     * Вводим фамилию.
     * @param lastName .
     */
    public void setInputLastName(final String lastName) {
        isWebElementExists(inputLastName);
        log.info("Вводим фамилию");
        inputLastName.sendKeys(lastName);
    }

    /**
     * Вводим номер карты.
     * @param creditNumber .
     */
    public void setInputCreditNumber(final String creditNumber) {
        isWebElementExists(inputCreditNumber);
        log.info("Вводим номер карты");
        inputCreditNumber.sendKeys(creditNumber);
    }

    /**
     * Нажимаем кнопку продолжить.
     */
    public void clickButtonBuyFlights() {
        isWebElementExists(buttonBuyFlights);
        log.info("Нажимаем кнопку 'Secure Purchase'");
        buttonBuyFlights.click();
    }
}
