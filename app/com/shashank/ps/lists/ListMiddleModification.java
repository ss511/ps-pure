package com.shashank.ps.lists;

import com.shashank.ps.lists.singlyLists.ListActions;
import com.shashank.ps.lists.singlyLists.SinglyList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Stack;

/**
 * This program updates the second half of the list
 * such that n-th element becomes sum(1st + nth) element,
 * (n-1)st element becomes sum(2nd + n-1st) element and so on...
 *
 * Eg: 2->3->4->5->6 => 2->3->(4+4)->(5+3)->(6+2)
 */
@RequiredArgsConstructor
public class ListMiddleModification {

    @NonNull
    private Stack<SinglyList> stack;

    @NonNull
    private ListMiddleNode listMiddleNode;

    @NonNull
    private ListReverse listReverse;

    public static void main(String[] args) {

        ListMiddleModification listMiddleModification = new ListMiddleModification(new Stack(), new ListMiddleNode(), new ListReverse());
        ListActions listActions = new ListActions(null);

        listActions.add(5);
        listActions.add(6);
        listActions.add(30);
        listActions.add(8);
        listActions.add(12);
        SinglyList list = listActions.add(9);

        System.out.println("Original");
        listActions.print(list);

        listMiddleModification.v1UsingListSplit(list);
        System.out.println("After List Modification Using v1.");
        listActions.print(list);


        listMiddleModification.v2UsingStack(list);
        System.out.println("After List Modification Using v2.");
        listActions.print(list);

    }

    /**
     * Core method which splits the list into two, reverses the second half, performs the addition, re-reverses it and joins the two halves.
     * @param list - the list which has to be modified.
     */
    private void v1UsingListSplit(SinglyList list) {

        if (list == null) {
            return;
        }
        if(list.getNext() == null) {
            list.setData(list.getData()*2);
            return;
        }
        SinglyList firstHalf = list;
        SinglyList secondHalf = splitList(list);

        SinglyList reverseList = listReverse.getReverse(secondHalf);
        SinglyList temp = reverseList;

        SinglyList curr = firstHalf;

        while(firstHalf != null && reverseList!= null) {
            reverseList.setData(reverseList.getData() + firstHalf.getData());

            curr = firstHalf;
            firstHalf = firstHalf.getNext();
            reverseList = reverseList.getNext();
        }

        if (reverseList != null) {
            reverseList.setData(reverseList.getData()*2);
        }

        SinglyList reReverseList = listReverse.getReverse(temp);

        curr.setNext(reReverseList);

    }

    /**
     * Core method which uses stack to perform the modification.
     * @param list - the list which has to be modified.
     */
    private void v2UsingStack(SinglyList list) {

        if (list == null) {
            return;
        }

        ListActions listActions = new ListActions();
        int listSize = listActions.size(list);
        SinglyList middle = listMiddleNode.getMiddleNode(list);

        SinglyList temp = list;

        while (temp != middle) {
            stack.push(temp);
            temp = temp.getNext();
        }

        if (listSize%2 != 0) {
            temp.setData(temp.getData()*2);
            temp = temp.getNext();
        }

        while (temp != null) {
            temp.setData(temp.getData() + stack.pop().getData());
            temp = temp.getNext();
        }
    }

    /**
     * Splits the list into two from middle.
     * @param singlyList - the list to split.
     * @return - the second half of the list.
     */
    private SinglyList splitList(SinglyList singlyList) {

        SinglyList middleNode = listMiddleNode.getMiddleNode(singlyList);

        SinglyList temp = singlyList;

        while(temp.getNext() != middleNode && temp.getNext() != null) {
            temp = temp.getNext();
        }
        SinglyList secondHalf = temp.getNext();
        temp.setNext(null);

        return secondHalf;
    }
}
