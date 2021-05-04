package helpers;

import com.codeborne.selenide.Configuration;
import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;

public class DriverHelper {
private static final DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

private static boolean isRemote() {
    return config.isRemote();
}

public static void setConfig() {
    Configuration.browser = config.webBrowser();
    Configuration.browserVersion = config.webBrowserVersion();
    Configuration.timeout = 10000;

    if (isRemote()) {
        Configuration.remote = config.webRemoteDriverUrl();
    }
}

}

