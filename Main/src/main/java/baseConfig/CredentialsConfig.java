package baseConfig;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface CredentialsConfig extends Config {

    @Key("dbHost")
    String dbHost();

    @Key("dbPort")
    String dbPort();

    @Key("dbUser")
    String dbUser();

    @Key("dbPassword")
    String dbPassword();

    @Key("dbName")
    String dbName();

}
