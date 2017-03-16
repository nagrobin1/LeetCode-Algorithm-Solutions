
// Definition for singly-linked list.
public class ListNode {
    ListNode(int x) {
        val = x; }

    int val;
    ListNode next;

}

class Solution {
    public static void main (String[] args){
        ListNode a1 = new ListNode((2));
        ListNode a2 = new ListNode((4));
        ListNode a3 = new ListNode((3));
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode((5));
        ListNode b2 = new ListNode((6));
        ListNode b3 = new ListNode((4));
        b1.next = b2;
        b2.next = b3;

        ListNode r = addTwoNumbers(a1, b1);

        System.out.println(printNode(r));

    }

    public static int printNode(ListNode l1){
        double l1_digit = 0;
        int l1_num = 0;

        // get all value till the last one
        while(l1.next != null){

            l1_num = l1_num + l1.val * (int) Math.pow(10.0, l1_digit);
            l1 = l1.next;
            l1_digit++;
        }

        // get the last value
        l1_num = l1_num + l1.val * (int) Math.pow(10.0, l1_digit);

        System.out.println(l1_num);

        return l1_num;

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int l1_num = printNode(l1);
        int l2_num = printNode(l2);


        int result = l1_num + l2_num;

        ListNode res = new ListNode(result%10);
        result = result/10;

        insertElementAndMovetoNext(res, result);

        return res;

    }

    public static void insertElementAndMovetoNext(ListNode a, int result){

        // base case
        if(result == 0){
            return;
        }

        int digit = result%10;
        result = result / 10;
        a.next = new ListNode(digit);

        insertElementAndMovetoNext(a.next, result);

    }

}
