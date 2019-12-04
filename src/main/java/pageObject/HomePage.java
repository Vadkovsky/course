package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class HomePage extends PageBase {
    private static final Logger log = Logger.getGlobal();
    @FindBy(xpath = ".//a[text() = 'SIGN-ON']")
    private WebElement buttonSingOn;

    /**
     * Нажимаем кнопку SIGN-ON.
     */
    public void clickButtonSingOn() {
        isWebElementExists(buttonSingOn);
        log.info("Нажимаем кнопку 'SIGN-ON'");
        buttonSingOn.click();
    }
}
