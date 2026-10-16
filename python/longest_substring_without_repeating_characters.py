"""
LeetCode 3: Longest Substring Without Repeating Characters
Difficulty: Medium
Topic: Sliding window + hash map

Approach:
Maintain a window whose characters are unique. `last_seen` stores the most
recent index of each character. When a repeated character appears inside the
current window, move the left edge just past its previous occurrence.

Time: O(n), where n is the length of the string.
Space: O(min(n, alphabet size)) for the last-seen index map.
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        last_seen = {}
        left = 0
        best = 0

        for right, char in enumerate(s):
            previous = last_seen.get(char)
            if previous is not None and previous >= left:
                left = previous + 1

            last_seen[char] = right
            best = max(best, right - left + 1)

        return best


if __name__ == "__main__":
    import unittest

    class TestLongestSubstring(unittest.TestCase):
        def setUp(self):
            self.solution = Solution()

        def test_standard_example(self):
            self.assertEqual(self.solution.lengthOfLongestSubstring("abcabcbb"), 3)

        def test_all_characters_repeat(self):
            self.assertEqual(self.solution.lengthOfLongestSubstring("bbbbb"), 1)

        def test_repeated_character_outside_window(self):
            self.assertEqual(self.solution.lengthOfLongestSubstring("abba"), 2)

        def test_empty_string(self):
            self.assertEqual(self.solution.lengthOfLongestSubstring(""), 0)

        def test_window_moves_after_repeat(self):
            self.assertEqual(self.solution.lengthOfLongestSubstring("dvdf"), 3)

        def test_unicode_characters(self):
            self.assertEqual(self.solution.lengthOfLongestSubstring("你好你"), 2)

    unittest.main()
