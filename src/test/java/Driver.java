import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    public static final String CHROMEKEY = "webdriver.chrome.driver";
    public static final String CHROMEPATH = "res\\chromedriver.exe";


    public static final String SCROLLDOWNTOBOTTM = "window.scrollBy(0,document.body.scrollHeight)";
    public static final String SCROLLUPTOTOP = "window.scrollBy(0,-(document.body.scrollHeight))";
    public static final String SCROLLDOWNTOHALFPAGE = "window.scrollBy(0,document.body.scrollHeight/2)";
    public static final String SCROLLUPTOHALFPAGE = "window.scrollBy(0,-(document.body.scrollHeight)/2)";
    public static final String SCROLLTOELEMENT = "arguments[0].scrollIntoView();";


    public static WebDriver setupDriver() {
        System.setProperty(CHROMEKEY, CHROMEPATH);
        return new ChromeDriver();
    }

    public static WebDriver driver = setupDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public static JavascriptExecutor jse = (JavascriptExecutor)driver;

}
