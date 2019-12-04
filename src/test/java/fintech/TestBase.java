package fintech;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.Driver.closeChromeDriver;
import static driver.Driver.getChromeDriver;

public class TestBase {
    private final Wait<WebDriver> wait = new WebDriverWait(getChromeDriver(), 5, 1000);

    /**
     * Предварительные действия.
     */
    @Before
    public void before() {
        getChromeDriver().get("http://newtours.demoaut.com/");
        getChromeDriver().manage().window().maximize();
        initialize();
    }

    /**
     * Метод инициализации страниц.
     */
    protected void initialize() {
    }

    /**
     * Закрываем драйвер после окончания теста.
     */
    @After
    public void after() {
        closeChromeDriver();
    }
}
