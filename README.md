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
