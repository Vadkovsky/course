package driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static ChromeDriver driver;

    /**
     * Возвращаем веб драйвер.
     * @return
     */
    public static ChromeDriver getChromeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * Закрываем драйвер.
     */
    public static void closeChromeDriver() {
        if (driver != null) {
            waitClose(4);
            driver.close();
        }
    }

    /**
     * Ожидалка закрытия.
     * @param seconds .
     */
    private static void waitClose(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
