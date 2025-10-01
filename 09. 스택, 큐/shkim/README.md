# 유효한 괄호

<img width="608" height="129" alt="Image" src="https://github.com/user-attachments/assets/331c5674-6242-4614-86b4-3bb08e8d0c02" />

## 접근 과정

- 스택을 사용
  - 열린 괄호일 경우 push
  - 닫힌 괄호이고 스택이 비어있으면 false, 짝이 아니면 false, 맞으면 pop
  - 모든 문자를 순회한 후 스택이 비어있으면 true, 아니면 false

## 풀이

```java
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 닫힌 괄호인데 스택이 비어있으면 false
                if (stack.isEmpty()) return false;

                // 짝이 맞는지 확인
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        
        // 스택이 비어있으면 true, 아니면 false
        return stack.isEmpty();
    }
}
```

## 시간복잡도

o(n)

---

# 중복 문자 제거

<img width="636" height="154" alt="Image" src="https://github.com/user-attachments/assets/42af76e7-fa60-4028-b644-6c9b3c7a4505" />

## 접근 과정

- 각 문자의 등장 횟수 카운트
- 결과에 포함 여부 체크 
- 스택을 이용해 결과 문자열 구성
  - 현재 문자가 결과의 마지막 문자보다 사전순으로 앞서고, 마지막 문자가 뒤에 다시 등장한다면 pop
  - 그 후 현재 문자를 push

## 풀이

```java
import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // 각 문자의 남은 개수
        boolean[] inStack = new boolean[26]; // 결과에 포함 여부
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (inStack[c - 'a']) continue; // 이미 결과에 있으면 skip

            // 스택 top이 현재 문자보다 크고, 뒤에 다시 등장한다면 pop
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            inStack[c - 'a'] = true;
        }

        // 스택에 쌓인 문자들을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
```

## 시간복잡도

o(n)

---

# 일일 온도

<img width="783" height="300" alt="Image" src="https://github.com/user-attachments/assets/0d3fe10e-233f-4789-9897-842edb43e9ac" />

## 접근 과정

- 온도 배열을 왼쪽에서 오른쪽으로 순회
  - 현재 온도가 스택의 top 인덱스의 온도보다 높으면:
  - 스택에서 pop한 인덱스의 answer를 (현재 인덱스 - pop한 인덱스)로 채운다
  - 이 과정을 현재 온도가 스택의 top보다 높을 때까지 반복
  - 현재 인덱스를 스택에 push

## 풀이

```java
import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // 현재 온도가 스택 top의 온도보다 높으면, 스택에서 pop하며 answer 채움
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            // 현재 인덱스를 스택에 push
            stack.push(i);
        }
        // 스택에 남아있는 인덱스들은 answer가 0 (이미 초기화됨)
        return answer;
    }
}
```

## 시간복잡도

o(n)

---

# 큐를 이용한 스택 구현

<img width="528" height="503" alt="Image" src="https://github.com/user-attachments/assets/0087c418-252d-4dbb-8015-bdbbf4ca7aaa" />

## 풀이

```java
import java.util.*;

class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
```

---

# 스택을 이용한 큐 구현

<img width="543" height="498" alt="Image" src="https://github.com/user-attachments/assets/94128e95-c77f-4a4c-9dd5-3cdcaf7883c9" />

## 풀이

```java
import java.util.*;

class MyQueue {
    private Deque<Integer> in = new ArrayDeque<>();
    private Deque<Integer> out = new ArrayDeque<>();

    public MyQueue() {
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        fromInToOut();
        return out.pop();
    }

    public int peek() {
        fromInToOut();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void fromInToOut() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
```

---

# 원형 큐 디자인

<img width="669" height="451" alt="Image" src="https://github.com/user-attachments/assets/d90f294e-216f-4bde-8561-eeb3c81155fb" />

## 풀이

```java
class MyCircularQueue {
    private final int[] data;   // 고정 크기 배열 (ring buffer)
    private final int capacity; // 총 용량 k
    private int head;           // 현재 Front가 위치한 인덱스
    private int tail;           // 다음 enQueue가 삽입될 인덱스
    private int size;           // 현재 원소 수

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        // tail은 다음 삽입 위치를 가리키므로 삽입 후 한 칸 전진
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        // head는 현재 Front를 가리킴. 삭제는 head를 한 칸 전진.
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        // tail은 다음 삽입 위치를 가리키므로, 마지막 요소는 tail - 1 위치에 있음.
        int lastIdx = (tail - 1 + capacity) % capacity;
        return data[lastIdx];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

```
