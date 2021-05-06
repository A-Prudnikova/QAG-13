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

    @Key("webdriver.url")
    String webDriverUrl();

    @Key("webdriver.browser.version")
    String webBrowserVersion();

    @DefaultValue("CHROME")
    @Key("webdriver.browser")
    BROWSER getBrowser();

    enum BROWSER {
        CHROME,
        FIREFOX
    }

}