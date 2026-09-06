class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
}

class RemoveNthSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;

        if (n == 1){
            head = head.next;
        }
        else{
            for (int i = 1; i < n; i++){
            if (i == n  -1 && head.next != null ){
                head.next = head.next.next;
            }

            else if (i == n - 1&& head.next == null){
                head.next = null ;
            }
            else{
                head = head.next;
            }
            
        }
        }
        
        prev = null;
        curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}


public class LeetCode19 {
    
}
