package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/testdata.properties"
})
public interface TestDataConfig extends Config {
    @Key("web.url")
    String baseUrl();

    @Key("user.login")
    String userLogin();

    @Key("user.password")
    String userPassword();

}