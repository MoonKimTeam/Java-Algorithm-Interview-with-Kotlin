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

