package problem5;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public LinkedList<Integer> swapPairs(LinkedList<Integer> head) {
        int temp = 0;
        for (int i = 0; i < head.size(); i++) {
            if (i % 2 == 0) {
                temp = (int) head.get(i);
                continue;
            }
            head.set(i - 1, head.get(i));
            head.set(i, temp);
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.swapPairs(new LinkedList<>(List.of(1, 2, 3, 4, 5, 6))) = " + solution.swapPairs(new LinkedList<>(List.of(1, 2, 3, 4, 5, 6))));
    }
}