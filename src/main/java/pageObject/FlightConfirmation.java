package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class FlightConfirmation extends PageBase {
    private static final Logger log = Logger.getGlobal();
    //поле с информацией о билете 1
    @FindBy(xpath = ".//tbody/tr[5]/td/table/tbody/tr[3]/td")
    private WebElement fieldInfoDeparting;
    //поле с информацией о билете 2
    @FindBy(xpath = ".//tbody/tr[5]/td/table/tbody/tr[5]/td")
    private WebElement fieldInfoReturning;
    //кнопка переход на главную страницу
    @FindBy(xpath = ".//tr[7]/td/table/tbody/tr/td[2]/a")
    private WebElement buttonBackToHome;

    /**
     * Забираем инфу о билете 1.
     * @return инфа.
     */
    public String getInfoDeparting() {
        isWebElementExists(fieldInfoDeparting);
        log.info("Забираем информацию о первом билете");
        return fieldInfoDeparting.getText();
    }

    /**
     * Забираем инфу о билете 2.
     * @return инфа.
     */
    public String getInfoReturning() {
        isWebElementExists(fieldInfoReturning);
        log.info("Забираем информацию о втором билете");
        return fieldInfoReturning.getText();
    }

    /**
     * Нажимаем кнопку 'Back to home'.
     */
    public void clickButtonBackToHome() {
        isWebElementExists(buttonBackToHome);
        log.info("Нажимаем кнопку 'Back to home'");
        buttonBackToHome.click();
    }
}
