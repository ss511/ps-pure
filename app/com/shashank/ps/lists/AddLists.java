package com.shashank.ps.lists;

import com.shashank.ps.lists.singlyLists.ListActions;
import com.shashank.ps.lists.singlyLists.SinglyList;

/**
 * This program adds the node value of two lists, with carry if the node sum becomes greater than 9.
 * Since all node must contain value between and inclusive of 0 and 9
 * Constraint - All nodes will contain single digit value.
 * Example1:
 * l1 = 3 4 2
 * l2 = 4 6 5
 * result = 7 0 8
 * Explanation: 4+6 = 10, 0 is set to middle node and 1 is carry forwarded, which now becomes 2 + 5 + 1(carry) = 8
 * Example2:
 * l1 = 9 9 9
 * l2 = 9 9 9 9
 * result = 8 9 9 0 1
 * Explanation: 9+9 = 18, so list start with 8 and carry 1, then 2 subsequent sum are 9, then, 9+1(carry) -> 0 and 1(carry)
 */
public class AddLists {
    public static void main(String[] args) {
        ListActions listActions = new ListActions(null);
        listActions.add(9);
        listActions.add(9);
        SinglyList l1 = listActions.add(9);
        listActions = new ListActions(null);
        listActions.add(9);
        listActions.add(9);
        listActions.add(9);
        SinglyList l2 = listActions.add(9);
        SinglyList sumList = sumLists(l1, l2);
        System.out.println("Sum of both lists is");
        listActions.print(sumList);
    }

    private static SinglyList sumLists(SinglyList l1, SinglyList l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int carry = 0;
        SinglyList result = new SinglyList();
        SinglyList res = result;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.getData();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                sum += l2.getData();
                l2 = l2.getNext();
            }
            if (sum > 9) {
                int temp = sum;
                sum = sum%10;
                carry = temp/10;
            } else {
                carry = 0;
            }
            res.setData(sum);
            if (l1 == null && l2 == null && carry == 0) {
                res.setNext(null);
            } else {
                res.setNext(new SinglyList());
                res = res.getNext();
            }
        }
        if (carry != 0) {
            res.setData(carry);
            res.setNext(null);
        }
        return result;
    }
}
