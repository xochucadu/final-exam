# List Index Mapper  

## 📖 Description  
Maps 1-based indexes from `list1` to values in `list2` and combines them into strings like `"value5"`.  

## ⚠️ Error Handling  
1. **Out-of-Bounds Indexes**:  
   - Prints an error but continues processing other indexes.  
   - Example: If `list2.size() = 10` and `list1` contains `9`:  
     ```
     ❌ Error: index 9 is out of bounds for list2 (size = 10)
     ```  
   *(Note: `index + 1` must be < `list2.size()` due to 1-based indexing.)*  

2. **Edge Cases**:  
   - Negative indexes are flagged as invalid.  
   - Null inputs will throw `NullPointerException` (unhandled in current code).  

*Output for `list1 = [5, 99]`, `list2 = ["jqa", "vxe", ..., "anw"]` (size=12):*  
```plaintext
❌ Error: index 99 is out of bounds for list2 (size = 12)
✅ Result: [zjg5]

# University Management System (UMS) - Task #2

## Description
Java program to manage student data and enrolled courses.

## Classes
- **`UMS`**: Manages students and prints their data.
- **`Student`**: Stores student info (name, ID) and their courses.
- **`LearningCourse`**: Contains course details (title, prerequisites, topics).

## Nikita Bezhanovi's Courses
| Course Title                  | Prerequisites       | Major Topics               |
|------------------------------|--------------------|---------------------------|
| Object-Oriented Programming  | Basic Java         | Inheritance, Polymorphism |
| Algorithms and Data Structures | Discrete Math    | Sorting, Graphs           |
| Computer Organization        | Digital Logic     | CPU Architecture          |
| English Language Course C1-2 | English B2        | Academic Writing          |

## UML Diagram
![UML Diagram](link_to_your_uml_image.png)

## How to Run
1. Compile: `javac oop/final/t2/*.java`
2. Run: `java oop.final.t2.Main`
Task 3: Chat-Bot Application
This project implements a Java console-based chat bot that interacts with a web server via a REST API, as specified in the Final Exam assignment.

Project Structure
The project follows the package structure oop.final.t3 as required.

src/
└── oop/
    └── final/
        └── t3/
            ├── Config.java
            ├── ChatBot.java
            └── Main.java
config.txt

Classes Overview
Config.java:

Purpose: Manages the loading of configuration properties from config.txt.

Fields:

properties (Properties): Stores key-value pairs loaded from the configuration file.

Methods:

Constructor: Attempts to load config.txt. If the file is not found or an error occurs, it uses default values for the REST server URL and bot name.

getRestServerUrl(): Returns the configured REST server URL.

getBotName(): Returns the configured chat bot name.

ChatBot.java:

Purpose: The core logic of the chat bot, handling user interaction and making API calls.

Fields:

botName (String): The name of the bot, displayed during interaction.

restServerUrl (String): The base URL for the REST API.

scanner (Scanner): Used for reading user input from the console.

Methods:

Constructor: Initializes the bot with its name and the server URL.

start(): Enters the main interaction loop, displays the menu, and processes user commands.

printMenu(): Displays the available actions to the user.

sendGetRequest(String apiUrl): A private helper method to send HTTP GET requests and return the server's response. Includes basic error handling.

sendPostRequest(String apiUrl, String jsonInputString): A private helper method to send HTTP POST requests with a JSON payload and return the server's response. Includes basic error handling.

viewAllBlogPosts(): Calls the API to retrieve and display all blog posts.

createNewBlogPost(): Prompts the user for post details (title, content, author), constructs a JSON payload, and sends it to the server via a POST request.

viewGeneralStatistics(): Calls the API to retrieve and display general site statistics.

escapeJson(String text): A utility method to escape special characters in strings to ensure valid JSON formatting.

Main.java:

Purpose: The entry point of the application.

Methods:

main(String[] args):

Creates a Config object to load settings.

Initializes a ChatBot instance with the loaded configuration.

Calls the start() method of the ChatBot to begin the interaction.

Configuration File (config.txt)
The config.txt file is used to configure the bot's behavior. It should be placed in the root directory of your project (or the directory from which you run the java command).

Example config.txt:

rest.server.url=http://max.ge/final/t3/72839461/index.php
bot.name=MyAwesomeChatBot

rest.server.url: The full URL of the REST API endpoint. Ensure this is plain text, without any Markdown formatting like [text](url).

bot.name: The name of your chat bot.

How to Run (Detailed Steps)
Follow these steps carefully to set up and run the application:

Create Project Directory:

Create a main project directory, for example, FinalExam.

Inside FinalExam, create a src directory.

Create Package Directories:

Inside the src directory, create the package structure: oop/final/t3.

So, the full path will be FinalExam/src/oop/final/t3/.

Create Java Files:

Config.java: Inside FinalExam/src/oop/final/t3/, create a file named Config.java. Copy and paste only the content marked for Config.java from the chatbot-java-code Canvas into this file.

ChatBot.java: Inside FinalExam/src/oop/final/t3/, create a file named ChatBot.java. Copy and paste only the content marked for ChatBot.java from the chatbot-java-code Canvas into this file.

Main.java: Inside FinalExam/src/oop/final/t3/, create a file named Main.java. Copy and paste only the content marked for Main.java from the chatbot-java-code Canvas into this file.

Create Configuration File:

Inside the main project directory (FinalExam/), create a file named config.txt. Copy and paste only the content marked for config.txt from the chatbot-java-code Canvas into this file.

Compile the Java Files:

Open your terminal or command prompt.

Navigate to the src directory of your project:

cd FinalExam/src

Compile all Java files:

javac oop/final/t3/*.java

If compilation is successful, .class files will be generated in the oop/final/t3/ directory.

Run the Application:

Navigate back to the main project directory (FinalExam/):

cd ..

Run the Main class, ensuring the current directory (.) is included in the classpath so config.txt can be found:

java -cp . oop.final.t3.Main

API Endpoints (Assumed)
The ChatBot class assumes the following API endpoints based on the assignment description:

View All Blog Posts: GET {rest.server.url}?action=view_posts

Create New Blog Post: POST {rest.server.url} with a JSON body like:
