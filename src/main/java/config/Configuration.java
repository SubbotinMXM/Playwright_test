//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties", "classpath:config.properties", "classpath:allure.properties", "classpath:log4j.properties"})
public interface Configuration extends Config{
    @Key("browser")
    String browser();

    @Key("base.url")
    String baseUrl();

    @Key("headless")
    boolean headless();

    @Key("retry.count")
    int retryCount();

    @Key("slowMo")
    int slowMo();

    @Key("timeout")
    int timeout();
}
