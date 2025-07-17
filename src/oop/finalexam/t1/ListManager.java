package oop.finalexam.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * Maps indexes from `list1` to values in `list2` and constructs a result list
 * where each entry combines a value from `list2` (at `index + 1`) with the index.
 * 
 * **Note**: This implementation uses 1-based indexing for `list2` (unlike Java's standard 0-based indexing).
 * 
 * Algorithm:
 * 1. **Iteration**: For each index in `list1`, retrieves the value at `index + 1` in `list2`.
 * 2. **Validation**: Checks if `index + 1` is within bounds of `list2`.
 * 3. **Error Handling**: Prints an error message for out-of-bounds indexes but continues processing.
 * 4. **Combination**: Formats valid entries as "value + index" (e.g., "vxe9").
 * 
 * Example:
 * - `list1 = [5, 9]`, `list2 = ["jqa", "vxe", ...]` → Result: ["zjg5", "kmn9"] (since `list2.get(5+1) = "zjg"`).
 * 
 * @author Nikita Bezhanovi
 */
public class ListManager {
    /**
     * Processes the two lists and prints the combined result or errors.
     * 
     * @param list1 List of integers representing 1-based indexes into `list2`.
     * @param list2 List of values to be indexed (must have size >= max(list1) + 1).
     */
    public static void processLists(List<Integer> list1, List<String> list2) {
        List<String> result = new ArrayList<>();

        for (int index : list1) {
            if (index >= 0 && index < list2.size()) {
                String combined = list2.get(index + 1) + index; // 1-based indexing
                result.add(combined);
            } else {
                System.out.println("❌ Error: index " + index + " is out of bounds for list2 (size = " + list2.size() + ")");
            }
        }

        System.out.println("✅ Result: " + result);
    }
}