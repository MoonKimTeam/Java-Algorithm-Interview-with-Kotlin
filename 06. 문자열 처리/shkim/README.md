# 유효한 팰린드롬

<img width="806" height="543" alt="Image" src="https://github.com/user-attachments/assets/6229adfa-eb7b-4c39-9bec-1383bc95212c" />

## 접근 과정

1. 대소문자를 구분하지 않고, 영숫자만 남도록 input 문자열 값을 파싱한다.
2. 파싱된 문자열 값과, 파싱된 문자열을 뒤집은 값이 같은지 비교한다.


## 풀이

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(
            solve("Do geese see God?")
        );
    }

    public static boolean solve(String input) {
        String replace = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverse = new StringBuilder(replace).reverse().toString();

        return replace.equals(reverse);
    }

}
```

## 시간복잡도

replaceAll(), toLowerCase(), reverse() 메서드 모두 시간복잡도는 o(n)이기에 위 알고리즘은 시간복잡도 o(n)이다.


---

# 문자열 뒤집기

<img width="798" height="190" alt="Image" src="https://github.com/user-attachments/assets/69a83992-bb0e-44a3-aa05-9fda404a7a44" />

## 접근 과정

1. 2개의 문자열을 swap해야 하기에, 임시 변수 temp를 사용한다.


## 풀이

```java
public class Main {
    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        solve(s);
    }

    public static void solve(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        System.out.println(s);
    }

}
```

## 시간복잡도

배열을 2/n번 순회하므로 시간복잡도는 o(n)

---

# 로그 파일 재정렬

<img width="759" height="304" alt="Image" src="https://github.com/user-attachments/assets/8b7742d6-0651-4d62-a61f-b4b56925b87c" />

## 접근 방식

1. 문자 로그와 숫자 로그 처리 방식이 다르므로, 둘을 분리하고 시작한다.
2. 문자 로그는 사전순으로 먼저 정렬한다. 만약 문자가 같다면 식별자 순으로 정렬한다.
3. 각각 처리된 문자, 숫자 로그를 병합한다.

## 풀이

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] logs = {
            "id1 8 1 5 1",
            "id2 art can",
            "id3 3 6",
            "id4 own kit dig",
            "id5 art zero"
        };
        solve(logs);
    }

    public static void solve(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String log: logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }

        letters.sort((s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            int compare = split1[1].compareTo(split2[1]);
            if (compare == 0) {
                return split1[0].compareTo(split2[0]);
            } else {
                return compare;
            }
        });

        letters.addAll(digits);
        System.out.println(
            Arrays.toString(letters.toArray(new String[0]))
        );
    }

}
```

## 시간복잡도

letters.sort의 시간복잡도가 nlog(n)이므로 전체 시간복잡도는 nlog(n)

---

# 가장 흔한 단어

<img width="790" height="205" alt="Image" src="https://github.com/user-attachments/assets/52bf5943-c898-4ef5-a0b6-1fa41a047070" />

## 접근 방식

1. 대소문자를 구분하지 않고, 구두점을 무시하도록 paragraph를 파싱한다.
2. 단어, 등장 횟수를 key, value로 하는 Map을 활용하여, 각 단어가 몇 번 등장하는지 저장한다.
3. value가 가장 큰 key값을 출력한다.

## 풀이

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(
            solve(paragraph, banned)
        );
    }

    public static String solve(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        String[] words = paragraph.replaceAll("\\W+", " ")
            .toLowerCase()
            .split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            if (!bannedSet.contains(word)) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

}
```

## 시간복잡도

문자열을 전처리하는데 o(n), Collections.max()가 o(n)이므로 시간복잡도는 o(n)

---

# 그룹 애너그램

<img width="626" height="363" alt="Image" src="https://github.com/user-attachments/assets/48fc623a-0020-41bb-b841-f75a46344e6a" />

## 접근 방식

1. 문자를 재배열하여 다른 뜻을 가진 단어로 바꾸기 = 문자를 정렬하면 같은 단어인 것
2. 문자열을 char로 분리하여 정렬 후, 같은 문자열끼리 묶는다

## 풀이

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String string = Arrays.toString(charArray);

            if (!result.containsKey(string)) {
                result.put(string, new ArrayList<>());
            }
            result.get(string).add(s);
        }
        
        return new ArrayList<>(result.values());
    }
}
```

## 시간복잡도

- 문자열의 길이 = a
- 문자열을 쪼갠 문자의 길이 = b 

o(a * b log b)

---

# 가장 긴 플린드롬 부분 문자열

<img width="364" height="119" alt="Image" src="https://github.com/user-attachments/assets/95bd25a8-62e3-44e5-8e95-508ee7ffc645" />

## 접근 방식

1. 문자열 중심으로 양옆을 비교하면 팰린드롬을 찾는다. 문자열이 홀수인 경우 중심 문자는 1개, 짝수인 경우 중심 문자는 2개이다.
2. 문자열의 각 인덱스를 중심으로 설정하여, 그 중심에서 좌우로 같은 문자가 계속되면 확장한다.
3. start와 end 인덱스를 기반으로 s.substring(start, end + 1)을 반환한다.

## 풀이

```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       // 홀수 팰린드롬
            int len2 = expandFromCenter(s, i, i + 1);   // 짝수 팰린드롬
            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start) {
                // 새로운 최대 팰린드롬 범위를 저장
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // 팰린드롬 길이 반환
    }
}
```

## 시간복잡도

o(n^2)


