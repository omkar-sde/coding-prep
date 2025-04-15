# CODING-ROUND-PREP

## Neetcode

<details>
  <summary>Blind 150 Java</summary>

  <details>
    <summary>Arrays and Hashing</summary>

  - [ContainsDuplicate_217](src/main/java/org/neetcode150/arraysAndHashing/ContainsDuplicate_217.java)
    - Problem Statement: If an array contains duplicate return false else return true
    - Intuition: Use sets to store all elements, if no duplicates are present, size will be different
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    
  - [ValidAnagram_242](src/main/java/org/neetcode150/arraysAndHashing/ValidAnagram_242.java)
    - Problem Statement: Two strings having exactly same characters (including their count)
    - Intuition: Use hashtable, store character counts with character ascii as key/index.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    
  - [TwoSum_1](src/main/java/org/neetcode150/arraysAndHashing/TwoSum_1.java)
    - Problem Statement: In an array find a pair of numbers(indices) that add up to a target. Order of indices not required
    - Intuition: Check if diff is present in map
    - Time Complexity: O(n)
    - Space Complexity: O(n)
    
  - [GroupAnagrams_49](src/main/java/org/neetcode150/arraysAndHashing/GroupAnagrams_49.java)
    - Problem Statement: In an array of strings, group the anagrams together and return a list
    - Intuition: Use hashmap where sorted string is the key and its value is the list of its anagram. (map.putIfAbsent())
    - Time Complexity: O(n*mlogm)
    - Space Complexity: O(n*m)
    
  - [TopKFrequentElements_347](src/main/java/org/neetcode150/arraysAndHashing/TopKFrequentElements_347.java)
    - Problem Statement: In an array find k top elements with highest occurrences
    - Intuition: Bucket Sort. Count occurrences in hashmap, put it in bucket of size N as per occurrences
    - Time Complexity: O(n)
    - Space Complexity: O(n)
    
  - [EncodeDecodeStrings_premium](src/main/java/org/neetcode150/arraysAndHashing/EncodeDecodeStrings_premium.java)
    - Problem Statement: Encode and decode a string. Array of strings is given
    - Intuition: Append each string with strLength and a special character to encode.
    - Time Complexity: O(m)
    - Space Complexity: O(m + n)
    
  - [ProductOfArrayExceptSelf_238](src/main/java/org/neetcode150/arraysAndHashing/ProductOfArrayExceptSelf_238.java)
    - Problem Statement: Product of array except itself stored at the same index as self
    - Intuition: Prefix (res[i] * nums[i]) postfix(product * res[i]; product * nums[i])
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    
  - [ValidSudoku_36](src/main/java/org/neetcode150/arraysAndHashing/ValidSudoku_36.java)
    - Problem Statement: Prefilled char matrix with ‘1-9 and ’.’. No duplicates in a row and col and 3x3 matrix
    - Intuition: Hashset to store values in each row, col and box. Box index calc (i/3)*3+(j/3)
    - Time Complexity: O(m^2)
    - Space Complexity: O(m^2)
    
  - [LongestConsecutiveSequence_128](src/main/java/org/neetcode150/arraysAndHashing/LongestConsecutiveSequence_128.java)
    - Problem Statement: In an array find sequence of consecutive elements(nums)
    - Intuition: Store in set. Iterate over set, check if num-1 doesn’t exist. Keep adding length to num and checking in set.
    - Time Complexity: O(n)
    - Space Complexity: O(n)

  </details>

  <details>
    <summary>Two Pointers</summary>

  - [ValidPalindrome_125](src/main/java/org/neetcode150/twoPointers/ValidPalindrome_125.java)
    - Problem Statement: String Palindrome check for alphanumeric case insensitive characters.
    - Intuition: Helper function for char check, while loop to skip non-alphanumeric characters.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    
  - [TwoSumII_167](src/main/java/org/neetcode150/twoPointers/TwoSumII_167.java)
    - Problem Statement: Sorted array is given. Find pair such that their sum = target
    - Intuition: sum = left + right, sum < target left++ else right++
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    
  - [ThreeSum_15](src/main/java/org/neetcode150/twoPointers/ThreeSum_15.java)
    - Problem Statement: Sum of triplets in an array where target is 0. Multiple triplets but no duplicates
    - Intuition: Skip duplicates, i, j, k. Sum < 0 j++ else k++
    - Time Complexity: O(n^2)
    - Space Complexity: O(1)
    
  - [ContainerWithMostWater_11](src/main/java/org/neetcode150/twoPointers/ContainerWithMostWater_11.java)
    - Problem Statement: Array with heights, find max area between two heights
    - Intuition: Min height is breadth, indices difference is length
    - Time Complexity: O(n)
    - Space Complexity: O(1)

  </details>

  <details>
    <summary>Sliding Window</summary>

  - [BestTimeToBuyAndSellStock_121](src/main/java/org/neetcode150/slidingWindow/BestTimeToBuyAndSellStock_121.java)
    - Problem Statement: Maximize profit by buying low and selling high. Find pair of such prices
    - Intuition: Keep moving right, if right is small than left, update left, find diff, get max
    - Time Complexity: O(n)
    - Space Complexity: O(1)
  - [LongestSubstringWithoutRepeatingCharacter_3](src/main/java/org/neetcode150/slidingWindow/LongestSubstringWithoutRepeatingCharacter_3.java)
    - Problem Statement: Find length of longest substring without duplicate characters 
    - Intuition: use set to store unique chars. If duplicate found remove until unique again
    - Time Complexity: O(n)
    - Space Complexity: O(m), m is set of unique characters
  - [LongestRepeatingCharacterReplacement_424](src/main/java/org/neetcode150/slidingWindow/LongestRepeatingCharacterReplacement_424.java)
    - Problem Statement: In a string, find max length of repeating char if k replacements are allowed
    - Intuition: HashMap, Increase right char freq if grow, reduce left char freq if shrink. Right - left + 1 - maxFreq > k
    - Time Complexity: O(n)
    - Space Complexity: O(m), m is no. of unique chars
  - [PermutationInString_567](src/main/java/org/neetcode150/slidingWindow/PermutationInString_567.java)
    - Problem Statement: Check if s2 contains permutation of s1 
    - Intuition: hashmap[26]. Count char matches in s2 of s1 char, start window at s1’s length when iterating over s2. calculate right/left char index, increment/decrement match as it is found. If total matches is 26 true
    - Time Complexity: O(26) + O(n), n is length of s2
    - Space Complexity: O(1), except constant space for maps.
  </details>

  <details>
    <summary>Stack</summary>

  - [ValidParentheses_20](src/main/java/org/neetcode150/stack/ValidParentheses_20.java)
    - Problem Statement: Brackets closed properly
    - Intuition: HashMap. Close to open.Time Complexity: O(n)
    - Space Complexity: O(n)
  - [MinStack_155](/src/main/java/org/neetcode150/stack/MinStack_155.java)
    - Problem Statement: Postfix expression without parentheses.
      Intuition: if number push in stack, if operand pop two, perform push.
      Time Complexity: O(n)
      Space Complexity: O(n)
  - [EvaluateReversePolishNotation_150](src/main/java/org/neetcode150/stack/EvaluateReversePolishNotation_150.java)
    - Problem Statement: generate ‘n’ valid parentheses 
    - Intuition: o = c & o = n; o < n; c < o 
    - Time Complexity: O(4^n / sqrt(n))
    - Space Complexity: O(n)
  - [GenerateParentheses_22](src/main/java/org/neetcode150/stack/GenerateParentheses_22.java)
    - Problem Statement: generate ‘n’ valid parentheses 
    - Intuition: o = c & o = n; o < n; c < o
    - Time Complexity: O(4^n / sqrt(n))
    - Space Complexity: O(n)
  - [DailyTemperatures_739](src/main/java/org/neetcode150/stack/DailyTemperatures_739.java)
    - Problem Statement: Consecutive temperatures of day are given. Find after how many days the temp will be higher than the current day’s temp.
    - Intuition: Monotonic stack. Keep adding temp with index, if temp i greater keep poping
    - Time Complexity: O(n)
    - Space Complexity: O(n)
  - [CarFleet_853](/src/main/java/org/neetcode150/stack/CarFleet_853.java)
    - Problem Statement: Car fleet. Fleet of cars reaching a target. Position and speed are given
    - Intuition: Create pair(p,s). Sort descending. Calculate time taken for car to reach target. Compare it with time taken of the previous.
    - Time Complexity: O(nlogn)
    - Space Complexity: O(1)
 
</details>

<details>
<summary>Binary Search</summary>

  - [BinarySearch_704](/src/main/java/org/neetcode150/binarySearch/BinarySearch_704.java)
    - Problem Statement: Search in sorted array in O(logn)
    - Intuition: Use pivot
    - Time Complexity: O(logn)
    - Space Complexity: O(1)
- [SearchA2DMatrix_74](/src/main/java/org/neetcode150/binarySearch/SearchA2DMatrix_74.java)
  - Problem Statement: Binary search in 2D matrix
  - Intuition: calculate index row = mid / n
  - Time Complexity: O(log(m*n))
  - Space Complexity: O(1)
- [TimeBasedKeyValueStore_987](/src/main/java/org/neetcode150/binarySearch/TimeBasedKeyValueStore_987.java)
  - Problem Statement: Design time based key value structure. Where for a key value is timestamp and value. Define ctor, get and set methods. When getting value, if timestamp is not available, latest timestamp is picked. 
  - Intuition: HashMap<String, List<Pair<K,V>>. A pair class is required. Using binary search find value smaller than the timestamp and get the value associated with it. 
  - Time Complexity: O(1) to set, O(logn) to get 
  - Space Complexity: O(m*n)

</details>

</details>

