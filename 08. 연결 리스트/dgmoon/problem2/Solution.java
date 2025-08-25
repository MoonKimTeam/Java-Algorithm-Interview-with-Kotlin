package problem2;
import java.util.LinkedList;

class Solution {
    public LinkedList<Integer> mergeTwoLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> result = new LinkedList<>();

        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.peekFirst() <= list2.peekFirst()) {
                result.add(list1.pollFirst());
            } else {
                result.add(list2.pollFirst());
            }
        }

        while (!list1.isEmpty()) {
            result.add(list1.pollFirst());
        }
        while (!list2.isEmpty()) {
            result.add(list2.pollFirst());
        }

        return result;
    }
}