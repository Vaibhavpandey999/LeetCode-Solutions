import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3: Longest Substring Without Repeating Characters
 *
 * Difficulty: Medium
 * Topic: Sliding window + hash map
 *
 * Approach:
 * Keep a window containing unique characters. lastSeen stores the most recent
 * index of each character. If a repeated character occurs inside the current
 * window, move the left boundary just beyond its previous position.
 *
 * Time: O(n), where n is the UTF-16 length of the string.
 * Space: O(min(n, character-set size)) for the last-seen map.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            Integer previous = lastSeen.get(current);

            if (previous != null && previous >= left) {
                left = previous + 1;
            }

            lastSeen.put(current, right);
            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    // Small dependency-free smoke tests; run with: java LongestSubstringWithoutRepeatingCharacters.java
    public static void main(String[] args) {
        Solution solution = new Solution();

        check(solution, "abcabcbb", 3);
        check(solution, "bbbbb", 1);
        check(solution, "pwwkew", 3);
        check(solution, "abba", 2);
        check(solution, "", 0);
        check(solution, "dvdf", 3);
        check(solution, "你好你", 2);

        System.out.println("All 7 test cases passed.");
    }

    private static void check(Solution solution, String input, int expected) {
        int actual = solution.lengthOfLongestSubstring(input);
        if (actual != expected) {
            throw new AssertionError(
                "For input \"" + input + "\": expected " + expected + ", got " + actual
            );
        }
    }
}
