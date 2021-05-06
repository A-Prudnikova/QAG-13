package helpers;

import com.codeborne.selenide.Configuration;
import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;

public class DriverHelper {
    private static final DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

    public static boolean isRemote() {
        return !config.webDriverUrl().equals("");
    }

    public static void setBrowserVersion() {
        Configuration.browserVersion = config.webBrowserVersion();
    }

//    public static void setBrowser() {
//        Configuration.browser = config.getBrowser();
//    }

    public static void setConfig() {

        if (isRemote()) {
            Configuration.remote = config.webDriverUrl();
        }

    }

}

