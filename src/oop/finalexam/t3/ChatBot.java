package oop.finalexam.t3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Scanner;

/**
 * The core ChatBot class responsible for user interaction and communication
 * with the web server via REST API.
 */
public class ChatBot {
    private String botName;
    private String restServerUrl;
    private Scanner scanner;

    /**
     * Constructs a ChatBot instance.
     *
     * @param botName The name of the chat bot.
     * @param restServerUrl The URL of the REST API server.
     */
    public ChatBot(String botName, String restServerUrl) {
        this.botName = botName;
        this.restServerUrl = restServerUrl;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the chat bot interaction loop.
     */
    public void start() {
        System.out.println("Hello! I am " + botName + ". How can I help you today?");
        printMenu();

        while (true) {
            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    viewAllBlogPosts();
                    break;
                case "2":
                    createNewBlogPost();
                    break;
                case "3":
                    viewGeneralStatistics();
                    break;
                case "4":
                    System.out.println("Goodbye! " + botName + " is shutting down.");
                    return; // Exit the loop and terminate the bot
                case "menu":
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, 4, or 'menu'.");
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. View all blog posts");
        System.out.println("2. Create a new blog post");
        System.out.println("3. View general site statistics");
        System.out.println("4. Exit");
        System.out.println("Type 'menu' to show this menu again.");
        System.out.println("-----------------");
    }

    /**
     * Makes an HTTP GET request to the specified URL and returns the response body.
     *
     * @param apiUrl The URL to send the GET request to.
     * @return The response body as a String, or an error message if the request fails.
     */
    private String sendGetRequest(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000); // 5 seconds
            conn.setReadTimeout(5000);    // 5 seconds

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return "Error: GET request failed. Response Code: " + responseCode;
            }
        } catch (IOException e) {
            return "Error sending GET request: " + e.getMessage();
        }
    }

    /**
     * Makes an HTTP POST request to the specified URL with the given JSON payload.
     *
     * @param apiUrl The URL to send the POST request to.
     * @param jsonInputString The JSON string to send in the request body.
     * @return The response body as a String, or an error message if the request fails.
     */
    private String sendPostRequest(String apiUrl, String jsonInputString) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true); // Allows sending a body

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine.trim()); // Trim to remove potential newline issues
                }
                in.close();
                return response.toString();
            } else {
                // Read error stream for more details
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8));
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine.trim());
                }
                errorReader.close();
                return "Error: POST request failed. Response Code: " + responseCode + ". Error Message: " + errorResponse.toString();
            }
        } catch (IOException e) {
            return "Error sending POST request: " + e.getMessage();
        }
    }

    /**
     * Handles viewing all blog posts by making a GET request to the server.
     */
    private void viewAllBlogPosts() {
        System.out.println("\n" + botName + ": Fetching all blog posts...");
        String response = sendGetRequest(restServerUrl + "?action=view_posts"); // Assuming API endpoint for viewing posts
        System.out.println("Server Response:\n" + response);
    }

    /**
     * Handles creating a new blog post by prompting the user for details
     * and making a POST request to the server.
     */
    private void createNewBlogPost() {
        System.out.println("\n" + botName + ": Let's create a new blog post.");
        System.out.print("Enter post title: ");
        String title = scanner.nextLine();
        System.out.print("Enter post content: ");
        String content = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        // Construct JSON payload for the new post
        String jsonInputString = String.format(
                "{\"action\": \"create_post\", \"title\": \"%s\", \"content\": \"%s\", \"author\": \"%s\"}",
                escapeJson(title), escapeJson(content), escapeJson(author)
        );

        System.out.println(botName + ": Sending new post request...");
        String response = sendPostRequest(restServerUrl, jsonInputString);
        System.out.println("Server Response:\n" + response);
    }

    /**
     * Handles viewing general site statistics by making a GET request to the server.
     */
    private void viewGeneralStatistics() {
        System.out.println("\n" + botName + ": Fetching general site statistics...");
        String response = sendGetRequest(restServerUrl + "?action=view_stats"); // Assuming API endpoint for viewing stats
        System.out.println("Server Response:\n" + response);
    }

    /**
     * Escapes special characters in a string to make it safe for JSON.
     * @param text The text to escape.
     * @return The escaped text.
     */
    private String escapeJson(String text) {
        if (text == null) {
            return "";
        }
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}