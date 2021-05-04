package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:config/testdata.properties"
})
public interface TestDataConfig extends Config {
    @Key("web.url")
    String webUrl();

    @Key("user.login")
    String userLogin();

    @Key("user.password")
    String userPassword();

}