package problem6;

import java.util.LinkedList;
import java.util.List;



class Solution {
    public LinkedList<Integer> oddEvenList(LinkedList<Integer> head) {
        LinkedList<Integer> evenHead = (LinkedList<Integer>) head.clone();
        evenHead.pollFirst();
        LinkedList<Integer> oddHead = (LinkedList<Integer>) head.clone();
        oddHead.addFirst(null);
        for (int i = 1; i < head.size() - 1; i++) {
            if (i % 2 == 1) {
                head.set(i, evenHead.get(i));
            } else {
                head.set(i, oddHead.get(i));
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.oddEvenList(new LinkedList(List.of(1, 2, 3, 4, 5, 6)) = " + solution.oddEvenList(new LinkedList(List.of(1, 2, 3, 4, 5, 6))));
    }
}