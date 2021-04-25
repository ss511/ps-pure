package com.shashank.ps.lists.singlyLists;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ListActions {

    private SinglyList singlyList;

    public SinglyList add(int data) {

        if (singlyList == null) {
            singlyList = new SinglyList();
            singlyList.setData(data);
            singlyList.setNext(null);
            return singlyList;
        }
        SinglyList temp = singlyList;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        SinglyList newNode = new SinglyList();
        newNode.setData(data);
        newNode.setNext(null);
        temp.setNext(newNode);
        return singlyList;
    }

    public SinglyList insert(int data, int pos) {

        return null;
    }

    public SinglyList remove() {

        return null;
    }

    public int size(SinglyList singlyList) {

        int size = 0;
        SinglyList temp = singlyList;

        while (temp != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    public void print(SinglyList singlyList) {
        SinglyList temp = singlyList;
        while (temp != null) {
            System.out.print(temp.getData());
            if (temp.getNext() != null) {
                System.out.print(" -> ");
            }
            temp = temp.getNext();
        }
        System.out.println();
    }
}
