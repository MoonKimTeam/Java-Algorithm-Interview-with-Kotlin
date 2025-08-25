package problem3;

import java.util.LinkedList;

class Solution {
    public LinkedList<Integer> reverseList(LinkedList<Integer> head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (!head.isEmpty()) {
            list.add(head.pollLast());
        }
        return list;
    }
}