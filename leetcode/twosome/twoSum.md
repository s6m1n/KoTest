https://leetcode.com/problems/two-sum/description/

1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?


---


### # Intuition

The initial idea to solve this problem is to find two numbers in the array that add up to the target value.<br>
이 문제를 해결하기 위한 초기 아이디어는 배열에서 두 숫자를 찾아 이들의 합이 목표 값이 되는 경우를 찾는 것입니다.

The brute-force approach would be to check all possible pairs, but this would be inefficient.<br>
브루트포스 접근법은 모든 가능한 쌍을 검사하는 것이지만, 이는 비효율적입니다.

Instead, we can use a hash map to reduce the time complexity to linear time, `O(n)`.<br>
대신 해시맵을 사용하여 시간 복잡도를 선형 시간인 `O(n)`으로 줄일 수 있습니다.

By storing the elements we have already seen and checking if the complement (i.e., `target - current number`) exists in our hash map, we can efficiently find the two numbers.<br>
이미 본 요소들을 해시맵에 저장하고, 목표 값에서 현재 숫자를 뺀 값(즉, `target - 현재 숫자`)이 해시맵에 있는지 확인함으로써 효율적으로 두 숫자를 찾을 수 있습니다.

---

### # Approach

1. Initialize a hash map called `numToIndex` to store numbers and their corresponding indices.<br>
   숫자와 해당 인덱스를 저장할 `numToIndex`라는 해시맵을 초기화합니다.
2. Iterate through the array using an index and the number at that index.<br>
   배열을 인덱스와 해당 인덱스의 숫자를 사용하여 반복합니다.
3. For each number, calculate the complement needed to reach the target: `complement = target - num`.<br>
   각 숫자에 대해 목표 값을 달성하기 위해 필요한 보완값을 계산합니다: `complement = target - num`.
4. Check if the complement is already in the hash map:<br>
   보완값이 해시맵에 이미 있는지 확인합니다:
    - If it exists, return the indices of the complement and the current number as the solution.<br>
      존재한다면, 보완값과 현재 숫자의 인덱스를 솔루션으로 반환합니다.
    - If it does not exist, store the current number and its index in the hash map for future reference.<br>
      존재하지 않는다면, 현재 숫자와 그 인덱스를 해시맵에 저장하여 나중에 참조할 수 있도록 합니다.
5. If no solution is found by the end of the loop, throw an exception (though the problem guarantees that there will always be a solution).<br>
   루프가 끝날 때까지 솔루션이 발견되지 않으면 예외를 던집니다 (하지만 문제에서 항상 솔루션이 있다고 보장합니다).

---

### # Complexity

- **Time complexity**: `O(n)`, where `n` is the number of elements in the array. We only traverse the array once, and each lookup or insertion in the hash map is `O(1)` on average.<br>
  **시간 복잡도**: `O(n)`, 여기서 `n`은 배열의 요소 수입니다. 배열을 한 번만 순회하며, 해시맵에서의 조회 또는 삽입은 평균적으로 `O(1)`입니다.
- **Space complexity**: `O(n)`, because in the worst case, we might store all `n` numbers in the hash map.<br>
  **공간 복잡도**: `O(n)`, 최악의 경우 모든 `n`개의 숫자를 해시맵에 저장할 수 있기 때문입니다.
