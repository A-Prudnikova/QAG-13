package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${driver}_driver.properties",
        "classpath:config/remote_driver.properties"
})
public interface DriverConfig extends Config {

//    @Key("webdriver.browser")
//    String getBrowser();

    @Key("webdriver.browser.version")
    String webBrowserVersion();

    @Key("webdriver.url")
    String webDriverUrl();

//    enum BROWSER {
//        CHROME,
//        FIREFOX
//    }

}