package problem21;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter =new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        for(char c: s.toCharArray()){
            counter.put(c, counter.get(c) == null ?  1: counter.get(c) + 1);
        }
        for(char c: s.toCharArray()){
            counter.put(c, counter.get(c) - 1);
            if(seen.get(c) != null && seen.get(c) == true) {
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                seen.put(stack.pop(), false);
            }
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println("solution.removeDuplicateLetters(\"bcabc\") = " + solution.removeDuplicateLetters("cbacdcbc"));

    }
}
