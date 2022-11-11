package ru.javarush.module3.quest.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * A class for working with Text Quest application settings (first init and loading settings).
 */
public class PropertiesLoader {
    public static String rootPath = Objects.requireNonNull(Thread.currentThread()
                    .getContextClassLoader()
                    .getResource(""))
            .getPath();
    private static final String APP_CONFIG_PATH = rootPath + "app.properties";

    public static Properties load() {
        Properties appProps = new Properties();

        try (FileInputStream fis = new FileInputStream(APP_CONFIG_PATH)) {
            appProps.load(fis);
        } catch (IOException e) {
            System.out.println("Problems with loading settings file. Check the app.properties file" +
                    " in the root directory of the program.");
            e.printStackTrace();
        }
        return appProps;
    }
}
