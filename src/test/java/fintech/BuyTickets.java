package fintech;

import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.Listeners;
import pageObject.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import static driver.Driver.getChromeDriver;
import static org.hamcrest.Matchers.containsString;

@Listeners(fintech.ListenerTest.class)

public class BuyTickets extends TestBase {
    private static final Logger log = Logger.getGlobal();
    private HomePage homePage;
    private SingOn singOn;
    private FlightFinder flightFinder;
    private TicketSelection ticketSelection;
    private BookAFlinght bookAFlinght;
    private FlightConfirmation flightConfirmation;
    private String dateStr2;
    private String dayFrom;
    private String dayReturn;
    private String dateStr1;

    @Override
    protected void initialize() {
        homePage = new HomePage();
        homePage.init(getChromeDriver());
        singOn = new SingOn();
        singOn.init(getChromeDriver());
        flightFinder = new FlightFinder();
        flightFinder.init(getChromeDriver());
        ticketSelection = new TicketSelection();
        ticketSelection.init(getChromeDriver());
        bookAFlinght = new BookAFlinght();
        bookAFlinght.init(getChromeDriver());
        flightConfirmation = new FlightConfirmation();
        flightConfirmation.init(getChromeDriver());
    }

    @Test
    public void testBuyTikets(){

        getDate();
        step1();
        step2();
        step3();
        step4();
        step5();
        step6();
        step7();
        step8();
        step9();
        step10();
    }

    private void getDate() {
        log.info("Получаем текущую дату и форматируем ее.");
        Date date1 = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("MM/d/yyyy");
        SimpleDateFormat formatForDateForSet = new SimpleDateFormat("d");
        dateStr1 = formatForDateNow.format(date1);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 4);
        Date date2 = cal.getTime();
        dateStr2 = formatForDateNow.format(date2);
        dayFrom = formatForDateForSet.format(date1);
        dayReturn = formatForDateForSet.format(date2);
    }

    private void step1() {
        log.info("Step 1");
        homePage.clickButtonSingOn();
        String userName = "test1";
        singOn.setInputUserName(userName);
        String password = "test1";
        singOn.setInputPassword(password);
    }

    private void step2() {
        log.info("Step 2");
        singOn.clickButtonSubmit();
    }

    private void step3() {
        log.info("Step 3");
        String cityFrom = "Acapulco";
        String cityTo = "London";
        flightFinder.selectDepartingFrom(cityFrom);
        flightFinder.selectArrivingIn(cityTo);
        flightFinder.selectOnDays(dayFrom);
        flightFinder.selectReturningDay(dayReturn);
    }

    private void step4() {
        log.info("Step 4");
        flightFinder.clickButtonContiniue();
    }

    private void step5() {
        log.info("Step 5");
        ticketSelection.selectRadioButtonDepart();
        ticketSelection.selectRadioButtonReturn();
    }

    private void step6() {
        log.info("Step 6");
        ticketSelection.clickButtonContiniue();
    }

    private void step7() {
        log.info("Step 7");
        String firstName = "Stepan";
        String lastName = "Perepechko";
        String creditCardNumber = "6523658741";
        bookAFlinght.setInputFirstName(firstName);
        bookAFlinght.setInputLastName(lastName);
        bookAFlinght.setInputCreditNumber(creditCardNumber);
    }

    private void step8() {
        log.info("Step 8");
        bookAFlinght.clickButtonBuyFlights();
    }

    private void step9() {
        log.info("Step 9");
        String infoDep = flightConfirmation.getInfoDeparting();
        String infoReturn = flightConfirmation.getInfoReturning();
        Assert.assertThat(infoDep, containsString("Acapulco to London"));
        Assert.assertThat(infoDep, containsString(dateStr1));
        Assert.assertThat(infoReturn, containsString("London to Acapulco"));
        Assert.assertThat(infoReturn, containsString(dateStr2));
    }

    private void step10() {
        log.info("Step 10");
        flightConfirmation.clickButtonBackToHome();
    }
}
