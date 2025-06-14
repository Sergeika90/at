package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {
    private static Properties props = new Properties();
    private static String env;

    static {
        env = System.getProperty("env", "default");
        try (InputStream input = ConfigProvider.class.getClassLoader().getResourceAsStream("properties")) {
            if (input == null) {
                throw new RuntimeException("properties not found");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties", e);
        }
    }

    public static String getBaseUrl() {
        return props.getProperty(env + ".baseUrl");
    }

    public static String getEnv() {
        return env;
    }
}
