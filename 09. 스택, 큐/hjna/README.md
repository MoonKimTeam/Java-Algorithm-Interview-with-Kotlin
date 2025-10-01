# 20. 유효한 괄호

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}

```

# 21. 중복 문자 제거

```java
import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (visited[index]) continue;
            while (!stack.isEmpty() && c < stack.peekLast() && lastIndex[stack.peekLast() - 'a'] > i) {
                visited[stack.pollLast() - 'a'] = false;
            }
            stack.addLast(c);
            visited[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}

```

# 22. 일일 온도

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }
}

```

# 23. 큐를 이용한 스택 구현
```java
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
	private Queue<Integer> queue;
	public MyStack() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		queue.add(x);

		for (int i = 0; i < queue.size() - 1; i++) {
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

# 24. 스택을 이용한 큐 구현
```java
class MyQueue {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void push(int x) {
		stack1.push(x);
	}

	public int pop() {
		peek();

		return stack2.pop();
	}

	public int peek() {
		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	public boolean empty() {
		return stack1.empty() && stack2.empty();
	}
}
```

# 25. 원형 큐 디자인
```java
class MyCircularQueue {

	private int[] data;

	private int front = 0;
	private int rear = -1;
	private int size = 0;

	public MyCircularQueue(int k) {
		data = new int[k];
	}

	public boolean enQueue(int value) {
		if (!isFull()) {
			rear = (rear + 1) % data.length;
			data[rear] = value;
			size++;
			return true;
		} else {
			return false;
		}
	}

	public boolean deQueue() {
		if (!isEmpty()) {
			front = (front + 1) % data.length;
			size--;
			return true;
		} else {
			return false;
		}
	}

	public int Front() {
		return data[front];
	}

	public int Rear() {
		return rear == -1 ? -1 : data[rear];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == data.length;
	}
}

```

