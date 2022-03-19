package code.topic.linkedlist;

import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = getNumber(l1);
        System.out.println("num1 : " + num1 );
        long num2 = getNumber(l2);
        System.out.println("num2 : " + num2 );
        long sum = num1 + num2;
        System.out.println("sum : " + sum );
        return getList(sum);
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2)
    {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 !=null )
        {
            int num1 = l1 != null ? l1.val:0;
            int num2 = l2 != null ? l2.val:0;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

            int num = num1 + num2 + carry;
            carry = num/10;
            ListNode node = new ListNode(num%10);

            if(head == null) {
                head = node;
                tail = node;
            }
            else {
                tail.next = node;
                tail = node;
            }

        }
        if(l1 == null && l2 == null && carry ==1){
            tail.next = new ListNode(1);
        }
        return head;
    }

    private long getNumber(ListNode node)
    {

        long num = 0;
        long digit = 1L;
        while (node != null)
        {
            num = num + digit*node.val;
            System.out.println(num);
            digit = digit*10;
            node = node.next;
        }
        return num;
    }

    private ListNode getList(long number)
    {
        if(number == 0) return new ListNode(0);
        ListNode head = null;
        ListNode tail = null;

        while (number != 0)
        {
            ListNode node = new ListNode((int)(number%10L));
            if(head == null){head = node;}
            else {tail.next = node;}

            tail = node;
            number = number/10L;
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode res = addTwoNumbers.addTwoNumbers1(l1, l2);

        while (res!=null)
        {
            System.out.print(res.val + "--> " );
            res= res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
