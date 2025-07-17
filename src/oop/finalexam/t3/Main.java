package oop.finalexam.t3;

public class Main {
    public static void main(String[] args) {
        // Load configuration
        Config config = new Config();
        String botName = config.getBotName();
        String restServerUrl = config.getRestServerUrl();

        // Create and start the chat bot
        ChatBot chatBot = new ChatBot(botName, restServerUrl);
        chatBot.start();
    }
}


