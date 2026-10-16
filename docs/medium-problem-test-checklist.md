# Medium Problem Test-Case Checklist

Use this checklist before considering a LeetCode solution complete.

## General cases

- [ ] Typical example from the problem statement
- [ ] Smallest valid input
- [ ] Empty input, if the constraints allow it
- [ ] Repeated values or characters
- [ ] Already sorted and reverse-sorted inputs, when relevant
- [ ] Duplicate values and ties
- [ ] Boundary values from the constraints
- [ ] A case that forces the algorithm's main branch or pointer to move
- [ ] A case that previously exposed a bug

## Review before committing

- [ ] Expected output is independently reasoned about
- [ ] The solution handles all stated constraints
- [ ] Tests are deterministic and can be rerun
- [ ] Time and space complexity are documented
- [ ] The commit message describes the actual change

## Example: Longest Substring Without Repeating Characters

| Input | Expected | Why |
|---|---:|---|
| `"abcabcbb"` | 3 | Standard overlapping repeats |
| `"bbbbb"` | 1 | All characters repeat |
| `"abba"` | 2 | A repeated character is behind the current window |
| `""` | 0 | Empty input |
| `"dvdf"` | 3 | Window must move without discarding too much |
