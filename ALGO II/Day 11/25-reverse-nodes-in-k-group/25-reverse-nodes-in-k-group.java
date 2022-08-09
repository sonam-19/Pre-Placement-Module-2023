class Solution{
public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode tail = head;
        int movements = k;
        while(tail != null && movements > 1){
            tail = tail.next;
            movements--;
        }
        if(tail == null) return head;
        
        ListNode next = tail.next;
        tail.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(next, k);
        return newHead;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }
}