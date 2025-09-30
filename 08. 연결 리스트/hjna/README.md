# 13. 팰린드롬 연결 리스트

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode nextNode = head;
        Stack<Integer> stack = new Stack<>();
        while (nextNode != null) {
            stack.add(nextNode.val);
            nextNode = nextNode.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
```

# 14. 두 정렬 리스트의 병합



```java

class Solution {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}

	}
}
```

# 15. 역순 연결 리스트

```java

class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode node = head;

		while (node != null) {
			ListNode next = node.next;

			node.next = prev;

			prev = node;

			node = next;
		}

		return prev;
	}
}

```
# 16. 두 수의 덧셈

```java

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;
        int sum = x + y + carry;
        carry = sum / 10;
        cur.next = new ListNode(sum % 10);
        cur = cur.next;
        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
    }
    return dummy.next;
}

```

# 17. 페어의 노드 스왑

```java

public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;
    ListNode cur = head;

    while (cur != null && cur.next != null) {
        ListNode nextPair = cur.next.next;
        ListNode second = cur.next;

        second.next = cur;
        cur.next = nextPair;
        prev.next = second;


        prev = cur;
        cur = nextPair;
    }

    return dummy.next;
}

```


# 18. 홀짝 연결 리스트

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}


```