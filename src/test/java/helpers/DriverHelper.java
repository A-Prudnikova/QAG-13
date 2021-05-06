package helpers;

import com.codeborne.selenide.Configuration;
import config.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class DriverHelper {
    private static final DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

    public static boolean isRemote() {
        return !config.webDriverUrl().equals("");
    }

    public static void setConfig() {

        if (isRemote()) {
            Configuration.remote = config.webDriverUrl();
        }

    }

    public static void setBrowserVersion() {
        Configuration.browserVersion = config.webBrowserVersion();
    }

    public static void setBrowser() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = config.getBrowser().toString();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
    }

}

