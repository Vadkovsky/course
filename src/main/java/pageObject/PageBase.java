package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    /**
     * Проверяем видимость элемента.
     * @param webElement
     */
    public void isWebElementExists(WebElement webElement) {
        for (int i = 0; i < 5; i++) {
            try {
                if (!webElement.isDisplayed()) {
                    waitWebElement(2);
                } else {
                    return;
                }
            } catch (NullPointerException e) {
                waitWebElement(3);
            }
        }
    }

    /**
     * Ожидалка.
     * @param seconds .
     */
    private void waitWebElement(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Инициализация страницы.
     * @param webDriver .
     */
    public void init(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
