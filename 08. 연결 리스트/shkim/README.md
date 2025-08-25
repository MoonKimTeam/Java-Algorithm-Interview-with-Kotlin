# 팰린드롬 연결 리스트

<img width="620" height="170" alt="Image" src="https://github.com/user-attachments/assets/01609be2-8221-4282-b875-20a479a8594a" />

## 접근 과정

1. 연결 리스트의 모든 값을 데크에 저장
2. 데크의 앞(front)과 뒤(rear)에서 값을 하나씩 꺼내 비교
3. 값이 다르면 false, 끝까지 같으면 true를 반환


## 풀이

```java
import java.util.Deque;
import java.util.ArrayDeque;

// Definition for singly-linked list.
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode curr = head;

        // 1. 모든 값을 데크에 저장
        while (curr != null) {
            deque.addLast(curr.val);
            curr = curr.next;
        }

        // 2. 앞뒤에서 값을 꺼내 비교
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }
}
```

## 시간복잡도

O(n)

---

# 두 정렬 리스트의 병합

<img width="817" height="184" alt="Image" src="https://github.com/user-attachments/assets/fdc3f302-3b67-419f-900b-4a1708d1e670" />

## 접근 과정

1. **더미 노드**를 하나 만들어 결과 리스트의 시작점으로 사용.
2. **포인터(curr)** 를 더미 노드에 두고, list1과 list2를 앞에서부터 비교.
3. 두 리스트의 현재 노드 중 값이 더 작은 쪽을 curr.next에 연결하고, 해당 리스트의 포인터를 다음 노드로 이동.
4. 둘 중 하나가 끝나면, 남은 리스트를 curr.next에 연결.
5. 더미 노드의 다음 노드(dummy.next)가 결과 리스트의 head가 됨.

## 풀이

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // 더미 노드
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // 남은 노드 연결
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }
}
```

## 시간복잡도

O(n + m) (n: list1의 노드 개수, m: list2의 노드 개수)

---

# 역순 연결 리스트

<img width="728" height="162" alt="Image" src="https://github.com/user-attachments/assets/fe01279e-412c-44c6-8403-657d33475c35" />

## 접근 과정

1. 반복문 방식
   1. 포인터 준비:
      - `prev`(이전 노드),
      - `curr`(현재 노드, 처음엔 head),
      - `next`(다음 노드, 임시 저장용)
   2. 반복:
      - 현재 노드의 next를 prev로 바꾼다.
      - prev를 현재 노드로 이동.
      - curr을 다음 노드로 이동.
   3. 종료:
      - curr이 null이 되면 prev가 새로운 head가 된다.

2. 재귀(Recursive) 방식
   1. 기저 조건:
      - head가 null이거나 head.next가 null이면 head 반환.
   2. 재귀 호출:
      - head.next를 뒤집은 결과를 받아온다.
   3. 연결 변경:
      - head.next.next = head로 연결을 반대로 바꾼다.
      - head.next = null로 끊어준다.
   4. 반환:
      - 뒤집힌 리스트의 head 반환.

## 풀이

```java
// 반복문 방식
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode next = curr.next; // 다음 노드 저장
        curr.next = prev;          // 연결 반전
        prev = curr;               // prev 이동
        curr = next;               // curr 이동
    }
    return prev; // prev가 새로운 head
}
```

```java
// 재귀 방식
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}
```

## 시간복잡도

반복문/재귀 모두 O(n)

---

# 두 수의 덧셈

<img width="583" height="187" alt="Image" src="https://github.com/user-attachments/assets/c7902ab1-aadf-4ddf-9358-8de3e0e52777" /> <br>
<img width="784" height="891" alt="Image" src="https://github.com/user-attachments/assets/1849a4d6-7377-443a-b1b6-e30459762b75" />

## 접근 과정

1. 포인터 준비 (l1, l2의 현재 노드를 가리키는 포인터와 결과 리스트의 더미 노드를 준비.)
2. 자리수 합산 (두 리스트의 현재 노드 값과 이전 자리에서 올림(carry)을 더한다.)
3. 노드 생성 (합산 결과의 1의 자리만 새로운 노드로 만들어 결과 리스트에 추가.)
4. 올림 처리 (합산 결과가 10 이상이면 carry를 1로, 아니면 0으로 설정.)
5. 다음 노드로 이동 (l1, l2가 각각 null이 될 때까지 반복.)
6. 마지막 carry 처리 (반복이 끝난 후 carry가 남아 있으면 마지막에 노드를 추가.)

## 풀이

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
```

## 시간복잡도

O(max(N, M)) (N: l1의 길이, M: l2의 길이)
