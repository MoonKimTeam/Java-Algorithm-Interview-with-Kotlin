package problem7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public LinkedList<Integer> reverseBetween(LinkedList<Integer> head, int left, int right) {
        Collections.reverse(head.subList(left - 1, right));
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseBetween(new LinkedList(List.of(1, 2, 3, 4, 5, 6)), 1, 2);
    }
}