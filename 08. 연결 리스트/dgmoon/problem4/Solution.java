package problem4;

import java.util.LinkedList;

/**
 * O(n)
 */
class Solution {
    public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;

        while (!l1.isEmpty() || !l2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!l1.isEmpty()) {
                sum += l1.pollLast();
            }
            if (!l2.isEmpty()) {
                sum += l2.pollLast();
            }

            carry = sum / 10;
            result.add(sum % 10);
        }

        return result;
    }
}