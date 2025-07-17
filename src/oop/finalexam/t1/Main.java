package oop.finalexam.t1;

import java.util.Arrays;
import java.util.List;

/**
 * Entry point for the List Management task.
 * Demonstrates mapping from list1 (indexes) to list2 (values),
 * and building a result list by combining value + index.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(5, 9, 7, 1, 6, 8, 3, 4, 10, 2);
        List<String> list2 = Arrays.asList(
                "jqa", "vxe", "rri", "hac", "gil", "zjg",
                "riq", "dij", "low", "kmn", "cjh", "anw"
        );

        ListManager.processLists(list1, list2);
    }
}
