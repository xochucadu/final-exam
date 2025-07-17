package oop.finalexam.t3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Handles loading configuration properties for the chat bot from a text file.
 * This includes the REST server URL and the bot's name.
 */
public class Config {
    private static final String CONFIG_FILE_NAME = "config.txt";
    private Properties properties;

    /**
     * Constructs a Config object and attempts to load properties from config.txt.
     * If the file is not found or an error occurs, default values are used.
     */
    public Config() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_NAME)) {
            properties.load(fis);
            System.out.println("Configuration loaded successfully from " + CONFIG_FILE_NAME);
        } catch (IOException e) {
            System.err.println("Warning: Could not load configuration from " + CONFIG_FILE_NAME + ". Using default values.");
            System.err.println("Error: " + e.getMessage());
            // Set default values if config file is not found or cannot be read
            properties.setProperty("rest.server.url", "http://max.ge/final/t3/72839461/index.php");
            properties.setProperty("bot.name", "ChatBot");
        }
    }

    /**
     * Returns the configured REST server URL.
     * @return The REST server URL.
     */
    public String getRestServerUrl() {
        return properties.getProperty("rest.server.url");
    }

    /**
     * Returns the configured chat bot name.
     * @return The bot's name.
     */
    public String getBotName() {
        return properties.getProperty("bot.name");
    }
}