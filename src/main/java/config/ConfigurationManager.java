package config;

import java.util.Map;
import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {
    private ConfigurationManager() {
    }

    public static Configuration config() {
        return (Configuration)ConfigCache.getOrCreate(Configuration.class, new Map[0]);
    }
}
