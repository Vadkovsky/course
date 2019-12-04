package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class SingOn extends PageBase {
    private static final Logger log = Logger.getGlobal();
    //поле User Name
    @FindBy(xpath = ".//input[@name='userName']")
    private WebElement inputUserName;
    //поле пароль
    @FindBy(xpath = ".//input[@name='password']")
    private WebElement inputPassword;
    //кнопка продолжить
    @FindBy(xpath = ".//input[@name='login']")
    private WebElement buttonSubmit;

    /**
     * Вводим логин.
     * @param login .
     */
    public void setInputUserName(final String login) {
        isWebElementExists(inputUserName);
        log.info("Вводим логин");
        inputUserName.sendKeys(login);
    }

    /**
     * Вводим пароль.
     * @param password .
     */
    public void setInputPassword(final String password) {
        isWebElementExists(inputPassword);
        log.info("Вводим пароль");
        inputPassword.sendKeys(password);
    }

    /**
     * Нажимаем продолжить.
     */
    public void clickButtonSubmit() {
        isWebElementExists(inputUserName);
        log.info("Нажимаем кнопку 'Submit'");
        buttonSubmit.click();
    }
}
