https://leetcode.com/problems/contains-duplicate/

# Intuition
The goal is to detect if there are any duplicate elements in the array.<br>
목표는 배열에 중복 요소가 있는지 감지하는 것입니다.

Using a HashSet is an efficient way to check for duplicates because it has constant time complexity for both adding elements and checking if an element exists.<br>
HashSet을 사용하면 요소를 추가하거나 존재 여부를 확인할 때 상수 시간 복잡도를 제공하기 때문에 중복을 효율적으로 검사할 수 있습니다.

# Approach
Initialize an empty HashSet to store unique elements as we iterate through the array.<br>
배열을 순회하면서 고유한 요소를 저장하기 위해 빈 HashSet을 초기화합니다.

Traverse the array using a loop or forEach function:<br>
배열을 루프나 forEach 함수를 사용해 순회합니다.

If an element is already in the HashSet, return true immediately, indicating a duplicate is found.<br>
요소가 이미 HashSet에 있다면, 중복이 발견되었음을 나타내며 즉시 true를 반환합니다.

Otherwise, add the element to the HashSet to continue checking subsequent elements.<br>
그렇지 않다면, 그 요소를 HashSet에 추가하여 다음 요소들을 계속 확인합니다.

If no duplicates are found after iterating through the array, return false.<br>
배열을 다 순회한 후에도 중복이 발견되지 않으면 false를 반환합니다.

# Complexity
Time complexity: O(n), because we iterate through the array once and each operation (insertion and lookup) in a HashSet is O(1). <br>
시간 복잡도: O(n). 배열을 한 번 순회하고, HashSet의 삽입 및 조회 작업이 O(1)이기 때문입니다.

Space complexity: O(n), as we may need to store all elements in the HashSet in the worst case.<br>
공간 복잡도: O(n). 최악의 경우 모든 요소를 HashSet에 저장해야 할 수 있기 때문입니다.
