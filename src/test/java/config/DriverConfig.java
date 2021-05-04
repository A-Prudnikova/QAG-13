package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${driver}_driver.properties",
        "classpath:config/remote_driver.properties"
})
public interface DriverConfig extends Config {

    @Key("web.driver.remote")
    boolean isRemote();

    @Key("web.driver.browser")
    String webBrowser();

    @Key("web.driver.browser.version")
    String webBrowserVersion();

    @Key("web.driver.remote.url")
    String webRemoteDriverUrl();

    @Key("web.driver.remote.user")
    String webRemoteDriverUser();

    @Key("web.driver.remote.password")
    String webRemoteDriverPassword();


}