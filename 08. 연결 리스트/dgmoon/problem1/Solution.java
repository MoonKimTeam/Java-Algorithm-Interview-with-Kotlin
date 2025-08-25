package problem1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * O(1) ~ O(n)
 */
class Solution {
    public boolean isPalindrome(LinkedList<Integer> head) {
        Deque<Integer> deque = new ArrayDeque<>();

        while (!head.isEmpty()) {
            deque.push(head.pop());
        }

        while (!deque.isEmpty()) {
            if (!deque.getFirst().equals(deque.getLast())) {
                return false;
            }
            deque.pollFirst();
            if (!deque.isEmpty()) {
                deque.pollLast();
            }
        }
        return true;
    }
}