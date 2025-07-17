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
