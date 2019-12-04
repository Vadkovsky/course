package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

public class FlightFinder extends PageBase {
    private static final Logger log = Logger.getGlobal();
    //выбор города 1
    @FindBy(xpath = ".//select[@name='fromPort']")
    private WebElement selectDepartingFrom;
    //выбор города 2
    @FindBy(xpath = ".//select[@name='toPort']")
    private WebElement selectArrivingIn;
    //поле дни
    @FindBy(xpath = ".//select[@name='toDay']//option[@selected]")
    private WebElement fieldOnDays;
    //селект даты вылета
    @FindBy(xpath = ".//select[@name='fromDay']")
    private WebElement selectOnDays;
    //селект даты возврата
    @FindBy(xpath = ".//select[@name='toDay']")
    private WebElement selectReturningDays;
    //кнопка продолжить
    @FindBy(xpath = ".//input[@name='findFlights']")
    private WebElement buttonContiniue;

    /**
     * Выбираем город 1.
     * @param departingFrom .
     */
    public void selectDepartingFrom(final String departingFrom) {
        log.info("Выбираем город откуда вылетаем.");
        isWebElementExists(selectDepartingFrom);
        Select selectDepartingFrom2 = new Select(selectDepartingFrom);
        selectDepartingFrom2.selectByValue(departingFrom);
    }

    /**
     * Выбираем город 2.
     * @param arrivingIn .
     */
    public void selectArrivingIn(final String arrivingIn) {
        log.info("Выбираем город куда вылетаем.");
        isWebElementExists(selectArrivingIn);
        Select selectDepartingFrom2 = new Select(selectArrivingIn);
        selectDepartingFrom2.selectByValue(arrivingIn);
    }

    /**
     * Выбираем дату 1.
     * @param days .
     */
    public void selectOnDays(final String days) {
        log.info("Выбираем число вылета.");
        isWebElementExists(selectOnDays);
        Select selectDepartingFrom2 = new Select(selectOnDays);
        selectDepartingFrom2.selectByValue(days);
    }

    /**
     * Выбираем дату 2.
     * @param days .
     */
    public void selectReturningDay(final String days) {
        log.info("Выбираем число обратного полета.");
        isWebElementExists(selectReturningDays);
        Select selectDepartingFrom2 = new Select(selectReturningDays);
        selectDepartingFrom2.selectByValue(days);
    }

    /**
     * Нажимаем кнопку Continiue".
     */
    public void clickButtonContiniue() {
        log.info("Нажимаем кнопку Continiue");
        isWebElementExists(fieldOnDays);
        buttonContiniue.click();
    }
}
