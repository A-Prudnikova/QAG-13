package helpers;

import com.codeborne.selenide.Configuration;
import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;

public class DriverHelper {
    private static final DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

    public static boolean isRemote() {
        return !config.webDriverUrl().equals("");
    }

    public static void setConfig() {

        if (isRemote()) {
            Configuration.remote = config.webDriverUrl();
        }
        System.out.println("Driver " + Configuration.remote);
    }

    public static void setBrowser() {

        Configuration.browser = config.getBrowser();
        System.out.println("Browser " + Configuration.browser);
    }

    public static void setBrowserVersion() {
        Configuration.browserVersion = config.webBrowserVersion();
        System.out.println("Browser version " + Configuration.browserVersion);
    }

}

