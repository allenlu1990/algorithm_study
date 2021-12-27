package leetcode;

import java.util.LinkedList;

public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode = swapPairs(listNode1);

    }

    public static ListNode swapPairs(ListNode head) {
        LinkedList<ListNode> listNodes = new LinkedList<>();
        while (head != null){
            listNodes.add(head);
            head = head.next;
        }

        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        boolean flag = true;
        int size = listNodes.size();
        if(size ==1){
            return listNodes.get(0);
        }

        if(size ==0){
            return null;
        }

        for(int i =0; i < size; i++){

            if(flag && i+1 < size){
                ListNode node = listNodes.get(i + 1);
                node.next = null;
                tmp.next = node;
            }

            if(flag && i+1 == size){
                ListNode node = listNodes.get(i);
                node.next = null;
                tmp.next = node;
            }

            if(!flag && i-1 >= 0 && i-1 < size){
                ListNode node = listNodes.get(i - 1);
                node.next =null;
                tmp.next = node;
            }
            tmp = tmp.next;
            flag = !flag;
        }

        return res.next;

    }

}
