# 두 수의 합

<img width="629" height="184" alt="Image" src="https://github.com/user-attachments/assets/6d456d60-456d-4dcf-9b38-ed99d4b35818" />

## 접근 과정

1. 브루트포스
   1. 이중 for문으로 각 요소들을 더해본다.
   2. 더해서 target과 같은 값이 나오는 인덱스 값을 반환한다.

## 풀이

```java
// 브루트포스
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
```

## 시간복잡도

o(n^2)

---

# 빗물트래핑

<img width="682" height="367" alt="Image" src="https://github.com/user-attachments/assets/a1a2e405-bbb1-48dd-8853-f117992ee275" />

## 접근 과정

1. 각 인덱스의 높이(height[i])가 주어질 때, 비가 온 후 고일 수 있는 물의 총량을 구한다.
2. 각 위치에서 고일 수 있는 물의 양은, 그 위치의 왼쪽과 오른쪽에서 가장 높은 벽 중 더 낮은 벽의 높이에서 현재 높이를 뺀 값이다.
3. 투포인터
   1. 배열의 양 끝에서 시작하는 두 개의 포인터(left, right)을 사용한다.
   2. leftMax: 현재 left 포인터까지의 최대 높이
   3. rightMax: 현재 right 포인터까지의 최대 높이
   4. leftMax < rightMax이면, left 위치에서 고일 수 있는 물의 양은 leftMax - height[left]
   5. 반대로 rightMax < leftMax이면, right 위치에서 고일 수 있는 물의 양은 rightMax - height[right]
   6. 각 포인터를 안쪽으로 이동시키며 위 과정을 반복한다.

## 풀이

```java
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            // 왼쪽 높이가 오른쪽 높이보다 작거나 같으면
            if (height[left] < height[right]) {
                // 현재 위치의 높이가 지금까지 만난 왼쪽 최대 높이보다 크거나 같으면
                if (height[left] >= leftMax) {
                    // 왼쪽 최대 높이 갱신
                    leftMax = height[left];
                } else {
                    // 왼쪽 최대 높이보다 현재 높이가 작으면, 그 차이만큼 물이 고임
                    totalWater += leftMax - height[left];
                }
                // 왼쪽 포인터를 오른쪽으로 한 칸 이동
                left++;
            } else {
                // 오른쪽 높이가 왼쪽 높이보다 작으면
                // 현재 위치의 높이가 지금까지 만난 오른쪽 최대 높이보다 크거나 같으면
                if (height[right] >= rightMax) {
                    // 오른쪽 최대 높이 갱신
                    rightMax = height[right];
                } else {
                    // 오른쪽 최대 높이보다 현재 높이가 작으면, 그 차이만큼 물이 고임
                    totalWater += rightMax - height[right];
                }
                // 오른쪽 포인터를 왼쪽으로 한 칸 이동
                right--;
            }
        }

        return totalWater;
    }
}
```

## 시간복잡도

o(n)

---

# 세 수의 합

<img width="570" height="174" alt="Image" src="https://github.com/user-attachments/assets/a29b8479-c1f8-426d-9538-f6e5ec131b7d" />

## 접근 과정

- 배열을 오름차순으로 정렬 (중복제거, 투포인터 사용을 위해)
- 투포인터로 순회

## 풀이

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 i는 건너뜀
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // left, right 중복값 건너뜀
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
```

## 시간복잡도

o(n^2)

---

# 배열 파티션 1

<img width="647" height="173" alt="Image" src="https://github.com/user-attachments/assets/5e6c8a37-6f3c-4d06-99ac-e38749408e0b" />

## 접근 과정

- 배열을 오름차순 정렬하면, 인접한 두 수씩 쌍을 만들 때 min값의 합이 최대
- 정렬 후 짝수 인덱스의 값들을 더함

## 풀이

```java
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
```

## 시간복잡도

o(n log n)